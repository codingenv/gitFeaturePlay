package com.opencloseprinciple.demo;

public class Calculator {
    
	public void calculate(Operation operation) throws Exception {
        
		if (operation == null) {
            throw new Exception("Can not perform operation");
        }
         
		operation.perform();
    }
	
	public static void main(String[] args) throws Exception {
		Calculator obj = new Calculator();
		
		Addition add = new Addition(10, 5);
		obj.calculate(add);
		
		System.out.println("result: " + add.result);
		
		Substraction subs = new Substraction(10,  5);
		obj.calculate(subs);
		System.out.println("result: " + subs.result);
		
		Multiplication mul = new Multiplication(10,  5);
		obj.calculate(mul);
		System.out.println("result: " + mul.result);
		
		Divison  div = new Divison(10,  5);
		obj.calculate(div);
		System.out.println("result: " + div.result);
	}

}
