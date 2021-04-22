package com.project.semi;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
@Repository("dao")
public class BoardMybatisDAO {
	@Autowired
	SqlSession session; //mybatis.jar 안에 있다
	
	public List<BoardDTO> getAllBoard(){
		List<BoardDTO> list = session.selectList("board.all");
		return list;
	}
	
	//페이징처리
	public List<BoardDTO> getAllBoard(BoardPageDTO dto){
		System.out.println(dto);
		List<BoardDTO> list = session.selectList("board.page", dto);
		
		return list;
	}
	
	public BoardDTO getDetailBoard(int seq) { //상세정보		
		List<BoardDTO> list = session.selectList("board.all",seq);
		session.update("board.count",seq); //조회수 1증가
		BoardDTO dto = new BoardDTO();
		dto = list.get(seq-1);
		System.out.println(dto);
		return dto;
		//paramemtermap이나 resultmap
	}	
	
	public BoardDTO deleteBoard(int seq) { //상세정보		
		List<BoardDTO> list = session.selectList("board.all",seq);
		session.update("board.count",seq); //조회수 1증가
		BoardDTO dto = new BoardDTO();
		dto = list.get(seq-1);
		System.out.println(dto);
		return dto;
		//paramemtermap이나 resultmap
	}
}
