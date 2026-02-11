package com.apps.quantitymeasurement.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeasurementComparatorTest {

    @Test
    public void testCheckFeetEqualityTrue() {
        assertTrue(MeasurementComparator.checkFeetEquality(5.0, 5.0));
    }

    @Test
    public void testCheckFeetEqualityFalse() {
        assertFalse(MeasurementComparator.checkFeetEquality(12.0, 5.0));
        assertFalse(MeasurementComparator.checkFeetEquality(5.0, 15.0));
    }

    @Test
    public void testCheckInchesEqualityTrue() {
        assertTrue(MeasurementComparator.checkInchesEquality(12.0, 12.0));
    }

    @Test
    public void testCheckInchesEqualityFalse() {
        assertFalse(MeasurementComparator.checkInchesEquality(10.0, 12.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckFeetEqualityWithInvalidValue() {
        MeasurementComparator.checkFeetEquality(Double.NaN, 5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckInchesEqualityWithInvalidValue() {
        MeasurementComparator.checkInchesEquality(Double.NaN, 12.0);
    }
}
