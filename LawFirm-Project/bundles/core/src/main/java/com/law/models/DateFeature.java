package com.law.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class DateFeature {

	@Inject
	private Date date1, date2, date3, date4;
	
	private String d1, d2, d3, d4;
	
	@PostConstruct
	private void testing() {
		System.out.println("testing() Called .. .. .!!");
		SimpleDateFormat sdf = new SimpleDateFormat("dd, MMM");
		d1 = sdf.format(date1);
		d2 = sdf.format(date2);
		d3 = sdf.format(date3);
		d4 = sdf.format(date4);
	}

	public String getD1() {
		return d1;
	}

	public String getD2() {
		return d2;
	}

	public String getD3() {
		return d3;
	}

	public String getD4() {
		return d4;
	}
}
