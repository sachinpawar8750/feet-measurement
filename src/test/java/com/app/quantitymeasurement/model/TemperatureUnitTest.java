package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureUnitTest {

    @Test
    public void testCelsiusToBaseUnit() {
        assertEquals(0.0, TemperatureUnit.CELSIUS.convertToBaseUnit(0.0), 0.001);
        assertEquals(100.0, TemperatureUnit.CELSIUS.convertToBaseUnit(100.0), 0.001);
    }

    @Test
    public void testFahrenheitToBaseUnit() {
        assertEquals(0.0, TemperatureUnit.FAHRENHEIT.convertToBaseUnit(32.0), 0.001);
        assertEquals(100.0, TemperatureUnit.FAHRENHEIT.convertToBaseUnit(212.0), 0.001);
    }

    @Test
    public void testCelsiusFromBaseUnit() {
        assertEquals(0.0, TemperatureUnit.CELSIUS.convertFromBaseUnit(0.0), 0.001);
        assertEquals(100.0, TemperatureUnit.CELSIUS.convertFromBaseUnit(100.0), 0.001);
    }

    @Test
    public void testFahrenheitFromBaseUnit() {
        assertEquals(32.0, TemperatureUnit.FAHRENHEIT.convertFromBaseUnit(0.0), 0.001);
        assertEquals(212.0, TemperatureUnit.FAHRENHEIT.convertFromBaseUnit(100.0), 0.001);
    }

    @Test
    public void testCelsiusUnitName() {
        assertEquals("CELSIUS", TemperatureUnit.CELSIUS.getUnitName());
    }

    @Test
    public void testFahrenheitUnitName() {
        assertEquals("FAHRENHEIT", TemperatureUnit.FAHRENHEIT.getUnitName());
    }

    @Test
    public void testSupportsArithmetic() {
        assertFalse(TemperatureUnit.CELSIUS.supportsArithmetic());
        assertFalse(TemperatureUnit.FAHRENHEIT.supportsArithmetic());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testValidateOperationSupport() {
        TemperatureUnit.CELSIUS.validateOperationSupport("ADD");
    }
}
