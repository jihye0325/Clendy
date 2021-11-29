package com.kh.clendy.CScenter.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.CScenter.model.vo.PersonalQ;

@Mapper
public interface PersonalQMapper {
	
	// 1:1문의 전체 목록 개수 
	int allPersonalQGetListCount();
	// 1:1문의 전체 목록 리스트
	List<PersonalQ> selectAllPersonalQList(Map<String, Object> mapMapper);
	
	// 유저의 1:1 문의 목록 개수
	int myPersonalQGetListCount(int user_no);
	// 유저의 1:1문의 목록 리스트
	List<PersonalQ> selectMyPersonalQList(Map<String, Object> mapMapper);
	
	
	PersonalQ selectPersonalQDetail(int p_no);
	
	int insertQuestion(PersonalQ newpersonalQ);
	
	int insertAnswer(PersonalQ newAnswer);
	
	int deleteAnswer(int p_no);
	
	int updateAnswer(PersonalQ updateAnswer);
	

}
