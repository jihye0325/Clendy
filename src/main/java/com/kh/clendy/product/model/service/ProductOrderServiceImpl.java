package com.kh.clendy.product.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.member.model.vo.Member;
import com.kh.clendy.product.model.dao.ProductOrderMapper;
import com.kh.clendy.product.model.vo.Order;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.model.vo.ProductComplete;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService{
	
	private ProductOrderMapper productOrderMapper;
	
	public ProductOrderServiceImpl(ProductOrderMapper productOrderMapper) {
		this.productOrderMapper = productOrderMapper;
	}

	// 회원 정보 조회
	@Override
	public Member orderMemberSelect(int userNo) {
		return productOrderMapper.orderMemberSelect(userNo);
	}

	// 주문 내역
	@Override
	public Map<String, List<Order>> orderInfoSelect(List<ProductCart> cartList) {
		Map<String, List<Order>> returnMap = new HashMap<>();
		
		for(ProductCart cart : cartList) {
			
			Order order = productOrderMapper.orderInfoSelect(cart);
			
			List<Order> list = new ArrayList<>();
			String key = order.getSellerCode() + "";
			
			if(returnMap.containsKey(key)) {
				list = returnMap.get(key);
				
			}
			list.add(order);
			returnMap.put(key, list);
			
		}
		
		return returnMap;
	}

	// 포인트 조회
	@Override
	public int orderPointSelect(int userNo) {
		return productOrderMapper.orderPointSelect(userNo);
	}

	// 주문 결제
	@Transactional
	@Override
	public int order(Map<String, Object> parameters) {
		
		// 상품주문목록 PRODUCT_ORDER 추가
		int productOrder = productOrderMapper.orderProductOrder(parameters);
		
		// 상품 주문 옵션 ORDER_OPTION
		 List<Integer> pOptionNos = (ArrayList<Integer>)parameters.get("pOptionNos");
		 List<Integer> cartMounts = (ArrayList<Integer>)parameters.get("cartMounts");
		
		int optionSize = pOptionNos.size();
		int orderOption = 0;
		
		for(int i = 0; i < optionSize; i++) {
			ProductCart cart = new ProductCart();
			cart.setpOptionNo(pOptionNos.get(i));
			cart.setCartAmount(cartMounts.get(i));
			
			orderOption += productOrderMapper.orderOrderOption(cart);
		}
		
		// 적립금 POINT - 추가
		int point = (int)parameters.get("point");
		int pointResult = 0;
		if(point > 0) {
			pointResult = productOrderMapper.orderPoint(parameters);
		}
		
		// 상품 주문 배송지 관리 ORDER_DEL_INFO - 추가
		int orderDelInfo = productOrderMapper.orderDelInfo(parameters);
		
		// PRODUCT_OPTION 상품 재고 재설정
		int productStock = 0;
		for(int i = 0; i < optionSize; i++) {
			ProductCart cart = new ProductCart();
			cart.setpOptionNo(pOptionNos.get(i));
			cart.setCartAmount(cartMounts.get(i));
			
			productStock += productOrderMapper.orderStock(cart);
		}
		
		// 결제 PAYMENT 추가
		int paymentResult = productOrderMapper.orderPayment(parameters);
		
		return productOrder > 0 && orderOption > 0 && pointResult >= 0 && orderDelInfo > 0 && productStock > 0 && paymentResult > 0 ? 1 : -1;
	}

	
	// orderCode 최신
	@Override
	public int orderCodeSelect(int userNo) {
		return productOrderMapper.orderCodeSelect(userNo);
	}

	// 주문완료 배송정보
	@Override
	public Map<String, String> completeOrderInfo(Map<String, Integer> parameters) {
		return productOrderMapper.completeOrderInfo(parameters);
	}

	// 주문완료 주문내역
	@Override
	public List<ProductComplete> productCompleteList(Map<String, Integer> parameters) {
		return productOrderMapper.productCompleteList(parameters);
	}

	// 결제정보
	@Override
	public ProductComplete orderPayMentEnd(Map<String, Integer> parameters) {
		// TODO Auto-generated method stub
		return productOrderMapper.orderPayMentEnd(parameters);
	}
	

	

}

