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
}
