package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityLengthTest {

    @Test
    public void testFeetEquality() {
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(5.0, LengthUnit.FEET);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testFeetInequality() {
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(10.0, LengthUnit.FEET);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testInchesToFeetConversion() {
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertEquals(feet, inches);
    }

    @Test
    public void testYardToFeetConversion() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        assertEquals(yard, feet);
    }

    @Test
    public void testCentimeterEquality() {
        QuantityLength cm1 = new QuantityLength(10.0, LengthUnit.CENTIMETER);
        QuantityLength cm2 = new QuantityLength(10.0, LengthUnit.CENTIMETER);
        assertEquals(cm1, cm2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValue() {
        new QuantityLength(Double.NaN, LengthUnit.FEET);
    }
}
