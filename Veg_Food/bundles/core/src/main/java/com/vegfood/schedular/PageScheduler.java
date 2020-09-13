package com.vegfood.schedular;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(immediate = true)
@Designate(ocd = SchedulerInterface.class)
public class PageScheduler implements Runnable {

	int i = 1;
	private String pagePath;
	@SuppressWarnings("unused")
	private String templatePath;
	@SuppressWarnings("unused")
	private String pageName;
	@SuppressWarnings("unused")
	private String pageTitle;
	
	@Reference
	private ResourceResolverFactory resResolverFactory;
	private ResourceResolver resourceResolver; 
	
	@Activate
	private void pageCreation(SchedulerInterface configure) {
		pagePath = configure.pagePath();
		templatePath = configure.templatePath();
		pageName = configure.pageName();
		pageTitle = configure.pageTitle();
	}
	
	@Override
	public void run() {
		System.out.println(i+": Page Scheduler - run()"); i++;
		Map<String, Object> map = new HashMap<>();
		map.put(ResourceResolverFactory.SUBSERVICE, "PageCreationDemo");
		try {
			resourceResolver = resResolverFactory.getServiceResourceResolver(map);
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
//			Page page = pageManager.create(pagePath, pageName, templatePath, pageTitle);
			
			Resource resource = resourceResolver.getResource(pagePath+"/SchedulerPage"+i);
			
			if (resource != null) {
				resourceResolver.delete(resource);
				
			}
			Page page2 = pageManager.getPage(pagePath+"/SchedulerPage"+i);
			String title = page2.getTitle();
//			pageManager.delete(page2, true);
			System.out.println(title+"Delete Operation \n");
			resourceResolver.commit();
			
		} catch (LoginException | PersistenceException e) {
			e.printStackTrace();
		}
	}

}
