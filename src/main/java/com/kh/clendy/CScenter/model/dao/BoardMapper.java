package com.kh.clendy.CScenter.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.CScenter.model.vo.Board;

@Mapper
public interface BoardMapper {
	
	// 공지사항 목록 개수 - 페이징 처리
	int boardGetListCount();
	
	List<Board> selectAllBoard(Map<String, Object> mapMapper);
	
	Board selectOneBoard(int b_no);
	
	int insertBoard(Board newBoard);
	
	int updateBoard(Board board);
	
	int deleteBoard(int b_no);

	
}
