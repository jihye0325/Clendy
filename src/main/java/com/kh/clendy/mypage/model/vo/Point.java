package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Point {
	private int point_no;
	private int order_code;
	private int point_code;
	private Date point_date;
	
	public Point() {}

	public Point(int point_no, int order_code, int point_code, Date point_date) {
		super();
		this.point_no = point_no;
		this.order_code = order_code;
		this.point_code = point_code;
		this.point_date = point_date;
	}

	public int getPoint_no() {
		return point_no;
	}

	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public int getPoint_code() {
		return point_code;
	}

	public void setPoint_code(int point_code) {
		this.point_code = point_code;
	}

	public Date getPoint_date() {
		return point_date;
	}

	public void setPoint_date(Date point_date) {
		this.point_date = point_date;
	}

	@Override
	public String toString() {
		return "Point [point_no=" + point_no + ", order_code=" + order_code + ", point_code=" + point_code
				+ ", point_date=" + point_date + "]";
	}
	
}
