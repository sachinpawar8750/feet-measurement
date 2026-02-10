package com.apps;

import com.apps.measurement.util.MeasurementComparator;

public class Main {

    public static void main(String[] args) {

        boolean feetResult1 = MeasurementComparator.compareFeet(10, 10);
        boolean feetResult2 = MeasurementComparator.compareFeet(17, 20);

        boolean inchResult1 = MeasurementComparator.compareInches(2, 2);
        boolean inchResult2 = MeasurementComparator.compareInches(3, 5);

        System.out.println(feetResult1);
        System.out.println(feetResult2);
        System.out.println("***************");
        System.out.println(inchResult1);
        System.out.println(inchResult2);
    }
}
