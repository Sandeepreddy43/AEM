package com.vegfood.models;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.vegfood.services.Test;


@Model(
        adaptables = { SlingHttpServletRequest.class },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TestModel {

    @Self
    private SlingHttpServletRequest request;

    @Self
    private Resource resource;

    @ValueMapValue
    @Named("title")
    @Optional
    private String title;

    @OSGiService
    private Test test;
    
    @ValueMapValue
    @Named("path")
    @Optional
    private String path;
    
    private String author;

    public String getTitle() {
		return title;
	}

	public String getPath() {
		return path;
	}
	
	@PostConstruct
	private void init() {
		if(null != title) {
			author = test.author(title);
		}else
		author = test.author("Sandeep");
	}

	public String getAuthor() {
		return author;
	}

}
