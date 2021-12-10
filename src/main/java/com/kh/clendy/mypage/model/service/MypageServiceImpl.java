package com.kh.clendy.mypage.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.CScenter.model.vo.PersonalQ;
import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.mypage.model.dao.MypageMapper;
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
import com.kh.clendy.product.model.vo.PageInfo;
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
	public Map<String, Object> selectPoint(int user_no, int page) {
		// 적립금 개수
		int listCount = mypageMapper.countPoint_List(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 5, 5);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 적립금 조회
		List<Point> point_list = mypageMapper.selectPoint(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("point_list", point_list);
		result.put("pi", pageInfo);
		
		return result;
	}

	// 위시리스트 불러오기(아우터)
	@Override
	public Map<String, Object> selectOuterlist(int user_no, int page) {
		// 아우터 개수
		int listCount = mypageMapper.countOuter_List(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 5, 9);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 아우터 조회
		Wishlist outer_list = mypageMapper.selectOuterlist(mapMapper);

		Map<String, Object> result = new HashMap<>();
		result.put("outer_list", outer_list);
		result.put("pi", pageInfo);
		
		return result;
	}

	// 위시리스트 불러오기(상의)
	@Override
	public Map<String, Object> selectToplist(int user_no, int page) {
		// 상의 개수
		int listCount = mypageMapper.countTop_List(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 5, 9);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 상의 조회
		Wishlist top_list = mypageMapper.selectToplist(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("top_list", top_list);
		result.put("pi", pageInfo);
		
		return result;
	}

	// 위시리스트 불러오기(하의)
	@Override
	public Map<String, Object> selectBottomlist(int user_no, int page) {
		// 하의 개수
		int listCount = mypageMapper.countBottom_List(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 5, 9);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 하의 조회
		Wishlist bottom_list = mypageMapper.selectBottomlist(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("bottom_list", bottom_list);
		result.put("pi", pageInfo);
		
		return result;
	}
	
	// 위시리스트 불러오기(acc)
	@Override
	public Map<String, Object> selectAcclist(int user_no, int page) {
		// acc 개수
		int listCount = mypageMapper.countAcc_List(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 5, 9);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// acc 조회
		Wishlist acc_list = mypageMapper.selectAcclist(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("acc_list", acc_list);
		result.put("pi", pageInfo);
		
		return result;
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
	public int insertReview(Review review, int user_no) {
		int result = 0;
		int result1 = mypageMapper.insertReview(review);
		int result2 = mypageMapper.review_Point(user_no);
				
		if(result1 > 0 && result2 > 0)
			result = 1;
		return result;
	}
	
	// 리뷰 상세페이지
	@Override
	public Review selectReview(int order_option_code) {
		return mypageMapper.selectReview(order_option_code);
	}

	// 내가 쓴 글 - 상품문의글 리스트
	@Override
	public Map<String, Object> selectP_Qna_List(int user_no, int page) {
		// 문의글 개수
		int listCount = mypageMapper.countP_Qna_List(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 상품문의글 조회
		List<ProductQnaQ> p_qna_list = mypageMapper.selectP_Qna_List(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("p_qna_list", p_qna_list);
		result.put("pi", pageInfo);
		
		return result;
	}
	

	// 내가 쓴 글 - 리뷰 리스트
	@Override
	public Map<String, Object> selectReview_List(int user_no, int page) {
		// 리뷰 개수
		int listCount = mypageMapper.countReviewList(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 리뷰 목록 조회
		List<Review> review_list = mypageMapper.selectReview_List(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("review_list", review_list);
		result.put("pi", pageInfo);
		
		return result;
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
	public Map<String, Object> selectProduct_Order(int user_no, int page) {
		// 주문 내역 개수
		int listCount = mypageMapper.countOrderList(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 주문내역 목록 조회
		List<Product_Order> po_list = mypageMapper.selectProduct_Order(mapMapper);
		// 배송중인 상품의 개수
		int del_cnt = mypageMapper.selectDel_cnt(user_no);
		// 배송완료 개수
		int del_complete_cnt = mypageMapper.selectDel_Complete_cnt(user_no);
		// 취소/반품 개수
		int cancle_cnt = mypageMapper.selectCancle_cnt(user_no);
		
		Map<String, Object> result = new HashMap<>();
		result.put("po_list", po_list);
		result.put("pi", pageInfo);
		result.put("del_cnt", del_cnt);
		result.put("del_complete_cnt", del_complete_cnt);
		result.put("cancle_cnt", cancle_cnt);
		
		return result;
	}
	
	// 운송장번호 조회
	@Override
	public int selectPostnum(int order_option_code) {
		return mypageMapper.selectPostnum(order_option_code);
	}

	// 구매확정
	@Override
	public int decide_buy(int order_option_code, int user_no) {
		int result = 0;
		// 주문상태 변경
		int result1 = mypageMapper.decide_buy(order_option_code);
		// 구매확정 적립금 
		int result2 = mypageMapper.buy_point(order_option_code, user_no);
		// 구매확정 날짜
		int result3 = mypageMapper.decide_buyDate(order_option_code);
		
		if(result1 > 0 && result2 > 0 && result3 > 0)
			result = 1;
		
		return result;
	}

	// 주문내역조회
	@Override
	public Payment selectOrderInfo(int order_option_code) {
		return mypageMapper.selectOrderInfo(order_option_code);
	}

	// 환불요청
	@Override
	public int requestRefund(Refund refund) {
		int result = 0;
		
		// 환불요청 등록
		int result1 = mypageMapper.requestRefund(refund);
		// 주문상태 변경
		int result2 = mypageMapper.changeOrder_Status(refund.getOrder_option_code());
		// 상태변경 날짜
		int result3 = mypageMapper.requestRefund_date(refund.getOrder_option_code());
		
		if(result1 > 0 && result2 > 0 && result3 >0)
			result = 1;
		
		return result;
	}

	// 내가 쓴 글 (1:1 조회)
	@Override
	public Map<String, Object> selectQ_list(int user_no, int page) {
		// 1:1문의 개수
		int listCount = mypageMapper.countQ_list(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 1:1문의 목록 조회
		List<PersonalQ> q_list = mypageMapper.selectQ_list(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("q_list", q_list);
		result.put("pi", pageInfo);
		
		return result;
	}

	// 내가 쓴 글 (환불)
	@Override
	public Map<String, Object> selectR_list(int user_no, int page) {
		// 환불요청 내역 개수
		int listCount = mypageMapper.countR_list(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 환불요청 목록 조회
		List<Refund> r_list = mypageMapper.selectR_list(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("r_list", r_list);
		result.put("pi", pageInfo);
		
		return result;
	}

	// 환불요청 상세
	@Override
	public Refund selectRefund(int order_option_code) {
		return mypageMapper.selectRefund(order_option_code);
	}
	
	// 내가쓴글- 교환리스트
	@Override
	public Map<String, Object> selectEx_list(int user_no, int page) {
		// 교환 내역 개수
		int listCount = mypageMapper.countEx_list(user_no);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(page, listCount, 10, 10);
		
		// 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage()-1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() -1;
		
		// 목록 호출에 넘기는 값
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", page);
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("user_no", user_no);
		
		// 교환 목록 조회
		List<Exchange> ex_list = mypageMapper.selectEx_list(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("ex_list", ex_list);
		result.put("pi", pageInfo);
		
		return result;
	}
	
	// 다운 가능한 이벤트 포인트 리스트
	@Override
	public List<Point_Category> selectDownableEventPoint(int user_no) {
		return mypageMapper.selectDownableEventPoint(user_no);
	}

	// 이벤트 포인트 다운로드
	@Override
	public int downloadEventPoint(Point_Category downloadPoint, int user_no) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("downloadPoint", downloadPoint);
		map.put("user_no", user_no);
	
		return mypageMapper.downloadEventPoint(map);
	}

	// 교환페이지
	@Override
	public List<Product_Option> selectExOption(int order_option_code) {
		return mypageMapper.selectExOption(order_option_code);
	}

	// 교환요청
	@Override
	public int requestExchange(Exchange exchange) {
		int result = 0;
		int result1 = mypageMapper.requestExchange(exchange);
		int result2 = mypageMapper.changeExchange_stauts(exchange.getOrder_option_code());
		int result3 = mypageMapper.requestExchange_date(exchange.getOrder_option_code());
		
		if(result1 > 0 && result2 > 0 && result3 > 0)
			result = 1;
		
		return result;
	}

	// 교환상세페이지
	@Override
	public Exchange selectExchange(int order_option_code) {
		return mypageMapper.selectExchange(order_option_code);
	}

	// 결제취소
	@Override
	public Payment selectPayment(String merchant_uid) {
		return mypageMapper.selectPayment(merchant_uid);
	}

	// 결제 취소 후 상태변경
	@Override
	public int canclePay(String merchant_uid_Value) {
		int result = 0;
		
		// order_option 변경
		int result1 = mypageMapper.o_o_status(merchant_uid_Value);
		
		// product_order 변경
		int result2 = mypageMapper.p_o_status(merchant_uid_Value);
		
		// payment 변경
		int result3 = mypageMapper.payment_status(merchant_uid_Value);
		
		// product_option 재고 원래대로
		List<Order_Option> order_optionList = mypageMapper.selectO_Olist(merchant_uid_Value);

		int result4 = 0;
		
		for(Order_Option o : order_optionList) {
			int r = mypageMapper.stock_Status(o.getOrder_option_code());
			if(r > 0)
				result4 = 1;
		}
		
		// 포인트 사용취소
		int result5 = mypageMapper.cancle_usePoint(merchant_uid_Value);
		
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0)
			result = 1; 
				
		return result;
	}

	// 리뷰수정
	@Override
	public int reviewModify(Review review) {
		return mypageMapper.reviewModify(review);
	}

	// 리뷰 삭제 전 날짜 확인
	@Override
	public Review reviewDate(int order_option_code) {
		return mypageMapper.reviewDate(order_option_code);
	}

	// 포인트 총합
	@Override
	public int selectTotalPoint(int user_no) {
		return mypageMapper.selectTotalPoint(user_no);
	}

	// 리뷰삭제
	@Override
	public int reviewDelete(int order_option_code) {
		return mypageMapper.reviewDelete(order_option_code);
	}

}
