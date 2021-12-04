package com.kh.clendy.mypage.model.vo;

import java.util.Date;

public class Order_Option {
	private int order_option_code;
	private int order_code;
	private int order_product_num;
	
	private Product_Option product_option;
	// 추가컬럼
	private int p_no;
	private String p_name;
	private String p_option_no;
	private String p_color;
	private String p_size;
	private int p_stock;
	private String order_name;
	private String order_address;
	private String order_phone;
	private String order_status_name;
	private String route;
	private String img_r_name;
	private int user_no;
	private String order_request;
	private Date order_create_date;
	private int order_delivery;
	private int order_all_price;
	private String order_postnum;
	private Date order_modify_date;
	private int r_no;
	private int p_price;
	private int subtotal;
	private int p_discount;
	private String merchant_uid;
	private int pay_money;
	private String r_status;
	
	public Order_Option() {}

	public Order_Option(int order_option_code, int order_code, int order_product_num, Product_Option product_option,
			int p_no, String p_name, String p_option_no, String p_color, String p_size, int p_stock, String order_name,
			String order_address, String order_phone, String order_status_name, String route, String img_r_name,
			int user_no, String order_request, Date order_create_date, int order_delivery, int order_all_price,
			String order_postnum, Date order_modify_date, int r_no, int p_price, int subtotal, int p_discount,
			String merchant_uid, int pay_money, String r_status) {
		super();
		this.order_option_code = order_option_code;
		this.order_code = order_code;
		this.order_product_num = order_product_num;
		this.product_option = product_option;
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_option_no = p_option_no;
		this.p_color = p_color;
		this.p_size = p_size;
		this.p_stock = p_stock;
		this.order_name = order_name;
		this.order_address = order_address;
		this.order_phone = order_phone;
		this.order_status_name = order_status_name;
		this.route = route;
		this.img_r_name = img_r_name;
		this.user_no = user_no;
		this.order_request = order_request;
		this.order_create_date = order_create_date;
		this.order_delivery = order_delivery;
		this.order_all_price = order_all_price;
		this.order_postnum = order_postnum;
		this.order_modify_date = order_modify_date;
		this.r_no = r_no;
		this.p_price = p_price;
		this.subtotal = subtotal;
		this.p_discount = p_discount;
		this.merchant_uid = merchant_uid;
		this.pay_money = pay_money;
		this.r_status = r_status;
	}

	public int getOrder_option_code() {
		return order_option_code;
	}

	public void setOrder_option_code(int order_option_code) {
		this.order_option_code = order_option_code;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public int getOrder_product_num() {
		return order_product_num;
	}

	public void setOrder_product_num(int order_product_num) {
		this.order_product_num = order_product_num;
	}

	public Product_Option getProduct_option() {
		return product_option;
	}

	public void setProduct_option(Product_Option product_option) {
		this.product_option = product_option;
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

	public String getP_option_no() {
		return p_option_no;
	}

	public void setP_option_no(String p_option_no) {
		this.p_option_no = p_option_no;
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

	public int getP_stock() {
		return p_stock;
	}

	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
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

	public String getOrder_status_name() {
		return order_status_name;
	}

	public void setOrder_status_name(String order_status_name) {
		this.order_status_name = order_status_name;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getImg_r_name() {
		return img_r_name;
	}

	public void setImg_r_name(String img_r_name) {
		this.img_r_name = img_r_name;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getOrder_request() {
		return order_request;
	}

	public void setOrder_request(String order_request) {
		this.order_request = order_request;
	}

	public Date getOrder_create_date() {
		return order_create_date;
	}

	public void setOrder_create_date(Date order_create_date) {
		this.order_create_date = order_create_date;
	}

	public int getOrder_delivery() {
		return order_delivery;
	}

	public void setOrder_delivery(int order_delivery) {
		this.order_delivery = order_delivery;
	}

	public int getOrder_all_price() {
		return order_all_price;
	}

	public void setOrder_all_price(int order_all_price) {
		this.order_all_price = order_all_price;
	}

	public String getOrder_postnum() {
		return order_postnum;
	}

	public void setOrder_postnum(String order_postnum) {
		this.order_postnum = order_postnum;
	}

	public Date getOrder_modify_date() {
		return order_modify_date;
	}

	public void setOrder_modify_date(Date order_modify_date) {
		this.order_modify_date = order_modify_date;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getP_discount() {
		return p_discount;
	}

	public void setP_discount(int p_discount) {
		this.p_discount = p_discount;
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

	public String getR_status() {
		return r_status;
	}

	public void setR_status(String r_status) {
		this.r_status = r_status;
	}

	@Override
	public String toString() {
		return "Order_Option [order_option_code=" + order_option_code + ", order_code=" + order_code
				+ ", order_product_num=" + order_product_num + ", product_option=" + product_option + ", p_no=" + p_no
				+ ", p_name=" + p_name + ", p_option_no=" + p_option_no + ", p_color=" + p_color + ", p_size=" + p_size
				+ ", p_stock=" + p_stock + ", order_name=" + order_name + ", order_address=" + order_address
				+ ", order_phone=" + order_phone + ", order_status_name=" + order_status_name + ", route=" + route
				+ ", img_r_name=" + img_r_name + ", user_no=" + user_no + ", order_request=" + order_request
				+ ", order_create_date=" + order_create_date + ", order_delivery=" + order_delivery
				+ ", order_all_price=" + order_all_price + ", order_postnum=" + order_postnum + ", order_modify_date="
				+ order_modify_date + ", r_no=" + r_no + ", p_price=" + p_price + ", subtotal=" + subtotal
				+ ", p_discount=" + p_discount + ", merchant_uid=" + merchant_uid + ", pay_money=" + pay_money
				+ ", r_status=" + r_status + "]";
	}

	
}
