package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Point {
	private int point_no;
	private int order_code;
	private int point_code;
	private int point;
	private Date point_date;
	private int user_no;
	private String rec_user;
	
	private String point_content;
	private int point_amount;
	private int point_group;
	private int point_status;
	/* point 적립 내용 */
	private Point_Category point_category;
	
	public Point() {}

	public Point(int point_no, int order_code, int point_code, int point, Date point_date, int user_no, String rec_user,
			String point_content, int point_amount, int point_group, int point_status, Point_Category point_category) {
		super();
		this.point_no = point_no;
		this.order_code = order_code;
		this.point_code = point_code;
		this.point = point;
		this.point_date = point_date;
		this.user_no = user_no;
		this.rec_user = rec_user;
		this.point_content = point_content;
		this.point_amount = point_amount;
		this.point_group = point_group;
		this.point_status = point_status;
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

	public String getRec_user() {
		return rec_user;
	}

	public void setRec_user(String rec_user) {
		this.rec_user = rec_user;
	}

	public String getPoint_content() {
		return point_content;
	}

	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}

	public int getPoint_amount() {
		return point_amount;
	}

	public void setPoint_amount(int point_amount) {
		this.point_amount = point_amount;
	}

	public int getPoint_group() {
		return point_group;
	}

	public void setPoint_group(int point_group) {
		this.point_group = point_group;
	}

	public int getPoint_status() {
		return point_status;
	}

	public void setPoint_status(int point_status) {
		this.point_status = point_status;
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
				+ point + ", point_date=" + point_date + ", user_no=" + user_no + ", rec_user=" + rec_user
				+ ", point_content=" + point_content + ", point_amount=" + point_amount + ", point_group=" + point_group
				+ ", point_status=" + point_status + ", point_category=" + point_category + ", getPoint_no()="
				+ getPoint_no() + ", getOrder_code()=" + getOrder_code() + ", getPoint_code()=" + getPoint_code()
				+ ", getPoint()=" + getPoint() + ", getPoint_date()=" + getPoint_date() + ", getUser_no()="
				+ getUser_no() + ", getRec_user()=" + getRec_user() + ", getPoint_content()=" + getPoint_content()
				+ ", getPoint_amount()=" + getPoint_amount() + ", getPoint_group()=" + getPoint_group()
				+ ", getPoint_status()=" + getPoint_status() + ", getPoint_category()=" + getPoint_category()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
