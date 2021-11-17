package com.kh.clendy.product.model.vo;

import java.sql.Date;

public class ProductQnaA {
	private int piaCode;
	private String piaContent;
	private Date piaCreateDate;
	private String piaDelStatus;
	
	public ProductQnaA() {
	}

	public int getPiaCode() {
		return piaCode;
	}

	public void setPiaCode(int piaCode) {
		this.piaCode = piaCode;
	}

	public String getPiaContent() {
		return piaContent;
	}

	public void setPiaContent(String piaContent) {
		this.piaContent = piaContent;
	}

	public Date getPiaCreateDate() {
		return piaCreateDate;
	}

	public void setPiaCreateDate(Date piaCreateDate) {
		this.piaCreateDate = piaCreateDate;
	}

	public String getPiaDelStatus() {
		return piaDelStatus;
	}

	public void setPiaDelStatus(String piaDelStatus) {
		this.piaDelStatus = piaDelStatus;
	}

	@Override
	public String toString() {
		return "ProductQnaA [piaCode=" + piaCode + ", piaContent=" + piaContent + ", piaCreateDate=" + piaCreateDate
				+ ", piaDelStatus=" + piaDelStatus + "]";
	}
	
	
}
