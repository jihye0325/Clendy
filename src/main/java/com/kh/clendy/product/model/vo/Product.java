package com.kh.clendy.product.model.vo;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private int pNo;
	private String pName;
	private int pPrice;
	private int pDiscount;
	private String pAbleCoupon;
	private String pDetailImage;
	private int CategoryCode;
	private int sellerCode;
	private String pStatus;
	private int wishLike;
	private List<ProductImage> imageList;
	private ProductFilter filter;
	private int selCount;
	private int reviewCount;
	
	public Product() {
		imageList = new ArrayList<>();
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

	public int getCategoryCode() {
		return CategoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		CategoryCode = categoryCode;
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

	public int getWishLike() {
		return wishLike;
	}

	public void setWishLike(int wishLike) {
		this.wishLike = wishLike;
	}

	public List<ProductImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<ProductImage> imageList) {
		this.imageList = imageList;
	}

	public ProductFilter getFilter() {
		return filter;
	}

	public void setFilter(ProductFilter filter) {
		this.filter = filter;
	}

	public int getSelCount() {
		return selCount;
	}

	public void setSelCount(int selCount) {
		this.selCount = selCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "Product [pNo=" + pNo + ", pName=" + pName + ", pPrice=" + pPrice + ", pDiscount=" + pDiscount
				+ ", pAbleCoupon=" + pAbleCoupon + ", pDetailImage=" + pDetailImage + ", CategoryCode=" + CategoryCode
				+ ", sellerCode=" + sellerCode + ", pStatus=" + pStatus + ", wishLike=" + wishLike + ", imageList="
				+ imageList + ", filter=" + filter + ", selCount=" + selCount + ", reviewCount=" + reviewCount + "]";
	}

}
