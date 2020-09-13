package com.law.services;

import org.osgi.service.component.annotations.Component;

import com.law.jdbc.CRUDOperations;

@Component(name = "Service Demo - 123456")
public class ServiceDemo implements CRUDOperations {

	@Override
	public String retrieveBuses() {
		// TODO Auto-generated method stub
		return "Service Demo";
	}

}
