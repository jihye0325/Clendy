package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Coupon {
	private int cou_no;	// 쿠폰번호
	private String cou_name; // 쿠폰이름
	private int cou_condition; // 쿠폰사용조건(금액)
	private int cou_price;	// 금액
	private Date start_date;	// 시작일
	private Date expire_date;	// 만료일
	private String cou_status;	// 발급상태
	private int cou_dday;		// 쿠폰 남은일자	
	
	public Coupon() {}

	public Coupon(int cou_no, String cou_name, int cou_condition, int cou_price, Date start_date, Date expire_date,
			String cou_status) {
		super();
		this.cou_no = cou_no;
		this.cou_name = cou_name;
		this.cou_condition = cou_condition;
		this.cou_price = cou_price;
		this.start_date = start_date;
		this.expire_date = expire_date;
		this.cou_status = cou_status;
	}

	public int getCou_no() {
		return cou_no;
	}

	public void setCou_no(int cou_no) {
		this.cou_no = cou_no;
	}

	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}

	public int getCou_condition() {
		return cou_condition;
	}

	public void setCou_condition(int cou_condition) {
		this.cou_condition = cou_condition;
	}

	public int getCou_price() {
		return cou_price;
	}

	public void setCou_price(int cou_price) {
		this.cou_price = cou_price;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}

	public String getCou_status() {
		return cou_status;
	}

	public void setCou_status(String cou_status) {
		this.cou_status = cou_status;
	}

	public int getCou_dday() {
		return cou_dday;
	}

	public void setCou_dday(int cou_dday) {
		this.cou_dday = cou_dday;
	}

	@Override
	public String toString() {
		return "Coupon [cou_no=" + cou_no + ", cou_name=" + cou_name + ", cou_condition=" + cou_condition
				+ ", cou_price=" + cou_price + ", start_date=" + start_date + ", expire_date=" + expire_date
				+ ", cou_status=" + cou_status + ", cou_dday=" + cou_dday + "]";
	}

}
