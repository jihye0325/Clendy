package com.kh.clendy.admin.model.vo;

import java.util.Date;

public class CancelStore {
	
	private int can_no;
	private Date c_date;
	private Date complete_date;
	private int seller_code;
	private int a_no; 			// 입점 신청 코드
	private String seller_name;
	private String rep_name;
	private long b_license;
	private int user_no;

	public CancelStore() {}

	public CancelStore(int can_no, Date c_date, Date complete_date, int seller_code, int a_no, String seller_name,
			String rep_name, long b_license, int user_no) {
		super();
		this.can_no = can_no;
		this.c_date = c_date;
		this.complete_date = complete_date;
		this.seller_code = seller_code;
		this.a_no = a_no;
		this.seller_name = seller_name;
		this.rep_name = rep_name;
		this.b_license = b_license;
		this.user_no = user_no;
	}

	public int getCan_no() {
		return can_no;
	}

	public void setCan_no(int can_no) {
		this.can_no = can_no;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public Date getComplete_date() {
		return complete_date;
	}

	public void setComplete_date(Date complete_date) {
		this.complete_date = complete_date;
	}

	public int getSeller_code() {
		return seller_code;
	}

	public void setSeller_code(int seller_code) {
		this.seller_code = seller_code;
	}

	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getRep_name() {
		return rep_name;
	}

	public void setRep_name(String rep_name) {
		this.rep_name = rep_name;
	}

	public long getB_license() {
		return b_license;
	}

	public void setB_license(long b_license) {
		this.b_license = b_license;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "CancelStore [can_no=" + can_no + ", c_date=" + c_date + ", complete_date=" + complete_date
				+ ", seller_code=" + seller_code + ", a_no=" + a_no + ", seller_name=" + seller_name + ", rep_name="
				+ rep_name + ", b_license=" + b_license + ", user_no=" + user_no + "]";
	}

}
