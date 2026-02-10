package com.apps.measurement.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeasurementComparatorTest {

    @Test
    public void testCompareFeetEqual() {
        assertTrue(MeasurementComparator.compareFeet(10, 10));
    }

    @Test
    public void testCompareFeetNotEqual() {
        assertFalse(MeasurementComparator.compareFeet(10, 20));
    }

    @Test
    public void testCompareInchesEqual() {
        assertTrue(MeasurementComparator.compareInches(12, 12));
    }

    @Test
    public void testCompareInchesNotEqual() {
        assertFalse(MeasurementComparator.compareInches(12, 24));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareFeetWithInvalidValue() {
        MeasurementComparator.compareFeet(Double.NaN, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareInchesWithInvalidValue() {
        MeasurementComparator.compareInches(Double.NaN, 12);
    }
}
