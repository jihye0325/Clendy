package com.kh.clendy.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.admin.model.vo.PointCategory;

@Mapper
public interface PointMapper {
	
	/* 기본 포인트 조회 */
	List<PointCategory> selectBasicPoint();
	
	/* 이벤트 포인트 조회 + 페이징 */
	int eventPointGetListCount();
	List<PointCategory> selectEventPoint(Map<String, Object> mapMapper);
	
	/* 기본 포인트 수정 */
	int updateBasicPoint(PointCategory updatePoint);
	
	/* 포인트 삭제 */
	int deletePoint(int point_code);
	
	/* 포인트 등록 */
	int insertPoint(PointCategory newPoint);


	
	
	
}
