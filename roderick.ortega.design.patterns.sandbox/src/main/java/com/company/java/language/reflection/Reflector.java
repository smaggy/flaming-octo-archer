package com.company.java.language.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflector {
	
	@SuppressWarnings("rawtypes")
	private Class clazz;

	@SuppressWarnings("rawtypes")
	public Class getClazz() {
		return clazz;
	}

	@SuppressWarnings("rawtypes")
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Constructor getConstructor(Class[] params) throws SecurityException, NoSuchMethodException {
		return getClazz().getConstructor(params);
	}
	
	@SuppressWarnings("rawtypes")
	public Constructor[] getConstructors() {
		return getClazz().getConstructors();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Constructor getDeclaredConstructor(Class[] params) throws SecurityException, NoSuchMethodException {
		return getClazz().getDeclaredConstructor(params);
	}
	
	@SuppressWarnings("rawtypes")
	public Constructor[] getDeclaredConstructors() {
		return getClazz().getDeclaredConstructors();
	}
	
	public Field getField(String fieldName) throws SecurityException, NoSuchFieldException {
		return getClazz().getField(fieldName);
	}
	
	public Field[] getFields() {
		return getClazz().getFields();
	}
	
	public Field getDeclaredField(String fieldName) throws SecurityException, NoSuchFieldException {
		return getClazz().getDeclaredField(fieldName);
	}
	
	public Field[] getDeclaredFields() {
		return getClazz().getDeclaredFields();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Method getMethod(String name, Class[] params) throws SecurityException, NoSuchMethodException {
		return getClazz().getMethod(name, params);
	}
	
	public Method[] getMethods() {
		return getClazz().getMethods();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Method getDeclaredMethod(String name, Class[] params) throws SecurityException, NoSuchMethodException {
		return getClazz().getDeclaredMethod(name, params);
	}
	
	public Method[] getDeclaredMethods() {
		return getClazz().getDeclaredMethods();
	}
}
