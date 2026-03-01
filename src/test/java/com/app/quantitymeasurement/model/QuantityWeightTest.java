package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityWeightTest {

    // Equality Tests - Same Unit
    @Test
    public void testKilogramEquality() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testGramEquality() {
        QuantityWeight w1 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testPoundEquality() {
        QuantityWeight w1 = new QuantityWeight(2.0, WeightUnit.POUND);
        QuantityWeight w2 = new QuantityWeight(2.0, WeightUnit.POUND);
        assertEquals(w1, w2);
    }

    // Equality Tests - Cross Unit
    @Test
    public void testKilogramToGramEquality() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(kg, g);
    }

    @Test
    public void testKilogramToPoundEquality() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight lb = new QuantityWeight(2.20462442, WeightUnit.POUND);
        double epsilon = 0.000001;
        assertEquals(kg.getValue(), lb.convertTo(WeightUnit.KILOGRAM).getValue(), epsilon);
    }

    @Test
    public void testGramToKilogramEquality() {
        QuantityWeight g = new QuantityWeight(500.0, WeightUnit.GRAM);
        QuantityWeight kg = new QuantityWeight(0.5, WeightUnit.KILOGRAM);
        assertEquals(g, kg);
    }

    @Test
    public void testPoundToGramEquality() {
        QuantityWeight lb = new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight g = new QuantityWeight(453.592, WeightUnit.GRAM);
        assertEquals(lb, g);
    }

    // Inequality Tests
    @Test
    public void testKilogramInequality() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        assertNotEquals(w1, w2);
    }

    // Conversion Tests
    @Test
    public void testKilogramToGramConversion() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight result = kg.convertTo(WeightUnit.GRAM);
        assertEquals(new QuantityWeight(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void testPoundToKilogramConversion() {
        QuantityWeight lb = new QuantityWeight(2.0, WeightUnit.POUND);
        QuantityWeight result = lb.convertTo(WeightUnit.KILOGRAM);
        assertEquals(0.907184, result.getValue(), 0.001);
    }

    @Test
    public void testGramToPoundConversion() {
        QuantityWeight g = new QuantityWeight(500.0, WeightUnit.GRAM);
        QuantityWeight result = g.convertTo(WeightUnit.POUND);
        assertEquals(1.10231, result.getValue(), 0.001);
    }

    @Test
    public void testZeroKilogramToGramConversion() {
        QuantityWeight kg = new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        QuantityWeight result = kg.convertTo(WeightUnit.GRAM);
        assertEquals(new QuantityWeight(0.0, WeightUnit.GRAM), result);
    }

    // Addition Tests - Implicit Target Unit
    @Test
    public void testAddSameUnitKilogram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        QuantityWeight result = QuantityWeight.add(w1, w2);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testAddKilogramAndGram() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = QuantityWeight.add(kg, g);
        assertEquals(new QuantityWeight(2.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testAddGramAndKilogram() {
        QuantityWeight g = new QuantityWeight(500.0, WeightUnit.GRAM);
        QuantityWeight kg = new QuantityWeight(0.5, WeightUnit.KILOGRAM);
        QuantityWeight result = QuantityWeight.add(g, kg);
        assertEquals(new QuantityWeight(1000.0, WeightUnit.GRAM), result);
    }

    // Addition Tests - Explicit Target Unit
    @Test
    public void testAddKilogramAndGramWithGramTarget() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = QuantityWeight.add(kg, g, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(2000.0, WeightUnit.GRAM), result);
    }

    @Test
    public void testAddPoundAndGramWithPoundTarget() {
        QuantityWeight lb = new QuantityWeight(1.0, WeightUnit.POUND);
        QuantityWeight g = new QuantityWeight(453.592, WeightUnit.GRAM);
        QuantityWeight result = QuantityWeight.add(lb, g, WeightUnit.POUND);
        assertEquals(2.0, result.getValue(), 0.001);
    }

    @Test
    public void testAddKilogramAndPoundWithKilogramTarget() {
        QuantityWeight kg = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        QuantityWeight lb = new QuantityWeight(4.0, WeightUnit.POUND);
        QuantityWeight result = QuantityWeight.add(kg, lb, WeightUnit.KILOGRAM);
        assertEquals(3.814368, result.getValue(), 0.001);
    }

    // Instance Method Tests
    @Test
    public void testInstanceAdd() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(new QuantityWeight(2.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testInstanceAddWithTargetUnit() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2, WeightUnit.GRAM);
        assertEquals(new QuantityWeight(2000.0, WeightUnit.GRAM), result);
    }

    // Edge Cases
    @Test
    public void testAddWithZero() {
        QuantityWeight w1 = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(0.0, WeightUnit.GRAM);
        QuantityWeight result = QuantityWeight.add(w1, w2);
        assertEquals(new QuantityWeight(5.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testAddWithNegative() {
        QuantityWeight w1 = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(-2.0, WeightUnit.KILOGRAM);
        QuantityWeight result = QuantityWeight.add(w1, w2);
        assertEquals(new QuantityWeight(3.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testAddCommutativity() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result1 = QuantityWeight.add(w1, w2, WeightUnit.KILOGRAM);
        QuantityWeight result2 = QuantityWeight.add(w2, w1, WeightUnit.KILOGRAM);
        assertEquals(result1, result2);
    }

    // Category Incompatibility Test
    @Test
    public void testWeightAndLengthIncompatibility() {
        QuantityWeight weight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityLength length = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(weight.equals(length));
    }

    // Validation Tests
    @Test(expected = IllegalArgumentException.class)
    public void testNullUnit() {
        new QuantityWeight(1.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaNValue() {
        new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInfiniteValue() {
        new QuantityWeight(Double.POSITIVE_INFINITY, WeightUnit.KILOGRAM);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertToNullUnit() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        w.convertTo(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullFirstOperand() {
        QuantityWeight.add((QuantityWeight) null, new QuantityWeight(1.0, WeightUnit.KILOGRAM));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullSecondOperand() {
        QuantityWeight.add(new QuantityWeight(1.0, WeightUnit.KILOGRAM), (QuantityWeight) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNullTargetUnit() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight.add(w1, w2, (WeightUnit) null);
    }

    // ToString Test
    @Test
    public void testToString() {
        QuantityWeight w = new QuantityWeight(1.5, WeightUnit.KILOGRAM);
        assertEquals("Quantity(1.50, KILOGRAM)", w.toString());
    }

    // HashCode Test
    @Test
    public void testHashCodeConsistency() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(w1.hashCode(), w2.hashCode());
    }

    // Null Equality Test
    @Test
    public void testEqualsWithNull() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertFalse(w.equals(null));
    }

    // Self Equality Test
    @Test
    public void testEqualsWithSelf() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(w.equals(w));
    }
}
