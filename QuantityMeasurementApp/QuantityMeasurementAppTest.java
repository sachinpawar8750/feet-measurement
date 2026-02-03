import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ===== FEET CLASS TESTS =====
    
    @Test
    @DisplayName("Test Feet equality - same values should be equal")
    public void testFeetEquality_SameValues_ShouldBeEqual() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    @DisplayName("Test Feet equality - different values should not be equal")
    public void testFeetEquality_DifferentValues_ShouldNotBeEqual() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(10.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    @DisplayName("Test Feet equality - same object reference should be equal")
    public void testFeetEquality_SameReference_ShouldBeEqual() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet.equals(feet));
    }

    @Test
    @DisplayName("Test Feet equality - null object should not be equal")
    public void testFeetEquality_NullObject_ShouldNotBeEqual() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(feet.equals(null));
    }

    @Test
    @DisplayName("Test Feet equality - different class should not be equal")
    public void testFeetEquality_DifferentClass_ShouldNotBeEqual() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        String notFeet = "5.0";
        assertFalse(feet.equals(notFeet));
    }

    @Test
    @DisplayName("Test Feet with zero value")
    public void testFeet_ZeroValue_ShouldWork() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    @DisplayName("Test Feet with negative values")
    public void testFeet_NegativeValues_ShouldWork() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(-5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(-5.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    @DisplayName("Test Feet with decimal values")
    public void testFeet_DecimalValues_ShouldWork() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(5.5, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(5.5, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    @DisplayName("Test Feet constructor with NaN should throw exception")
    public void testFeet_NaNValue_ShouldThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(Double.NaN, QuantityMeasurementApp.LengthUnit.FEET);
        });
        assertEquals("Invalid feet value", exception.getMessage());
    }

    @Test
    @DisplayName("Test Feet hashCode - equal objects should have same hashCode")
    public void testFeet_HashCode_EqualObjectsSameHashCode() {
        QuantityMeasurementApp.QuantityLength feet1 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength feet2 = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(feet1.hashCode(), feet2.hashCode());
    }

    // ===== INCHES CLASS TESTS =====

    @Test
    @DisplayName("Test Inches equality - same values should be equal")
    public void testInchesEquality_SameValues_ShouldBeEqual() {
        QuantityMeasurementApp.QuantityLength inches1 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        QuantityMeasurementApp.QuantityLength inches2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    @DisplayName("Test Inches equality - different values should not be equal")
    public void testInchesEquality_DifferentValues_ShouldNotBeEqual() {
        QuantityMeasurementApp.QuantityLength inches1 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        QuantityMeasurementApp.QuantityLength inches2 = new QuantityMeasurementApp.QuantityLength(24.0, QuantityMeasurementApp.LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    @DisplayName("Test Inches equality - same object reference should be equal")
    public void testInchesEquality_SameReference_ShouldBeEqual() {
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        assertTrue(inches.equals(inches));
    }

    @Test
    @DisplayName("Test Inches equality - null object should not be equal")
    public void testInchesEquality_NullObject_ShouldNotBeEqual() {
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        assertFalse(inches.equals(null));
    }

    @Test
    @DisplayName("Test Inches equality - different class should not be equal")
    public void testInchesEquality_DifferentClass_ShouldNotBeEqual() {
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(inches.equals(feet));
    }

    @Test
    @DisplayName("Test Inches with zero value")
    public void testInches_ZeroValue_ShouldWork() {
        QuantityMeasurementApp.QuantityLength inches1 = new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.INCHES);
        QuantityMeasurementApp.QuantityLength inches2 = new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    @DisplayName("Test Inches with negative values")
    public void testInches_NegativeValues_ShouldWork() {
        QuantityMeasurementApp.QuantityLength inches1 = new QuantityMeasurementApp.QuantityLength(-12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        QuantityMeasurementApp.QuantityLength inches2 = new QuantityMeasurementApp.QuantityLength(-12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    @DisplayName("Test Inches constructor with NaN should throw exception")
    public void testInches_NaNValue_ShouldThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(Double.NaN, QuantityMeasurementApp.LengthUnit.INCHES);
        });
        assertEquals("Invalid inches value", exception.getMessage());
    }

    @Test
    @DisplayName("Test Inches hashCode - equal objects should have same hashCode")
    public void testInches_HashCode_EqualObjectsSameHashCode() {
        QuantityMeasurementApp.QuantityLength inches1 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        QuantityMeasurementApp.QuantityLength inches2 = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCHES);
        assertEquals(inches1.hashCode(), inches2.hashCode());
    }

    // ===== STATIC METHOD TESTS =====

    @Test
    @DisplayName("Test checkFeetEquality - equal values should return true")
    public void testCheckFeetEquality_EqualValues_ShouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(5.0, 5.0));
    }

    @Test
    @DisplayName("Test checkFeetEquality - different values should return false")
    public void testCheckFeetEquality_DifferentValues_ShouldReturnFalse() {
        assertFalse(QuantityMeasurementApp.checkFeetEquality(5.0, 10.0));
    }

    @Test
    @DisplayName("Test checkFeetEquality - zero values should return true")
    public void testCheckFeetEquality_ZeroValues_ShouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(0.0, 0.0));
    }

    @Test
    @DisplayName("Test checkFeetEquality - negative values should work")
    public void testCheckFeetEquality_NegativeValues_ShouldWork() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(-5.0, -5.0));
        assertFalse(QuantityMeasurementApp.checkFeetEquality(-5.0, 5.0));
    }

    @Test
    @DisplayName("Test checkInchesEquality - equal values should return true")
    public void testCheckInchesEquality_EqualValues_ShouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.checkInchesEquality(12.0, 12.0));
    }

    @Test
    @DisplayName("Test checkInchesEquality - different values should return false")
    public void testCheckInchesEquality_DifferentValues_ShouldReturnFalse() {
        assertFalse(QuantityMeasurementApp.checkInchesEquality(12.0, 24.0));
    }

    @Test
    @DisplayName("Test checkInchesEquality - zero values should return true")
    public void testCheckInchesEquality_ZeroValues_ShouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.checkInchesEquality(0.0, 0.0));
    }

    @Test
    @DisplayName("Test checkInchesEquality - negative values should work")
    public void testCheckInchesEquality_NegativeValues_ShouldWork() {
        assertTrue(QuantityMeasurementApp.checkInchesEquality(-12.0, -12.0));
        assertFalse(QuantityMeasurementApp.checkInchesEquality(-12.0, 12.0));
    }

    // ===== EDGE CASE TESTS =====

    @Test
    @DisplayName("Test with very large values")
    public void testVeryLargeValues_ShouldWork() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(Double.MAX_VALUE, Double.MAX_VALUE));
        assertTrue(QuantityMeasurementApp.checkInchesEquality(Double.MAX_VALUE, Double.MAX_VALUE));
    }

    @Test
    @DisplayName("Test with very small values")
    public void testVerySmallValues_ShouldWork() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(Double.MIN_VALUE, Double.MIN_VALUE));
        assertTrue(QuantityMeasurementApp.checkInchesEquality(Double.MIN_VALUE, Double.MIN_VALUE));
    }

    @Test
    @DisplayName("Test with positive and negative infinity")
    public void testInfinityValues_ShouldWork() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        assertTrue(QuantityMeasurementApp.checkFeetEquality(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
        assertFalse(QuantityMeasurementApp.checkFeetEquality(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
    }

    @Test
    @DisplayName("Test checkFeetEquality with NaN should throw exception")
    public void testCheckFeetEquality_NaNValues_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.checkFeetEquality(Double.NaN, 5.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.checkFeetEquality(5.0, Double.NaN);
        });
    }

    @Test
    @DisplayName("Test checkInchesEquality with NaN should throw exception")
    public void testCheckInchesEquality_NaNValues_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.checkInchesEquality(Double.NaN, 12.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.checkInchesEquality(12.0, Double.NaN);
        });
    }
}