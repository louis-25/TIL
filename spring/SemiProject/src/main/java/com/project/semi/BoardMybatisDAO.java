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
	
	//board테이블의 모든 행 가져오기
	public List<BoardDTO> getAllBoard(){
		List<BoardDTO> list = session.selectList("board.all");
		return list;
	}
	
	//member테이블의 모든 행 가져오기
	public List<MemberDTO> getAllMember(){
		List<MemberDTO> list = session.selectList("board.getMember");
		return list;
	}
	
	//게시판 페이징처리
	public List<BoardDTO> getAllBoard(BoardPageDTO dto){
		System.out.println(dto);
		List<BoardDTO> list = session.selectList("board.page", dto);
		
		return list;
	}
	
	//글쓰기 DB삽입
	public void insert_content(String title, String contents) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setWriter("semi"); // 세션값 넣어주자
		System.out.println(dto);
		session.insert("board.insert_content",dto);
	}
	
	//회원가입 DB삽입
	public void member_register(String id, int password, String name) {
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		session.insert("board.member_register",member);
	}
	
	//상세 게시글정보 불러오기
	public BoardDTO getDetailBoard(int seq) { //상세정보		
		List<BoardDTO> list = session.selectList("board.all",seq);
		session.update("board.count",seq); //조회수 1증가
		BoardDTO dto = new BoardDTO();
		dto = list.get(seq-1);
		System.out.println(dto);
		return dto;
		//paramemtermap이나 resultmap
	}	
	
	//게시글하나 삭제
	public void deleteBoard(int seq) { //상세정보				
		session.delete("board.delete",seq); //조회수 1증가	
		System.out.println(seq+"번 게시글이 삭제됐습니다");
	}
}
