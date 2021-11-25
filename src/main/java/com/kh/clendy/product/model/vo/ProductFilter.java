package com.kh.clendy.product.model.vo;

public class ProductFilter {
	private String type;
	private String align;
	private String category;
	
	public ProductFilter() { }

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
		return "ProductFilter [type=" + type + ", align=" + align + ", category=" + category + "]";
	}
	
	
	
	
	
}
