package com.law.models;

import java.util.ArrayList;
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
public class FeaturedMultiField {

	@Inject
	@Optional
	private Resource navItems;

	private List<NavBean> listData;

	public List<NavBean> getListData() {
		return listData;
	}
	
	@PostConstruct
	protected void init() {
		System.out.println("First Line");
		System.out.println("init------");
		if (navItems != null) {
			listData = new ArrayList<NavBean>();
			System.out.println("featured - init() called");
			Iterator<Resource> listChildren = navItems.listChildren();
			while (listChildren.hasNext()) {
				Resource res = listChildren.next();
				ValueMap vMap = res.getValueMap();
				System.out.println("\nValue Map");
				System.out.println(vMap.get("title", String.class));
				System.out.println(vMap.get("text1", String.class));
				System.out.println(vMap.get("text2", String.class));
				System.out.println(vMap.get("link", String.class));
				System.out.println(vMap.get("imglink", String.class));
				System.out.println(vMap.get("date", Date.class));
				NavBean bean = new NavBean();
				bean.setTitle(vMap.get("title", String.class));
				bean.setCardtext1(vMap.get("text1", String.class));
				bean.setCardtext2(vMap.get("text2", String.class));
				bean.setLink(vMap.get("link", String.class));
				bean.setImage(vMap.get("imglink", String.class));
				bean.setDate(vMap.get("date", Date.class));
				System.out.println("\nBean Getters");
				System.out.println(bean.getCardtext1());
				System.out.println(bean.getCardtext2());
				System.out.println(bean.getD());
				System.out.println(bean.getImage());
				System.out.println(bean.getLink());
				System.out.println(bean.getTitle());
				System.out.println(bean.getDate());
				listData.add(bean);
			}
		}
	}
}