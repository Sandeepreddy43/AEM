package com.law.services.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;

import com.law.services.MultiField;

public class MultiFieldImpl implements MultiField {

	@SuppressWarnings("unused")
	@Override
	public List<?> getChildPages(Resource resource) {
		if(resource != null) {
			Iterator<Resource> listChildren = resource.listChildren();
			
		}
		return null;
	}

}
