package com.vegfood.models;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;

import com.adobe.cq.sightly.WCMUsePojo;  
  
  
public class DateDemo extends WCMUsePojo{  
  
  
    private String formattedDate;  
    
    @Override  
    public void activate() {  
    Calendar date  = get("date", Calendar.class);  
    String format =  get("format",String.class);  
    SimpleDateFormat formatter = new SimpleDateFormat(format);  
    formattedDate = formatter.format(date.getTime());  
    }  
    @PostConstruct
    private void init() {
	System.out.println("******"+formattedDate);
	}
  
  
    public String getFormattedDate() {  
        return formattedDate;  
    }  
   
}