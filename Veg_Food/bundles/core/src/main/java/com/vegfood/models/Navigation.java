package com.vegfood.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = {Resource.class})
public class Navigation {

	@Inject @Optional
	private String parentPage;
	
	@Inject
	private ResourceResolver resolver;
	
	private List<Page> childPages;
	
	public List<Page> getChildPages() {
		return childPages;
	}

	@PostConstruct
	private void init() {
		PageManager pageManager = resolver.adaptTo(PageManager.class);
		childPages = new ArrayList<Page>();
		if(null != pageManager && null != parentPage) {
			Page page = pageManager.getPage(parentPage);
			if(null != page) {
				Iterator<Page> listChildren = page.listChildren();
				while(listChildren.hasNext()) {
					Page next = listChildren.next();
					childPages.add(next);
				}
			}
		}
		
	}
	
}
