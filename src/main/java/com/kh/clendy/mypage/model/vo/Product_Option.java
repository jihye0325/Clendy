package com.kh.clendy.mypage.model.vo;

public class Product_Option {
	private int p_option_no;
	private String p_color;
	private String p_size;
	private int p_stock;
	
	private Product product;
	
	public Product_Option() {}

	public Product_Option(int p_option_no, String p_color, String p_size, int p_stock, Product product) {
		super();
		this.p_option_no = p_option_no;
		this.p_color = p_color;
		this.p_size = p_size;
		this.p_stock = p_stock;
		this.product = product;
	}

	public int getP_option_no() {
		return p_option_no;
	}

	public void setP_option_no(int p_option_no) {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Product_Option [p_option_no=" + p_option_no + ", p_color=" + p_color + ", p_size=" + p_size
				+ ", p_stock=" + p_stock + ", product=" + product + "]";
	}

	
}
