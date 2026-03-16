package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.exception.QuantityMeasurementException;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public boolean performCompare(QuantityDTO q1, QuantityDTO q2) {
        try {
            boolean result = service.compare(q1, q2);
            System.out.printf("Compare: %s == %s → %b%n", q1, q2, result);
            return result;
        } catch (QuantityMeasurementException e) {
            System.err.println("Compare error: " + e.getMessage());
            throw e;
        }
    }

    public QuantityDTO performConvert(QuantityDTO source, QuantityDTO.IMeasurableUnit targetUnit) {
        try {
            QuantityDTO result = service.convert(source, targetUnit);
            System.out.printf("Convert: %s → %s%n", source, result);
            return result;
        } catch (QuantityMeasurementException e) {
            System.err.println("Convert error: " + e.getMessage());
            throw e;
        }
    }

    public QuantityDTO performAdd(QuantityDTO q1, QuantityDTO q2) {
        try {
            QuantityDTO result = service.add(q1, q2);
            System.out.printf("Add: %s + %s = %s%n", q1, q2, result);
            return result;
        } catch (QuantityMeasurementException e) {
            System.err.println("Add error: " + e.getMessage());
            throw e;
        }
    }

    public QuantityDTO performAdd(QuantityDTO q1, QuantityDTO q2, QuantityDTO.IMeasurableUnit targetUnit) {
        try {
            QuantityDTO result = service.add(q1, q2, targetUnit);
            System.out.printf("Add (target=%s): %s + %s = %s%n", targetUnit.getUnitName(), q1, q2, result);
            return result;
        } catch (QuantityMeasurementException e) {
            System.err.println("Add error: " + e.getMessage());
            throw e;
        }
    }

    public QuantityDTO performSubtract(QuantityDTO q1, QuantityDTO q2) {
        try {
            QuantityDTO result = service.subtract(q1, q2);
            System.out.printf("Subtract: %s - %s = %s%n", q1, q2, result);
            return result;
        } catch (QuantityMeasurementException e) {
            System.err.println("Subtract error: " + e.getMessage());
            throw e;
        }
    }

    public QuantityDTO performSubtract(QuantityDTO q1, QuantityDTO q2, QuantityDTO.IMeasurableUnit targetUnit) {
        try {
            QuantityDTO result = service.subtract(q1, q2, targetUnit);
            System.out.printf("Subtract (target=%s): %s - %s = %s%n", targetUnit.getUnitName(), q1, q2, result);
            return result;
        } catch (QuantityMeasurementException e) {
            System.err.println("Subtract error: " + e.getMessage());
            throw e;
        }
    }

    public double performDivide(QuantityDTO q1, QuantityDTO q2) {
        try {
            double result = service.divide(q1, q2);
            System.out.printf("Divide: %s / %s = %.4f%n", q1, q2, result);
            return result;
        } catch (QuantityMeasurementException e) {
            System.err.println("Divide error: " + e.getMessage());
            throw e;
        }
    }

    public void performOperations(QuantityDTO q1, QuantityDTO q2, QuantityDTO.IMeasurableUnit targetUnit) {
        performCompare(q1, q2);
        performConvert(q1, q2.getUnit());
        performAdd(q1, q2);
        performAdd(q1, q2, targetUnit);
        performSubtract(q1, q2);
        performSubtract(q1, q2, targetUnit);
        performDivide(q1, q2);
    }

    public void performTemperatureOperations(QuantityDTO q1, QuantityDTO q2) {
        performCompare(q1, q2);
        performConvert(q1, q2.getUnit());
        System.out.println("Note: Temperature does not support arithmetic operations.");
    }
}
