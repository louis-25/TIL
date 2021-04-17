package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedInsertTest {
	//1. 오라클 자동 시작 2. ojdbc6.jar
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			
			
			String sql = "insert into c_emp values(?, ?, ?, ?, ?)";
			//db 전송
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, 800);
			st.setString(2, "김신입");
			st.setString(3, "사원");
			st.setDouble(4, 10000.99);
			st.setInt(5, 10);
			
			// 실행
			int insertrow = st.executeUpdate();
			// 리턴결과 검색
			System.out.println(insertrow+" 개의 행 삽입");
			
			System.out.println("db연결해제성공");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace(); // 자세한 원인 출력
		}finally {
			try {
				conn.close();
			}
			catch(SQLException e) {}
		}

	}

}
