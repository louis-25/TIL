package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {
	//1. 오라클 자동 시작 2. ojdbc6.jar
	public static void main(String[] args) {
		Connection conn = null; // db연결
		Statement st = null; // db저장
		ResultSet rs = null; // db검색
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결성공");
			
			String sql = "select employee_id, first_name, job_id, salary, department_id,"+
			"to_char(hire_date, 'yyyy:mm:dd HH24:MMmi:ss') as h_date "+
			"from employees";
			
			//db 전송
			st = conn.createStatement();
			// 실행
			rs = st.executeQuery(sql);
			// 리턴결과 검색
			while(rs.next()) {
//				int employee_id = rs.getInt("employee_id");
//				String first_name = rs.getString("first_name");
//				String job_id = rs.getString("job_id");
//
//				double salary = rs.getDouble("salary");
//				int department_id = rs.getInt("department_id");
				String hire_date = rs.getString("h_date");
				System.out.println(hire_date);
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
