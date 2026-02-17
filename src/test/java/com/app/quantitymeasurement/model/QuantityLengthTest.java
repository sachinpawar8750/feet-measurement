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

    @Test
    public void testAddSameUnits() {
        QuantityLength result = QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(2.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddFeetAndInches() {
        QuantityLength result = QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES));
        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddInchesAndFeet() {
        QuantityLength result = QuantityLength.add(new QuantityLength(12.0, LengthUnit.INCHES), new QuantityLength(1.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(24.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddYardAndFeet() {
        QuantityLength result = QuantityLength.add(new QuantityLength(1.0, LengthUnit.YARD), new QuantityLength(3.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(2.0, LengthUnit.YARD), result);
    }

    @Test
    public void testAddInchesAndYard() {
        QuantityLength result = QuantityLength.add(new QuantityLength(36.0, LengthUnit.INCHES), new QuantityLength(1.0, LengthUnit.YARD));
        assertEquals(new QuantityLength(72.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddCentimeterAndInches() {
        QuantityLength result = QuantityLength.add(new QuantityLength(2.54, LengthUnit.CENTIMETER), new QuantityLength(1.0, LengthUnit.INCHES));
        assertEquals(new QuantityLength(5.08, LengthUnit.CENTIMETER), result);
    }

    @Test
    public void testAddWithZero() {
        QuantityLength result = QuantityLength.add(new QuantityLength(5.0, LengthUnit.FEET), new QuantityLength(0.0, LengthUnit.INCHES));
        assertEquals(new QuantityLength(5.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddWithNegative() {
        QuantityLength result = QuantityLength.add(new QuantityLength(5.0, LengthUnit.FEET), new QuantityLength(-2.0, LengthUnit.FEET));
        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddCommutativity() {
        QuantityLength result1 = QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES));
        QuantityLength result2 = QuantityLength.add(new QuantityLength(12.0, LengthUnit.INCHES), new QuantityLength(1.0, LengthUnit.FEET));
        assertEquals(result1.toFeet(), result2.toFeet(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullFirstOperand() {
        QuantityLength.add(null, new QuantityLength(1.0, LengthUnit.FEET));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullSecondOperand() {
        QuantityLength.add(new QuantityLength(1.0, LengthUnit.FEET), null);
    }

    @Test
    public void testInstanceAdd() {
        QuantityLength length1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength length2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = length1.add(length2);
        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }
}
