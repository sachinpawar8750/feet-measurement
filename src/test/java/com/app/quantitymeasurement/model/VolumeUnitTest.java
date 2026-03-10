package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class VolumeUnitTest {

    @Test
    public void testLitreConversionFactor() {
        assertEquals(1.0, VolumeUnit.LITRE.getConversionFactor(), 0.001);
    }

    @Test
    public void testMillilitreConversionFactor() {
        assertEquals(0.001, VolumeUnit.MILLILITRE.getConversionFactor(), 0.0001);
    }

    @Test
    public void testGallonConversionFactor() {
        assertEquals(3.78541, VolumeUnit.GALLON.getConversionFactor(), 0.00001);
    }

    @Test
    public void testLitreToBaseUnit() {
        assertEquals(1.0, VolumeUnit.LITRE.convertToBaseUnit(1.0), 0.001);
    }

    @Test
    public void testMillilitreToBaseUnit() {
        assertEquals(1.0, VolumeUnit.MILLILITRE.convertToBaseUnit(1000.0), 0.001);
    }

    @Test
    public void testGallonToBaseUnit() {
        assertEquals(3.78541, VolumeUnit.GALLON.convertToBaseUnit(1.0), 0.00001);
    }

    @Test
    public void testLitreFromBaseUnit() {
        assertEquals(1.0, VolumeUnit.LITRE.convertFromBaseUnit(1.0), 0.001);
    }

    @Test
    public void testMillilitreFromBaseUnit() {
        assertEquals(1000.0, VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0), 0.001);
    }

    @Test
    public void testGallonFromBaseUnit() {
        assertEquals(0.264172, VolumeUnit.GALLON.convertFromBaseUnit(1.0), 0.001);
    }

    @Test
    public void testLitreLabel() {
        assertEquals("L", VolumeUnit.LITRE.label());
    }

    @Test
    public void testMillilitreLabel() {
        assertEquals("mL", VolumeUnit.MILLILITRE.label());
    }

    @Test
    public void testGallonLabel() {
        assertEquals("gal", VolumeUnit.GALLON.label());
    }

    @Test
    public void testLitreUnitName() {
        assertEquals("LITRE", VolumeUnit.LITRE.getUnitName());
    }

    @Test
    public void testMillilitreUnitName() {
        assertEquals("MILLILITRE", VolumeUnit.MILLILITRE.getUnitName());
    }

    @Test
    public void testGallonUnitName() {
        assertEquals("GALLON", VolumeUnit.GALLON.getUnitName());
    }
}
