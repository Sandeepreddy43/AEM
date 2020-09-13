package com.vegfood.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class SideBarMultiField {

	@Inject @Optional
	private Resource navItems;
	
	private List<EventBean> navItemList;
	
	@PostConstruct
	private void init() {
		//System.out.println("88888888");
		navItemList = new ArrayList<EventBean>();
		if(null != navItems) {
			Iterator<Resource> listChildren = navItems.listChildren();
			while(listChildren.hasNext()) {
				EventBean navBean = new EventBean();
				Resource res = listChildren.next();
				ValueMap map = res.getValueMap();
				navBean.setTitle(map.get("title", String.class));
				navBean.setCardDes(map.get("description", String.class));
				navBean.setImgRef(map.get("imglink", String.class));
				navBean.setLink(map.get("link", String.class));
				navBean.setDate(map.get("eventDate", Date.class));
				navItemList.add(navBean);
			}
		}
		Collections.sort(navItemList, Comparator.comparing(EventBean::getDate));
	}
	public List<EventBean> getNavItemList() {
		return navItemList;
	}
}
