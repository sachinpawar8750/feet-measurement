package com.app.quantitymeasurement.model;

public enum WeightUnit {
    KILOGRAM(1.0, "kg"),
    GRAM(0.001, "g"),
    POUND(0.453592, "lb");

    private final double toKilogramFactor;
    private final String label;

    WeightUnit(double toKilogramFactor, String label) {
        this.toKilogramFactor = toKilogramFactor;
        this.label = label;
    }

    public double getConversionFactor() {
        return toKilogramFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * toKilogramFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toKilogramFactor;
    }

    public String label() {
        return label;
    }
}
