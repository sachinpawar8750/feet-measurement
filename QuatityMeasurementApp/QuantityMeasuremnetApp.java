import java.util.Scanner;
import java.util.Objects;
//package.com.apps.quantitymeasurement;
public class QuantityMeasurementApp{
    public static class Feet{
        private final double value;
        public Feet(double value){
            this.value=value;

        }
        @Override
        public boolean equals(Object obj){
            if(this==obj){
                return true;
            }
            if(obj==null || getClass()!=obj.getClass()){
                return false;
            }
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value)==0;
        }
        @Override 
        public int hashCode(){
            return Double.hashCode(this.value);
        }
    }
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter first measurement in feet");
            double val1 =scanner.nextDouble();
            System.out.println("Enter second measurement in feet");
            double val2 =scanner.nextDouble();
            Feet first = new Feet(val1);
            Feet second = new Feet(val2);
            System.out.println("Are they equal? "+ first.equals(second));

        } catch(Exception e){
            System.out.println("Invalid input, please enter valid input");
        }
        
    }
}