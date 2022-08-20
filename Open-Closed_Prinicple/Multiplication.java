package com.opencloseprinciple.demo;

public class Multiplication implements Operation{
    public double a;
    public double b;
    public double result = 0.0;

    public Multiplication(double a , double b) {
        this.a = a;
        this.b = b;
    }
    
    public void perform()
    {
    	this.result = this.a * this.b;
    }

}
