package com.apps.measurement.unit;

import org.junit.Test;
import static org.junit.Assert.*;

public class InchesTest {

    @Test
    public void testEqualInches() {
        Inches inches1 = new Inches(2);
        Inches inches2 = new Inches(2);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testNotEqualInches() {
        Inches inches1 = new Inches(2);
        Inches inches2 = new Inches(5);
        assertNotEquals(inches1, inches2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInchesValue() {
        new Inches(Double.NaN);
    }

    @Test
    public void testInchesHashCode() {
        Inches inches1 = new Inches(3);
        Inches inches2 = new Inches(3);
        assertEquals(inches1.hashCode(), inches2.hashCode());
    }
}
