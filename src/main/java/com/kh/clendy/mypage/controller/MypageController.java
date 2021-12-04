package com.kh.clendy.mypage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.CScenter.model.vo.PersonalQ;
import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.mypage.model.service.MypageService;
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
	
	// 적립금 화면
	@GetMapping("/point")
	public ModelAndView point(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		// 적립금 리스트 불러오기
		List<Point> point_list = mypageService.selectPoint(user_no);
		
		// 다운 가능한 이벤트 적립금 불러오기
		List<Point_Category> event_point_list = mypageService.selectDownableEventPoint(user_no);
		
		mv.addObject("event_point_list", event_point_list);

		
		mv.addObject("point_list", point_list);
		
		mv.setViewName("mypage/point");
		
		return mv;
	}
	
	// 이벤트 포인트 다운로드
	@PostMapping("/point/download")
	public String downloadPoint(RedirectAttributes redirectAttr, Point_Category downloadPoint) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		// 유저에게 포인트 지급
		int result = mypageService.downloadEventPoint(downloadPoint, user_no);
		
		if(result<1) {
			redirectAttr.addFlashAttribute("msg","다운로드에 실패하였습니다.");
		}
		return "redirect:/mypage/point";
	}
	
	// 위시리스트 화면
	@GetMapping("/wishlist")
	public ModelAndView wishlist(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		// 위시리스트 불러오기(아우터)
		Wishlist outer_list = mypageService.selectOuterlist(user_no);
		mv.addObject("outer_list", outer_list);
		System.out.println(outer_list);
		
		// 위시리스트 불러오기(상의)
		Wishlist top_list = mypageService.selectToplist(user_no);
		mv.addObject("top_list", top_list);
		System.out.println(top_list);
		
		// 위시리스트 불러오기(하의)
		Wishlist bottom_list = mypageService.selectBottomlist(user_no);
		mv.addObject("bottom_list", bottom_list);
		System.out.println(bottom_list);
		
		// 위시리스트 불러오기(ACC)
		Wishlist acc_list = mypageService.selectAcclist(user_no);
		mv.addObject("acc_list", acc_list);
		System.out.println(acc_list);
		
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
	@GetMapping("/reviewInsert/{order_option_code}")
	public ModelAndView insertReview(ModelAndView mv, @PathVariable int order_option_code) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		Member m = mypageService.selectMember(user_no);
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
		
		String msg = "";	
		int result = mypageService.insertReview(review, user_no); 
		
		if(result > 0) 
			msg = "리뷰가 등록되어 포인트 200원 적립되었습니다.";
		else 
			msg = "리뷰 등록에 실패하였습니다.";
				
		redirectAttr.addFlashAttribute("msg", msg);
		
		return "redirect:/mypage/orderList";
	}
	
	// 리뷰 상세화면
	@GetMapping("/reviewDetail/{order_option_code}")
	public ModelAndView reviewDetail(ModelAndView mv, @PathVariable int order_option_code) {
		// *** 리뷰 보기 클릭시 주문옵션번호(order_option_code)가 넘어오게 구현해야함 ***
		// 상품정보 조회
		Review review = mypageService.selectReview(order_option_code);
		
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
		// System.out.println(p_qna_list);
		mv.addObject("p_qna_list", p_qna_list);
		// 리뷰 리스트
		List<Review> review_list = mypageService.selectReview_List(user_no);
		mv.addObject("review_list", review_list);
		//System.out.println(review_list);		
		// 1:1 문의 리스트  
		List<PersonalQ> q_list = mypageService.selectQ_list(user_no);
		mv.addObject("q_list", q_list);
		// 교환 리스트
		List<Exchange> ex_list = mypageService.selectEx_list(user_no);
		mv.addObject("ex_list", ex_list);
		System.out.println(ex_list);
		// 환불 리스트
		List<Refund> r_list = mypageService.selectR_list(user_no);
		mv.addObject("r_list", r_list);
		mv.setViewName("mypage/myBoard");
		return mv;
	}

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
		System.out.println(cart_no);
		System.out.println(p_option_no);
		HashMap<String, Integer> userMap = new HashMap<>();
		userMap.put("cart_no", cart_no);
		userMap.put("user_no", user_no);
		userMap.put("p_option_no", p_option_no);
		int result = mypageService.plusAmount(userMap);
		System.out.println(result);
		return result;
	}
	
	// 주문내역 화면
	@GetMapping("/orderList")
	public ModelAndView orderList(ModelAndView mv) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		List<Product_Order> po_list = mypageService.selectProduct_Order(user_no);
		
		System.out.println(po_list);
		mv.addObject("po_list", po_list);
		mv.setViewName("/mypage/orderList");
		return mv;
	}
	
	// 배송조회 
	@PostMapping("/readDelivery")
	@ResponseBody
	public int readDelivery(@RequestParam int order_option_code) {
		int postnum = mypageService.selectPostnum(order_option_code);
		return postnum;
	}
		
	// 구매확정
	@PostMapping("/decide_buy")
	@ResponseBody
	public int decide_buy(@RequestParam int order_option_code) {
		UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int user_no = user.getUser_no();
		
		int result = mypageService.decide_buy(order_option_code, user_no);
		return result;
	}
	
	// 주문상세내역조회
	@GetMapping("/orderInfo/{order_code}")
	public ModelAndView orderInfo(ModelAndView mv, @PathVariable int order_code) {
		// 주문내역조회
		Payment p = mypageService.selectOrderInfo(order_code);
		System.err.println(p);
		mv.addObject("p", p);
		mv.setViewName("/mypage/orderInfo");
		return mv;
	}
	
	// 교환신청화면
	@GetMapping("/exchange/{order_option_code}")
	public ModelAndView exchange(ModelAndView mv, @PathVariable int order_option_code) {
		// 상품정보 조회
		Order_Option order_option = mypageService.selectProduct(order_option_code);
		List<Product_Option> ex_option = mypageService.selectExOption(order_option_code);
		
		System.out.println(order_option);	
		System.out.println(ex_option);
		mv.addObject("o", order_option);
		mv.addObject("ex", ex_option);
		mv.setViewName("/mypage/exchangeForm");
		return mv;
	}
	
	// 교환요청
	@PostMapping("exchange")
	public String exchange(RedirectAttributes redirectAttr, Exchange exchange) {
		System.out.println(exchange);
		int result = mypageService.requestExchange(exchange);
		int order_option_code = exchange.getOrder_option_code();
		
		String msg = "";
		if(result > 0) 
			msg = "교환 신청이 완료되었습니다.";
		else 
			msg = "교환 신청이 실패하였습니다.";
				
		redirectAttr.addFlashAttribute("msg", msg);
		
		return "redirect:/mypage/exchange/" + order_option_code;
	}
	
	// 환불신청화면
	@GetMapping("/refund/{order_option_code}")
	public ModelAndView refund(ModelAndView mv, @PathVariable int order_option_code) {
		// 상품정보 조회
		Order_Option order_option = mypageService.selectProduct(order_option_code);
		
		mv.addObject("o", order_option);
		
		mv.setViewName("/mypage/refundForm");
		return mv;
	}
	
	// 환불요청
	@PostMapping("/requestRefund")
	public String requestRefund(HttpServletRequest request, RedirectAttributes redirectAttr) {
		int order_option_code = Integer.parseInt(request.getParameter("order_option_code"));
		int ref_id = Integer.parseInt(request.getParameter("ref_id"));
		String ref_reason = request.getParameter("ref_reason");
		int ref_price = Integer.parseInt(request.getParameter("ref_price"));
		
		Refund refund = new Refund(order_option_code, ref_id, ref_reason, ref_price);
		System.out.println(refund);
		String msg = "";
		int result = mypageService.requestRefund(refund);
		System.out.println(result);
		if(result > 0) 
			msg = "환불 신청이 완료되었습니다.";
		else 
			msg = "환불 신청이 실패하였습니다.";
				
		redirectAttr.addFlashAttribute("msg", msg);
		
		return "redirect:/mypage/refund/" + order_option_code;
	}
	
	// 환불요청 상세
	@GetMapping("/refundDetail/{order_option_code}")
	public ModelAndView refundDetail(ModelAndView mv, @PathVariable int order_option_code) {
		// 상품정보 조회
		Order_Option order_option = mypageService.selectProduct(order_option_code);
		
		mv.addObject("o", order_option);
		
		// 환불내역 조회
		Refund refund = mypageService.selectRefund(order_option_code);
		mv.addObject("r", refund);
		
		mv.setViewName("/mypage/refundDetail");
		return mv;
	}
	
	// 교환요청 상세
	@GetMapping("/exchangeDetail/{order_option_code}")
	public ModelAndView exchangeDetail(ModelAndView mv, @PathVariable int order_option_code) {
		Order_Option order_option = mypageService.selectProduct(order_option_code);
		mv.addObject("o", order_option);
		
		// 교환내역 조회
		Exchange exchange = mypageService.selectExchange(order_option_code);
		System.out.println(exchange);
		
		mv.addObject("e", exchange);
		mv.setViewName("/mypage/exchangeDetail");
		return mv;
	}
	
	// 토큰 요청
	@GetMapping("/users/getToken")
	public String getToken() {
		String imp_key = "6905996150362685";
		String imp_secret = "b26f35c4e598e5be41979266728988e82027ec199ea7982b485f0910dc0492ca73c19d48f82b68e9";
		
	    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
	    converters.add(new FormHttpMessageConverter());
	    converters.add(new StringHttpMessageConverter());
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setMessageConverters(converters);
	    
	    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("imp_key", imp_key);
	    map.add("imp_secret", imp_secret);
	    
	    JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		String token = "";
		try {
			jsonObject = (JSONObject) jsonParser.parse(restTemplate.postForObject("https://api.iamport.kr/users/getToken", map, String.class));
			JSONObject response = (JSONObject)jsonObject.get("response");
			token = (String) response.get("access_token");
			
		} catch (RestClientException | ParseException e) {
			e.printStackTrace();
		}
		// 토큰 값 넘기기
		return token;
	}
	
	// 결제취소 
	@PostMapping("/canclePay")
	@ResponseBody
	public int canclePay(@RequestBody Map<String, String> u_map) {
		
		Payment payment = mypageService.selectPayment(u_map.get("merchant_uid"));
		String imp_uid = payment.getImp_uid();
		String merchant_uid = payment.getMerchant_uid();
		String reason = u_map.get("reason");
		
		//메소드호출해서리턴값을 토큰값으로 헤더에 추가해주기
		String access_token = getToken();
		
	    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
	    converters.add(new FormHttpMessageConverter());
	    converters.add(new StringHttpMessageConverter());
	    
	    // 헤더 설정
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    headers.setBearerAuth(access_token);	// 토큰 값 넣어주기
	    
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setMessageConverters(converters);
	    
	    // 파라미터 세팅
	    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	    map.add("imp_uid", imp_uid);
	    map.add("merchant_uid", merchant_uid);
	    map.add("reason", reason);
	    
	    // 요청 세팅 완료
	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
	    
	    // 실제 요청부 
	    ResponseEntity<String> response = restTemplate.postForEntity("https://api.iamport.kr/payments/cancel", request , String.class);
	    
	    
	    String merchant_uid_Value = "";
	    JSONParser parser = new JSONParser();
	    JSONObject jsonObject;
	    try {
			jsonObject = (JSONObject) parser.parse(response.getBody());
			JSONObject json_response = (JSONObject) jsonObject.get("response");
			merchant_uid_Value = (String) json_response.get("merchant_uid");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	    System.out.println(merchant_uid_Value);
	    
	    int result = mypageService.canclePay(merchant_uid_Value);
	    
		return result;
	}
	
	
}

















