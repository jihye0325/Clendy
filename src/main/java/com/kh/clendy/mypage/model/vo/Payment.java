package com.kh.clendy.mypage.model.vo;

public class Payment {
	private int pay_code;
	private int order_code;
	private int pay_money;
	private String pay_means;
	private String pay_card_name;
	private String pay_card_num;
	private String pay_refund;
	
	// 추가
	private String order_request;
	private String order_name;
	private String order_address;
	private String order_phone;

	public Payment() {}

	public Payment(int pay_code, int order_code, int pay_money, String pay_means, String pay_card_name,
			String pay_card_num, String pay_refund, String order_request, String order_name, String order_address,
			String order_phone) {
		super();
		this.pay_code = pay_code;
		this.order_code = order_code;
		this.pay_money = pay_money;
		this.pay_means = pay_means;
		this.pay_card_name = pay_card_name;
		this.pay_card_num = pay_card_num;
		this.pay_refund = pay_refund;
		this.order_request = order_request;
		this.order_name = order_name;
		this.order_address = order_address;
		this.order_phone = order_phone;
	}

	public int getPay_code() {
		return pay_code;
	}

	public void setPay_code(int pay_code) {
		this.pay_code = pay_code;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public int getPay_money() {
		return pay_money;
	}

	public void setPay_money(int pay_money) {
		this.pay_money = pay_money;
	}

	public String getPay_means() {
		return pay_means;
	}

	public void setPay_means(String pay_means) {
		this.pay_means = pay_means;
	}

	public String getPay_card_name() {
		return pay_card_name;
	}

	public void setPay_card_name(String pay_card_name) {
		this.pay_card_name = pay_card_name;
	}

	public String getPay_card_num() {
		return pay_card_num;
	}

	public void setPay_card_num(String pay_card_num) {
		this.pay_card_num = pay_card_num;
	}

	public String getPay_refund() {
		return pay_refund;
	}

	public void setPay_refund(String pay_refund) {
		this.pay_refund = pay_refund;
	}

	public String getOrder_request() {
		return order_request;
	}

	public void setOrder_request(String order_request) {
		this.order_request = order_request;
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
		return "Payment [pay_code=" + pay_code + ", order_code=" + order_code + ", pay_money=" + pay_money
				+ ", pay_means=" + pay_means + ", pay_card_name=" + pay_card_name + ", pay_card_num=" + pay_card_num
				+ ", pay_refund=" + pay_refund + ", order_request=" + order_request + ", order_name=" + order_name
				+ ", order_address=" + order_address + ", order_phone=" + order_phone + "]";
	}
	
}
