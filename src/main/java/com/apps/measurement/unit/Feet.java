package com.apps.measurement.unit;
public class Feet{
    private final double value;

    public Feet(double value){
        if(Double.isNaN(value)){
            throw new IllegalArgumentException("Please enter valid input");
        }
        this.value = value;
    }

    @Override public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null || getClass()!= obj.getClass()) return false;
        Feet other =(Feet)obj;
        return Double.compare(this.value, other.value)==0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

}
