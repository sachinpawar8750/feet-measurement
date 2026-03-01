package com.app.quantitymeasurement.model;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid " + unit.label() + " value");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseValue = this.toBaseUnit();
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityWeight(convertedValue, targetUnit);
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("Quantity(%.2f, %s)", value, unit.name());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityWeight other = (QuantityWeight) obj;
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.toBaseUnit());
    }

    public static QuantityWeight add(QuantityWeight weight1, QuantityWeight weight2) {
        if (weight1 == null || weight2 == null) {
            throw new IllegalArgumentException("Weight values cannot be null");
        }
        double baseSum = weight1.toBaseUnit() + weight2.toBaseUnit();
        double resultValue = weight1.unit.convertFromBaseUnit(baseSum);
        return new QuantityWeight(resultValue, weight1.unit);
    }

    public static QuantityWeight add(QuantityWeight weight1, QuantityWeight weight2, WeightUnit targetUnit) {
        if (weight1 == null || weight2 == null) {
            throw new IllegalArgumentException("Weight values cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseSum = weight1.toBaseUnit() + weight2.toBaseUnit();
        double resultValue = targetUnit.convertFromBaseUnit(baseSum);
        return new QuantityWeight(resultValue, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(this, other);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        return add(this, other, targetUnit);
    }
}
