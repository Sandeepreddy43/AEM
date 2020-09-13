package com.law.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.day.cq.wcm.api.Page;
import com.law.services.PageNavigation;

@Model(adaptables = Resource.class)
public class HeaderNavigation {
	
	@Inject
	private ResourceResolver resolver;
	
	@Inject @Optional
	private String pagePath;
	
	@OSGiService
	private PageNavigation navigation;
	
	private List<Page> childPageList;
	
	@PostConstruct
	private void init() {
		childPageList = navigation.getChildPages(resolver, pagePath);
	}

	public List<Page> getChildPageList() {
		return childPageList;
	}
}
