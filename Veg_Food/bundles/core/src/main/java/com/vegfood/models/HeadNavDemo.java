package com.vegfood.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.day.cq.wcm.api.Page;
import com.vegfood.services.HeaderNavigation;

@Model(adaptables = Resource.class)
public class HeadNavDemo {

	@Inject
	@Optional
	private String parentPage;

	@Inject
	private ResourceResolver resolver;

	@OSGiService
	private HeaderNavigation headNav;

	private List<Page> childPages;

	private List<Page> childPages2;

	private List<List<Page>> childList;

	public List<Page> getChildPages() {
		return childPages;
	}

	public List<Page> getChildPages2() {
		return childPages2;
	}

	@PostConstruct
	private void init() {
		System.out.println("Sling init() Called..!!");
		childList = new ArrayList<List<Page>>();
		childPages = headNav.getChildPages(resolver, parentPage);		
		int i = 1, j = 1;
		for (Page page : childPages) {
			System.out.println("Parent Page #" + i + "" + page.getName());
			i++;
			if (page.listChildren() != null) {
				String childPagePath = page.getPath();
				childPages2 = headNav.getChildPages(resolver, childPagePath);
				childList.add(childPages2);
			}
		}

		for (List<Page> list : childList) {
			System.out.println("Child Page #" + j);
			j++;
			for (Page page : list) {
				System.out.println(page.getName());
			}
		}

	}

	public List<List<Page>> getChildList() {
		return childList;
	}

}
