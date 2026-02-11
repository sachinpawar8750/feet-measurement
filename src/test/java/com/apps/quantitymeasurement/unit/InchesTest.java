package com.apps.quantitymeasurement.unit;

import com.apps.measurement.unit.Inches;
import org.junit.Test;
import static org.junit.Assert.*;

public class InchesTest {

    @Test
    public void testEqualInches() {
        Inches inches1 = new Inches(12.0);
        Inches inches2 = new Inches(12.0);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testNotEqualInches() {
        Inches inches1 = new Inches(10.0);
        Inches inches2 = new Inches(12.0);
        assertNotEquals(inches1, inches2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInchesValue() {
        new Inches(Double.NaN);
    }

    @Test
    public void testInchesHashCode() {
        Inches inches1 = new Inches(12.0);
        Inches inches2 = new Inches(12.0);
        assertEquals(inches1.hashCode(), inches2.hashCode());
    }
}
