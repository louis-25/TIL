package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	public void insertBoard(BoardDTO dto) {
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

		
	}//insertBoard end
	
	public ArrayList<BoardDTO> getBoardList() {
		//SELECT sql 작성
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs =  null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			String selectSQL = "SELECT * FROM BOARD order by time desc";
			pt = con.prepareStatement(selectSQL);
			rs = pt.executeQuery(); //컬럼명 위치
			while(rs.next()) { //번호 제목  작성자 조회수 
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
			con.close(); // db 더이상 접속 허용x
			}catch(SQLException e) { }
		}
		return list;
	}//getBoardList()	
	
	public ArrayList<BoardDTO> getBoardList(int pageNum, int cntPerPage) {
		//SELECT sql 작성
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs =  null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			//int pageNum = 1, int cntPerPage =10 --> 1-10
			//int pageNum = 2, int cntPerPage =10 --> 11-20
			
			
			String selectSQL ="select seq, title, writer, viewcount"
					+" from (select rownum r, seq, title, writer, viewcount"
					+ "  	 from (select * from board order by time desc)"
					+ "     )"
					+ " where r between ? and ?";
			
			
			pt = con.prepareStatement(selectSQL);
			pt.setInt(1, (pageNum-1) * cntPerPage  + 1);
			pt.setInt(2, pageNum * cntPerPage);
			rs = pt.executeQuery(); //컬럼명 위치
			while(rs.next()) { //번호 제목  작성자 조회수 
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
			con.close(); // db 더이상 접속 허용x
			}catch(SQLException e) { }
		}
		return list;
	}//getBoardList(int, int)	

	public int getBoardCount() {
		//SELECT sql 작성
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs =  null;
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			
			String selectSQL ="select count(*) from board";
						
			pt = con.prepareStatement(selectSQL);
			rs = pt.executeQuery(); //컬럼명 위치
			while(rs.next()) { //번호 제목  작성자 조회수 
				cnt = rs.getInt("count(*)");
			}

		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 정보를 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			pt.close();
			con.close(); // db 더이상 접속 허용x
			}catch(SQLException e) { }
		}
		return cnt;
	}//getBoardCount	

	//Board 테이블 SEQ 컬럼 PRIMARY KEY 부여
	public BoardDTO getDetailBoard(int seq) {
		BoardDTO dto= new BoardDTO();
		
		//SELECT sql 작성
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs =  null;		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			
			String updateSQL = "update board set viewcount = viewcount+1 where seq=?";
			String selectSQL ="select * board where seq=?";
						
			pt = con.prepareStatement(updateSQL);
			pt.setInt(1, seq);
			pt.executeUpdate();//업데이트 실행
			//pt.close(); 자동호출
			
			pt = con.prepareStatement(selectSQL);
			pt.setInt(1, seq);
			rs = pt.executeQuery(); //셀렉트문 실행, 객체반환
			
			rs.next(); //
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setWriter(rs.getString("writer"));
				dto.setTime(rs.getString("time"));
				dto.setPassword(rs.getInt("password"));
				dto.setViewcount(rs.getInt("viewcount"));
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 정보를 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			pt.close();
			con.close(); // db 더이상 접속 허용x
			}catch(SQLException e) { }
		}				
		
		return dto;
	}
	
	//글 작성자 확인용
	public boolean getMember(String writer) {				
		//SELECT sql 작성
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs =  null;
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
						
			String selectSQL ="select id from member where id=?";
											
			pt = con.prepareStatement(selectSQL);
			pt.setString(1, writer);
			rs = pt.executeQuery(); //셀렉트문 실행, 객체반환
			
			if(rs.next()==true) { //하나라도 리턴된 결과가 있는가? -> writer가 db에 존재함
				result = true;
			}
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 정보를 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			pt.close();
			con.close(); // db 더이상 접속 허용x
			}catch(SQLException e) { }
		}				
		
		return result;
	}
}//class end
