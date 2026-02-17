package com.app;

import com.app.quantitymeasurement.model.LengthUnit;
import com.app.quantitymeasurement.model.QuantityLength;

import java.util.Scanner;

import static com.app.quantitymeasurement.util.MeasurementComparator.*;
import static com.app.quantitymeasurement.util.Conversion.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Length Addition Calculator ===");
        System.out.print("Enter first value: ");
        double value1 = scanner.nextDouble();
        
        System.out.print("Enter first unit (FEET/INCHES/YARD/CENTIMETER): ");
        LengthUnit unit1 = LengthUnit.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Enter second value: ");
        double value2 = scanner.nextDouble();
        
        System.out.print("Enter second unit (FEET/INCHES/YARD/CENTIMETER): ");
        LengthUnit unit2 = LengthUnit.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Enter target unit for result (FEET/INCHES/YARD/CENTIMETER): ");
        LengthUnit targetUnit = LengthUnit.valueOf(scanner.next().toUpperCase());
        
        QuantityLength length1 = new QuantityLength(value1, unit1);
        QuantityLength length2 = new QuantityLength(value2, unit2);
        QuantityLength result = QuantityLength.add(length1, length2, targetUnit);
        
        System.out.println("\nResult: " + result);
        
        scanner.close();
    }

}
