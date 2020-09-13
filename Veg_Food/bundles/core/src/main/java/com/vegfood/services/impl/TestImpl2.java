package com.vegfood.services.impl;

import org.osgi.service.component.annotations.Component;

import com.vegfood.services.Test;

@Component(service = Test.class, name = "Test OSGI Service - Impl 2")
public class TestImpl2 implements Test {

	@Override
	public String author(String author) {
		return "Test Implementation 2 ";
	}

}
