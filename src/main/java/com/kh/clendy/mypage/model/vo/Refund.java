package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Refund {
	private int ref_no;
	private int order_option_code;
	private int ref_id;
	private String ref_reason;
	private String ref_status;
	private int ref_price;
	private Date ref_date;
	
	private String ref_name;
	private int p_no;
	private String p_name;
	
	public Refund() {}

	public Refund(int ref_no, int order_option_code, int ref_id, String ref_reason, String ref_status, int ref_price,
			Date ref_date, String ref_name, int p_no, String p_name) {
		super();
		this.ref_no = ref_no;
		this.order_option_code = order_option_code;
		this.ref_id = ref_id;
		this.ref_reason = ref_reason;
		this.ref_status = ref_status;
		this.ref_price = ref_price;
		this.ref_date = ref_date;
		this.ref_name = ref_name;
		this.p_no = p_no;
		this.p_name = p_name;
	}

	public Refund(int order_option_code, int ref_id, String ref_reason, int ref_price) {
		super();
		this.order_option_code = order_option_code;
		this.ref_id = ref_id;
		this.ref_reason = ref_reason;
		this.ref_price = ref_price;
	}

	public int getRef_no() {
		return ref_no;
	}

	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}

	public int getOrder_option_code() {
		return order_option_code;
	}

	public void setOrder_option_code(int order_option_code) {
		this.order_option_code = order_option_code;
	}

	public int getRef_id() {
		return ref_id;
	}

	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}

	public String getRef_reason() {
		return ref_reason;
	}

	public void setRef_reason(String ref_reason) {
		this.ref_reason = ref_reason;
	}

	public String getRef_status() {
		return ref_status;
	}

	public void setRef_status(String ref_status) {
		this.ref_status = ref_status;
	}

	public int getRef_price() {
		return ref_price;
	}

	public void setRef_price(int ref_price) {
		this.ref_price = ref_price;
	}

	public Date getRef_date() {
		return ref_date;
	}

	public void setRef_date(Date ref_date) {
		this.ref_date = ref_date;
	}

	public String getRef_name() {
		return ref_name;
	}

	public void setRef_name(String ref_name) {
		this.ref_name = ref_name;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	@Override
	public String toString() {
		return "Refund [ref_no=" + ref_no + ", order_option_code=" + order_option_code + ", ref_id=" + ref_id
				+ ", ref_reason=" + ref_reason + ", ref_status=" + ref_status + ", ref_price=" + ref_price
				+ ", ref_date=" + ref_date + ", ref_name=" + ref_name + ", p_no=" + p_no + ", p_name=" + p_name + "]";
	}

}
