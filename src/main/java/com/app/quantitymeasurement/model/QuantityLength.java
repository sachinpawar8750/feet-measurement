package com.app.quantitymeasurement.model;


public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid " + unit.label() + " value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double toFeet() {
        return unit.toFeet(value);
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseValue = this.toFeet();
        double convertedValue = baseValue / targetUnit.getConversionFactor();
        return new QuantityLength(convertedValue, targetUnit);
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.label());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength other = (QuantityLength) obj;
        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.toFeet());
    }

    public static QuantityLength add(QuantityLength length1, QuantityLength length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Length values cannot be null");
        }
        double baseSum = length1.toFeet() + length2.toFeet();
        double resultValue = baseSum / length1.unit.getConversionFactor();
        return new QuantityLength(resultValue, length1.unit);
    }

    public static QuantityLength add(QuantityLength length1, QuantityLength length2, LengthUnit targetUnit) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Length values cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseSum = length1.toFeet() + length2.toFeet();
        double resultValue = baseSum / targetUnit.getConversionFactor();
        return new QuantityLength(resultValue, targetUnit);
    }

    public QuantityLength add(QuantityLength other) {
        return add(this, other);
    }

    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        return add(this, other, targetUnit);
    }

}
