package com.kh.clendy.mypage.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Cart;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.mypage.model.vo.Order_Option;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Product;
import com.kh.clendy.mypage.model.vo.Review;
import com.kh.clendy.mypage.model.vo.Wishlist;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Mapper
public interface MypageMapper {

	Member selectMember(int user_no);

	int modifyMember(Member m);

	int deleteMember(int user_no);

	List<Point> selectPoint(int user_no);

	List<Coupon> selectCou_List(int user_no);

	List<Coupon> selectDisable_Cou_List(int user_no);

	List<Coupon> selectUse_Cou_List(int user_no);

	Wishlist selectOuterlist(int user_no);

	Wishlist selectToplist(int user_no);

	Wishlist selectBottomlist(int user_no);

	Wishlist selectAcclist(int user_no); 
	
	int deleteWish(HashMap<String, Integer> userMap);

	Order_Option selectProduct(int order_option_code);

	int insertReview(Review review);
	
	Review selectReview(int order_option_code);

	List<ProductQnaQ> selectP_Qna_List(int user_no);

	List<Review> selectReview_List(int user_no);
	
	List<Cart> selectCart_list(int user_no);

	int deleteCart(int cart_no);

	int minusAmount(HashMap<String, Integer> userMap);

	int plusAmount(HashMap<String, Integer> userMap);

}
