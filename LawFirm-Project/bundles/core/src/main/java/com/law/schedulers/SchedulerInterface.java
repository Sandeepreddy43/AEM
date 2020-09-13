package com.law.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Test Scheduler - 6.4")
public @interface SchedulerInterface {

	@AttributeDefinition(name = "Meassage", description = "Message to be displayed !!")
	String displayMessage() default "Hi, Welcome to 2020";

	@AttributeDefinition(name = "Scheduler Expression - 6.4", description = "Enter the CRON Expression here.. No need to go for Backend(Java)")
	String scheduler_expression() default "0/30 0/1 * 1/1 * ? *";
	
	@AttributeDefinition(name = "Page Path", description = "Give the Path, where you want to Store your Page -- under /Content")
	String pagePath() default "/content/Law-Proj";
	
	@AttributeDefinition(name = "Template Path", description = "Give the Path, on which Template you are going to create your Page")
	String templatePath() default "/apps/lawfirm-project/templates/IndexPage";
	
	@AttributeDefinition(name = "Page Name & Title", description = "Give the Name/Title of the Page")
	String pageTitle() default "Page123456";
}
