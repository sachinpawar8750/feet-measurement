package com.app.quantitymeasurement.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeasurementComparatorTest {

    @Test
    public void testCheckFeetEquality() {
        assertTrue(MeasurementComparator.checkFeetEquality(5.0, 5.0));
        assertFalse(MeasurementComparator.checkFeetEquality(5.0, 10.0));
    }

    @Test
    public void testCheckInchesEquality() {
        assertTrue(MeasurementComparator.checkInchesEquality(12.0, 12.0));
        assertFalse(MeasurementComparator.checkInchesEquality(10.0, 12.0));
    }

    @Test
    public void testCheckCentimeterEquality() {
        assertTrue(MeasurementComparator.checkCentimeterEquality(10.0, 10.0));
        assertFalse(MeasurementComparator.checkCentimeterEquality(12.2, 12.0));
    }

    @Test
    public void testCheckYardEquality() {
        assertTrue(MeasurementComparator.checkYardEquality(1.0, 1.0));
        assertFalse(MeasurementComparator.checkYardEquality(3.0, 1.0));
    }
}
