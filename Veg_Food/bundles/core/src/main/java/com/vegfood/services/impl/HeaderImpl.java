package com.vegfood.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.vegfood.services.HeaderNavigation;

@Component(service = HeaderNavigation.class, name = "Navigation OSGI Service")
@Designate(ocd = TestData.class)
public class HeaderImpl implements HeaderNavigation {

	public List<Page> childPages;
	private String message;
	

	@Activate
	private void activate(TestData data) {
		message = data.message();

	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public List<Page> getChildPages(ResourceResolver resolver, String pagePath) {
		//System.out.println("Implementation - getChildPages() Called");
		PageManager pm = resolver.adaptTo(PageManager.class);
		childPages = new ArrayList<Page>();
		if(null != pm && null != pagePath) {
			Page page = pm.getPage(pagePath);
			if(page != null) {
				Iterator<Page> listChildren = page.listChildren();
				while(listChildren.hasNext()) {
					Page child = listChildren.next();
					childPages.add(child);
				}
			}else 
				System.out.println("Page not Found "+page);
		}else
			System.out.println("PagePath Error "+pagePath);		
		return childPages;
	}
}