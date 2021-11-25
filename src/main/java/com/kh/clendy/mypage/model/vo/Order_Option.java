package com.kh.clendy.mypage.model.vo;

public class Order_Option {
	private int order_option_code;
	private int order_code;
	private int order_product_num;
	
	private Product_Option product_option;
	
	public Order_Option() {}

	public Order_Option(int order_option_code, int order_code, int order_product_num, Product_Option product_option) {
		super();
		this.order_option_code = order_option_code;
		this.order_code = order_code;
		this.order_product_num = order_product_num;
		this.product_option = product_option;
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

	@Override
	public String toString() {
		return "Order_Option [order_option_code=" + order_option_code + ", order_code=" + order_code
				+ ", order_product_num=" + order_product_num + ", product_option=" + product_option + "]";
	}

	
}
