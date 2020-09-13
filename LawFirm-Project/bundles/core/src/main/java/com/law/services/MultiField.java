package com.law.services;

import java.util.List;

import org.apache.sling.api.resource.Resource;

public interface MultiField {
	List<?> getChildPages(Resource resource); 
}
