package com.app;

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
    }
}
