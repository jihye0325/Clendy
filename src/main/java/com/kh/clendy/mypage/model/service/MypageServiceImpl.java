package com.kh.clendy.mypage.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.CScenter.model.vo.PersonalQ;
import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.dao.MypageMapper;
import com.kh.clendy.mypage.model.vo.Cart;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.mypage.model.vo.Order_Option;
import com.kh.clendy.mypage.model.vo.Payment;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Product;
import com.kh.clendy.mypage.model.vo.Product_Option;
import com.kh.clendy.mypage.model.vo.Product_Order;
import com.kh.clendy.mypage.model.vo.Refund;
import com.kh.clendy.mypage.model.vo.Review;
import com.kh.clendy.mypage.model.vo.Wishlist;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Service	
public class MypageServiceImpl implements MypageService {

	private MypageMapper mypageMapper;
	
	@Autowired
	public MypageServiceImpl(MypageMapper mypageMapper) {
		this.mypageMapper = mypageMapper;
	}
	
		
	// 로그인한 user_no로 해당 유저 정보 읽어오기	
	@Override
	public Member selectMember(int user_no) {
		Member m = mypageMapper.selectMember(user_no);
		
		return m;
	}
	
	// 회원정보 수정
	@Override
	public int modifyMember(Member m) {
		
		int result = mypageMapper.modifyMember(m);
		
		if(result > 0)
			System.out.println("수정 성공");
		else 
			System.out.println("수정 실패");
		
		return result;
	}
	
	//  회원탈퇴 - 상태변경 
	@Transactional
	@Override
	public int deleteMember(int user_no) {

		int result = mypageMapper.deleteMember(user_no);
		
		return result;
	}

	// 적립금 리스트 불러오기
	@Override
	public List<Point> selectPoint(int user_no) {
		List<Point> point_list = mypageMapper.selectPoint(user_no);
		
		return point_list;
	}

	// 사용가능 쿠폰 리스트
	@Override
	public List<Coupon> selectCou_List(int user_no) {
		List<Coupon> cou_list = mypageMapper.selectCou_List(user_no);
		return cou_list;
	}

	// 사용만료 쿠폰 리스트
	@Override
	public List<Coupon> selectDisable_Cou_List(int user_no) {
		List<Coupon> disable_cou_list = mypageMapper.selectDisable_Cou_List(user_no);
		return disable_cou_list;
	}

	// 사용완료 쿠폰 리스트
	@Override
	public List<Coupon> selectUse_Cou_List(int user_no) {
		List<Coupon> use_cou_list = mypageMapper.selectUse_Cou_List(user_no);
		return use_cou_list;
	}

	// 위시리스트 불러오기(아우터)
	@Override
	public Wishlist selectOuterlist(int user_no) {
		Wishlist outer_list = mypageMapper.selectOuterlist(user_no);
		return outer_list;
	}

	// 위시리스트 불러오기(상의)
	@Override
	public Wishlist selectToplist(int user_no) {
		Wishlist top_list = mypageMapper.selectToplist(user_no);
		return top_list;
	}

	// 위시리스트 불러오기(하의)
	@Override
	public Wishlist selectBottomlist(int user_no) {
		Wishlist bottom_list = mypageMapper.selectBottomlist(user_no);
		return bottom_list;
	}

	// 위시리스트 불러오기(acc)
	@Override
	public Wishlist selectAcclist(int user_no) {
		Wishlist acc_list = mypageMapper.selectAcclist(user_no);
		return acc_list;
	}
	
	// 위시리스트 삭제
	@Override
	public int deleteWish(HashMap<String, Integer> userMap) {
		return mypageMapper.deleteWish(userMap);
	}


	// 리뷰등록시 상품정보 조회
	@Override
	public Order_Option selectProduct(int order_option_code) {
		return mypageMapper.selectProduct(order_option_code);
	}

	// 리뷰 등록
	@Override
	public int insertReview(Review review) {
		return mypageMapper.insertReview(review);
	}
	
	// 리뷰 상세페이지
	@Override
	public Review selectReview(int order_option_code) {
		return mypageMapper.selectReview(order_option_code);
	}

	// 내가 쓴 글 - 상품문의글 리스트
	@Override
	public List<ProductQnaQ> selectP_Qna_List(int user_no) {
		List<ProductQnaQ> p_qna_list = mypageMapper.selectP_Qna_List(user_no);
		return p_qna_list;
	}

	// 내가 쓴 글 - 리뷰 리스트
	@Override
	public List<Review> selectReview_List(int user_no) {
		List<Review> review_list = mypageMapper.selectReview_List(user_no);
		return review_list;
	}
	

	// 장바구니 조회
	@Override
	public List<Cart> selectCart_list(int user_no) {
		return mypageMapper.selectCart_list(user_no);
	}

	// 장바구니 삭제(개별 버튼)
	@Override
	public int deleteCart(int cart_no) {
		return mypageMapper.deleteCart(cart_no);
	}

	// 장바구니 수량감소
	@Override
	public int minusAmount(HashMap<String, Integer> userMap) {
		return mypageMapper.minusAmount(userMap);
	}

	// 장바구니 수량증가
	@Override
	public int plusAmount(HashMap<String, Integer> userMap) {
		return mypageMapper.plusAmount(userMap);
	}

	// 주문내역 화면
	@Override
	public List<Product_Order> selectProduct_Order(int user_no) {
		return mypageMapper.selectProduct_Order(user_no);
	}
	
	// 운송장번호 조회
	@Override
	public int selectPostnum(int order_option_code) {
		return mypageMapper.selectPostnum(order_option_code);
	}

	// 구매확정
	@Override
	public int decide_buy(int order_option_code) {
		return mypageMapper.decide_buy(order_option_code);
	}

	// 주문내역조회
	@Override
	public Payment selectOrderInfo(int order_code) {
		return mypageMapper.selectOrderInfo(order_code);
	}

	// 환불요청
	@Override
	public int requestRefund(Refund refund) {
		int result = 0;
		
		// 환불요청 등록
		int result1 = mypageMapper.requestRefund(refund);
		// 주문상태 변경
		int result2 = mypageMapper.changeOrder_Status(refund.getOrder_option_code());
		System.out.println(result1);
		System.out.println(result2);
		
		if(result1 > 0 && result2 > 0)
			result = 1;
		
		return result;
	}

	// 내가 쓴 글 (1:1 조회)
	@Override
	public List<PersonalQ> selectQ_list(int user_no) {
		return mypageMapper.selectQ_list(user_no);
	}
	
}
