package com.kh.clendy.product.model.vo;

import java.util.Date;
import java.util.List;

import com.kh.clendy.member.model.vo.Member;

public class ProductReview {
	private int loginUno;
	private int rNo;
	private int orderCode; //??
	private int orderOptionCode;
	private String rTitle;
	private int score;
	private String openSize;
	private String rContent;
	private String pColor; 
	private String pSize; 
	private Date rCreateDate;
	private Date rModifyDate;
	private List<ProductImage> imageList; //ㅇㅇ
	private Member member; 
	private Product product;
	private int likeCount; // ㅇㅇ
	
	public ProductReview() { }

	public int getLoginUno() {
		return loginUno;
	}

	public void setLoginUno(int loginUno) {
		this.loginUno = loginUno;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getOrderOptionCode() {
		return orderOptionCode;
	}

	public void setOrderOptionCode(int orderOptionCode) {
		this.orderOptionCode = orderOptionCode;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getOpenSize() {
		return openSize;
	}

	public void setOpenSize(String openSize) {
		this.openSize = openSize;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
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

	public Date getrCreateDate() {
		return rCreateDate;
	}

	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}

	public Date getrModifyDate() {
		return rModifyDate;
	}

	public void setrModifyDate(Date rModifyDate) {
		this.rModifyDate = rModifyDate;
	}

	public List<ProductImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<ProductImage> imageList) {
		this.imageList = imageList;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	@Override
	public String toString() {
		return "ProductReview [loginUno=" + loginUno + ", rNo=" + rNo + ", orderCode=" + orderCode
				+ ", orderOptionCode=" + orderOptionCode + ", rTitle=" + rTitle + ", score=" + score + ", openSize="
				+ openSize + ", rContent=" + rContent + ", pColor=" + pColor + ", pSize=" + pSize + ", rCreateDate="
				+ rCreateDate + ", rModifyDate=" + rModifyDate + ", imageList=" + imageList + ", member=" + member
				+ ", product=" + product + ", likeCount=" + likeCount + "]";
	}
	
	

}
	