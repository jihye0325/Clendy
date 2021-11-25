package com.kh.clendy.product.model.vo;

public class ProductCart {
	private int pNo;
	private int cartNo;
	private int cartAmount;
	private int pOptionNo;
	private int userNo;
	
	public ProductCart() { }

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}

	public int getpOptionNo() {
		return pOptionNo;
	}

	public void setpOptionNo(int pOptionNo) {
		this.pOptionNo = pOptionNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "ProductCart [pNo=" + pNo + ", cartNo=" + cartNo + ", cartAmount=" + cartAmount + ", pOptionNo="
				+ pOptionNo + ", userNo=" + userNo + "]";
	}
	
}