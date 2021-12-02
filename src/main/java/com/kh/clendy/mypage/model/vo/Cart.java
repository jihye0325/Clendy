package com.kh.clendy.mypage.model.vo;

public class Cart {
	private int cart_no;
	private int cart_amount;
	private int p_option_no;
	private int user_no;
	
	private Product_Option product_option;
	
	// 추가 컬럼
	private String seller_name;
	private String p_color;
	private String p_size;
	private String p_name;
	private int p_price;
	private int seller_code;
	private String route;
	private String imgrName;
	private int subtotal; // 상품 * 카트에 담은 수량
	private int p_no;
	private int p_discount;
	
	public Cart() {}

	public Cart(int cart_no, int cart_amount, int p_option_no, int user_no, Product_Option product_option,
			String seller_name, String p_color, String p_size, String p_name, int p_price, int seller_code,
			String route, String imgrName, int subtotal, int p_no, int p_discount) {
		super();
		this.cart_no = cart_no;
		this.cart_amount = cart_amount;
		this.p_option_no = p_option_no;
		this.user_no = user_no;
		this.product_option = product_option;
		this.seller_name = seller_name;
		this.p_color = p_color;
		this.p_size = p_size;
		this.p_name = p_name;
		this.p_price = p_price;
		this.seller_code = seller_code;
		this.route = route;
		this.imgrName = imgrName;
		this.subtotal = subtotal;
		this.p_no = p_no;
		this.p_discount = p_discount;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(int cart_amount) {
		this.cart_amount = cart_amount;
	}

	public int getP_option_no() {
		return p_option_no;
	}

	public void setP_option_no(int p_option_no) {
		this.p_option_no = p_option_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public Product_Option getProduct_option() {
		return product_option;
	}

	public void setProduct_option(Product_Option product_option) {
		this.product_option = product_option;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getP_color() {
		return p_color;
	}

	public void setP_color(String p_color) {
		this.p_color = p_color;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
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

	public int getSeller_code() {
		return seller_code;
	}

	public void setSeller_code(int seller_code) {
		this.seller_code = seller_code;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getImgrName() {
		return imgrName;
	}

	public void setImgrName(String imgrName) {
		this.imgrName = imgrName;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public int getP_discount() {
		return p_discount;
	}

	public void setP_discount(int p_discount) {
		this.p_discount = p_discount;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", cart_amount=" + cart_amount + ", p_option_no=" + p_option_no
				+ ", user_no=" + user_no + ", product_option=" + product_option + ", seller_name=" + seller_name
				+ ", p_color=" + p_color + ", p_size=" + p_size + ", p_name=" + p_name + ", p_price=" + p_price
				+ ", seller_code=" + seller_code + ", route=" + route + ", imgrName=" + imgrName + ", subtotal="
				+ subtotal + ", p_no=" + p_no + ", p_discount=" + p_discount + "]";
	}

		
}
