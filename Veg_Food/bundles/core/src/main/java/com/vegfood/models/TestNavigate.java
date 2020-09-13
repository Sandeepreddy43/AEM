package com.vegfood.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = {Resource.class})
public class TestNavigate {

	@Inject @Optional
	private String parentPage;
	
	@Inject 
	private ResourceResolver resolver;
	
	@Inject @Optional
	private Session session;
	
	private List<Page> childPages;
	
	public List<Page> getChildPages() {
		return childPages;
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() throws InstantiationException, IllegalAccessException, PathNotFoundException, RepositoryException {
		//   /content/we-retail
		PageManager pageManager = resolver.adaptTo(PageManager.class);
		session.getClass().newInstance();
		Node node = session.getNode(parentPage);
		String path = node.getPath();
		
		childPages = new ArrayList<Page>();
		if(null != pageManager && null != parentPage) {
			System.out.println("Page Manager: "+pageManager);
			Page page = pageManager.getPage(parentPage);
			System.out.println("Page: "+page);
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
