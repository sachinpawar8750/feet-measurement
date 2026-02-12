package com.apps.quantitymeasurement.unit;
public class Inches {
    private final double value;

    public Inches(double value) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Invalid inches value");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Inches other = (Inches) obj;
        return Double.compare(this.value, other.value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}