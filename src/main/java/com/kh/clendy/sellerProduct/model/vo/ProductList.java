package com.kh.clendy.sellerProduct.model.vo;

public class ProductList {
	private int orderCode;
	private String pName;
	private String userName;
	private String orderAddress;
	private String pSize;
	private String pColor;
	private int orderProductNum;
	
	private String userId;

	public ProductList() {
		super();
	}

	public ProductList(int orderCode, String pName, String userName, String orderAddress, String pSize, String pColor,
			int orderProductNum, String userId) {
		super();
		this.orderCode = orderCode;
		this.pName = pName;
		this.userName = userName;
		this.orderAddress = orderAddress;
		this.pSize = pSize;
		this.pColor = pColor;
		this.orderProductNum = orderProductNum;
		this.userId = userId;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public int getOrderProductNum() {
		return orderProductNum;
	}

	public void setOrderProductNum(int orderProductNum) {
		this.orderProductNum = orderProductNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProductList [orderCode=" + orderCode + ", pName=" + pName + ", userName=" + userName + ", orderAddress="
				+ orderAddress + ", pSize=" + pSize + ", pColor=" + pColor + ", orderProductNum=" + orderProductNum
				+ ", userId=" + userId + "]";
	}
}