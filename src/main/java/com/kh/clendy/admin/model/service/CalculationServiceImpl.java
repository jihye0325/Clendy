package com.kh.clendy.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.admin.model.dao.CalculationMapper;
import com.kh.clendy.admin.model.vo.Calculation;
import com.kh.clendy.product.model.vo.PageInfo;

@Controller
@Transactional
public class CalculationServiceImpl implements CalculationService{
	
	private final CalculationMapper calculationMapper;
	
	@Autowired
	public CalculationServiceImpl(CalculationMapper calculationMapper) {
		this.calculationMapper = calculationMapper;
	}

	@Override
	public Map<String, Object> selectBeforeCalculation(int page) {
		// 리스트 개수 
		int listCount = calculationMapper.beforeCalculationGetListCount();
		
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
		
		// 목록 조회
		List<Calculation> beforeCalculation = calculationMapper.selectBeforeCalculation(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("beforeCalculation", beforeCalculation);
		result.put("pi", pageInfo);
		
		return result;
	}

	@Override
	public Map<String, Object> selectAfterCalculation(int page) {
		// 리스트 개수 
		int listCount = calculationMapper.afterCalculationGetListCount();
		
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
		
		// 목록 조회
		List<Calculation> afterCalculation = calculationMapper.selectAfterCalculation(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("afterCalculation", afterCalculation);
		result.put("pi", pageInfo);
		
		return result;
	}

	@Override
	public int updateBeforeToAfter(int cal_no) {
		return calculationMapper.updateBeforeToAfter(cal_no);
	}

	@Override
	public int makeCalculation() {
		return calculationMapper.makeCalculation();
	}

}
