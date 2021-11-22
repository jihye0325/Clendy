package com.kh.clendy.mypage.model.vo;

public class Point_Category {
	private int point_code;
	private String point_content;
	
	public Point_Category() {}

	public Point_Category(int point_code, String point_content) {
		super();
		this.point_code = point_code;
		this.point_content = point_content;
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

	@Override
	public String toString() {
		return "Point_Category [point_code=" + point_code + ", point_content=" + point_content + "]";
	}
		
}
