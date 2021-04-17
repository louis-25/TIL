package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("게시판 메뉴");
			System.out.println("1.글쓰기");
			System.out.println("2.게시물리스트 조회");
			System.out.println("3.종료");
			System.out.println("번호입력 : ");
			int menu = sc.nextInt();
			if(menu == 1) {
				//글쓰기 화면 이동
				//BoardInsertView
				BoardInsertView view = new BoardInsertView();
				BoardDTO dto = view.input();
				BoardDAO dao = new BoardDAO();
				dao.insertBoard(dto);				
				System.out.println("====글쓰기 완료====");
			}else if(menu == 2) {
				//페이지 번호 입력 화면 이동
				BoardListView list = new BoardListView();
				list.input();
			}else if(menu == 3) {
				System.out.println("게시판 메뉴를 종료합니다");
				break;
			}
		}//while end

	}

}
