package com.law.services;

import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;

public interface PageNavigation {

	List<Page> getChildPages(ResourceResolver resolver, String pagePath);
}