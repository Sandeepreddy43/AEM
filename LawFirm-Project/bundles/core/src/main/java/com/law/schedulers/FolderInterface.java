package com.law.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Folder Scheduler - 6.4")
public @interface FolderInterface {

	@AttributeDefinition(name = "Meassage", description = "Message to be displayed !!")
	String displayMessage() default "Hi, Welcome to 2020";

	@AttributeDefinition(name = "Scheduler Expression - 6.4", description = "Enter the CRON Expression here.. No need to go for Backend(Java)")
	String scheduler_expression() default "0/30 0/1 * 1/1 * ? *";
}
