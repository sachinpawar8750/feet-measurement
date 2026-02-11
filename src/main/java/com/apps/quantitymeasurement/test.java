package com.quantitymeasurement;

public class test {

    public enum LengthUnit {
        FEET(1.0,"feet"),
        INCHES(1.0/12.0, "inches");
        private final double feetFactor;
        private final String label;

        LengthUnit(double feetFactor, String label){
            this.feetFactor = feetFactor;
            this.label = label;
        }
        public double toFeet(double value){
            return value*feetFactor;
        }
    }
    public class QuantityLength{
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit){
            if(Double.isNaN(value)){
                throw new IllegalArgumentException("Invalid "+ unit.label() +" value");
            }
            this.value = value;
            this.unit = unit;
        }
        public double toFeet(){
            return unit.toFeet(value);
        }
        @Override public boolean equals(Object obj){
            if(this==obj) return true;
            if(obj == null || getClass()!= obj.getClass()) return false;
            QuantityLength other =(Quantitylength)obj;
            return Double.compare(this.toFeet(), other.toFeet())==0;
        }
        @Override
        public int hashCode() {

            return Double.hashCode(this.toFeet());
        }
    }

}
