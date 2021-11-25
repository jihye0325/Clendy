package com.kh.clendy.CScenter.model.service;

import java.util.Map;

import com.kh.clendy.CScenter.model.vo.Board;

public interface BoardService {

	Map<String, Object> selectAllBoard(int page);
	
	Board selectOneBoard(int b_no);
	
	int insertBoard(Board newBoard);
	
	int updateBoard(Board board);
	
	int deleteBoard(int b_no);
	
}
