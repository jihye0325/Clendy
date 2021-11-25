package com.kh.clendy.CScenter.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.clendy.CScenter.model.vo.Board;

@Mapper
public interface BoardMapper {
	
	List<Board> selectAllBoard();
	
	Board selectOneBoard(int b_no);
	
	int insertBoard(Board newBoard);
	
	int updateBoard(Board board);
	
	int deleteBoard(int b_no);
}
