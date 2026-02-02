public class SimpleTestRunner {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("Running QuantityMeasurementApp Tests...\n");
        
        // Feet Tests
        testFeetEquality();
        testFeetInequality();
        testFeetNullCheck();
        testFeetNaNException();
        testFeetHashCode();
        
        // Inches Tests
        testInchesEquality();
        testInchesInequality();
        testInchesNullCheck();
        testInchesNaNException();
        testInchesHashCode();
        
        // Static Method Tests
        testCheckFeetEqualityMethod();
        testCheckInchesEqualityMethod();
        
        // Edge Cases
        testEdgeCases();
        
        System.out.println("\n=== TEST RESULTS ===");
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed: " + passedTests);
        System.out.println("Failed: " + (totalTests - passedTests));
        System.out.println("Success Rate: " + (passedTests * 100 / totalTests) + "%");
    }
    
    private static void testFeetEquality() {
        test("Feet Equality - Same Values", () -> {
            QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(5.0);
            QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(5.0);
            return f1.equals(f2);
        });
    }
    
    private static void testFeetInequality() {
        test("Feet Inequality - Different Values", () -> {
            QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(5.0);
            QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(10.0);
            return !f1.equals(f2);
        });
    }
    
    private static void testFeetNullCheck() {
        test("Feet Null Check", () -> {
            QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(5.0);
            return !f1.equals(null);
        });
    }
    
    private static void testFeetNaNException() {
        test("Feet NaN Exception", () -> {
            try {
                new QuantityMeasurementApp.Feet(Double.NaN);
                return false;
            } catch (IllegalArgumentException e) {
                return e.getMessage().equals("Invalid feet value");
            }
        });
    }
    
    private static void testFeetHashCode() {
        test("Feet HashCode Consistency", () -> {
            QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(5.0);
            QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(5.0);
            return f1.hashCode() == f2.hashCode();
        });
    }
    
    private static void testInchesEquality() {
        test("Inches Equality - Same Values", () -> {
            QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(12.0);
            QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(12.0);
            return i1.equals(i2);
        });
    }
    
    private static void testInchesInequality() {
        test("Inches Inequality - Different Values", () -> {
            QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(12.0);
            QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(24.0);
            return !i1.equals(i2);
        });
    }
    
    private static void testInchesNullCheck() {
        test("Inches Null Check", () -> {
            QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(12.0);
            return !i1.equals(null);
        });
    }
    
    private static void testInchesNaNException() {
        test("Inches NaN Exception", () -> {
            try {
                new QuantityMeasurementApp.Inches(Double.NaN);
                return false;
            } catch (IllegalArgumentException e) {
                return e.getMessage().equals("Invalid inches value");
            }
        });
    }
    
    private static void testInchesHashCode() {
        test("Inches HashCode Consistency", () -> {
            QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(12.0);
            QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(12.0);
            return i1.hashCode() == i2.hashCode();
        });
    }
    
    private static void testCheckFeetEqualityMethod() {
        test("checkFeetEquality Method - Equal", () -> 
            QuantityMeasurementApp.checkFeetEquality(5.0, 5.0));
        
        test("checkFeetEquality Method - Not Equal", () -> 
            !QuantityMeasurementApp.checkFeetEquality(5.0, 10.0));
    }
    
    private static void testCheckInchesEqualityMethod() {
        test("checkInchesEquality Method - Equal", () -> 
            QuantityMeasurementApp.checkInchesEquality(12.0, 12.0));
        
        test("checkInchesEquality Method - Not Equal", () -> 
            !QuantityMeasurementApp.checkInchesEquality(12.0, 24.0));
    }
    
    private static void testEdgeCases() {
        test("Zero Values", () -> 
            QuantityMeasurementApp.checkFeetEquality(0.0, 0.0));
        
        test("Negative Values", () -> 
            QuantityMeasurementApp.checkFeetEquality(-5.0, -5.0));
        
        test("Large Values", () -> 
            QuantityMeasurementApp.checkFeetEquality(Double.MAX_VALUE, Double.MAX_VALUE));
    }
    
    private static void test(String testName, TestCase testCase) {
        totalTests++;
        try {
            boolean result = testCase.run();
            if (result) {
                System.out.println("✓ " + testName);
                passedTests++;
            } else {
                System.out.println("✗ " + testName + " - FAILED");
            }
        } catch (Exception e) {
            System.out.println("✗ " + testName + " - ERROR: " + e.getMessage());
        }
    }
    
    @FunctionalInterface
    interface TestCase {
        boolean run() throws Exception;
    }
}