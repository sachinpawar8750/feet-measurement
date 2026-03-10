package com.app.quantitymeasurement.model;

public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseValue = this.toBaseUnit();
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("Quantity(%.2f, %s)", value, unit.getUnitName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> other = (Quantity<?>) obj;
        if (this.unit.getClass() != other.unit.getClass()) return false;
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.toBaseUnit());
    }

    public static <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2) {
        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }
        double baseSum = q1.toBaseUnit() + q2.toBaseUnit();
        double resultValue = q1.unit.convertFromBaseUnit(baseSum);
        return new Quantity<>(resultValue, q1.unit);
    }

    public static <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseSum = q1.toBaseUnit() + q2.toBaseUnit();
        double resultValue = targetUnit.convertFromBaseUnit(baseSum);
        return new Quantity<>(resultValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(this, other);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        return add(this, other, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2) {
        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }
        double baseDiff = q1.toBaseUnit() - q2.toBaseUnit();
        double resultValue = q1.unit.convertFromBaseUnit(baseDiff);
        return new Quantity<>(resultValue, q1.unit);
    }

    public static <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseDiff = q1.toBaseUnit() - q2.toBaseUnit();
        double resultValue = targetUnit.convertFromBaseUnit(baseDiff);
        return new Quantity<>(resultValue, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(this, other);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        return subtract(this, other, targetUnit);
    }

    public static <U extends IMeasurable> double divide(Quantity<U> q1, Quantity<U> q2) {
        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantities cannot be null");
        }
        double divisor = q2.toBaseUnit();
        if (divisor == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        return q1.toBaseUnit() / divisor;
    }

    public double divide(Quantity<U> other) {
        return divide(this, other);
    }
}
