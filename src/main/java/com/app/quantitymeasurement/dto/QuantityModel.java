package com.app.quantitymeasurement.dto;

import com.app.quantitymeasurement.model.IMeasurable;

public class QuantityModel<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public QuantityModel(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() { return value; }
    public U getUnit() { return unit; }

    public double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public String toString() {
        return String.format("QuantityModel(%.4f, %s)", value, unit.getUnitName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityModel<?> other = (QuantityModel<?>) obj;
        if (this.unit.getClass() != other.unit.getClass()) return false;
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.toBaseUnit());
    }
}
