package com.kh.clendy.product.model.vo;

public class ProductOption {
	private int pOptionNo;
	private int pNo;
	private String pColor;
	private String pSize;
	private int pStock;
	private int pPrice;
	private int pDiscount;
	
	public ProductOption() { }

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

	@Override
	public String toString() {
		return "ProductOption [pOptionNo=" + pOptionNo + ", pNo=" + pNo + ", pColor=" + pColor + ", pSize=" + pSize
				+ ", pStock=" + pStock + ", pPrice=" + pPrice + ", pDiscount=" + pDiscount + "]";
	}
	
}
