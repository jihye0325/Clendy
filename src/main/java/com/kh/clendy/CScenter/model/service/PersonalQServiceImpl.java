package com.kh.clendy.CScenter.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.CScenter.model.dao.PersonalQMapper;
import com.kh.clendy.CScenter.model.vo.PersonalQ;
import com.kh.clendy.product.model.vo.PageInfo;

@Service
@Transactional
public class PersonalQServiceImpl implements PersonalQService{
	
	private final PersonalQMapper personalQMapper;
	
	@Autowired
	public PersonalQServiceImpl(PersonalQMapper personalQMapper) {
		this.personalQMapper = personalQMapper;
	}

	/* 회원으로 로그인 시 나의 1:1 문의 내역 리스트 조회 */
	@Override
	public Map<String, Object> selectMyPersonalQList(int user_no, int page) {
		// 1:1 문의 개수 
		int listCount = personalQMapper.myPersonalQGetListCount(user_no);
		
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
		mapMapper.put("user_no", user_no);
		
		// 목록 조회
		List<PersonalQ> personalQList = personalQMapper.selectMyPersonalQList(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("personalQList", personalQList);
		result.put("pi", pageInfo);
		
		return result;
	}

	/* 관리자로 로그인 시 모든 1:1 문의 내역 리스트 조회*/
	@Override
	public Map<String, Object> selectAllPersonalQList(int page) {
		
		// 1:1 문의 개수 
		int listCount = personalQMapper.allPersonalQGetListCount();
		
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
		List<PersonalQ> personalQList = personalQMapper.selectAllPersonalQList(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("personalQList", personalQList);
		result.put("pi", pageInfo);
		
		return result;
	} 
	
	@Override
	public PersonalQ selectPersonalQDetail(int p_no) {
		return personalQMapper.selectPersonalQDetail(p_no);
	}

	@Override
	public int insertQuestion(PersonalQ newpersonalQ) {
		return personalQMapper.insertQuestion(newpersonalQ);
	}

	@Override
	public int insertAnswer(PersonalQ newAnswer) {
		return personalQMapper.insertAnswer(newAnswer);
	}

	@Override
	public int deleteAnswer(int p_no) {
		return personalQMapper.deleteAnswer(p_no);
	}

	@Override
	public int updateAnswer(PersonalQ updateAnswer) {
		return personalQMapper.updateAnswer(updateAnswer);
	}



}
