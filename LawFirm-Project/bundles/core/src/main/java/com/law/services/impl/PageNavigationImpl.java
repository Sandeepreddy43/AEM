package com.law.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.law.services.PageNavigation;

@Component(service = PageNavigation.class, name = "Page Navigation - OSGI Service")
public class PageNavigationImpl implements PageNavigation {

	@Override
	public List<Page> getChildPages(ResourceResolver resolver, String pagePath) {
		List<Page> childPages = new ArrayList<>();
		PageManager pm = resolver.adaptTo(PageManager.class);
		if(pm != null && pagePath != null) {
			Page page = pm.getPage(pagePath);
			if(page != null) {
				Iterator<Page> listChildren = page.listChildren();
				while(listChildren.hasNext()) {
					Page next = listChildren.next();
					childPages.add(next);
				}
			}
		}
		return childPages;
	}

}
