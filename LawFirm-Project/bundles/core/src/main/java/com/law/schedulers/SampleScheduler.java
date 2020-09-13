package com.law.schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.result.Hit;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.law.queryBuilder.QueryBuilderInterface;

@Component(immediate = true)
@Designate(ocd = SchedulerInterface.class)
public class SampleScheduler implements Runnable {
	
	Logger loger = LoggerFactory.getLogger(this.getClass());

	private String displayMessage;	
	int i = 1;
	private String pagePath;
	private String templatePath;
	private String pageTitle;

	@Activate
	private void shceduler(SchedulerInterface test) {
		displayMessage = test.displayMessage();
		pagePath = test.pagePath();
		templatePath = test.templatePath();
		pageTitle = test.pageTitle();

	}

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Reference
	QueryBuilderInterface build;

	@Override
	public void run() {
		System.out.println(i + " : " + displayMessage);
		loger.info("Logger Runs: ---> "+i);
		if (i % 100 == 0) {
			System.out.println("\n------------Scheduler Runs " + i + " times ..!!------------\n");
		}
		i++;

		List<Hit> list = build.getHitsService();
		for (Hit hit : list) {
			try {
				System.out.println(hit.getPath().toString());
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * We are mapping this below SUBSERVICE to Apache Sling Service User Mapper
		 * Service Amendment in ConfigMgr(Felix Console)..!! To map this, we had
		 * already created a user in user admin console(localhost:4502/useradmin) named
		 * test-user-admin.. We are mapping the above user with the symbolic name of our
		 * project(We can find in our bundle(Felix console))
		 */

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ResourceResolverFactory.SUBSERVICE, "sandeep");
		try {
			ResourceResolver serviceResourceResolver = resourceResolverFactory.getServiceResourceResolver(map);
			if (null != serviceResourceResolver) {
				Resource resource = serviceResourceResolver.getResource("");
				if (null != resource) {
					PageManager pageManager = serviceResourceResolver.adaptTo(PageManager.class);
//					pageManager.
					Page page = pageManager.create(pagePath, pageTitle, templatePath, pageTitle);
					System.out.println("Page Path: " + page.getPath());
					serviceResourceResolver.commit();
				}
			}
		} catch (LoginException | WCMException | PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}