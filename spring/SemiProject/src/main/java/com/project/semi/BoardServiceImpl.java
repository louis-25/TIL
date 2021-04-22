package com.project.semi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("service")
public class BoardServiceImpl implements BoardService {
    @Autowired
	BoardMybatisDAO dao;
	
    @Override
	public List<BoardDTO> getAllBoard() {
		return dao.getAllBoard();
	}
	
	@Override	
	public List<BoardDTO> getAllBoard(BoardPageDTO dto) {
		return dao.getAllBoard(dto);
	}
	
	@Override
	public BoardDTO getDetailBoard(int seq) {		
		return dao.getDetailBoard(seq);
	}

}
