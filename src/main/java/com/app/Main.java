package com.app;

import com.app.quantitymeasurement.model.LengthUnit;
import com.app.quantitymeasurement.model.QuantityLength;
import com.app.quantitymeasurement.model.WeightUnit;
import com.app.quantitymeasurement.model.QuantityWeight;

import java.util.Scanner;

import static com.app.quantitymeasurement.util.MeasurementComparator.*;
import static com.app.quantitymeasurement.util.Conversion.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Quantity Measurement Application ===");
        System.out.println("1. Length Measurements");
        System.out.println("2. Weight Measurements");
        System.out.print("Choose category: ");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            handleLength(scanner);
        } else if (choice == 2) {
            handleWeight(scanner);
        } else {
            System.out.println("Invalid choice");
        }
        
        scanner.close();
    }
    
    private static void handleLength(Scanner scanner) {
        System.out.print("\nEnter first value: ");
        double value1 = scanner.nextDouble();
        System.out.print("Enter first unit (FEET/INCHES/YARD/CENTIMETER): ");
        LengthUnit unit1 = LengthUnit.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Enter second value: ");
        double value2 = scanner.nextDouble();
        System.out.print("Enter second unit (FEET/INCHES/YARD/CENTIMETER): ");
        LengthUnit unit2 = LengthUnit.valueOf(scanner.next().toUpperCase());
        
        QuantityLength length1 = new QuantityLength(value1, unit1);
        QuantityLength length2 = new QuantityLength(value2, unit2);
        
        System.out.println("\nEquality: " + length1.equals(length2));
        System.out.println("Conversion: " + length1 + " = " + length1.convertTo(unit2));
        System.out.println("Addition (first unit): " + QuantityLength.add(length1, length2));
        
        System.out.print("\nEnter target unit for addition (FEET/INCHES/YARD/CENTIMETER): ");
        LengthUnit targetUnit = LengthUnit.valueOf(scanner.next().toUpperCase());
        System.out.println("Addition (target unit): " + QuantityLength.add(length1, length2, targetUnit));
    }
    
    private static void handleWeight(Scanner scanner) {
        System.out.print("\nEnter first value: ");
        double value1 = scanner.nextDouble();
        System.out.print("Enter first unit (KILOGRAM/GRAM/POUND): ");
        WeightUnit unit1 = WeightUnit.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Enter second value: ");
        double value2 = scanner.nextDouble();
        System.out.print("Enter second unit (KILOGRAM/GRAM/POUND): ");
        WeightUnit unit2 = WeightUnit.valueOf(scanner.next().toUpperCase());
        
        QuantityWeight weight1 = new QuantityWeight(value1, unit1);
        QuantityWeight weight2 = new QuantityWeight(value2, unit2);
        
        System.out.println("\nEquality: " + weight1.equals(weight2));
        System.out.println("Conversion: " + weight1 + " = " + weight1.convertTo(unit2));
        System.out.println("Addition (first unit): " + QuantityWeight.add(weight1, weight2));
        
        System.out.print("\nEnter target unit for addition (KILOGRAM/GRAM/POUND): ");
        WeightUnit targetUnit = WeightUnit.valueOf(scanner.next().toUpperCase());
        System.out.println("Addition (target unit): " + QuantityWeight.add(weight1, weight2, targetUnit));
    }

}
