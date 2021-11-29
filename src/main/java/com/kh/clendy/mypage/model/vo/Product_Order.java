package com.kh.clendy.mypage.model.vo;

import java.util.Date;
import java.util.List;

public class Product_Order {
	private int order_code;
	private int user_no;
	private String order_request;
	private Date order_create_date;
	private int order_delivery;
	private int order_all_price;
	private String order_postnum;
	private Date order_modify_date;

	// 주문번호에 연결된 여러개의 상품 주문옵션
	private List<Order_Option> order_option_list;
	private Order_Status order_status;
	
	public Product_Order() {}

	public Product_Order(int order_code, int user_no, String order_request, Date order_create_date, int order_delivery,
			int order_all_price, String order_postnum, Date order_modify_date, List<Order_Option> order_option_list,
			Order_Status order_status) {
		super();
		this.order_code = order_code;
		this.user_no = user_no;
		this.order_request = order_request;
		this.order_create_date = order_create_date;
		this.order_delivery = order_delivery;
		this.order_all_price = order_all_price;
		this.order_postnum = order_postnum;
		this.order_modify_date = order_modify_date;
		this.order_option_list = order_option_list;
		this.order_status = order_status;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
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

	public List<Order_Option> getOrder_option_list() {
		return order_option_list;
	}

	public void setOrder_option_list(List<Order_Option> order_option_list) {
		this.order_option_list = order_option_list;
	}

	public Order_Status getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Order_Status order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "Product_Order [order_code=" + order_code + ", user_no=" + user_no + ", order_request=" + order_request
				+ ", order_create_date=" + order_create_date + ", order_delivery=" + order_delivery
				+ ", order_all_price=" + order_all_price + ", order_postnum=" + order_postnum + ", order_modify_date="
				+ order_modify_date + ", order_option_list=" + order_option_list + ", order_status=" + order_status
				+ "]";
	}

	
	
}
