package com.app.quantitymeasurement.model;

public enum LengthUnit implements IMeasurable {
    FEET(1.0, "feet"),
    INCHES(1.0 / 12.0, "inches"),
    YARD(3.0, "yard"),
    CENTIMETER(0.393701 / 12.0, "centimeter");

    private final double toFeetFactor;
    private final String label;

    LengthUnit(double toFeetFactor, String label) {
        this.toFeetFactor = toFeetFactor;
        this.label = label;
    }

    public double toFeet(double value) {
        return value * toFeetFactor;
    }

    @Override
    public double getConversionFactor() {
        return toFeetFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toFeetFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toFeetFactor;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    public String label() {
        return label;
    }
}
