package com.kh.clendy.mypage.model.vo;

public class Cart {
	private int cart_no;
	private int cart_amount;
	private int p_option_no;
	private int user_no;
	
	private Product_Option product_option;
	
	private String seller_name;
	
	public Cart() {}

	public Cart(int cart_no, int cart_amount, int p_option_no, int user_no, Product_Option product_option,
			String seller_name) {
		super();
		this.cart_no = cart_no;
		this.cart_amount = cart_amount;
		this.p_option_no = p_option_no;
		this.user_no = user_no;
		this.product_option = product_option;
		this.seller_name = seller_name;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(int cart_amount) {
		this.cart_amount = cart_amount;
	}

	public int getP_option_no() {
		return p_option_no;
	}

	public void setP_option_no(int p_option_no) {
		this.p_option_no = p_option_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public Product_Option getProduct_option() {
		return product_option;
	}

	public void setProduct_option(Product_Option product_option) {
		this.product_option = product_option;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", cart_amount=" + cart_amount + ", p_option_no=" + p_option_no
				+ ", user_no=" + user_no + ", product_option=" + product_option + ", seller_name=" + seller_name + "]";
	}

}
