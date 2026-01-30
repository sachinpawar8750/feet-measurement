public class QuantityMeasurementApp {
    static class Feet {
        private final double value;

        public Feet(double value) {
            if (Double.isNaN(value)) {
                throw new IllegalArgumentException("Invalid feet value");
            }
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // ===== Static method for Feet equality =====
    public static boolean checkFeetEquality(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }


    // ===== Main Method =====
    public static void main(String[] args) {

        // Hard-coded values as per use case
        boolean feetResult = checkFeetEquality(5.0, 5.0);
        boolean feetResult1 = checkFeetEquality(12, 5.0);
        boolean feetResult2 = checkFeetEquality(5.0, 15);

        System.out.println("Feet equality result: " + feetResult);
        System.out.println("Feet equality result: " + feetResult1);
        System.out.println("Feet equality result: " + feetResult2);
    }
}