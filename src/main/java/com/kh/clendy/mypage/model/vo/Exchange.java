package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Exchange {
	private int ex_no;
	private int order_option_code;
	private int ex_id;
	private String ex_reason;
	private String ex_status;
	private int ex_option;
	private Date ex_date;
	private String p_name;
	private String p_color;
	private String p_size;
	private String ex_name;
	
	public Exchange() {}

	public Exchange(int ex_no, int order_option_code, int ex_id, String ex_reason, String ex_status, int ex_option,
			Date ex_date, String p_name, String p_color, String p_size, String ex_name) {
		super();
		this.ex_no = ex_no;
		this.order_option_code = order_option_code;
		this.ex_id = ex_id;
		this.ex_reason = ex_reason;
		this.ex_status = ex_status;
		this.ex_option = ex_option;
		this.ex_date = ex_date;
		this.p_name = p_name;
		this.p_color = p_color;
		this.p_size = p_size;
		this.ex_name = ex_name;
	}

	public int getEx_no() {
		return ex_no;
	}

	public void setEx_no(int ex_no) {
		this.ex_no = ex_no;
	}

	public int getOrder_option_code() {
		return order_option_code;
	}

	public void setOrder_option_code(int order_option_code) {
		this.order_option_code = order_option_code;
	}

	public int getEx_id() {
		return ex_id;
	}

	public void setEx_id(int ex_id) {
		this.ex_id = ex_id;
	}

	public String getEx_reason() {
		return ex_reason;
	}

	public void setEx_reason(String ex_reason) {
		this.ex_reason = ex_reason;
	}

	public String getEx_status() {
		return ex_status;
	}

	public void setEx_status(String ex_status) {
		this.ex_status = ex_status;
	}

	public int getEx_option() {
		return ex_option;
	}

	public void setEx_option(int ex_option) {
		this.ex_option = ex_option;
	}

	public Date getEx_date() {
		return ex_date;
	}

	public void setEx_date(Date ex_date) {
		this.ex_date = ex_date;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_color() {
		return p_color;
	}

	public void setP_color(String p_color) {
		this.p_color = p_color;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public String getEx_name() {
		return ex_name;
	}

	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}

	@Override
	public String toString() {
		return "Exchange [ex_no=" + ex_no + ", order_option_code=" + order_option_code + ", ex_id=" + ex_id
				+ ", ex_reason=" + ex_reason + ", ex_status=" + ex_status + ", ex_option=" + ex_option + ", ex_date="
				+ ex_date + ", p_name=" + p_name + ", p_color=" + p_color + ", p_size=" + p_size + ", ex_name="
				+ ex_name + "]";
	}
	
}
