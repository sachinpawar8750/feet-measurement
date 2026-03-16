package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.dto.QuantityModel;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.QuantityMeasurementException;
import com.app.quantitymeasurement.model.*;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }


    @SuppressWarnings("unchecked")
    private <U extends IMeasurable> QuantityModel<U> toModel(QuantityDTO dto) {
        IMeasurable unit = resolveUnit(dto.getUnit());
        return new QuantityModel<>(dto.getValue(), (U) unit);
    }

    private IMeasurable resolveUnit(QuantityDTO.IMeasurableUnit dtoUnit) {
        switch (dtoUnit.getMeasurementType()) {
            case "LENGTH":      return LengthUnit.valueOf(dtoUnit.getUnitName());
            case "WEIGHT":      return WeightUnit.valueOf(dtoUnit.getUnitName());
            case "VOLUME":      return VolumeUnit.valueOf(dtoUnit.getUnitName());
            case "TEMPERATURE": return TemperatureUnit.valueOf(dtoUnit.getUnitName());
            default: throw new QuantityMeasurementException(
                    "Unknown measurement type: " + dtoUnit.getMeasurementType());
        }
    }

    private QuantityDTO toDTO(QuantityModel<?> model) {
        QuantityDTO.IMeasurableUnit dtoUnit = resolveDtoUnit(model.getUnit());
        return new QuantityDTO(model.getValue(), dtoUnit);
    }

    private QuantityDTO.IMeasurableUnit resolveDtoUnit(IMeasurable unit) {
        if (unit instanceof LengthUnit)      return QuantityDTO.LengthUnit.valueOf(unit.getUnitName());
        if (unit instanceof WeightUnit)      return QuantityDTO.WeightUnit.valueOf(unit.getUnitName());
        if (unit instanceof VolumeUnit)      return QuantityDTO.VolumeUnit.valueOf(unit.getUnitName());
        if (unit instanceof TemperatureUnit) return QuantityDTO.TemperatureUnit.valueOf(unit.getUnitName());
        throw new QuantityMeasurementException("Unknown unit type: " + unit.getClass().getSimpleName());
    }


    private void validateNotNull(QuantityDTO q, String label) {
        if (q == null) throw new QuantityMeasurementException(label + " cannot be null");
    }

    private void validateSameCategory(QuantityModel<?> m1, QuantityModel<?> m2) {
        if (m1.getUnit().getClass() != m2.getUnit().getClass()) {
            throw new QuantityMeasurementException(
                    "Cannot operate on different measurement categories: " +
                    m1.getUnit().getMeasurementType() + " vs " + m2.getUnit().getMeasurementType());
        }
    }

    private void validateArithmeticSupport(IMeasurable unit, String operation) {
        unit.validateOperationSupport(operation);
    }


    @Override
    public QuantityDTO convert(QuantityDTO source, QuantityDTO.IMeasurableUnit targetDtoUnit) {
        validateNotNull(source, "Source quantity");
        try {
            QuantityModel<IMeasurable> model = toModel(source);
            IMeasurable targetUnit = resolveUnit(targetDtoUnit);
            double baseValue = model.toBaseUnit();
            double converted = targetUnit.convertFromBaseUnit(baseValue);
            QuantityModel<IMeasurable> result = new QuantityModel<>(converted, targetUnit);
            repository.save(new QuantityMeasurementEntity("CONVERT",
                    String.valueOf(source.getValue()), source.getUnit().getUnitName(),
                    String.valueOf(converted), targetDtoUnit.getUnitName()));
            return toDTO(result);
        } catch (QuantityMeasurementException e) {
            repository.save(new QuantityMeasurementEntity("CONVERT", e.getMessage()));
            throw e;
        } catch (Exception e) {
            repository.save(new QuantityMeasurementEntity("CONVERT", e.getMessage()));
            throw new QuantityMeasurementException("Conversion failed: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        validateNotNull(q1, "First quantity");
        validateNotNull(q2, "Second quantity");
        try {
            QuantityModel<IMeasurable> m1 = toModel(q1);
            QuantityModel<IMeasurable> m2 = toModel(q2);
            validateSameCategory(m1, m2);
            boolean result = Double.compare(m1.toBaseUnit(), m2.toBaseUnit()) == 0;
            repository.save(new QuantityMeasurementEntity("COMPARE",
                    String.valueOf(q1.getValue()), q1.getUnit().getUnitName(),
                    String.valueOf(q2.getValue()), q2.getUnit().getUnitName(),
                    String.valueOf(result), "boolean"));
            return result;
        } catch (QuantityMeasurementException e) {
            repository.save(new QuantityMeasurementEntity("COMPARE", e.getMessage()));
            throw e;
        } catch (Exception e) {
            repository.save(new QuantityMeasurementEntity("COMPARE", e.getMessage()));
            throw new QuantityMeasurementException("Comparison failed: " + e.getMessage(), e);
        }
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        return performArithmetic("ADD", q1, q2, null);
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2, QuantityDTO.IMeasurableUnit targetUnit) {
        return performArithmetic("ADD", q1, q2, targetUnit);
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        return performArithmetic("SUBTRACT", q1, q2, null);
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2, QuantityDTO.IMeasurableUnit targetUnit) {
        return performArithmetic("SUBTRACT", q1, q2, targetUnit);
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {
        validateNotNull(q1, "First quantity");
        validateNotNull(q2, "Second quantity");
        try {
            QuantityModel<IMeasurable> m1 = toModel(q1);
            QuantityModel<IMeasurable> m2 = toModel(q2);
            validateSameCategory(m1, m2);
            validateArithmeticSupport(m1.getUnit(), "DIVIDE");
            double base1 = m1.toBaseUnit();
            double base2 = m2.toBaseUnit();
            if (base2 == 0.0) throw new ArithmeticException("Division by zero");
            double result = base1 / base2;
            repository.save(new QuantityMeasurementEntity("DIVIDE",
                    String.valueOf(q1.getValue()), q1.getUnit().getUnitName(),
                    String.valueOf(q2.getValue()), q2.getUnit().getUnitName(),
                    String.valueOf(result), "ratio"));
            return result;
        } catch (QuantityMeasurementException e) {
            repository.save(new QuantityMeasurementEntity("DIVIDE", e.getMessage()));
            throw e;
        } catch (Exception e) {
            repository.save(new QuantityMeasurementEntity("DIVIDE", e.getMessage()));
            throw new QuantityMeasurementException("Division failed: " + e.getMessage(), e);
        }
    }

    private QuantityDTO performArithmetic(String op, QuantityDTO q1, QuantityDTO q2,
                                          QuantityDTO.IMeasurableUnit targetDtoUnit) {
        validateNotNull(q1, "First quantity");
        validateNotNull(q2, "Second quantity");
        try {
            QuantityModel<IMeasurable> m1 = toModel(q1);
            QuantityModel<IMeasurable> m2 = toModel(q2);
            validateSameCategory(m1, m2);
            validateArithmeticSupport(m1.getUnit(), op);
            double baseResult = op.equals("ADD")
                    ? m1.toBaseUnit() + m2.toBaseUnit()
                    : m1.toBaseUnit() - m2.toBaseUnit();
            IMeasurable resultUnit = (targetDtoUnit != null) ? resolveUnit(targetDtoUnit) : m1.getUnit();
            double resultValue = resultUnit.convertFromBaseUnit(baseResult);
            QuantityModel<IMeasurable> result = new QuantityModel<>(resultValue, resultUnit);
            repository.save(new QuantityMeasurementEntity(op,
                    String.valueOf(q1.getValue()), q1.getUnit().getUnitName(),
                    String.valueOf(q2.getValue()), q2.getUnit().getUnitName(),
                    String.valueOf(resultValue), resultUnit.getUnitName()));
            return toDTO(result);
        } catch (QuantityMeasurementException e) {
            repository.save(new QuantityMeasurementEntity(op, e.getMessage()));
            throw e;
        } catch (Exception e) {
            repository.save(new QuantityMeasurementEntity(op, e.getMessage()));
            throw new QuantityMeasurementException(op + " failed: " + e.getMessage(), e);
        }
    }
}
