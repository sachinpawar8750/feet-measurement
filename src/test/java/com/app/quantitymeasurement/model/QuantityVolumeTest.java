package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityVolumeTest {

    // Equality Tests - Same Unit
    @Test
    public void testLitreEquality() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(q1, q2);
    }

    @Test
    public void testMillilitreEquality() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }

    @Test
    public void testGallonEquality() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.GALLON);
        assertEquals(q1, q2);
    }

    // Equality Tests - Cross Unit
    @Test
    public void testLitreToMillilitreEquality() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertEquals(litre, ml);
    }

    @Test
    public void testMillilitreToLitreEquality() {
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(ml, litre);
    }

    @Test
    public void testLitreToGallonEquality() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(0.264172, VolumeUnit.GALLON);
        assertEquals(litre.getValue(), gallon.convertTo(VolumeUnit.LITRE).getValue(), 0.001);
    }

    @Test
    public void testGallonToLitreEquality() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertEquals(gallon, litre);
    }

    @Test
    public void testMillilitreToGallonEquality() {
        Quantity<VolumeUnit> ml = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> litre = new Quantity<>(0.5, VolumeUnit.LITRE);
        assertEquals(ml, litre);
    }

    // Inequality Tests
    @Test
    public void testLitreInequality() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        assertNotEquals(q1, q2);
    }

    // Conversion Tests
    @Test
    public void testLitreToMillilitreConversion() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = litre.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    public void testMillilitreToLitreConversion() {
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = ml.convertTo(VolumeUnit.LITRE);
        assertEquals(new Quantity<>(1.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testGallonToLitreConversion() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> result = gallon.convertTo(VolumeUnit.LITRE);
        assertEquals(3.78541, result.getValue(), 0.001);
    }

    @Test
    public void testLitreToGallonConversion() {
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = litre.convertTo(VolumeUnit.GALLON);
        assertEquals(1.0, result.getValue(), 0.001);
    }

    @Test
    public void testMillilitreToGallonConversion() {
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = ml.convertTo(VolumeUnit.GALLON);
        assertEquals(0.264172, result.getValue(), 0.001);
    }

    @Test
    public void testZeroLitreToMillilitreConversion() {
        Quantity<VolumeUnit> litre = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = litre.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(0.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    public void testSameUnitConversion() {
        Quantity<VolumeUnit> litre = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = litre.convertTo(VolumeUnit.LITRE);
        assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE), result);
    }

    // Addition Tests - Implicit Target Unit
    @Test
    public void testAddSameUnitLitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = Quantity.add(q1, q2);
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testAddSameUnitMillilitre() {
        Quantity<VolumeUnit> q1 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = Quantity.add(q1, q2);
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    public void testAddLitreAndMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = Quantity.add(litre, ml);
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testAddMillilitreAndLitre() {
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = Quantity.add(ml, litre);
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    public void testAddGallonAndLitre() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = Quantity.add(gallon, litre);
        assertEquals(2.0, result.getValue(), 0.001);
    }

    // Addition Tests - Explicit Target Unit
    @Test
    public void testAddWithTargetUnitLitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = Quantity.add(litre, ml, VolumeUnit.LITRE);
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testAddWithTargetUnitMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = Quantity.add(litre, ml, VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    public void testAddWithTargetUnitGallon() {
        Quantity<VolumeUnit> litre1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> litre2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = Quantity.add(litre1, litre2, VolumeUnit.GALLON);
        assertEquals(2.0, result.getValue(), 0.001);
    }

    @Test
    public void testAddGallonAndLitreWithGallonTarget() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = Quantity.add(gallon, litre, VolumeUnit.GALLON);
        assertEquals(2.0, result.getValue(), 0.001);
    }

    // Edge Cases
    @Test
    public void testAddWithZero() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = Quantity.add(q1, q2);
        assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testAddWithNegative() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(-2000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = Quantity.add(q1, q2);
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testZeroValueEquality() {
        Quantity<VolumeUnit> q1 = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }

    @Test
    public void testNegativeVolumeEquality() {
        Quantity<VolumeUnit> q1 = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }

    @Test
    public void testLargeVolumeValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1000000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.LITRE);
        assertEquals(q1, q2);
    }

    @Test
    public void testSmallVolumeValue() {
        Quantity<VolumeUnit> q1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.MILLILITRE);
        assertEquals(q1, q2);
    }

    // Cross-Category Tests
    @Test
    public void testVolumeVsLengthIncompatibility() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        assertFalse(volume.equals(length));
    }

    @Test
    public void testVolumeVsWeightIncompatibility() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(volume.equals(weight));
    }

    // Validation Tests
    @Test(expected = IllegalArgumentException.class)
    public void testNullUnit() {
        new Quantity<>(1.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaNValue() {
        new Quantity<>(Double.NaN, VolumeUnit.LITRE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInfiniteValue() {
        new Quantity<>(Double.POSITIVE_INFINITY, VolumeUnit.LITRE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertToNullUnit() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        q.convertTo(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullFirstOperand() {
        Quantity.add((Quantity<VolumeUnit>) null, new Quantity<>(1.0, VolumeUnit.LITRE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullSecondOperand() {
        Quantity.add(new Quantity<>(1.0, VolumeUnit.LITRE), (Quantity<VolumeUnit>) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNullTargetUnit() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity.add(q1, q2, (VolumeUnit) null);
    }

    // Instance Method Tests
    @Test
    public void testInstanceAdd() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = q1.add(q2);
        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testInstanceAddWithTargetUnit() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = q1.add(q2, VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), result);
    }

    // ToString Test
    @Test
    public void testToString() {
        Quantity<VolumeUnit> q = new Quantity<>(1.5, VolumeUnit.LITRE);
        assertEquals("Quantity(1.50, LITRE)", q.toString());
    }

    // HashCode Test
    @Test
    public void testHashCodeConsistency() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    // Null Equality Test
    @Test
    public void testEqualsWithNull() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertFalse(q.equals(null));
    }

    // Self Equality Test
    @Test
    public void testEqualsWithSelf() {
        Quantity<VolumeUnit> q = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(q.equals(q));
    }

    // Commutativity Test
    @Test
    public void testAddCommutativity() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result1 = Quantity.add(q1, q2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result2 = Quantity.add(q2, q1, VolumeUnit.LITRE);
        assertEquals(result1, result2);
    }

    // Round Trip Conversion Test
    @Test
    public void testRoundTripConversion() {
        Quantity<VolumeUnit> original = new Quantity<>(1.5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> converted = original.convertTo(VolumeUnit.MILLILITRE).convertTo(VolumeUnit.LITRE);
        assertEquals(original.getValue(), converted.getValue(), 0.001);
    }
}
