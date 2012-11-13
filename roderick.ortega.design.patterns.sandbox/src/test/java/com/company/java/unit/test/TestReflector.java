package com.company.java.unit.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.company.concrete.test.objects.Calculator;
import com.company.java.language.reflection.Reflector;

public class TestReflector {

	private Calculator calculator;
	private Reflector reflector;

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public Reflector getReflector() {
		return reflector;
	}

	public void setReflector(Reflector reflector) {
		this.reflector = reflector;
	}
	
	@Before
	public void before() {
		System.out.println("##### NEW TEST #####");
	}
	
	@Test
	public void test01() {
		setCalculator(new Calculator());
		setReflector(new Reflector());
		
		getReflector().setClazz(Calculator.class);
		
		Field[] calculatorFields = getReflector().getDeclaredFields();
		for (Field field : calculatorFields) {
			System.out.println("Field: " + field.getName());
			System.out.println("Accessibility: " + field.isAccessible());
		}
	}
	
	@Test
	public void test02() {
		setCalculator(new Calculator());
		setReflector(new Reflector());
		
		getReflector().setClazz(Calculator.class);
		
		Method[] calculatorMethods = getReflector().getDeclaredMethods();
		for (Method method : calculatorMethods) {
			System.out.println("Method: " + method.getName());
			System.out.println("Accessibility: " + method.isAccessible());
			System.out.println("Return Type: " + method.getGenericReturnType());
			System.out.println("Generic Signature: " + method.toGenericString());
			System.out.println("Signature: " + method.toString());
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void test03() {
		setCalculator(new Calculator());
		setReflector(new Reflector());
		
		getReflector().setClazz(Calculator.class);
		
		Constructor[] calculatorConstructors = getReflector().getDeclaredConstructors();
		for (Constructor constructor : calculatorConstructors) {
			System.out.println("Constructor: " + constructor.getName());
			System.out.println("Accessibility: " + constructor.isAccessible());
			System.out.println("Parameter Types: " + constructor.getGenericParameterTypes());
			System.out.println("Signature: " + constructor.toGenericString());
		}
	}
	
}
