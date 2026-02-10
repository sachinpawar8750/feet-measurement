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
        assertFalse(MeasurementComparator.compareFeet(17, 20));
    }

    @Test
    public void testCompareInchesEqual() {
        assertTrue(MeasurementComparator.compareInches(2, 2));
    }

    @Test
    public void testCompareInchesNotEqual() {
        assertFalse(MeasurementComparator.compareInches(3, 5));
    }
}
