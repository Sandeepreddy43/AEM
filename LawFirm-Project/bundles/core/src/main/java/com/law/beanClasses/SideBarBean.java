package com.law.beanClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SideBarBean {

	private String title, cardtext1, cardtext2, link, image;
	
	private Date date;
	
	private String d;
	
	public String getD() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM");
		d = sdf.format(getDate());
		return d;
	}

	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setCardtext1(String cardtext1) {
		this.cardtext1 = cardtext1;
	}



	public void setCardtext2(String cardtext2) {
		this.cardtext2 = cardtext2;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getCardtext1() {
		return cardtext1;
	}



	public String getCardtext2() {
		return cardtext2;
	}



	public String getLink() {
		return link;
	}



	public String getImage() {
		return image;
	}



	public String getTitle() {
		return title;
	}
}
