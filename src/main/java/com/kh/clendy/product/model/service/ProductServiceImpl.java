package com.kh.clendy.product.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.product.model.dao.ProductMapper;
import com.kh.clendy.product.model.vo.PageInfo;
import com.kh.clendy.product.model.vo.Product;
import com.kh.clendy.product.model.vo.ProductCart;
import com.kh.clendy.product.model.vo.ProductFilter;
import com.kh.clendy.product.model.vo.ProductOption;
import com.kh.clendy.product.model.vo.ProductReview;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	private ProductMapper productMapper;
	
	@Autowired
	public ProductServiceImpl(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	// 상품 목록
	@Override
	public Map<String, Object> productSelectList(ProductFilter filter) {
		
		// 상품 목록 갯수
		int listCount = productMapper.productGetListCount(filter);
		
		// 페이징
		PageInfo pageInfo = new PageInfo(filter.getPage(), listCount, 10, 12);
		
		// 상품 목록 호출에 필요한 값
		int startRow = (pageInfo.getPage() - 1) * pageInfo.getBoardLimit() + 1;
		int endRow = startRow + pageInfo.getBoardLimit() - 1;
		
		Map<String, Object> mapMapper = new HashMap<>();
		mapMapper.put("page", filter.getPage());
		mapMapper.put("startRow", startRow);
		mapMapper.put("endRow", endRow);
		mapMapper.put("filter", filter);
		
		// 상품 목록
		List<Product> productList = productMapper.productSelectList(mapMapper);
		
		// 상품 카테고리 상품 갯수
		Map<String, Integer> categoryCount = productMapper.productCategoryCount(filter);
		
		Map<String, Object> mapReturn = new HashMap<>();
		mapReturn.put("productList", productList);
		mapReturn.put("pageInfo", pageInfo);
		mapReturn.put("categoryCount", categoryCount);
		
		return mapReturn;
	}

	// 상품 상세 정보
	@Override
	public Product productViewInfo(Map<String, Object> mapInfo) {
		return productMapper.productViewInfo(mapInfo);
	}
	
	// 상품 상세 위시리스트 기능
	@Override
	public int productViewWish(Map<String, Integer> returnMap) {
		
		int result = 0;
		// 위시리스트 누름 여부
		// (0 : insert, 1: delete)
		int isWish = productMapper.productViewIsWish(returnMap);
		
		// 위시리스트 추가/삭제
		if(isWish == 0) {
			result = productMapper.productViewInsertWish(returnMap) == 1 ? 0 : -1;
		}else if(isWish == 1) {
			result = productMapper.productViewDeleteWish(returnMap) == 1 ? 1 : -1;
		}
		
		return result;
	}

	@Override
	public Map<String, Object> productTabCount(int pNo) {
		return productMapper.productTabCount(pNo); 
	}

	@Override
	public List<ProductOption> productOptionSelect(int pNo) {
		return productMapper.productOptionSelect(pNo);
	}

	// 상품 상세 장바구니 
	@Override
	public int productCartInsert(List<ProductCart> cartList) {
		
		int result = 0;
		
		for(ProductCart productCart : cartList) {
			
			// 장바구니에 있는지 확인
			int cartGetCount = productMapper.cartGetCount(productCart); 
			
			if(cartGetCount == 0) {
				// 장바구니 추가
				result += productMapper.productCartInsert(productCart);
				
			}else if(cartGetCount == 1) {
				// 장바구니 업데이트
				result += productMapper.productCartUpdate(productCart);
			}
			
		}
		
		return result;
	}



}
