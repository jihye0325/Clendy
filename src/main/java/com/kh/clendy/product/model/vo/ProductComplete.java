package com.kh.clendy.product.model.vo;

public class ProductComplete {
	private int orderCode;
	private int userNo;
	private int orderDelivery;
	private int orderAllPrice;
	private int orderOptionCode;
	private int orderProductNum;
	private int pOptionNo;
	private int pNo;
	private String pColor;
	private String pSize;
	private int pStock;
	private String pName;
	private int pPrice;
	private int pDisCount;
	private int sellerCode;
	private int aNo;
	private String sellerName;
	private ProductImage productImage;
	private int point;
	private int payMoney;
	private String payCardName;
	private String payCardNum;
	
	public ProductComplete() { }

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getOrderDelivery() {
		return orderDelivery;
	}

	public void setOrderDelivery(int orderDelivery) {
		this.orderDelivery = orderDelivery;
	}

	public int getOrderAllPrice() {
		return orderAllPrice;
	}

	public void setOrderAllPrice(int orderAllPrice) {
		this.orderAllPrice = orderAllPrice;
	}

	public int getOrderOptionCode() {
		return orderOptionCode;
	}

	public void setOrderOptionCode(int orderOptionCode) {
		this.orderOptionCode = orderOptionCode;
	}

	public int getOrderProductNum() {
		return orderProductNum;
	}

	public void setOrderProductNum(int orderProductNum) {
		this.orderProductNum = orderProductNum;
	}

	public int getpOptionNo() {
		return pOptionNo;
	}

	public void setpOptionNo(int pOptionNo) {
		this.pOptionNo = pOptionNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpDisCount() {
		return pDisCount;
	}

	public void setpDisCount(int pDisCount) {
		this.pDisCount = pDisCount;
	}

	public int getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(int sellerCode) {
		this.sellerCode = sellerCode;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayCardName() {
		return payCardName;
	}

	public void setPayCardName(String payCardName) {
		this.payCardName = payCardName;
	}

	public String getPayCardNum() {
		return payCardNum;
	}

	public void setPayCardNum(String payCardNum) {
		this.payCardNum = payCardNum;
	}

	@Override
	public String toString() {
		return "ProductComplete [orderCode=" + orderCode + ", userNo=" + userNo + ", orderDelivery=" + orderDelivery
				+ ", orderAllPrice=" + orderAllPrice + ", orderOptionCode=" + orderOptionCode + ", orderProductNum="
				+ orderProductNum + ", pOptionNo=" + pOptionNo + ", pNo=" + pNo + ", pColor=" + pColor + ", pSize="
				+ pSize + ", pStock=" + pStock + ", pName=" + pName + ", pPrice=" + pPrice + ", pDisCount=" + pDisCount
				+ ", sellerCode=" + sellerCode + ", aNo=" + aNo + ", sellerName=" + sellerName + ", productImage="
				+ productImage + ", point=" + point + ", payMoney=" + payMoney + ", payCardName=" + payCardName
				+ ", payCardNum=" + payCardNum + "]";
	}

	
}
