package com.apps.quantitymeasurement.util;

import com.apps.measurement.unit.Inches;
import com.apps.measurement.unit.Feet;
public class MeasurementComparator{
    public static boolean checkFeetEquality(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    // ===== Static method for Inches equality =====
    public static boolean checkInchesEquality(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }
}