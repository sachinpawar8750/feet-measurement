package com.app.quantitymeasurement.model;

public enum VolumeUnit implements IMeasurable {
    LITRE(1.0, "L"),
    MILLILITRE(0.001, "mL"),
    GALLON(3.78541, "gal");

    private final double toLitreFactor;
    private final String label;

    VolumeUnit(double toLitreFactor, String label) {
        this.toLitreFactor = toLitreFactor;
        this.label = label;
    }

    @Override
    public double getConversionFactor() {
        return toLitreFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toLitreFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toLitreFactor;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return "VOLUME";
    }

    @Override
    public IMeasurable fromUnitName(String unitName) {
        return VolumeUnit.valueOf(unitName.toUpperCase());
    }

    public String label() {
        return label;
    }
}
