package com.app.quantitymeasurement.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityTemperatureTest {

    // Equality Tests
    @Test
    public void testCelsiusEquality() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertEquals(t1, t2);
    }

    @Test
    public void testFahrenheitEquality() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> t2 = new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(t1, t2);
    }

    @Test
    public void testCelsiusToFahrenheitEquality() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> fahrenheit = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(celsius, fahrenheit);
    }

    @Test
    public void testBoilingPointEquality() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> fahrenheit = new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(celsius, fahrenheit);
    }

    @Test
    public void testNegativeTemperatureEquality() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(-40.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> fahrenheit = new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(celsius, fahrenheit);
    }

    // Conversion Tests
    @Test
    public void testCelsiusToFahrenheitConversion() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = celsius.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(212.0, result.getValue(), 0.001);
    }

    @Test
    public void testFahrenheitToCelsiusConversion() {
        Quantity<TemperatureUnit> fahrenheit = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> result = fahrenheit.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(0.0, result.getValue(), 0.001);
    }

    @Test
    public void testZeroCelsiusToFahrenheit() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = celsius.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(32.0, result.getValue(), 0.001);
    }

    @Test
    public void testNegativeTemperatureConversion() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(-40.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = celsius.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(-40.0, result.getValue(), 0.001);
    }

    @Test
    public void testSameUnitConversion() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(25.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = celsius.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(25.0, result.getValue(), 0.001);
    }

    // Cross-Category Tests
    @Test
    public void testTemperatureVsLengthIncompatibility() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<LengthUnit> length = new Quantity<>(100.0, LengthUnit.FEET);
        assertFalse(temp.equals(length));
    }

    @Test
    public void testTemperatureVsWeightIncompatibility() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<WeightUnit> weight = new Quantity<>(100.0, WeightUnit.KILOGRAM);
        assertFalse(temp.equals(weight));
    }

    @Test
    public void testTemperatureVsVolumeIncompatibility() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<VolumeUnit> volume = new Quantity<>(100.0, VolumeUnit.LITRE);
        assertFalse(temp.equals(volume));
    }

    // Unsupported Operations Tests
    @Test(expected = UnsupportedOperationException.class)
    public void testAdditionNotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity.add(t1, t2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubtractionNotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity.subtract(t1, t2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDivisionNotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity.divide(t1, t2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAdditionWithTargetUnitNotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity.add(t1, t2, TemperatureUnit.FAHRENHEIT);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubtractionWithTargetUnitNotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity.subtract(t1, t2, TemperatureUnit.FAHRENHEIT);
    }

    // Validation Tests
    @Test(expected = IllegalArgumentException.class)
    public void testNullUnit() {
        new Quantity<>(100.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaNValue() {
        new Quantity<>(Double.NaN, TemperatureUnit.CELSIUS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInfiniteValue() {
        new Quantity<>(Double.POSITIVE_INFINITY, TemperatureUnit.CELSIUS);
    }

    // ToString Test
    @Test
    public void testToString() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertEquals("Quantity(100.00, CELSIUS)", temp.toString());
    }

    // HashCode Test
    @Test
    public void testHashCodeConsistency() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    // Null Equality Test
    @Test
    public void testEqualsWithNull() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertFalse(temp.equals(null));
    }

    // Self Equality Test
    @Test
    public void testEqualsWithSelf() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertTrue(temp.equals(temp));
    }

    // Edge Cases
    @Test
    public void testZeroTemperature() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(t1, t2);
    }

    @Test
    public void testLargeTemperature() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(1000.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = celsius.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(1832.0, result.getValue(), 0.001);
    }

    @Test
    public void testVeryNegativeTemperature() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(-273.15, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = celsius.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(-459.67, result.getValue(), 0.01);
    }
}
