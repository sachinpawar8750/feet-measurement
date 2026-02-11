package com.apps.quantitymeasurement.unit;

import com.apps.measurement.unit.Feet;
import org.junit.Test;
import static org.junit.Assert.*;

public class FeetTest {

    @Test
    public void testEqualFeet() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testNotEqualFeet() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(12.0);
        assertNotEquals(feet1, feet2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFeetValue() {
        new Feet(Double.NaN);
    }

    @Test
    public void testFeetHashCode() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);
        assertEquals(feet1.hashCode(), feet2.hashCode());
    }
}
