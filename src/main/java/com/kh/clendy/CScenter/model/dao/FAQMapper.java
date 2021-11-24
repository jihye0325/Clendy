package com.kh.clendy.CScenter.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.CScenter.model.vo.FAQ;

@Mapper
public interface FAQMapper {
	
	List<FAQ> selectAllFAQ();

	List<FAQ> selectFAQByCategory(int categoryCode);
	
	List<FAQ> searchFAQByKeyword(String keyword);
	
	int insertFAQ(FAQ newfaq);
	
	int updateFAQ(FAQ faq);
	
	int deleteFAQ(int q_no);

}
