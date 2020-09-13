package com.vegfood.models;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;

@Model(
        adaptables = { Resource.class }
//        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
        )
public class Instruments {
//  @ValueMapValue	
    @Via(value = "")
	@Inject @Optional
    private String title;
	
	@Inject @Optional
	private Date datevalue;
	
	private String formatDate, formatDate1, formatDate2, formatDate3;
	
	
	
	public String getTitle() {
		return title;
	}
	
	public Date getDatevalue() {
		return datevalue;
	}

	public String getFormatDate() {
		return formatDate;
	}

	public String getFormatDate1() {
		return formatDate1;
	}

	public String getFormatDate2() {
		return formatDate2;
	}

	public String getFormatDate3() {
		return formatDate3;
	}

	@PostConstruct
	private void init() {
		title = title.concat(" -- From Java 8");
		
		SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d,yyyy");
		formatDate = format.format(datevalue);
		
		SimpleDateFormat format1 = new SimpleDateFormat("hh 'o''clock' a, zzzz");
		formatDate1 = format1.format(datevalue);
		
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa");
		formatDate2 = format2.format(datevalue);
		
		SimpleDateFormat format3 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss SSSXXX");
		formatDate3 = format3.format(datevalue);
		
		
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-* InIt *-*-*-*-*-*-*-*-*-*-*-*"+datevalue);
		System.out.println("******----------*******"+formatDate);
	
	}

}
