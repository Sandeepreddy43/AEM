package com.vegfood.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ABC {
	public static void main(String[] args) {
		Annotation[] Annotations = Instruments.class.getAnnotations();
		for (Annotation annotation : Annotations) {
			System.out.println(annotation.toString()+"\n");
		}
		Method[] methods = Instruments.class.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.toString());
		}
		
		String s = "/content/SchedulerPage1659/jcr:content";
		StringBuilder sb = new StringBuilder(s);
		String res = sb.reverse().delete(0, 12).reverse().toString();
		System.out.println(res);
		System.out.println(new Employee());
	}
}
class Employee{
	
	int id;
	String name;
	@Override
	public int hashCode() {
		
		return 10;
	}
}
