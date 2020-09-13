package com.law.models;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class MapIterator_Sightly {
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	public Map<String, Integer> getMap() {
		return map;
	}

	@PostConstruct
	private void myLogic() {
		map.put("Twelve", 12);
		map.put("Fourteen", 14);
		map.put("Twenty", 20);
		map.put("Twenty Four", 24);
		map.put("Forty Four", 43);
		map.put("Forty Five", 45);
	}
}
