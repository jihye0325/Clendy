package com.kh.clendy.mypage.model.vo;

import com.kh.clendy.product.model.vo.Product;

public class Wishlist {
	private int user_no;
	private int p_no;
	
	// 상품정보
	private Product product;
	
	public Wishlist() {}

	public Wishlist(int user_no, int p_no, Product product) {
		super();
		this.user_no = user_no;
		this.p_no = p_no;
		this.product = product;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Wishlist [user_no=" + user_no + ", p_no=" + p_no + ", product=" + product + "]";
	}

}
