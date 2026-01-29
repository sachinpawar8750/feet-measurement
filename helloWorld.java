public class helloWorld {
    public static void main(String[] agrs){
        System.out.println("Hello World");
    }
}
public class QuantityMeasurementApp {

    // ===== Feet Class =====
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

    // ===== Inches Class =====
    static class Inches {
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

    // ===== Static method for Feet equality =====
    public static boolean checkFeetEquality(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    // ===== Static method for Inches equality =====
    public static boolean checkInchesEquality(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        // Hard-coded values as per use case
        boolean feetResult = checkFeetEquality(5.0, 5.0);
        boolean inchesResult1 = checkInchesEquality(12.0, 12.0);
        boolean inchesResult2 = checkInchesEquality(10.0, 12.0);

        System.out.println("Feet equality result: " + feetResult);
        System.out.println("Inches equality (same): " + inchesResult1);
        System.out.println("Inches equality (different): " + inchesResult2);
    }
}
