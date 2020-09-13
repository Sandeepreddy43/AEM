/**
 * 
 */
package com.law.jdbc;

/**
 * @author Lenovo
 *
 */
public class GreenBus {
	private int idNum;
	private String agency;
	private String regNum;
	private String starting_point;
	private String destination;
	private String acType;
	private String seaterType;
	private String date;
	private String rating;

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getStarting_point() {
		return starting_point;
	}

	public void setStarting_point(String starting_point) {
		this.starting_point = starting_point;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public String getSeaterType() {
		return seaterType;
	}

	public void setSeaterType(String seaterType) {
		this.seaterType = seaterType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "---Bus Details---" +"\nFrom: "+starting_point+"\nTo: "+destination+"\nDate Of Travel: "+date+"\nId: " + idNum + "\nAgency: " + agency + "\nReg. No: " + regNum + "\nAC Type: " + acType + "\nSeater Type: " + seaterType+"\nRatings: "+rating;
	}
}
