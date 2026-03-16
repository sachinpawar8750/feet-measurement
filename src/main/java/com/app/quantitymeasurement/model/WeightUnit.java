package com.app.quantitymeasurement.model;

public enum WeightUnit implements IMeasurable {
    KILOGRAM(1.0, "kg"),
    GRAM(0.001, "g"),
    POUND(0.453592, "lb");

    private final double toKilogramFactor;
    private final String label;

    WeightUnit(double toKilogramFactor, String label) {
        this.toKilogramFactor = toKilogramFactor;
        this.label = label;
    }

    @Override
    public double getConversionFactor() {
        return toKilogramFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toKilogramFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toKilogramFactor;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return "WEIGHT";
    }

    @Override
    public IMeasurable fromUnitName(String unitName) {
        return WeightUnit.valueOf(unitName.toUpperCase());
    }

    public String label() {
        return label;
    }
}
