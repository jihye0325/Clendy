package com.kh.clendy.admin.model.service;

import java.util.Map;

import com.kh.clendy.admin.model.vo.Calculation;

public interface CalculationService {
	
	Map<String, Object> selectBeforeCalculation(int page);
	
	Map<String, Object> selectAfterCalculation(int page);
	
	int updateBeforeToAfter(int cal_no);

	int makeCalculation();

}
