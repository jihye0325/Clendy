package com.kh.clendy.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.mypage.model.service.MypageService;
import com.kh.clendy.mypage.model.vo.Cart;
import com.kh.clendy.mypage.model.vo.Coupon;
import com.kh.clendy.mypage.model.vo.Order_Option;
import com.kh.clendy.mypage.model.vo.Point;
import com.kh.clendy.mypage.model.vo.Review;
import com.kh.clendy.mypage.model.vo.Wishlist;
import com.kh.clendy.product.model.vo.ProductQnaQ;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	private MypageService mypageService;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	// 회원정보 수정화면
	@GetMapping("/modify")
	public ModelAndView modifyForm(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		// System.out.println(user_no);
		Member m = mypageService.selectMember(user_no);
		String address[] = m.getAddress().split(",");
		
		
		//System.out.println(address[0]);
		//System.out.println(address[1]);
		//System.out.println(address[2]);
		
		mv.addObject("m", m);
		mv.setViewName("mypage/modify");
		
		return mv;
	}
	
	// 회원정보 수정
	@PostMapping("/modify")
	public String memberModify(Model model, Member m, @RequestParam Map<String, String> parameters, RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		m.setUser_no(user_no);
		
		String originPwd = parameters.get("originPwd");
		
		// 현재 비밀번호 일치 확인
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(originPwd,user.getPassword())) {
			System.out.println("비밀번호 일치");
			System.out.println(m.getPassword());
			
			// 새로운 비밀번호 입력 O
			if(m.getPassword() != "") {
				m.setPassword(encoder.encode(m.getPassword()));
				
				int result =  mypageService.modifyMember(m);
				
				if(result > 0 ) {
					redirectAttr.addFlashAttribute("msg", "회원정보 수정 성공했습니다. 새로운 비밀번호로 로그인하세요.");
					SecurityContextHolder.clearContext();
					return "redirect:/";
				}
				else {
					redirectAttr.addFlashAttribute("msg", "회원정보 수정 실패했습니다.");
					return "redirect:/mypage/modify";
				}
				
			} 
			
			m.setPassword(encoder.encode(originPwd));
			int result =  mypageService.modifyMember(m);
			
			if(result > 0 ) {
				redirectAttr.addFlashAttribute("msg", "회원정보 수정 성공했습니다.");
				return "redirect:/mypage/modify";
			}
			else {
				redirectAttr.addFlashAttribute("msg", "회원정보 수정 실패했습니다.");
				return "redirect:/mypage/modify";
			}
			
		} else {
			System.out.println("비밀번호 불일치");
			redirectAttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute(m);
			
			return "redirect:/mypage/modify";
		}			
	}
	
	@GetMapping("/confirmPwd")
	public void confirmPwd() {}
	
	// 회원 탈퇴
	@PostMapping("/deleteMember")
	public String deleteMember(RedirectAttributes redirectAttr, @RequestParam String password) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();		
		String originPwd = user.getPassword();
		
		/* 암호화 되어있는 기존 암호와 입력받은 암호 일치 확인 */
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(password, originPwd)) {
			System.out.println("일치");
			
			int result = mypageService.deleteMember(user_no);
					
			if(result > 0) {
				System.out.println("탈퇴 성공");		
				SecurityContextHolder.clearContext();
				redirectAttr.addFlashAttribute("msg", "Clendy 탈퇴가 완료되었습니다. 감사합니다.");	// ** 개행처리 **
			}
			else {
				System.out.println("탈퇴 실패");
				redirectAttr.addFlashAttribute("msg", "탈퇴에 실패하셨습니다.");
				return "redirect:/mypage/modify";
			}
			
			return "redirect:/member/deletePage";
			
		} else {
			System.out.println("불일치");
			redirectAttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
			
			return "redirect:/mypage/confirmPwd";
		}
	}
	
	// 적립금/쿠폰 화면
	@GetMapping("/point_coupon")
	public ModelAndView point_coupon(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		// 적립금 리스트 불러오기
		List<Point> point_list = mypageService.selectPoint(user_no);
		System.out.println(point_list);
		
		mv.addObject("point_list", point_list);
		
		// 사용가능 쿠폰 리스트 불러오기
		List<Coupon> cou_list = mypageService.selectCou_List(user_no);
		mv.addObject("cou_list", cou_list);
		
		// 사용만료 쿠폰 리스트 불러오기
		List<Coupon> disable_cou_list = mypageService.selectDisable_Cou_List(user_no);
		mv.addObject("disable_cou_list", disable_cou_list);
		
		// 사용완료 쿠폰 리스트 불러오기
		List<Coupon> use_cou_list = mypageService.selectUse_Cou_List(user_no);
		mv.addObject("use_cou_list", use_cou_list);
		
		mv.setViewName("mypage/point_coupon");
		
		return mv;
	}
	
	// 위시리스트 화면
	@GetMapping("/wishlist")
	public ModelAndView wishlist(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		// 위시리스트 불러오기(아우터)
		Wishlist outer_list = mypageService.selectOuterlist(user_no);
		mv.addObject("outer_list", outer_list);
		
		// 위시리스트 불러오기(상의)
		Wishlist top_list = mypageService.selectToplist(user_no);
		mv.addObject("top_list", top_list);
		
		// 위시리스트 불러오기(하의)
		Wishlist bottom_list = mypageService.selectBottomlist(user_no);
		mv.addObject("bottom_list", bottom_list);
		
		// 위시리스트 불러오기(ACC)
		Wishlist acc_list = mypageService.selectAcclist(user_no);
		mv.addObject("acc_list", acc_list);
		
		mv.setViewName("mypage/wishlist");
		
		return mv;
	}
	
	// 위시리스트 삭제
	@PostMapping("/deleteWish")
	@ResponseBody
	public int deleteWish(@RequestParam int p_no) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		HashMap<String, Integer> userMap = new HashMap<>();
		userMap.put("user_no", user_no);
		userMap.put("p_no", p_no);
		
		int result = mypageService.deleteWish(userMap);
		
		return result;
	}
		
	// 리뷰 화면
	@GetMapping("/reviewInsert")
	public ModelAndView insertReview(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		Member m = mypageService.selectMember(user_no);
		// *** 리뷰 등록 클릭시 주문옵션번호(order_option_code)가 넘어오게 구현해야함 ***
		int order_option_code = 4;
		// 상품정보 조회
		Order_Option order_option = mypageService.selectProduct(order_option_code);

		mv.addObject("m", m);
		mv.addObject("order_option", order_option);
		mv.setViewName("/mypage/reviewInsert");
		return mv;		
	}
	
	// 리뷰 등록
	@PostMapping("/reviewInsert")
	public String insertReview(HttpServletRequest request, RedirectAttributes redirectAttr) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		int order_option_code = Integer.parseInt(request.getParameter("order_option_code"));
		
		String r_title = request.getParameter("r_title");
		int score = Integer.parseInt(request.getParameter("score"));
		String open_size = "";
		
		if(request.getParameter("open_size") == null) {
			open_size = "N";
		} else {
			open_size = "Y";
		}
		
		String r_content = request.getParameter("content");
		Review review = new Review(r_title, score, open_size, r_content, user_no, order_option_code);
		
		System.out.println(review);
		
		String msg = "";	
		int result = mypageService.insertReview(review); 
		
		if(result > 0) 
			msg = "리뷰가 등록되었습니다.";
		else 
			msg = "리뷰 등록에 실패하였습니다.";
				
		redirectAttr.addFlashAttribute("msg", msg);
		
		return "redirect:/mypage/reviewInsert";
	}
	
	// 리뷰 상세화면
	@GetMapping("/reviewDetail")
	public ModelAndView reviewDetail(ModelAndView mv) {
		// *** 리뷰 보기 클릭시 주문옵션번호(order_option_code)가 넘어오게 구현해야함 ***
		int order_option_code = 4;
		// 상품정보 조회
		Review review = mypageService.selectReview(order_option_code);
		
		System.out.println(review);
		mv.addObject("r", review);
		mv.setViewName("/mypage/reviewDetail");
		return mv;
	}
	
	// 내가 쓴 글 화면 
	@GetMapping("/myBoard")
	public ModelAndView myBoard(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		// 상품 문의글 리스트 
		List<ProductQnaQ> p_qna_list = mypageService.selectP_Qna_List(user_no); 
		mv.addObject("p_qna_list", p_qna_list);
		System.out.println(p_qna_list);
		// 리뷰 리스트
		List<Review> review_list = mypageService.selectReview_List(user_no);
		mv.addObject("review_list", review_list);
		//System.out.println(review_list);		
		// 1:1 문의 리스트  
		
		// 교환/환불 리스트
		
		mv.setViewName("mypage/myBoard");
		return mv;
	}
	
	// 주문내역 화면
	@GetMapping("/orderList")
	public void orderList() {}
	
	// 장바구니 화면
	@GetMapping("/cart")
	public ModelAndView cart(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		List<Cart> cart_list = mypageService.selectCart_list(user_no);
		System.out.println(cart_list);
		
		mv.addObject("cart_list", cart_list);		
		mv.setViewName("/mypage/cart");
		return mv;
	}
		
	// 장바구니 삭제 (개별 버튼)
	@PostMapping("/deleteCart")
	@ResponseBody
	public int deleteCart(@RequestParam int cart_no) {
		
		int result = mypageService.deleteCart(cart_no);
		
		return result;
	}
	
	// 장바구니 삭제 (선택 삭제)
	@PostMapping("/selectDelete")
	@ResponseBody
	public int selectDelelte(@RequestParam(value="deleteList[]") List<Integer> deleteList) {
		int result = 0;
		
		System.out.println(deleteList);
		
		for(Integer no : deleteList) 
			result = mypageService.deleteCart(no);
		
		return result;
	}
	
	// 장바구니 수량감소
	@PostMapping("/minus_amount")
	@ResponseBody
	public int minusAmount(@RequestParam int cart_no) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		HashMap<String, Integer> userMap = new HashMap<>();
		userMap.put("cart_no", cart_no);
		userMap.put("user_no", user_no);
		int result = mypageService.minusAmount(userMap);
		
		return result;
	}
	
	// 장바구니 수량증가
	@PostMapping("/plus_amount")
	@ResponseBody
	public int plusAmount(@RequestParam int cart_no, int p_option_no) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		HashMap<String, Integer> userMap = new HashMap<>();
		userMap.put("cart_no", cart_no);
		userMap.put("user_no", user_no);
		userMap.put("p_option_no", p_option_no);
		int result = mypageService.plusAmount(userMap);
		
		return result;
	}
		
	// 장바구니 총 주문금액
	
	
	
}
