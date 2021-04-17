package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardDAO {	
	public void insertBoard(BoardDTO dto) {
		// 매개변수 전달 dto(제목 내용 작성자 글암호 입력 상태)		
		///번호 - 시퀀스 값 자동 1 증가(입력x)
		/* create sequence board_seq;
		 * 1 ~ 1씩 증가 ~ board_seq.nextval
		 * */
		//작성시간 - 20/01/01 12:21:13 기본 sysdate(입력x)
		//조회수 0 자동(입력x)
		//insert sql작성
		Connection con = null;			
		PreparedStatement pt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
//			String insertSQL = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, ?, ?)";
			String insertSQL = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, ?, 0)";
			pt = con.prepareStatement(insertSQL);
			pt.setString(1, dto.getTitle());
			pt.setNString(2, dto.getContents());
			pt.setNString(3, dto.getWriter());
			pt.setInt(4, dto.getPassword());
//			pt.setInt(5, 0); // 조회수
			
			int cnt = pt.executeUpdate(); // cnt == 1
			System.out.println(cnt+" 개의 글 저장 완료");
//			con.prepareStatement(insertSQL);
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 정보를 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			pt.close();
			con.close();
			}catch(SQLException e) {}
		}
		//Driver로딩 - o
		//con 생성 - o
		//pt나 st생성 - o
		// 실행 - o
		// close - o
		//try - catch - finally - o
		
	}//insertBoard end
	public ArrayList<BoardDTO> getBoardList() {		
		Connection con = null;			
		PreparedStatement pt=null;
		ResultSet rs = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");

			String selectSQL = "select * from board order by time desc";
			pt = con.prepareStatement(selectSQL);
						
			rs = pt.executeQuery(); // 조회용
			while(rs.next()) { //번호 제목 작성자 조회수 (내용, 암호는 조회하지않는다)				
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getNString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewcount(rs.getInt("viewcount"));
				list.add(dto);
			}
						
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 정보를 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			pt.close();
			rs.close();
			con.close();
			}catch(SQLException e) {}
		}
		
		return list;
	}//getBoardList() end
	public ArrayList<BoardDTO> getBoardList(int pageNum , int cntPerPage) {				
		Connection con = null;			
		PreparedStatement pt=null;
		ResultSet rs = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			
			//int pageNum = 1, int cntPerPage =5 --> 1-5
			//int pageNum = 2, int cntPerPage =5 --> 6-10
			//1페이지에서 레코드 5개 가져와라
			
			
//			String selectSQL = "select seq, title, writer, viewcount\r\n"
//					+ " from (select row_number over(order by time desc) as r from board)\r\n"
//					+ "	where r between ? and ?";
			String selectSQL = "select seq, title, writer, viewcount"
							+" from (select rownum r"
							+" from (select * from board order by time desc)"
							+")"
							+" where r between 1 and 10;";
					
			pt = con.prepareStatement(selectSQL);						
			pt.setInt(1, (pageNum-1) * cntPerPage + 1);
			pt.setInt(2, pageNum * cntPerPage);
			rs = pt.executeQuery(); // 조회용
			
			while(rs.next()) { //번호 제목 작성자 조회수 (내용, 암호는 조회하지않는다)				
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getNString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewcount(rs.getInt("viewcount"));
				list.add(dto);
			}
						
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 정보를 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			pt.close();
			rs.close();
			con.close();
			}catch(SQLException e) {}
		}
		
		return list;
	}//getBoardList() end
}//class end
