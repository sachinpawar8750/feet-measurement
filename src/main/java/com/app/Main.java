package com.app;

import com.app.quantitymeasurement.model.LengthUnit;
import com.app.quantitymeasurement.model.QuantityLength;

import static com.app.quantitymeasurement.util.MeasurementComparator.*;

public class Main {
    public static void main(String[] args){
        boolean feetResult = checkFeetEquality(5.0, 5.0);
        boolean feetResult1 = checkFeetEquality(12, 5.0);
        boolean feetResult2 = checkFeetEquality(5.0, 15);
        boolean inchesResult1 = checkInchesEquality(12.0, 12.0);
        boolean inchesResult2 = checkInchesEquality(10.0, 12.0);
        boolean centimeterResult1 = checkCentimeterEquality(10.0, 10.0);
        boolean centimeterResult2 = checkCentimeterEquality(12.2,12.0);
        boolean yardResult1 = checkYardEquality(1.0, 1.0);
        boolean yardResult2 = checkYardEquality(3.0, 1.0);
        
        System.out.println("Feet equality result: " + feetResult);
        System.out.println("Feet equality result: " + feetResult1);
        System.out.println("Feet equality result: " + feetResult2);
        System.out.println("Inches equality (same): " + inchesResult1);
        System.out.println("Inches equality (different): " + inchesResult2);
        System.out.println("Centimeter equality result: " + centimeterResult1);
        System.out.println("Centimeter equality result for second test "+ centimeterResult2);
        System.out.println("Yard equality result: " + yardResult1);
        System.out.println("Yard equality result: " + yardResult2);
        
        System.out.println("\n--- Length Conversion Demonstrations ---");
        demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(12.0, LengthUnit.INCHES, LengthUnit.FEET);
        demonstrateLengthConversion(1.0, LengthUnit.YARD, LengthUnit.FEET);
        demonstrateLengthConversion(30.48, LengthUnit.CENTIMETER, LengthUnit.FEET);
        
        System.out.println("\n--- Length Conversion with QuantityLength Object ---");
        QuantityLength lengthInYards = new QuantityLength(2.0, LengthUnit.YARD);
        demonstrateLengthConversion(lengthInYards, LengthUnit.INCHES);
        
        System.out.println("\n--- Length Equality Demonstrations ---");
        QuantityLength length1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength length2 = new QuantityLength(1.0, LengthUnit.FEET);
        demonstrateLengthEquality(length1, length2);
        
        System.out.println("\n--- Length Comparison Demonstrations ---");
        demonstrateLengthComparison(3.0, LengthUnit.FEET, 36.0, LengthUnit.INCHES);
    }
    
    /**
     * Demonstrates length conversion from a raw value and units.
     * @param value the numeric value to convert
     * @param fromUnit the source unit
     * @param toUnit the target unit
     */
    public static void demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        
        QuantityLength original = new QuantityLength(value, fromUnit);
        QuantityLength converted = original.convertTo(toUnit);
        System.out.println(original + " = " + converted);
    }
    
    /**
     * Demonstrates length conversion from an existing QuantityLength object.
     * @param quantity the QuantityLength object to convert
     * @param toUnit the target unit
     */
    public static void demonstrateLengthConversion(QuantityLength quantity, LengthUnit toUnit) {
        if (quantity == null || toUnit == null) {
            throw new IllegalArgumentException("Quantity and unit cannot be null");
        }
        
        QuantityLength converted = quantity.convertTo(toUnit);
        System.out.println(quantity + " = " + converted);
    }
    
    /**
     * Demonstrates equality check between two QuantityLength objects.
     * @param length1 the first length
     * @param length2 the second length
     */
    public static void demonstrateLengthEquality(QuantityLength length1, QuantityLength length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Lengths cannot be null");
        }
        
        boolean areEqual = length1.equals(length2);
        System.out.println(length1 + " equals " + length2 + ": " + areEqual);
    }
    
    /**
     * Demonstrates comparison between two lengths with different units.
     * @param value1 the first value
     * @param unit1 the first unit
     * @param value2 the second value
     * @param unit2 the second unit
     */
    public static void demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        if (!Double.isFinite(value1) || !Double.isFinite(value2)) {
            throw new IllegalArgumentException("Values must be finite");
        }
        if (unit1 == null || unit2 == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        
        QuantityLength length1 = new QuantityLength(value1, unit1);
        QuantityLength length2 = new QuantityLength(value2, unit2);
        demonstrateLengthEquality(length1, length2);
    }
}
