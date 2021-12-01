package com.kh.clendy.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.admin.model.dao.PointMapper;
import com.kh.clendy.admin.model.vo.PointCategory;
import com.kh.clendy.member.model.vo.MemberRole;
import com.kh.clendy.product.model.vo.PageInfo;

@Service
@Transactional
public class PointServiceImpl implements PointService{

	private final PointMapper pointMapper;
	
	@Autowired
	public PointServiceImpl (PointMapper pointMapper) {
		this.pointMapper = pointMapper;
	}
	
	/* 기본 포인트 조회 */
	@Override
	public List<PointCategory> selectBasicPoint() {
		return pointMapper.selectBasicPoint();
	}
	
	/* 이벤트 포인트 조회, 페이징 */
	@Override
	public Map<String, Object> selectEventPoint(int page) {
		// 이벤트 포인트 개수 
		int listCount = pointMapper.eventPointGetListCount();
		
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
		List<PointCategory> eventPointList = pointMapper.selectEventPoint(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("eventPointList", eventPointList);
		result.put("pageInfo", pageInfo);
		
		return result;
	}

	/* 기본 포인트 수정 */
	@Override
	public int updateBasicPoint(PointCategory updatePoint) {
		return pointMapper.updateBasicPoint(updatePoint);
	}

	/* 포인트 삭제 */
	@Override
	public int deletePoint(int point_code) {
		return pointMapper.deletePoint(point_code);
	}

	/* 포인트 등록 */
	@Override
	public int insertPoint(PointCategory newPoint) {	
		return pointMapper.insertPoint(newPoint);
	}



}













