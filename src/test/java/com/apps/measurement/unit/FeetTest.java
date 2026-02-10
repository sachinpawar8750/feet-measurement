package com.apps.measurement.unit;

import org.junit.Test;
import static org.junit.Assert.*;

public class FeetTest {

    @Test
    public void testEqualFeet() {
        Feet feet1 = new Feet(10);
        Feet feet2 = new Feet(10);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testNotEqualFeet() {
        Feet feet1 = new Feet(10);
        Feet feet2 = new Feet(20);
        assertNotEquals(feet1, feet2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFeetValue() {
        new Feet(Double.NaN);
    }

    @Test
    public void testFeetHashCode() {
        Feet feet1 = new Feet(10);
        Feet feet2 = new Feet(10);
        assertEquals(feet1.hashCode(), feet2.hashCode());
    }
}
