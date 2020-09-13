package com.vegfood.services;

import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;

public interface HeaderNavigation {

	public List<Page> getChildPages(ResourceResolver resolver ,String pagePath);

	String getMessage();
}