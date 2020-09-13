package com.vegfood.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Test Dynamic Data")
public @interface TestData {
	
	@AttributeDefinition(name="Message", description="Message to be displayed", cardinality = 2)
	String message() default "Hello World - Welcome 2020";
	
	@AttributeDefinition(name="Schedular Expression")
	String scheduler_expression() default "0/30 0/1 * 1/1 * ? *";
	
	@AttributeDefinition(name="Clean Up Path")
	String path() default "/content/abc";

}
