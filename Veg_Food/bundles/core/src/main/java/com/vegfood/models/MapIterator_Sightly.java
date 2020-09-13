package com.vegfood.models;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class MapIterator_Sightly {
	
	Map<Integer, String> map = new HashMap<Integer, String>();
	
	public Map<Integer, String> getMap() {
		return map;
	}

	@PostConstruct
	private void myLogic() {
		map.put(12, "Twelve");
		map.put(14, "Fourteen");
		map.put(20, "Twenty");
		map.put(24, "Twenty Four");
		map.put(43, "Forty Four");
		map.put(45, "Forty Five");
	}
}
