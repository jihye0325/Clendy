package com.kh.clendy.admin.model.service;

import java.util.List;
import java.util.Map;

import com.kh.clendy.admin.model.vo.PointCategory;

public interface PointService {
	
	/* 기본 포인트 조회 */
	List<PointCategory> selectBasicPoint();
	
	/* 이벤트 포인트 조회 */
	Map<String, Object> selectEventPoint(int page);
	
	/* 기본 포인트 수정 */
	int updateBasicPoint(PointCategory updatePoint);
	
	/* 포인트 삭제 */
	int deletePoint(int point_code);
	
	/* 포인트 등록 */
	int insertPoint(PointCategory newPoint);

}
