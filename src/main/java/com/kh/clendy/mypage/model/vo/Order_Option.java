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
	private String p_color;
	private String p_size;
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
	
	public Order_Option() {}

	public Order_Option(int order_option_code, int order_code, int order_product_num, Product_Option product_option,
			int p_no, String p_name, String p_color, String p_size, String order_name, String order_address,
			String order_phone, String order_status_name, String route, String img_r_name, int user_no,
			String order_request, Date order_create_date, int order_delivery, int order_all_price, String order_postnum,
			Date order_modify_date, int r_no) {
		super();
		this.order_option_code = order_option_code;
		this.order_code = order_code;
		this.order_product_num = order_product_num;
		this.product_option = product_option;
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_color = p_color;
		this.p_size = p_size;
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

	@Override
	public String toString() {
		return "Order_Option [order_option_code=" + order_option_code + ", order_code=" + order_code
				+ ", order_product_num=" + order_product_num + ", product_option=" + product_option + ", p_no=" + p_no
				+ ", p_name=" + p_name + ", p_color=" + p_color + ", p_size=" + p_size + ", order_name=" + order_name
				+ ", order_address=" + order_address + ", order_phone=" + order_phone + ", order_status_name="
				+ order_status_name + ", route=" + route + ", img_r_name=" + img_r_name + ", user_no=" + user_no
				+ ", order_request=" + order_request + ", order_create_date=" + order_create_date + ", order_delivery="
				+ order_delivery + ", order_all_price=" + order_all_price + ", order_postnum=" + order_postnum
				+ ", order_modify_date=" + order_modify_date + ", r_no=" + r_no + "]";
	}

	
}
