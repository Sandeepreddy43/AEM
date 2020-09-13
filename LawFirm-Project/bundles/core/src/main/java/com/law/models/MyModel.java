package com.law.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class MyModel {

	@Inject @Optional
	private String title;
	
	public String getTitle() {
		return title;
	}
	
	@PostConstruct
	private void myLogic() {
		title = title+" ABC 123";
	}
}
