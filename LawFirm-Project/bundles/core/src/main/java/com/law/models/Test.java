package com.law.models;

public class Test {
@SuppressWarnings("static-access")
public static void main(String[] args) {
//	B b = new B();
//	System.out.println(b.i);
	
	for (int i = 1; i < 1201; i++) {
		if(i%100 == 0) {
			System.out.println("Step: "+i);
		}
	}
}
}
//class A {
//	static int i =1111;
//	static {
//		i = i-- - --i;
//		System.out.println("A Class"+i);
//	}
//	{
//		i = i++ + ++i;
//		System.out.println("A - Instance "+i);
//	}
//}
//class B extends A {
//	static {
//		i = --i - i--;
//		System.out.println("B Class"+i);
//	}
//	{
//		i = ++i + i++;
//		System.out.println("B - Instance "+i);
//	}
//}