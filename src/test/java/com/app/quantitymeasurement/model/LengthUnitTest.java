package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LengthUnitTest {

    @Test
    public void testFeetToFeet() {
        assertEquals(5.0, LengthUnit.FEET.toFeet(5.0), 0.001);
    }

    @Test
    public void testInchesToFeet() {
        assertEquals(1.0, LengthUnit.INCHES.toFeet(12.0), 0.001);
    }

    @Test
    public void testYardToFeet() {
        assertEquals(3.0, LengthUnit.YARD.toFeet(1.0), 0.001);
    }

    @Test
    public void testCentimeterToFeet() {
        assertEquals(1.0, LengthUnit.CENTIMETER.toFeet(30.48), 0.01);
    }

    @Test
    public void testFeetLabel() {
        assertEquals("feet", LengthUnit.FEET.label());
    }

    @Test
    public void testInchesLabel() {
        assertEquals("inches", LengthUnit.INCHES.label());
    }

    @Test
    public void testYardLabel() {
        assertEquals("yard", LengthUnit.YARD.label());
    }

    @Test
    public void testCentimeterLabel() {
        assertEquals("centimeter", LengthUnit.CENTIMETER.label());
    }

    @Test
    public void testGetConversionFactor() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), 0.001);
        assertEquals(1.0 / 12.0, LengthUnit.INCHES.getConversionFactor(), 0.001);
        assertEquals(3.0, LengthUnit.YARD.getConversionFactor(), 0.001);
    }
}
