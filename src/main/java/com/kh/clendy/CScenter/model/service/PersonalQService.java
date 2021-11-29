package com.kh.clendy.CScenter.model.service;

import java.util.Map;

import com.kh.clendy.CScenter.model.vo.PersonalQ;

public interface PersonalQService {
	
	
	Map<String, Object> selectMyPersonalQList(int user_no, int page);
	
	Map<String, Object> selectAllPersonalQList(int page);
	
	PersonalQ selectPersonalQDetail(int p_no);
	
	int insertQuestion(PersonalQ newpersonalQ);
	
	int insertAnswer(PersonalQ newAnswer);
	
	int deleteAnswer(int p_no);
	
	int updateAnswer(PersonalQ updateAnswer);

}
