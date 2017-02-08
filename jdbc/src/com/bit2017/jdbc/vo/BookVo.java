package com.bit2017.jdbc.vo;

import java.sql.Date;

public class BookVo {
	private Long no;
	private String title;
	private String pub_date;
	private String state;
	private Long author_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getAuthor_no() {
		return author_no;
	}
	public void setAuthor_no(Long author_no) {
		this.author_no = author_no;
	}
	@Override
	public String toString() {
		return "Bookvo [no=" + no + ", title=" + title + ", pub_date=" + pub_date + ", state=" + state + ", author_no="
				+ author_no + "]";
	}	
	
	
}
