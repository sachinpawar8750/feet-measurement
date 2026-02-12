package com.app.quantitymeasurement.util;

import com.app.quantitymeasurement.model.LengthUnit;
import com.app.quantitymeasurement.model.QuantityLength;

public class Conversion {

    public static void LengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
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

    public static void LengthConversion(QuantityLength quantity, LengthUnit toUnit) {
        if (quantity == null || toUnit == null) {
            throw new IllegalArgumentException("Quantity and unit cannot be null");
        }

        QuantityLength converted = quantity.convertTo(toUnit);
        System.out.println(quantity + " = " + converted);
    }
    public static void LengthEquality(QuantityLength length1, QuantityLength length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Lengths cannot be null");
        }

        boolean areEqual = length1.equals(length2);
        System.out.println(length1 + " equals " + length2 + ": " + areEqual);
    }
    public static void LengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        if (!Double.isFinite(value1) || !Double.isFinite(value2)) {
            throw new IllegalArgumentException("Values must be finite");
        }
        if (unit1 == null || unit2 == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        QuantityLength length1 = new QuantityLength(value1, unit1);
        QuantityLength length2 = new QuantityLength(value2, unit2);
        LengthEquality(length1, length2);
    }
}
