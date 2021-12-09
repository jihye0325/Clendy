package com.kh.clendy.mypage.model.vo;

public class Payment {
	private int pay_code;
	private int order_code;
	private String imp_uid;
	private String merchant_uid;
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
	private String p_name;
	private String p_color;
	private String p_size;
	private int point;
	private int point_amount;
	private String order_status_code;
	
	public Payment() {}

	public Payment(int pay_code, int order_code, String imp_uid, String merchant_uid, int pay_money, String pay_means,
			String pay_card_name, String pay_card_num, String pay_refund, String order_request, String order_name,
			String order_address, String order_phone, String p_name, String p_color, String p_size, int point,
			int point_amount, String order_status_code) {
		super();
		this.pay_code = pay_code;
		this.order_code = order_code;
		this.imp_uid = imp_uid;
		this.merchant_uid = merchant_uid;
		this.pay_money = pay_money;
		this.pay_means = pay_means;
		this.pay_card_name = pay_card_name;
		this.pay_card_num = pay_card_num;
		this.pay_refund = pay_refund;
		this.order_request = order_request;
		this.order_name = order_name;
		this.order_address = order_address;
		this.order_phone = order_phone;
		this.p_name = p_name;
		this.p_color = p_color;
		this.p_size = p_size;
		this.point = point;
		this.point_amount = point_amount;
		this.order_status_code = order_status_code;
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

	public String getImp_uid() {
		return imp_uid;
	}

	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}

	public String getMerchant_uid() {
		return merchant_uid;
	}

	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPoint_amount() {
		return point_amount;
	}

	public void setPoint_amount(int point_amount) {
		this.point_amount = point_amount;
	}

	public String getOrder_status_code() {
		return order_status_code;
	}

	public void setOrder_status_code(String order_status_code) {
		this.order_status_code = order_status_code;
	}

	@Override
	public String toString() {
		return "Payment [pay_code=" + pay_code + ", order_code=" + order_code + ", imp_uid=" + imp_uid
				+ ", merchant_uid=" + merchant_uid + ", pay_money=" + pay_money + ", pay_means=" + pay_means
				+ ", pay_card_name=" + pay_card_name + ", pay_card_num=" + pay_card_num + ", pay_refund=" + pay_refund
				+ ", order_request=" + order_request + ", order_name=" + order_name + ", order_address=" + order_address
				+ ", order_phone=" + order_phone + ", p_name=" + p_name + ", p_color=" + p_color + ", p_size=" + p_size
				+ ", point=" + point + ", point_amount=" + point_amount + ", order_status_code=" + order_status_code
				+ "]";
	}

}
