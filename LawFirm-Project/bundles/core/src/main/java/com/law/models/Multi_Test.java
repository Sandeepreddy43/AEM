package com.law.models;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class Multi_Test 
{
@Inject
private Resource field;

private List<Multi_Test_Bean> mb; 

public List<Multi_Test_Bean> getMb() {
	return mb;
}
@SuppressWarnings("unused")
@PostConstruct
private void init() {
	// TODO Auto-generated method stub
if(field != null)
{
	Iterator<Resource> listChildren = field.listChildren();
	while (listChildren.hasNext()) {
		Resource resource =listChildren.next();
		ValueMap vm = resource.getValueMap();
	 
		
		
		
	}
	
}
}
}
