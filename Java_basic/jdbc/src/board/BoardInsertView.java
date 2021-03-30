package board;

import java.util.Scanner;

public class BoardInsertView {
	BoardDTO input(){
		//번호 제목 내용 작성자 작성시간 글암호 조회수
		//번호 - 시퀀스 값 자동 1 증가(입력x)
		//제목 내용 작성자 입력
		//작성시간 - 20/01/01 12:21:13 기본 sysdate(입력x)
		//글암호 입력
		//조회수 0 자동(입력x)
		Scanner sc = new Scanner(System.in);
		System.out.println("제목입력:");
		String title = sc.nextLine();
		System.out.println("내용입력:");
		String contents = sc.nextLine();
		System.out.println("작성자입력:");
		String writer = sc.nextLine();
		System.out.println("글암호입력:");
		int password = sc.nextInt();

		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setWriter(writer);
		dto.setPassword(password);
		return dto;
	}
}
