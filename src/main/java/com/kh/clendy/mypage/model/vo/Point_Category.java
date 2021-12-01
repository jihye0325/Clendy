package com.kh.clendy.mypage.model.vo;

public class Point_Category {
	private int point_code;
	private String point_content;
	private int point_amount;
	private int point_group;
	private int point_status;
	
	public Point_Category() {}

	public Point_Category(int point_code, String point_content, int point_amount, int point_group, int point_status) {
		super();
		this.point_code = point_code;
		this.point_content = point_content;
		this.point_amount = point_amount;
		this.point_group = point_group;
		this.point_status = point_status;
	}

	public int getPoint_code() {
		return point_code;
	}

	public void setPoint_code(int point_code) {
		this.point_code = point_code;
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

	@Override
	public String toString() {
		return "Point_Category [point_code=" + point_code + ", point_content=" + point_content + ", point_amount="
				+ point_amount + ", point_group=" + point_group + ", point_status=" + point_status + "]";
	}

}
