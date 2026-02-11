package com.app.quantitymeasurement.model;

public enum LengthUnit {
    FEET(1.0, "feet"),
    INCHES(1.0 / 12.0, "inches");

    private final double toFeetFactor;
    private final String label;

    LengthUnit(double toFeetFactor, String label) {
        this.toFeetFactor = toFeetFactor;
        this.label = label;
    }

    public double toFeet(double value) {
        return value * toFeetFactor;
    }

    public String label() {
        return label;
    }
}
