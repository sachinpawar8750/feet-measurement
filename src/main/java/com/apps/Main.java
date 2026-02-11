package com.apps;


import com.apps.measurement.util.MeasurementComparator;

public class Main {
    public static void main(String[] args) {

        // Hard-coded values as per use case
        boolean feetResult = MeasurementComparator.checkFeetEquality(5.0, 5.0);
        boolean feetResult1 = MeasurementComparator.checkFeetEquality(12, 5.0);
        boolean feetResult2 = MeasurementComparator.checkFeetEquality(5.0, 15);
        boolean inchesResult1 = MeasurementComparator.checkInchesEquality(12.0, 12.0);
        boolean inchesResult2 = MeasurementComparator.checkInchesEquality(10.0, 12.0);

        System.out.println("Feet equality result: " + feetResult);
        System.out.println("Feet equality result: " + feetResult1);
        System.out.println("Feet equality result: " + feetResult2);
        System.out.println("Inches equality (same): " + inchesResult1);
        System.out.println("Inches equality (different): " + inchesResult2);
    }
}