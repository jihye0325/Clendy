package com.kh.clendy.CScenter.model.service;

import java.util.List;

import com.kh.clendy.CScenter.model.vo.FAQ;

public interface FAQService {
	
	List<FAQ> selectAllFAQ();
	
	List<FAQ> selectFAQByCategory(int categoryCode);
	
	List<FAQ> searchFAQByKeyword(String keyword);
	
	int insertFAQ(FAQ newfaq);
	
	int updateFAQ(FAQ faq);
	
	int deleteFAQ(int q_no);
	

}
