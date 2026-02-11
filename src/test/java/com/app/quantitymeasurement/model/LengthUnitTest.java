package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LengthUnitTest {

    @Test
    public void testFeetToFeet() {
        assertEquals(5.0, LengthUnit.FEET.toFeet(5.0), 0.001);
    }

    @Test
    public void testInchesToFeet() {
        assertEquals(1.0, LengthUnit.INCHES.toFeet(12.0), 0.001);
    }

    @Test
    public void testFeetLabel() {
        assertEquals("feet", LengthUnit.FEET.label());
    }

    @Test
    public void testInchesLabel() {
        assertEquals("inches", LengthUnit.INCHES.label());
    }
}
