package com.kh.clendy.product.model.vo;

public class Order {
	private String pName;
	private int pOptionNo;
	private String pColor;
	private String pSize;
	private int pStock;
	private int pPrice;
	private int pDiscount;
	private int cartMount;
	private int sellerCode;
	private int aNo;
	private String sellerName;
	private ProductImage orderImage;
	
	public Order() { }

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpOptionNo() {
		return pOptionNo;
	}

	public void setpOptionNo(int pOptionNo) {
		this.pOptionNo = pOptionNo;
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

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpDiscount() {
		return pDiscount;
	}

	public void setpDiscount(int pDiscount) {
		this.pDiscount = pDiscount;
	}

	public int getCartMount() {
		return cartMount;
	}

	public void setCartMount(int cartMount) {
		this.cartMount = cartMount;
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

	public ProductImage getOrderImage() {
		return orderImage;
	}

	public void setOrderImage(ProductImage orderImage) {
		this.orderImage = orderImage;
	}

	@Override
	public String toString() {
		return "Order [pName=" + pName + ", pOptionNo=" + pOptionNo + ", pColor=" + pColor + ", pSize=" + pSize
				+ ", pStock=" + pStock + ", pPrice=" + pPrice + ", pDiscount=" + pDiscount + ", cartMount=" + cartMount
				+ ", sellerCode=" + sellerCode + ", aNo=" + aNo + ", sellerName=" + sellerName + ", orderImage="
				+ orderImage + "]";
	}

		
}
