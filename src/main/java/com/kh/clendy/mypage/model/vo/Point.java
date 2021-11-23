package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Point {
	private int point_no;
	private int order_code;
	private int point_code;
	private int point;
	private Date point_date;
	private int user_no;
	
	/* point 적립 내용 */
	private Point_Category point_category;
	
	public Point() {}

	public Point(int point_no, int order_code, int point_code, int point, Date point_date, int user_no,
			Point_Category point_category) {
		super();
		this.point_no = point_no;
		this.order_code = order_code;
		this.point_code = point_code;
		this.point = point;
		this.point_date = point_date;
		this.user_no = user_no;
		this.point_category = point_category;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getPoint_date() {
		return point_date;
	}

	public void setPoint_date(Date point_date) {
		this.point_date = point_date;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public Point_Category getPoint_category() {
		return point_category;
	}

	public void setPoint_category(Point_Category point_category) {
		this.point_category = point_category;
	}

	@Override
	public String toString() {
		return "Point [point_no=" + point_no + ", order_code=" + order_code + ", point_code=" + point_code + ", point="
				+ point + ", point_date=" + point_date + ", user_no=" + user_no + ", point_category=" + point_category
				+ "]";
	}

}
