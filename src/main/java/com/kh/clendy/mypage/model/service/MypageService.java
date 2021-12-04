package com.kh.clendy.mypage.model.service;

import java.util.HashMap;
import java.util.List;

import com.kh.clendy.CScenter.model.vo.PersonalQ;
import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Cart;
import com.kh.clendy.mypage.model.vo.Exchange;
import com.kh.clendy.mypage.model.vo.Order_Option;
import com.kh.clendy.mypage.model.vo.Payment;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Point_Category;
import com.kh.clendy.mypage.model.vo.Product_Option;
import com.kh.clendy.mypage.model.vo.Product_Order;
import com.kh.clendy.mypage.model.vo.Refund;
import com.kh.clendy.mypage.model.vo.Review;
import com.kh.clendy.mypage.model.vo.Wishlist;
import com.kh.clendy.product.model.vo.ProductQnaQ;

public interface MypageService{
	Member selectMember(int user_no);
	
	int modifyMember(Member m);

	int deleteMember(int user_no);

	List<Point> selectPoint(int user_no);
	
	Wishlist selectOuterlist(int user_no);

	Wishlist selectToplist(int user_no);

	Wishlist selectBottomlist(int user_no);

	Wishlist selectAcclist(int user_no);
	
	int deleteWish(HashMap<String, Integer> userMap);

	Order_Option selectProduct(int order_option_code);

	int insertReview(Review review, int user_no);

	List<ProductQnaQ> selectP_Qna_List(int user_no);

	List<Review> selectReview_List(int user_no);
	
	Review selectReview(int order_option_code);
	
	List<Cart> selectCart_list(int user_no);

	int deleteCart(int cart_no);

	int minusAmount(HashMap<String, Integer> userMap);

	int plusAmount(HashMap<String, Integer> userMap);

	List<Product_Order> selectProduct_Order(int user_no);

	int selectPostnum(int order_option_code);

	int decide_buy(int order_option_code, int user_no);

	Payment selectOrderInfo(int order_code);

	int requestRefund(Refund refund);

	List<PersonalQ> selectQ_list(int user_no);

	List<Refund> selectR_list(int user_no);

	Refund selectRefund(int order_option_code);

	/* 다운 가능한 이벤트 포인트 리스트*/
	List<Point_Category> selectDownableEventPoint(int user_no);

	/* 이벤트 포인트 다운로드 */
	int downloadEventPoint(Point_Category downloadPoint, int user_no);

	List<Product_Option> selectExOption(int order_option_code);

	int requestExchange(Exchange exchange);

	List<Exchange> selectEx_list(int user_no);

	Exchange selectExchange(int order_option_code);

	Payment selectPayment(String merchant_uid);

	int canclePay(String merchant_uid_Value);

}
