package com.app;

import com.app.quantitymeasurement.controller.QuantityMeasurementController;
import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import com.app.quantitymeasurement.service.QuantityMeasurementServiceImpl;

import java.util.Scanner;

public class Main {

    private static Main instance;
    private final QuantityMeasurementController controller;

    private Main() {
        this.controller = createController();
    }

    public static synchronized Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    private static IQuantityMeasurementService createService() {
        return new QuantityMeasurementServiceImpl(QuantityMeasurementCacheRepository.getInstance());
    }

    private static QuantityMeasurementController createController() {
        return new QuantityMeasurementController(createService());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Quantity Measurement Application (UC15 N-Tier) ===");
        System.out.println("1. Length Measurements");
        System.out.println("2. Weight Measurements");
        System.out.println("3. Volume Measurements");
        System.out.println("4. Temperature Measurements");
        System.out.print("Choose category: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: handleLength(scanner);      break;
            case 2: handleWeight(scanner);      break;
            case 3: handleVolume(scanner);      break;
            case 4: handleTemperature(scanner); break;
            default: System.out.println("Invalid choice");
        }
        scanner.close();
    }

    private void handleLength(Scanner scanner) {
        System.out.print("\nEnter first value: ");
        double v1 = scanner.nextDouble();
        System.out.print("Enter first unit (FEET/INCHES/YARD/CENTIMETER): ");
        QuantityDTO.LengthUnit u1 = QuantityDTO.LengthUnit.valueOf(scanner.next().toUpperCase());

        System.out.print("Enter second value: ");
        double v2 = scanner.nextDouble();
        System.out.print("Enter second unit (FEET/INCHES/YARD/CENTIMETER): ");
        QuantityDTO.LengthUnit u2 = QuantityDTO.LengthUnit.valueOf(scanner.next().toUpperCase());

        System.out.print("Enter target unit for arithmetic (FEET/INCHES/YARD/CENTIMETER): ");
        QuantityDTO.LengthUnit target = QuantityDTO.LengthUnit.valueOf(scanner.next().toUpperCase());

        controller.performOperations(new QuantityDTO(v1, u1), new QuantityDTO(v2, u2), target);
    }

    private void handleWeight(Scanner scanner) {
        System.out.print("\nEnter first value: ");
        double v1 = scanner.nextDouble();
        System.out.print("Enter first unit (KILOGRAM/GRAM/POUND): ");
        QuantityDTO.WeightUnit u1 = QuantityDTO.WeightUnit.valueOf(scanner.next().toUpperCase());

        System.out.print("Enter second value: ");
        double v2 = scanner.nextDouble();
        System.out.print("Enter second unit (KILOGRAM/GRAM/POUND): ");
        QuantityDTO.WeightUnit u2 = QuantityDTO.WeightUnit.valueOf(scanner.next().toUpperCase());

        System.out.print("Enter target unit for arithmetic (KILOGRAM/GRAM/POUND): ");
        QuantityDTO.WeightUnit target = QuantityDTO.WeightUnit.valueOf(scanner.next().toUpperCase());

        controller.performOperations(new QuantityDTO(v1, u1), new QuantityDTO(v2, u2), target);
    }

    private void handleVolume(Scanner scanner) {
        System.out.print("\nEnter first value: ");
        double v1 = scanner.nextDouble();
        System.out.print("Enter first unit (LITRE/MILLILITRE/GALLON): ");
        QuantityDTO.VolumeUnit u1 = QuantityDTO.VolumeUnit.valueOf(scanner.next().toUpperCase());

        System.out.print("Enter second value: ");
        double v2 = scanner.nextDouble();
        System.out.print("Enter second unit (LITRE/MILLILITRE/GALLON): ");
        QuantityDTO.VolumeUnit u2 = QuantityDTO.VolumeUnit.valueOf(scanner.next().toUpperCase());

        System.out.print("Enter target unit for arithmetic (LITRE/MILLILITRE/GALLON): ");
        QuantityDTO.VolumeUnit target = QuantityDTO.VolumeUnit.valueOf(scanner.next().toUpperCase());

        controller.performOperations(new QuantityDTO(v1, u1), new QuantityDTO(v2, u2), target);
    }

    private void handleTemperature(Scanner scanner) {
        System.out.print("\nEnter first value: ");
        double v1 = scanner.nextDouble();
        System.out.print("Enter first unit (CELSIUS/FAHRENHEIT): ");
        QuantityDTO.TemperatureUnit u1 = QuantityDTO.TemperatureUnit.valueOf(scanner.next().toUpperCase());

        System.out.print("Enter second value: ");
        double v2 = scanner.nextDouble();
        System.out.print("Enter second unit (CELSIUS/FAHRENHEIT): ");
        QuantityDTO.TemperatureUnit u2 = QuantityDTO.TemperatureUnit.valueOf(scanner.next().toUpperCase());

        controller.performTemperatureOperations(new QuantityDTO(v1, u1), new QuantityDTO(v2, u2));
    }

    public static void main(String[] args) {
        Main.getInstance().run();
    }
}
