package com.kh.clendy.admin.model.vo;

import java.util.Date;

public class PointCategory {
	private Integer point_code;
	private String point_content;
	private Integer point_amount;
	private Integer point_status;
	private Integer point_group;
	private Date insert_date;
	
	public PointCategory(Integer point_code, String point_content, Integer point_amount, Integer point_status, Integer point_group,
			             Date insert_date) {
		super();
		this.point_code = point_code;
		this.point_content = point_content;
		this.point_amount = point_amount;
		this.point_status = point_status;
		this.point_group = point_group;
		this.insert_date =insert_date;
	}

	public Date getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}

	public Integer getPoint_code() {
		return point_code;
	}

	public void setPoint_code(Integer point_code) {
		this.point_code = point_code;
	}

	public String getPoint_content() {
		return point_content;
	}

	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}

	public Integer getPoint_amount() {
		return point_amount;
	}

	public void setPoint_amount(Integer point_amount) {
		this.point_amount = point_amount;
	}

	public Integer getPoint_status() {
		return point_status;
	}

	public void setPoint_status(Integer point_status) {
		this.point_status = point_status;
	}

	public Integer getPoint_group() {
		return point_group;
	}

	public void setPoint_group(Integer point_group) {
		this.point_group = point_group;
	}

	@Override
	public String toString() {
		return "PointCategory [point_code=" + point_code + ", point_content=" + point_content + ", point_amount="
				+ point_amount + ", point_status=" + point_status + ", point_group=" + point_group + ", insert_date="
				+ insert_date + "]";
	}

}
