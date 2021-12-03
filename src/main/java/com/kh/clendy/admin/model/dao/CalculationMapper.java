package com.kh.clendy.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.admin.model.vo.Calculation;


@Mapper
public interface CalculationMapper {
	
	/* 정산 전 리스트 조회 */
	List<Calculation> selectBeforeCalculation(Map<String, Object> mapMapper);
	int beforeCalculationGetListCount();
	
	/* 정산 후 리스트 조회 */
	List<Calculation> selectAfterCalculation(Map<String, Object> mapMapper);
	int afterCalculationGetListCount();
	
	/* 정산전 -> 정산 후 상태 변경 */
	int updateBeforeToAfter(int cal_no);
	
	int makeCalculation();

}
