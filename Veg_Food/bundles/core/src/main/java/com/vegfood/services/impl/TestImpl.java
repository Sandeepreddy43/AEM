package com.vegfood.services.impl;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.vegfood.services.Test;

@Component(service = Test.class, name = "Test OSGI Service")
public class TestImpl implements Test {

	@Override
	public String author(String author) {
		// TODO Auto-generated method stub
		return "Test Method created By "+author;
	}
	
	@Activate
	protected void activate(ComponentContext config) {
		System.out.println("Activate Method Called");
	}
}