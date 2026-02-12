package com.app.quantitymeasurement.util;

import com.app.quantitymeasurement.model.LengthUnit;
import com.app.quantitymeasurement.model.QuantityLength;

public class MeasurementComparator {
    public static boolean checkFeetEquality(double v1, double v2) {
        QuantityLength f1 = new QuantityLength(v1, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(v2, LengthUnit.FEET);
        return f1.equals(f2);
    }
    public static boolean checkInchesEquality(double v1, double v2) {
        QuantityLength i1 = new QuantityLength(v1, LengthUnit.INCHES);
        QuantityLength i2 = new QuantityLength(v2, LengthUnit.INCHES);
        return i1.equals(i2);
    }
    public static boolean checkCentimeterEquality(double v1, double v2){
        QuantityLength q1 = new QuantityLength(v1, LengthUnit.CENTIMETER);
        QuantityLength q2 = new QuantityLength(v2, LengthUnit.CENTIMETER);
        return q1.equals(q2);
    }
    public static boolean checkYardEquality(double v1, double v2){
        QuantityLength q1 = new QuantityLength(v1, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(v2, LengthUnit.YARD);
        return q1.equals(q2);
    }
}
