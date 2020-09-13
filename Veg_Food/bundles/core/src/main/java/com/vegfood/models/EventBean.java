package com.vegfood.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventBean {
	
	private Date date;
	
	private String title;
	
	private String link;
	
	private String imgRef;
	
	private String cardDes;
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMM d");
	private String dateValue;
	
	public String getDateValue() {
		this.dateValue = sdf.format(date);
		return dateValue;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImgRef() {
		return imgRef;
	}

	public void setImgRef(String imgRef) {
		this.imgRef = imgRef;
	}

	public String getCardDes() {
		return cardDes;
	}

	public void setCardDes(String cardDes) {
		this.cardDes = cardDes;
	}

}
//class dateCompare implements Comparator<EventBean> {
//
//	@Override
//	public int compare(EventBean o1, EventBean o2) {
//		return o1.getDate().compareTo(o2.getDate());
//	}
//	
//}
