package com.app.quantitymeasurement.model;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {
    CELSIUS(celsius -> celsius, "°C"),
    FAHRENHEIT(fahrenheit -> (fahrenheit - 32) * 5.0 / 9.0, "°F");

    private final Function<Double, Double> toCelsius;
    private final String label;
    private final SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(Function<Double, Double> toCelsius, String label) {
        this.toCelsius = toCelsius;
        this.label = label;
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return toCelsius.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double celsiusValue) {
        if (this == CELSIUS) {
            return celsiusValue;
        } else {
            return celsiusValue * 9.0 / 5.0 + 32;
        }
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return "TEMPERATURE";
    }

    @Override
    public IMeasurable fromUnitName(String unitName) {
        return TemperatureUnit.valueOf(unitName.toUpperCase());
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
            "Temperature does not support " + operation + " operation. " +
            "Temperature measurements can only be compared and converted."
        );
    }

    public String label() {
        return label;
    }
}
