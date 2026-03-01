package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class WeightUnitTest {

    @Test
    public void testKilogramConversionFactor() {
        assertEquals(1.0, WeightUnit.KILOGRAM.getConversionFactor(), 0.001);
    }

    @Test
    public void testGramConversionFactor() {
        assertEquals(0.001, WeightUnit.GRAM.getConversionFactor(), 0.0001);
    }

    @Test
    public void testPoundConversionFactor() {
        assertEquals(0.453592, WeightUnit.POUND.getConversionFactor(), 0.000001);
    }

    @Test
    public void testKilogramToBaseUnit() {
        assertEquals(1.0, WeightUnit.KILOGRAM.convertToBaseUnit(1.0), 0.001);
    }

    @Test
    public void testGramToBaseUnit() {
        assertEquals(1.0, WeightUnit.GRAM.convertToBaseUnit(1000.0), 0.001);
    }

    @Test
    public void testPoundToBaseUnit() {
        assertEquals(0.453592, WeightUnit.POUND.convertToBaseUnit(1.0), 0.000001);
    }

    @Test
    public void testKilogramFromBaseUnit() {
        assertEquals(1.0, WeightUnit.KILOGRAM.convertFromBaseUnit(1.0), 0.001);
    }

    @Test
    public void testGramFromBaseUnit() {
        assertEquals(1000.0, WeightUnit.GRAM.convertFromBaseUnit(1.0), 0.001);
    }

    @Test
    public void testPoundFromBaseUnit() {
        assertEquals(2.20462, WeightUnit.POUND.convertFromBaseUnit(1.0), 0.001);
    }

    @Test
    public void testKilogramLabel() {
        assertEquals("kg", WeightUnit.KILOGRAM.label());
    }

    @Test
    public void testGramLabel() {
        assertEquals("g", WeightUnit.GRAM.label());
    }

    @Test
    public void testPoundLabel() {
        assertEquals("lb", WeightUnit.POUND.label());
    }
}
