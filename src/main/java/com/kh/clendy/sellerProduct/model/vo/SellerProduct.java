package com.kh.clendy.sellerProduct.model.vo;

import java.util.List;

public class SellerProduct {
	private int pNo;					// 상품 번호
	private String pName;				// 상품명
	private int pPrice;					// 판매가
	private int pDiscount;				// 할인율
	private String pAbleCoupon;			// 쿠폰 적용여부
	private String pDetailImage;		// 썸네일? 상세?
	private String categoryCode;		// 카테고리코드
	private int sellerCode;				// 판매자 코드
	private String pStatus;				// 상품 상태
	private List<SellerProductImage> imageList;
	
	private String productImg;
	private String productThumbImg;

	public SellerProduct() {
		super();
	}

	public SellerProduct(int pNo, String pName, int pPrice, int pDiscount, String pAbleCoupon, String pDetailImage,
			String categoryCode, int sellerCode, String pStatus, List<SellerProductImage> imageList, String productImg,
			String productThumbImg) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pAbleCoupon = pAbleCoupon;
		this.pDetailImage = pDetailImage;
		this.categoryCode = categoryCode;
		this.sellerCode = sellerCode;
		this.pStatus = pStatus;
		this.imageList = imageList;
		this.productImg = productImg;
		this.productThumbImg = productThumbImg;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
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

	public int getpDiscount() {
		return pDiscount;
	}

	public void setpDiscount(int pDiscount) {
		this.pDiscount = pDiscount;
	}

	public String getpAbleCoupon() {
		return pAbleCoupon;
	}

	public void setpAbleCoupon(String pAbleCoupon) {
		this.pAbleCoupon = pAbleCoupon;
	}

	public String getpDetailImage() {
		return pDetailImage;
	}

	public void setpDetailImage(String pDetailImage) {
		this.pDetailImage = pDetailImage;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public int getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(int sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public List<SellerProductImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<SellerProductImage> imageList) {
		this.imageList = imageList;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductThumbImg() {
		return productThumbImg;
	}

	public void setProductThumbImg(String productThumbImg) {
		this.productThumbImg = productThumbImg;
	}

	@Override
	public String toString() {
		return "SellerProduct [pNo=" + pNo + ", pName=" + pName + ", pPrice=" + pPrice + ", pDiscount=" + pDiscount
				+ ", pAbleCoupon=" + pAbleCoupon + ", pDetailImage=" + pDetailImage + ", categoryCode=" + categoryCode
				+ ", sellerCode=" + sellerCode + ", pStatus=" + pStatus + ", imageList=" + imageList + ", productImg="
				+ productImg + ", productThumbImg=" + productThumbImg + "]";
	}
}