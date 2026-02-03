public class QuantityMeasurementApp {
    // Enum representing supported length units and their conversion factor to feet
    public enum LengthUnit {
        FEET(1.0, "feet"),
        INCHES(1.0 / 12.0, "inches");

        private final double toFeetFactor;
        private final String label;

        LengthUnit(double toFeetFactor, String label) {
            this.toFeetFactor = toFeetFactor;
            this.label = label;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public String label() {
            return label;
        }
    }

    // Generic QuantityLength class that represents a measurement and its unit
    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (Double.isNaN(value)) {
                throw new IllegalArgumentException("Invalid " + unit.label() + " value");
            }
            this.value = value;
            this.unit = unit;
        }

        public double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            QuantityLength other = (QuantityLength) obj;
            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(this.toFeet());
        }
    }

    // ===== Static method for Feet equality (kept for compatibility) =====
    public static boolean checkFeetEquality(double v1, double v2) {
        QuantityLength f1 = new QuantityLength(v1, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(v2, LengthUnit.FEET);
        return f1.equals(f2);
    }

    // ===== Static method for Inches equality (kept for compatibility) =====
    public static boolean checkInchesEquality(double v1, double v2) {
        QuantityLength i1 = new QuantityLength(v1, LengthUnit.INCHES);
        QuantityLength i2 = new QuantityLength(v2, LengthUnit.INCHES);
        return i1.equals(i2);
    }

    // ===== Main Method =====
    public static void main(String[] args) {
        boolean feetResult = checkFeetEquality(5.0, 5.0);
        boolean feetResult1 = checkFeetEquality(12, 5.0);
        boolean feetResult2 = checkFeetEquality(5.0, 15);
        boolean inchesResult1 = checkInchesEquality(12.0, 12.0);
        boolean inchesResult2 = checkInchesEquality(10.0, 12.0);

        System.out.println("Feet equality result: " + feetResult);
        System.out.println("Feet equality result: " + feetResult1);
        System.out.println("Feet equality result: " + feetResult2);
        System.out.println("Inches equality (same): " + inchesResult1);
        System.out.println("Inches equality (different): " + inchesResult2);
    }
}