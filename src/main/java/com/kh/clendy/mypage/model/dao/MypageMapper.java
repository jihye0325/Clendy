package com.kh.clendy.mypage.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.CScenter.model.vo.PersonalQ;
import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.vo.Cart;
import com.kh.clendy.mypage.model.vo.Coupon;
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

@Mapper
public interface MypageMapper {

	Member selectMember(int user_no);

	int modifyMember(Member m);

	int deleteMember(int user_no);

	List<Point> selectPoint(Map<String, Object> mapMapper);

	List<Coupon> selectCou_List(int user_no);

	List<Coupon> selectDisable_Cou_List(int user_no);

	List<Coupon> selectUse_Cou_List(int user_no);

	Wishlist selectOuterlist(Map<String, Object> mapMapper);

	Wishlist selectToplist(Map<String, Object> mapMapper);
	
	Wishlist selectBottomlist(Map<String, Object> mapMapper);
	
	Wishlist selectAcclist(Map<String, Object> mapMapper);
	
	int deleteWish(HashMap<String, Integer> userMap);

	Order_Option selectProduct(int order_option_code);

	int insertReview(Review review);
	
	Review selectReview(int order_option_code);

	List<ProductQnaQ> selectP_Qna_List(Map<String, Object> mapMapper);

	List<Review> selectReview_List(Map<String, Object> mapMapper);
	
	List<Cart> selectCart_list(int user_no);

	int deleteCart(int cart_no);

	int minusAmount(HashMap<String, Integer> userMap);

	int plusAmount(HashMap<String, Integer> userMap);

	List<Product_Order> selectProduct_Order(Map<String, Object> mapMapper);
	
	int selectPostnum(int order_option_code);

	int decide_buy(int order_option_code);

	Payment selectOrderInfo(int order_option_code);

	int requestRefund(Refund refund);

	int changeOrder_Status(int order_option_code);

	int requestRefund_date(int order_option_code);
	
	List<PersonalQ> selectQ_list(Map<String, Object> mapMapper);

	List<Refund> selectR_list(Map<String, Object> mapMapper);

	Refund selectRefund(int order_option_code);

	/* 다운 가능한 이벤트 포인트 리스트 */
	List<Point_Category> selectDownableEventPoint(int user_no);

	// 이벤트 포인트 다운로드
	int downloadEventPoint(Map<String, Object> map);

	int buy_point(int order_option_code, int user_no);
	
	int decide_buyDate(int order_option_code);

	List<Product_Option> selectExOption(int order_option_code);

	int review_Point(int user_no);

	int requestExchange(Exchange exchange);

	int changeExchange_stauts(int order_option_code);

	List<Exchange> selectEx_list(Map<String, Object> mapMapper);

	Exchange selectExchange(int order_option_code);

	int requestExchange_date(int order_option_code);
	
	Payment selectPayment(String merchant_uid);

	int o_o_status(String merchant_uid_Value);

	int p_o_status(String merchant_uid_Value);

	int payment_status(String merchant_uid_Value);

	List<Order_Option> selectO_Olist(String merchant_uid_Value);

	int stock_Status(int order_option_code);

	int reviewModify(Review review);

	Review reviewDate(int order_option_code);

	int countOrderList(int user_no);

	int countP_Qna_List(int user_no);

	int countReviewList(int user_no);

	int countQ_list(int user_no);

	int countEx_list(int user_no);

	int countR_list(int user_no);

	int countOuter_List(int user_no);

	int countTop_List(int user_no);

	int countBottom_List(int user_no);

	int countAcc_List(int user_no);

	int countPoint_List(int user_no);

	int selectTotalPoint(int user_no);

	int selectDel_cnt(int user_no);

	int selectDel_Complete_cnt(int user_no);

	int selectCancle_cnt(int user_no);

	int reviewDelete(int order_option_code);
	
	int countWishList(Map<String, Object> cnt);
	
	Wishlist selectWishlist(Map<String, Object> mapMapper);

	int cancle_usePoint(String merchant_uid_Value);
	
}
