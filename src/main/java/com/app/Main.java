package com.app;

import com.app.quantitymeasurement.model.LengthUnit;
import com.app.quantitymeasurement.model.WeightUnit;
import com.app.quantitymeasurement.model.VolumeUnit;
import com.app.quantitymeasurement.model.Quantity;

import java.util.Scanner;

import static com.app.quantitymeasurement.util.MeasurementComparator.*;
import static com.app.quantitymeasurement.util.Conversion.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Quantity Measurement Application ===");
        System.out.println("1. Length Measurements");
        System.out.println("2. Weight Measurements");
        System.out.println("3. Volume Measurements");
        System.out.print("Choose category: ");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            handleLength(scanner);
        } else if (choice == 2) {
            handleWeight(scanner);
        } else if (choice == 3) {
            handleVolume(scanner);
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
        
        Quantity<LengthUnit> length1 = new Quantity<>(value1, unit1);
        Quantity<LengthUnit> length2 = new Quantity<>(value2, unit2);
        
        demonstrateOperations(length1, length2, scanner, "FEET/INCHES/YARD/CENTIMETER", 
            s -> LengthUnit.valueOf(s.toUpperCase()));
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
        
        Quantity<WeightUnit> weight1 = new Quantity<>(value1, unit1);
        Quantity<WeightUnit> weight2 = new Quantity<>(value2, unit2);
        
        demonstrateOperations(weight1, weight2, scanner, "KILOGRAM/GRAM/POUND", 
            s -> WeightUnit.valueOf(s.toUpperCase()));
    }
    
    private static void handleVolume(Scanner scanner) {
        System.out.print("\nEnter first value: ");
        double value1 = scanner.nextDouble();
        System.out.print("Enter first unit (LITRE/MILLILITRE/GALLON): ");
        VolumeUnit unit1 = VolumeUnit.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Enter second value: ");
        double value2 = scanner.nextDouble();
        System.out.print("Enter second unit (LITRE/MILLILITRE/GALLON): ");
        VolumeUnit unit2 = VolumeUnit.valueOf(scanner.next().toUpperCase());
        
        Quantity<VolumeUnit> volume1 = new Quantity<>(value1, unit1);
        Quantity<VolumeUnit> volume2 = new Quantity<>(value2, unit2);
        
        demonstrateOperations(volume1, volume2, scanner, "LITRE/MILLILITRE/GALLON", 
            s -> VolumeUnit.valueOf(s.toUpperCase()));
    }
    
    private static <U extends com.app.quantitymeasurement.model.IMeasurable> void demonstrateOperations(
            Quantity<U> q1, Quantity<U> q2, Scanner scanner, String unitOptions, 
            java.util.function.Function<String, U> unitParser) {
        System.out.println("\nEquality: " + q1.equals(q2));
        System.out.println("Conversion: " + q1 + " = " + q1.convertTo(q2.getUnit()));
        System.out.println("Addition (first unit): " + Quantity.add(q1, q2));
        System.out.println("Subtraction (first unit): " + Quantity.subtract(q1, q2));
        System.out.println("Division: " + Quantity.divide(q1, q2));
        
        System.out.print("\nEnter target unit for addition (" + unitOptions + "): ");
        U targetUnit = unitParser.apply(scanner.next());
        System.out.println("Addition (target unit): " + Quantity.add(q1, q2, targetUnit));
        System.out.println("Subtraction (target unit): " + Quantity.subtract(q1, q2, targetUnit));
    }

}
