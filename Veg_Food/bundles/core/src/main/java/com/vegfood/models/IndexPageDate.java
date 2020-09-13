package com.vegfood.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class IndexPageDate {
	
	@Inject @Optional
	private Date date1;
	
	@Inject @Optional
	private Date date2;
	
	@Inject @Optional
	private Date date3;
	
	@Inject @Optional
	private Date date4;
	
	@Inject @Optional
	private Date date5;
	
	private String resDate1, resDate2, resDate3, resDate4, resDate5;

	@PostConstruct
	private void init() {
		SimpleDateFormat format = new SimpleDateFormat("MMM d");
		resDate1 = format.format(date1);
		resDate2 = format.format(date2);
		resDate3 = format.format(date3);
		resDate4 = format.format(date4);
		resDate5 = format.format(date5);
	}
	
	public String getResDate1() {
		return resDate1;
	}

	public String getResDate2() {
		return resDate2;
	}

	public String getResDate3() {
		return resDate3;
	}

	public String getResDate4() {
		return resDate4;
	}

	public String getResDate5() {
		return resDate5;
	}	
}