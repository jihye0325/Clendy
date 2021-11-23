package com.kh.clendy.CScenter.model.vo;

import java.util.Date;

public class Board {

	private int b_no;
	private String b_title;
	private String b_content;
	private Date b_enroll_date;
	private Date b_modify_date;
	private int user_no;
	
	public Board() {}

	public Board(int b_no, String b_title, String b_content, Date b_enroll_date, Date b_modify_date, int user_no) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_enroll_date = b_enroll_date;
		this.b_modify_date = b_modify_date;
		this.user_no = user_no;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Date getB_enroll_date() {
		return b_enroll_date;
	}

	public void setB_enroll_date(Date b_enroll_date) {
		this.b_enroll_date = b_enroll_date;
	}

	public Date getB_modify_date() {
		return b_modify_date;
	}

	public void setB_modify_date(Date b_modify_date) {
		this.b_modify_date = b_modify_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "Board [b_no=" + b_no + ", b_title=" + b_title + ", b_content=" + b_content + ", b_enroll_date="
				+ b_enroll_date + ", b_modify_date=" + b_modify_date + ", user_no=" + user_no + "]";
	}
	
}
