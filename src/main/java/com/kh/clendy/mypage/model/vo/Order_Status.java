package com.kh.clendy.mypage.model.vo;

public class Order_Status {
	private String order_status_code;
	private String order_status_name;
	
	public Order_Status() {}

	public Order_Status(String order_status_code, String order_status_name) {
		super();
		this.order_status_code = order_status_code;
		this.order_status_name = order_status_name;
	}

	public String getOrder_status_code() {
		return order_status_code;
	}

	public void setOrder_status_code(String order_status_code) {
		this.order_status_code = order_status_code;
	}

	public String getOrder_status_name() {
		return order_status_name;
	}

	public void setOrder_status_name(String order_status_name) {
		this.order_status_name = order_status_name;
	}

	@Override
	public String toString() {
		return "Order_Status [order_status_code=" + order_status_code + ", order_status_name=" + order_status_name
				+ "]";
	}
	
	
}
