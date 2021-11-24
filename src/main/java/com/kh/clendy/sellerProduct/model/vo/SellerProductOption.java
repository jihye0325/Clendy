package com.kh.clendy.sellerProduct.model.vo;

public class SellerProductOption {
	private int pOptionNo;
	private int pNo;
	private String pColor;
	private String pSize;
	private int pStock;

	public SellerProductOption() {
		super();
	}

	public SellerProductOption(int pOptionNo, int pNo, String pColor, String pSize, int pStock) {
		super();
		this.pOptionNo = pOptionNo;
		this.pNo = pNo;
		this.pColor = pColor;
		this.pSize = pSize;
		this.pStock = pStock;
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

	@Override
	public String toString() {
		return "SellerProductOption [pOptionNo=" + pOptionNo + ", pNo=" + pNo + ", pColor=" + pColor + ", pSize="
				+ pSize + ", pStock=" + pStock + "]";
	}
}