package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	//1. 오라클 자동 시작 2. ojdbc6.jar
	public static void main(String[] args) {
		Connection conn = null; // db연결
		Statement st = null; // db저장
		ResultSet rs = null; // db검색
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			
			String sql = "select * from c_emp";
			
			//db 전송
			st = conn.createStatement();
			// 실행
			rs = st.executeQuery(sql);
			// 리턴결과 검색
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				System.out.println(emp_id+"|"+emp_name+"|"+title+"|"+salary+"|"+dept_id);
			}
			
			System.out.println("db연결해제성공");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace(); // 자세한 원인 출력
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			}
			catch(SQLException e) {}
		}

	}

}
