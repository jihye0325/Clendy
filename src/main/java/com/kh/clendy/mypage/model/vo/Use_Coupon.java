package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Use_Coupon {
	private int user_no;
	private int cou_no;
	private int order_code;
	private Date cou_date;
	
	public Use_Coupon() {}

	public Use_Coupon(int user_no, int cou_no, int order_code, Date cou_date) {
		super();
		this.user_no = user_no;
		this.cou_no = cou_no;
		this.order_code = order_code;
		this.cou_date = cou_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getCou_no() {
		return cou_no;
	}

	public void setCou_no(int cou_no) {
		this.cou_no = cou_no;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public Date getCou_date() {
		return cou_date;
	}

	public void setCou_date(Date cou_date) {
		this.cou_date = cou_date;
	}

	@Override
	public String toString() {
		return "Use_Coupon [user_no=" + user_no + ", cou_no=" + cou_no + ", order_code=" + order_code + ", cou_date="
				+ cou_date + "]";
	}
	
}
