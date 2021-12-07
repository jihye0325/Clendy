package com.kh.clendy.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.clendy.member.model.vo.UserImpl;
import com.kh.clendy.product.model.service.ProductService;
import com.kh.clendy.product.model.vo.Product;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.model.vo.ProductFilter;
import com.kh.clendy.product.model.vo.ProductOption;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	private static final Log LOG = LogFactory.getLog( ProductController.class );
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	// type = 공용, 남성, 여성 카테고리 들어감
	// 상품 목록
	@GetMapping("/list/{type}")
	public String productListPage(@PathVariable String type, Model model, @ModelAttribute ProductFilter filter) {
		
		Map<String, Object> mapReturn = productService.productSelectList(filter);
		// 상품 목록 
		model.addAttribute("productList", mapReturn.get("productList"));
		
		// 상품 갯수
		model.addAttribute("categoryCount", mapReturn.get("categoryCount"));
		// 페이징
		model.addAttribute("pi", mapReturn.get("pageInfo"));
		// 페이지
		model.addAttribute("filter", filter);
		
		return "product/product_list";
	}
	
	// 상품 상세(상품번호)
	@GetMapping("/view/{pNo}")
	public String productViewPage(@PathVariable int pNo, Model model) {
		int userNo = -1;
		//UserImpl user = (UserImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		if(principal != null && principal instanceof UserImpl) {
			userNo =  ((UserImpl)principal).getUser_no();
		}
		
		Map<String, Object> mapInfo = new HashMap<>();
		mapInfo.put("pNo", pNo);
		mapInfo.put("userNo", userNo);
		
		Product productInfo = productService.productViewInfo(mapInfo);
		
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("info", productInfo);
		modelMap.put("loginUno", userNo);
		
		model.addAttribute("modelMap", modelMap);
		
		return "product/product_view";
	}
	
	// 상품 상세 - 옵션
	@PostMapping("/options")
	@ResponseBody
	public Map<String, List<ProductOption>> productOptionSelect(@RequestBody Map<String, Object> returnMap){
		// 상품 옵션
		List<ProductOption> optionList = productService.productOptionSelect((int)returnMap.get("pNo"));
		
		Map<String, List<ProductOption>> optionMap = new HashMap<>();
		
		// key 가공
		for(ProductOption po : optionList) {
			optionMap.put(po.getpColor(), new ArrayList<>());
		}
		
		// value 가공
		List<ProductOption> poList = new ArrayList<>();
		for(ProductOption po : optionList) {
			if(optionMap.containsKey(po.getpColor())) {
				List<ProductOption> list = optionMap.get(po.getpColor());
				list.add(po);
				optionMap.put(po.getpColor(), list);
			}
		}
		
		
		return optionMap;
		
	};
	
	// 상품 상세 - 위시리스트
	@PostMapping("/wishStatus")
	@ResponseBody
	public String productViewWish(@RequestBody Map<String, Integer> returnMap) {
		int result = productService.productViewWish(returnMap);
		
		String msg = "fail";
		
		switch(result) {
			case 0 : msg = "insert"; break;
			case 1 : msg = "delete"; break;
		}
		
		return msg;
	}
	
	// 상품 상세 - 탭메뉴 갯수
	@PostMapping("/tabCount")
	@ResponseBody
	public Map<String, Object> productTabCount(@RequestParam int pNo){

		Map<String, Object> productTabCount = productService.productTabCount(pNo);
		
		return productTabCount;
	}
	
	// 상품 상세 - 장바구니 추가
	@GetMapping("/cartInsert")
	public String productCartInsert(HttpServletRequest request, @RequestParam int pNo, @RequestParam int userNo, RedirectAttributes redirectAttr) {
		
		String[] pOptionNos = request.getParameterValues("pOptionNo");
		String[] cartAmounts = request.getParameterValues("cartAmount");
		int size = pOptionNos.length;
		
		List<ProductCart> cartList = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			ProductCart pc = new ProductCart();
			pc.setpNo(pNo);
			pc.setUserNo(userNo);
			pc.setpOptionNo(Integer.parseInt(pOptionNos[i]));
			pc.setCartAmount(Integer.parseInt(cartAmounts[i]));
			
			cartList.add(pc);
		}
		
		int result = productService.productCartInsert(cartList);
		
		if(result > 0) {
			redirectAttr.addFlashAttribute("pMsg", "장바구니 목록에 추가/변경 되었습니다.");
		}else {
			redirectAttr.addFlashAttribute("pMsg", "장바구니 추가/변경이 실패하였습니다.");
		}
		
		return "redirect:/product/view/" + pNo;
	}
	
}
