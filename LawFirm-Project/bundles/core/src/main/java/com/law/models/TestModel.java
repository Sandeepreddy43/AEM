package com.law.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestModel {

	@ValueMapValue
	private String title;
	
	@ValueMapValue @Default
	private Integer charLimit;
	
	@PostConstruct
	private void init() {
		if(title != null && 0 < charLimit && charLimit < title.length()) {
			title = title.substring(0, charLimit);
		}
		
	}

	public String getTitle() {
		return title;
	}
}
