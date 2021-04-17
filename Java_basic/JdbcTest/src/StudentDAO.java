import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	Connection conn = null;	//DB연결
	ResultSet rs = null; // db검색
	Statement st = null; // db 1줄 sql문작성
	PreparedStatement ps = null; // db sql문
	
	public void insertStudent(StudentDTO StudentDTO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // jdbc드라이버
			//DB연동
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			
			String sql = "insert into Student values(?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);			
			
			ps.setInt(1, StudentDTO.getNo());
			ps.setString(2, StudentDTO.getName());
			ps.setString(3, StudentDTO.getDet());
			ps.setString(4, StudentDTO.getAddr());
			ps.setString(5, StudentDTO.getTel());
			
			int insertrow = ps.executeUpdate(); //삽입부분
			System.out.println(insertrow+" 개의 행 삽입");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		} finally {
			try {
			ps.close();
			conn.close();
			}catch(SQLException e) {}
		}
		
		
	}
	public void printAllStudents() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
		
			String sql ="select * from Student";
			//db 전송
			st = conn.createStatement();
			// 실행
			rs = st.executeQuery(sql);
			
			int No;
			String name, det, addr, tel;
			while(rs.next()) {
				No = rs.getInt("No");
				name = rs.getString("name");
				det = rs.getString("det");
				addr = rs.getString("addr");
				tel = rs.getString("tel");			
			
			System.out.println(No+"\t"+name+"\t"+det+"\t"+addr+"\t"+tel);
		}
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();
		} finally {
			try {									
			st.close();			
			rs.close();
			conn.close();
			System.out.println("db연결해제성공");
			}catch(SQLException e) {}
		}
	}
}
