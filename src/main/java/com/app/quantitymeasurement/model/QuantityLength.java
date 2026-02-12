package com.app.quantitymeasurement.model;


public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid " + unit.label() + " value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double toFeet() {
        return unit.toFeet(value);
    }

    /**
     * Converts this quantity to the specified target unit.
     * @param targetUnit the unit to convert to
     * @return a new QuantityLength in the target unit
     * @throws IllegalArgumentException if targetUnit is null
     */
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

}
