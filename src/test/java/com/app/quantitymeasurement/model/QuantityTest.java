package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityTest {

    // Length Tests - Equality
    @Test
    public void testLengthFeetEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    @Test
    public void testLengthInchesToFeetEquality() {
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        assertEquals(feet, inches);
    }

    @Test
    public void testLengthYardToFeetEquality() {
        Quantity<LengthUnit> yard = new Quantity<>(1.0, LengthUnit.YARD);
        Quantity<LengthUnit> feet = new Quantity<>(3.0, LengthUnit.FEET);
        assertEquals(yard, feet);
    }

    // Length Tests - Conversion
    @Test
    public void testLengthFeetToInchesConversion() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = feet.convertTo(LengthUnit.INCHES);
        assertEquals(new Quantity<>(12.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testLengthYardToFeetConversion() {
        Quantity<LengthUnit> yard = new Quantity<>(1.0, LengthUnit.YARD);
        Quantity<LengthUnit> result = yard.convertTo(LengthUnit.FEET);
        assertEquals(new Quantity<>(3.0, LengthUnit.FEET), result);
    }

    // Length Tests - Addition
    @Test
    public void testLengthAddSameUnits() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = Quantity.add(q1, q2);
        assertEquals(new Quantity<>(3.0, LengthUnit.FEET), result);
    }

    @Test
    public void testLengthAddDifferentUnits() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = Quantity.add(feet, inches);
        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testLengthAddWithTargetUnit() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = Quantity.add(feet, inches, LengthUnit.INCHES);
        assertEquals(new Quantity<>(24.0, LengthUnit.INCHES), result);
    }

    // Weight Tests - Equality
    @Test
    public void testWeightKilogramEquality() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertEquals(q1, q2);
    }

    @Test
    public void testWeightKilogramToGramEquality() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertEquals(kg, g);
    }

    @Test
    public void testWeightGramToKilogramEquality() {
        Quantity<WeightUnit> g = new Quantity<>(500.0, WeightUnit.GRAM);
        Quantity<WeightUnit> kg = new Quantity<>(0.5, WeightUnit.KILOGRAM);
        assertEquals(g, kg);
    }

    // Weight Tests - Conversion
    @Test
    public void testWeightKilogramToGramConversion() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = kg.convertTo(WeightUnit.GRAM);
        assertEquals(new Quantity<>(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void testWeightPoundToKilogramConversion() {
        Quantity<WeightUnit> lb = new Quantity<>(2.0, WeightUnit.POUND);
        Quantity<WeightUnit> result = lb.convertTo(WeightUnit.KILOGRAM);
        assertEquals(0.907184, result.getValue(), 0.001);
    }

    // Weight Tests - Addition
    @Test
    public void testWeightAddSameUnits() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = Quantity.add(q1, q2);
        assertEquals(new Quantity<>(3.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testWeightAddDifferentUnits() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = Quantity.add(kg, g);
        assertEquals(new Quantity<>(2.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testWeightAddWithTargetUnit() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = Quantity.add(kg, g, WeightUnit.GRAM);
        assertEquals(new Quantity<>(2000.0, WeightUnit.GRAM), result);
    }

    // Cross-Category Tests
    @Test
    public void testCrossCategoryInequality() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(length.equals(weight));
    }

    // Validation Tests
    @Test(expected = IllegalArgumentException.class)
    public void testNullUnit() {
        new Quantity<>(1.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaNValue() {
        new Quantity<>(Double.NaN, LengthUnit.FEET);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInfiniteValue() {
        new Quantity<>(Double.POSITIVE_INFINITY, LengthUnit.FEET);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertToNullUnit() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        q.convertTo(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullFirstOperand() {
        Quantity.add((Quantity<LengthUnit>) null, new Quantity<>(1.0, LengthUnit.FEET));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullSecondOperand() {
        Quantity.add(new Quantity<>(1.0, LengthUnit.FEET), (Quantity<LengthUnit>) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNullTargetUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity.add(q1, q2, (LengthUnit) null);
    }

    // Instance Method Tests
    @Test
    public void testInstanceAdd() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testInstanceAddWithTargetUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(new Quantity<>(24.0, LengthUnit.INCHES), result);
    }

    // ToString Test
    @Test
    public void testToString() {
        Quantity<LengthUnit> q = new Quantity<>(1.5, LengthUnit.FEET);
        assertEquals("Quantity(1.50, FEET)", q.toString());
    }

    // HashCode Test
    @Test
    public void testHashCodeConsistency() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    // Null Equality Test
    @Test
    public void testEqualsWithNull() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertFalse(q.equals(null));
    }

    // Self Equality Test
    @Test
    public void testEqualsWithSelf() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);
        assertTrue(q.equals(q));
    }
}
