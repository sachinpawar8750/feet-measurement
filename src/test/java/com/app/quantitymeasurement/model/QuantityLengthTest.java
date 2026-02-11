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
    public void testInchesEquality() {
        QuantityLength inches1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength inches2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testFeetNotEqual() {
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(12.0, LengthUnit.FEET);
        assertNotEquals(feet1, feet2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFeetValue() {
        new QuantityLength(Double.NaN, LengthUnit.FEET);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInchesValue() {
        new QuantityLength(Double.NaN, LengthUnit.INCHES);
    }

    @Test
    public void testHashCode() {
        QuantityLength feet1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(5.0, LengthUnit.FEET);
        assertEquals(feet1.hashCode(), feet2.hashCode());
    }

    @Test
    public void testToFeetConversion() {
        QuantityLength feet = new QuantityLength(5.0, LengthUnit.FEET);
        assertEquals(5.0, feet.toFeet(), 0.001);
    }

    @Test
    public void testInchesToFeet() {
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);
        assertEquals(1.0, inches.toFeet(), 0.001);
    }
}
