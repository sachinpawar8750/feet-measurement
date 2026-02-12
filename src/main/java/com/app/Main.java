package com.app;

import com.app.quantitymeasurement.model.LengthUnit;
import com.app.quantitymeasurement.model.QuantityLength;

import static com.app.quantitymeasurement.util.MeasurementComparator.*;
import static com.app.quantitymeasurement.util.Conversion.*;

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
        LengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
        LengthConversion(12.0, LengthUnit.INCHES, LengthUnit.FEET);
        LengthConversion(1.0, LengthUnit.YARD, LengthUnit.FEET);
        LengthConversion(30.48, LengthUnit.CENTIMETER, LengthUnit.FEET);
        
        System.out.println("\n--- Length Conversion with QuantityLength Object ---");
        QuantityLength lengthInYards = new QuantityLength(2.0, LengthUnit.YARD);
        LengthConversion(lengthInYards, LengthUnit.INCHES);
        
        System.out.println("\n--- Length Equality Demonstrations ---");
        QuantityLength length1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength length2 = new QuantityLength(1.0, LengthUnit.FEET);
        LengthEquality(length1, length2);
        
        System.out.println("\n--- Length Comparison Demonstrations ---");
        LengthComparison(3.0, LengthUnit.FEET, 36.0, LengthUnit.INCHES);
    }

}
