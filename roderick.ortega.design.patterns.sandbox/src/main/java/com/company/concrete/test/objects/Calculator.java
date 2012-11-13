package com.company.concrete.test.objects;
/**
 * Calculator class: basic class with fields, setters and getters, and methods.
 * Used for basic testing purposes.
 * 
 * @author ortega_e
 *
 */
public class Calculator {
	
	private int number1;
	private int number2;
	
	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public Calculator() {
		
	}
	
	public Calculator(int number1, int number2) {
		this.setNumber1(number1);
		this.setNumber2(number2);
	}
	
	public int add(int number1, int number2) {
		this.setNumber1(number1);
		this.setNumber2(number2);
		return number1 + number2;
	}
	
	public int subtract(int number1, int number2) {
		this.setNumber1(number1);
		this.setNumber2(number2);
		return number1 - number2;
	}
	
	public int multiply(int number1, int number2) {
		this.setNumber1(number1);
		this.setNumber2(number2);
		return number1 * number2;
	}
	
}
