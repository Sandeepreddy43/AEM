package com.law.schedulers;

import java.util.Date;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, configurationPid = "ABC123")
public class TestScheduler implements Runnable {
	
	@SuppressWarnings("unused")
	private String date;


	@Activate
	private void perform() {
		date = new Date().toString();
	}
	
	
	@Override
	public void run() {
		System.out.println();
	}

}
