package com.kh.clendy.CScenter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.CScenter.model.dao.FAQMapper;
import com.kh.clendy.CScenter.model.vo.FAQ;

@Service
@Transactional
public class FAQServiceImpl implements FAQService{
	
	private final FAQMapper faqMapper;
	
	@Autowired
	public FAQServiceImpl(FAQMapper faqMapper) {
		this.faqMapper = faqMapper;
	}

	@Override
	public List<FAQ> selectAllFAQ() {
		List<FAQ> FaqList = faqMapper.selectAllFAQ();
		return FaqList;
	}

	@Override
	public List<FAQ> selectFAQByCategory(int categoryCode) {
		return faqMapper.selectFAQByCategory(categoryCode);
	}

	@Override
	public List<FAQ> searchFAQByKeyword(String keyword) {
		return faqMapper.searchFAQByKeyword(keyword);
	}

	@Override
	public int insertFAQ(FAQ newfaq) {
		return faqMapper.insertFAQ(newfaq);
	}

	@Override
	public int updateFAQ(FAQ faq) {
				
		return faqMapper.updateFAQ(faq);
	}

	@Override
	public int deleteFAQ(int q_no) {
		return faqMapper.deleteFAQ(q_no);
	}

}
