package com.vegfood.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class NavigationMultiField {

	@Inject @Optional
	private Resource navItems;
	private List<NavItemBean> navItemList;
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		navItemList = new ArrayList<NavItemBean>();
		if(null != navItems) {
			Iterator<Resource> listChildren = navItems.listChildren();
			while(listChildren.hasNext()) {
				NavItemBean navBean = new NavItemBean();
				Resource res = listChildren.next();
				ValueMap map = res.getValueMap();
				navBean.setTitle(map.get("title", String.class));
				navBean.setLink(map.get("page", String.class));
				navItemList.add(navBean);
			}
		}

	}
	public List<NavItemBean> getNavItemList() {
		return navItemList;
	}
}
