package com.apps.measurement.util;

import com.apps.measurement.unit.Feet;
import com.apps.measurement.unit.Inches;

public class MeasurementComparator {

    public static boolean compareFeet(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
//        return new Feet(v1).equals(new Feet(v2));
    }

    public static boolean compareInches(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
//        return new Inches(v1).equals(new Inches(v2));
    }
}
