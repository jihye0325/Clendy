package com.kh.clendy.mypage.model.vo;

import java.util.Date;
import java.util.List;

import com.kh.clendy.product.model.vo.Product;

public class Wishlist {
	private int user_no;
	private Date create_date;
	
	// 상품정보
	private List<Product> product_list;
	
	public Wishlist() {}

	public Wishlist(int user_no, Date create_date, List<Product> product_list) {
		super();
		this.user_no = user_no;
		this.create_date = create_date;
		this.product_list = product_list;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public List<Product> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}

}
