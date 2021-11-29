package com.kh.clendy.mypage.model.vo;

public class Order_Del_Info {
	private int order_code;
	private String order_name;
	private String order_address;
	private String order_phone;
	
	public Order_Del_Info() {}

	public Order_Del_Info(int order_code, String order_name, String order_address, String order_phone) {
		super();
		this.order_code = order_code;
		this.order_name = order_name;
		this.order_address = order_address;
		this.order_phone = order_phone;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public String getOrder_phone() {
		return order_phone;
	}

	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}

	@Override
	public String toString() {
		return "Order_Del_Info [order_code=" + order_code + ", order_name=" + order_name + ", order_address="
				+ order_address + ", order_phone=" + order_phone + "]";
	}
	
}
