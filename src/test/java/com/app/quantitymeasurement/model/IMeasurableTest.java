package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class IMeasurableTest {

    // LengthUnit IMeasurable Tests
    @Test
    public void testLengthUnitGetUnitName() {
        assertEquals("FEET", LengthUnit.FEET.getUnitName());
        assertEquals("INCHES", LengthUnit.INCHES.getUnitName());
        assertEquals("YARD", LengthUnit.YARD.getUnitName());
        assertEquals("CENTIMETER", LengthUnit.CENTIMETER.getUnitName());
    }

    @Test
    public void testLengthUnitConvertToBaseUnit() {
        assertEquals(1.0, LengthUnit.FEET.convertToBaseUnit(1.0), 0.001);
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0), 0.001);
        assertEquals(3.0, LengthUnit.YARD.convertToBaseUnit(1.0), 0.001);
    }

    @Test
    public void testLengthUnitConvertFromBaseUnit() {
        assertEquals(1.0, LengthUnit.FEET.convertFromBaseUnit(1.0), 0.001);
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0), 0.001);
        assertEquals(1.0, LengthUnit.YARD.convertFromBaseUnit(3.0), 0.001);
    }

    // WeightUnit IMeasurable Tests
    @Test
    public void testWeightUnitGetUnitName() {
        assertEquals("KILOGRAM", WeightUnit.KILOGRAM.getUnitName());
        assertEquals("GRAM", WeightUnit.GRAM.getUnitName());
        assertEquals("POUND", WeightUnit.POUND.getUnitName());
    }

    @Test
    public void testWeightUnitConvertToBaseUnit() {
        assertEquals(1.0, WeightUnit.KILOGRAM.convertToBaseUnit(1.0), 0.001);
        assertEquals(1.0, WeightUnit.GRAM.convertToBaseUnit(1000.0), 0.001);
        assertEquals(0.453592, WeightUnit.POUND.convertToBaseUnit(1.0), 0.000001);
    }

    @Test
    public void testWeightUnitConvertFromBaseUnit() {
        assertEquals(1.0, WeightUnit.KILOGRAM.convertFromBaseUnit(1.0), 0.001);
        assertEquals(1000.0, WeightUnit.GRAM.convertFromBaseUnit(1.0), 0.001);
        assertEquals(2.20462, WeightUnit.POUND.convertFromBaseUnit(1.0), 0.001);
    }

    // Polymorphism Tests
    @Test
    public void testIMeasurablePolymorphism() {
        IMeasurable lengthUnit = LengthUnit.FEET;
        IMeasurable weightUnit = WeightUnit.KILOGRAM;
        
        assertEquals("FEET", lengthUnit.getUnitName());
        assertEquals("KILOGRAM", weightUnit.getUnitName());
    }

    @Test
    public void testIMeasurableConversionFactors() {
        IMeasurable feet = LengthUnit.FEET;
        IMeasurable kg = WeightUnit.KILOGRAM;
        
        assertEquals(1.0, feet.getConversionFactor(), 0.001);
        assertEquals(1.0, kg.getConversionFactor(), 0.001);
    }
}
