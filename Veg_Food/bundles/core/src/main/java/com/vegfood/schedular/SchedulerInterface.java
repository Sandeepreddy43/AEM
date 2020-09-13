package com.vegfood.schedular;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Page Scheduler")
public @interface SchedulerInterface {
	
	@AttributeDefinition(name = "Page Path", description = "Enter the Path, where You want to store Your Page under /Content")
	String pagePath() default " ";
	
	@AttributeDefinition(name = "Template Path", description = "Enter the Path, on which Template You want to Create a Page")
	String templatePath() default " ";
	
	@AttributeDefinition(name = "Page Name", description = "Enter the Name of Your Page")
	String pageName() default " ";
	
	@AttributeDefinition(name = "Page Title", description = "Enter the Title of Your Page")
	String pageTitle() default " ";
	
	@AttributeDefinition(name = "Scheduler Expression", description = "Enter the CRON expression for your Page Creation Demo..!!")
	String scheduler_expression() default " ";
}
