package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityArithmeticTest {

    // Subtraction Tests - Length
    @Test
    public void testSubtractSameUnitLength() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = Quantity.subtract(q1, q2);
        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), result);
    }

    @Test
    public void testSubtractDifferentUnitsLength() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = Quantity.subtract(q1, q2);
        assertEquals(9.5, result.getValue(), 0.01);
    }

    @Test
    public void testSubtractWithTargetUnitLength() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = Quantity.subtract(q1, q2, LengthUnit.INCHES);
        assertEquals(114.0, result.getValue(), 0.01);
    }

    @Test
    public void testSubtractResultingInNegative() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = Quantity.subtract(q1, q2);
        assertEquals(new Quantity<>(-5.0, LengthUnit.FEET), result);
    }

    @Test
    public void testSubtractResultingInZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(120.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = Quantity.subtract(q1, q2);
        assertEquals(0.0, result.getValue(), 0.01);
    }

    // Subtraction Tests - Weight
    @Test
    public void testSubtractSameUnitWeight() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = Quantity.subtract(q1, q2);
        assertEquals(new Quantity<>(5.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testSubtractDifferentUnitsWeight() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = Quantity.subtract(q1, q2);
        assertEquals(new Quantity<>(5.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void testSubtractWithTargetUnitWeight() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = Quantity.subtract(q1, q2, WeightUnit.GRAM);
        assertEquals(5000.0, result.getValue(), 0.01);
    }

    // Subtraction Tests - Volume
    @Test
    public void testSubtractSameUnitVolume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = Quantity.subtract(q1, q2);
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testSubtractDifferentUnitsVolume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = Quantity.subtract(q1, q2);
        assertEquals(4.5, result.getValue(), 0.01);
    }

    @Test
    public void testSubtractWithTargetUnitVolume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = Quantity.subtract(q1, q2, VolumeUnit.MILLILITRE);
        assertEquals(3000.0, result.getValue(), 0.01);
    }

    // Division Tests - Length
    @Test
    public void testDivideSameUnitLength() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = Quantity.divide(q1, q2);
        assertEquals(5.0, result, 0.01);
    }

    @Test
    public void testDivideDifferentUnitsLength() {
        Quantity<LengthUnit> q1 = new Quantity<>(24.0, LengthUnit.INCHES);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = Quantity.divide(q1, q2);
        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testDivideResultGreaterThanOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        double result = Quantity.divide(q1, q2);
        assertEquals(2.0, result, 0.01);
    }

    @Test
    public void testDivideResultLessThanOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);
        double result = Quantity.divide(q1, q2);
        assertEquals(0.5, result, 0.01);
    }

    @Test
    public void testDivideResultEqualsOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);
        double result = Quantity.divide(q1, q2);
        assertEquals(1.0, result, 0.01);
    }

    // Division Tests - Weight
    @Test
    public void testDivideSameUnitWeight() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        double result = Quantity.divide(q1, q2);
        assertEquals(2.0, result, 0.01);
    }

    @Test
    public void testDivideDifferentUnitsWeight() {
        Quantity<WeightUnit> q1 = new Quantity<>(2000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        double result = Quantity.divide(q1, q2);
        assertEquals(2.0, result, 0.01);
    }

    // Division Tests - Volume
    @Test
    public void testDivideSameUnitVolume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(5.0, VolumeUnit.LITRE);
        double result = Quantity.divide(q1, q2);
        assertEquals(2.0, result, 0.01);
    }

    @Test
    public void testDivideDifferentUnitsVolume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        double result = Quantity.divide(q1, q2);
        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testDivideVolumeResultLessThanOne() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(10.0, VolumeUnit.LITRE);
        double result = Quantity.divide(q1, q2);
        assertEquals(0.5, result, 0.01);
    }

    // Error Handling Tests
    @Test(expected = IllegalArgumentException.class)
    public void testSubtractNullFirstOperand() {
        Quantity.subtract((Quantity<LengthUnit>) null, new Quantity<>(5.0, LengthUnit.FEET));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractNullSecondOperand() {
        Quantity.subtract(new Quantity<>(10.0, LengthUnit.FEET), (Quantity<LengthUnit>) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractNullTargetUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity.subtract(q1, q2, (LengthUnit) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideNullFirstOperand() {
        Quantity.divide((Quantity<LengthUnit>) null, new Quantity<>(5.0, LengthUnit.FEET));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideNullSecondOperand() {
        Quantity.divide(new Quantity<>(10.0, LengthUnit.FEET), (Quantity<LengthUnit>) null);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);
        Quantity.divide(q1, q2);
    }

    // Instance Method Tests
    @Test
    public void testInstanceSubtract() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), result);
    }

    @Test
    public void testInstanceSubtractWithTargetUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = q1.subtract(q2, LengthUnit.INCHES);
        assertEquals(114.0, result.getValue(), 0.01);
    }

    @Test
    public void testInstanceDivide() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = q1.divide(q2);
        assertEquals(5.0, result, 0.01);
    }

    // Edge Cases
    @Test
    public void testSubtractWithZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = Quantity.subtract(q1, q2);
        assertEquals(new Quantity<>(10.0, LengthUnit.FEET), result);
    }

    @Test
    public void testSubtractLargeValues() {
        Quantity<LengthUnit> q1 = new Quantity<>(1000000.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(500000.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = Quantity.subtract(q1, q2);
        assertEquals(new Quantity<>(500000.0, LengthUnit.FEET), result);
    }

    @Test
    public void testDivideWithLargeValues() {
        Quantity<LengthUnit> q1 = new Quantity<>(1000000.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(500000.0, LengthUnit.FEET);
        double result = Quantity.divide(q1, q2);
        assertEquals(2.0, result, 0.01);
    }
}
