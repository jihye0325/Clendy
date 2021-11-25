package com.kh.clendy.CScenter.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.CScenter.model.dao.BoardMapper;
import com.kh.clendy.CScenter.model.vo.Board;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	private final BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<Board> selectAllBoard() {
		return boardMapper.selectAllBoard();
	}

	@Override
	public Board selectOneBoard(int b_no) {
		return boardMapper.selectOneBoard(b_no);
	}

	@Override
	public int insertBoard(Board newBoard) {
		return boardMapper.insertBoard(newBoard);
	}

	@Override
	public int updateBoard(Board board) {
		return boardMapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(int b_no) {
		return boardMapper.deleteBoard(b_no);
	}

}
