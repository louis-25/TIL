package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardListView {
	//페이지번호를 입력받아서
	//한 페이지당 출력게시물개수 입력
	//가장 최근 게시물부터 순서대로 보여주기
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("페이지번호: ");
		int pagenum = sc.nextInt();
		System.out.println("한페이지당 출력게시물개수: ");
		int cntPerPage = sc.nextInt();
		
		//main에서 실행하도록 배열반환하는코드
//		int [] all = new int[2];
//		all[0] = pagenum;
//		all[1] = cntPerPage;
//		return all;
		
		//BoardMain에서 실행하려면 BoardDAO 객체 생성 - getBoardList 호출
		BoardDAO dao = new BoardDAO();
		if(pagenum == 0) {
			ArrayList<BoardDTO> list = dao.getBoardList();
			for(BoardDTO one : list) {
				System.out.println(one.getSeq()+" | "+one.getTitle()+" | "+
								   one.getWriter()+" | "+one.getViewcount());
			}
		}
		else if(pagenum > 0) {
			ArrayList<BoardDTO> list = dao.getBoardList(pagenum, cntPerPage);
			for(BoardDTO one : list) {
				System.out.println(one.getSeq()+" | "+one.getTitle()+" | "+
								   one.getWriter()+" | "+one.getViewcount());
			}
		}
	}
}
