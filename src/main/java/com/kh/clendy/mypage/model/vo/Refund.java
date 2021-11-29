package com.kh.clendy.mypage.model.vo;

public class Refund {
	private int ref_no;
	private int order_option_code;
	private int ref_id;
	private String ref_reason;
	private String ref_status;
	private int ref_price;
	
	public Refund() {}

	public Refund(int ref_no, int order_option_code, int ref_id, String ref_reason, String ref_status, int ref_price) {
		super();
		this.ref_no = ref_no;
		this.order_option_code = order_option_code;
		this.ref_id = ref_id;
		this.ref_reason = ref_reason;
		this.ref_status = ref_status;
		this.ref_price = ref_price;
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

	@Override
	public String toString() {
		return "Refund [ref_no=" + ref_no + ", order_option_code=" + order_option_code + ", ref_id=" + ref_id
				+ ", ref_reason=" + ref_reason + ", ref_status=" + ref_status + ", ref_price=" + ref_price + "]";
	}
	
	
}
