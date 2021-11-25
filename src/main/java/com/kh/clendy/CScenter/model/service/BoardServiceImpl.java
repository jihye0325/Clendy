package com.kh.clendy.CScenter.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.clendy.CScenter.model.dao.BoardMapper;
import com.kh.clendy.CScenter.model.vo.Board;
import com.kh.clendy.product.model.vo.PageInfo;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	private final BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	/* 공지사항 전체조회, 페이징 처리 */
	@Override
	public Map<String, Object> selectAllBoard(int page) {
		
		// 공지사항 개수 
		int listCount = boardMapper.boardGetListCount();
		
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
		List<Board> boardList = boardMapper.selectAllBoard(mapMapper);
		
		Map<String, Object> result = new HashMap<>();
		result.put("boardList", boardList);
		result.put("pageInfo", pageInfo);
		
		return result;
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
