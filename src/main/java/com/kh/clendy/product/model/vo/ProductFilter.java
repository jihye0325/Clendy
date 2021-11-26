package com.kh.clendy.product.model.vo;

public class ProductFilter {
	private int page;
	private String type;
	private String align;
	private String category;
	
	public ProductFilter() { 
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		this.page = page;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override 
	public String toString() {
		return "ProductFilter [page=" + page + ", type=" + type + ", align=" + align + ", category=" + category + "]";
	}

}
