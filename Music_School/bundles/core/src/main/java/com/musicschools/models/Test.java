package com.musicschools.models;

import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(
        adaptables = { SlingHttpServletRequest.class },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Test {

    @Self
    private SlingHttpServletRequest request;

    @Self
    private Resource resource;

    @ValueMapValue
    @Named("jcr:title")
    @Optional
    private String title;

    
    @ValueMapValue
    @Named("path")
    @Optional
    private String path;

    public String getTitle() {
		return title;
	}

	public String getPath() {
		return path;
	}

}
