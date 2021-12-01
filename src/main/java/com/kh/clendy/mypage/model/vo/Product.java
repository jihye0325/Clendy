package com.kh.clendy.mypage.model.vo;

import java.util.List;

import com.kh.clendy.product.model.vo.ProductImage;

public class Product {
	private int p_no;
	private String p_name;
	private int p_price;
	private int p_discount;
	private String p_detail_image;
	private int category_code;
	private int seller_code;
	private String p_status;
	
	private List<ProductImage> imageList;
	private Product_Category product_category;
	private Seller seller;
	
	public Product() {}

	public Product(int p_no, String p_name, int p_price, int p_discount, String p_detail_image, int category_code,
			int seller_code, String p_status, List<ProductImage> imageList, Product_Category product_category,
			Seller seller) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_discount = p_discount;
		this.p_detail_image = p_detail_image;
		this.category_code = category_code;
		this.seller_code = seller_code;
		this.p_status = p_status;
		this.imageList = imageList;
		this.product_category = product_category;
		this.seller = seller;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_discount() {
		return p_discount;
	}

	public void setP_discount(int p_discount) {
		this.p_discount = p_discount;
	}

	public String getP_detail_image() {
		return p_detail_image;
	}

	public void setP_detail_image(String p_detail_image) {
		this.p_detail_image = p_detail_image;
	}

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public int getSeller_code() {
		return seller_code;
	}

	public void setSeller_code(int seller_code) {
		this.seller_code = seller_code;
	}

	public String getP_status() {
		return p_status;
	}

	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	public List<ProductImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<ProductImage> imageList) {
		this.imageList = imageList;
	}

	public Product_Category getProduct_category() {
		return product_category;
	}

	public void setProduct_category(Product_Category product_category) {
		this.product_category = product_category;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_name=" + p_name + ", p_price=" + p_price + ", p_discount=" + p_discount
				+ ", p_detail_image=" + p_detail_image + ", category_code=" + category_code + ", seller_code="
				+ seller_code + ", p_status=" + p_status + ", imageList=" + imageList + ", product_category="
				+ product_category + ", seller=" + seller + "]";
	}

	
}
