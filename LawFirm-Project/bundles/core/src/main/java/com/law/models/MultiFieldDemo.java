package com.law.models;

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
import org.json.JSONArray;

@Model(adaptables = Resource.class)
public class MultiFieldDemo {

	@Inject
	private Resource navItems;

	private List<NavBean> listData;

	private String json;

	public String getJson() {
		return json;
	}

	public List<NavBean> getListData() {
		return listData;
	}

	@PostConstruct
	private void init() {
		if (null != navItems) {
			Iterator<Resource> listChildren = navItems.listChildren();
			listData = new ArrayList<NavBean>();
			while (listChildren.hasNext()) {
				NavBean bean = new NavBean();
				Resource next = listChildren.next();
				ValueMap vm = next.getValueMap();
				bean.setCardtext1(vm.get("text1", String.class));
				bean.setCardtext2(vm.get("text2", String.class));
				bean.setDate(vm.get("date", Date.class));
				bean.setImage(vm.get("imglink", String.class));
				bean.setLink(vm.get("link", String.class));
				bean.setTitle(vm.get("title", String.class));
				listData.add(bean);
			}
			JSONArray jsArray = new JSONArray(listData);
			System.out.println(jsArray);
			json = jsArray.toString();
			Collections.sort(listData, Comparator.comparing(NavBean::getDate));
			System.out.println("\n\nAfter While Loop");
			for (NavBean navBean : listData) {
				System.out.println(navBean);
			}

		}
	}
}
