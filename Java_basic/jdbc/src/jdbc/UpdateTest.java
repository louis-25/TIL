package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	//1. 오라클 자동 시작 2. ojdbc6.jar
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			/*이자바 사원을 사번 100번인 사원과 같은 직급으로 변경
			 * update 테이블명
			 * set 변경컬럼이름 = 변경값
			 * where 변경조건식
			 * update c_emp set title = (select title from c_emp where emp_id=100)
			 * where emp_name='이자바'
			 * */
//			String sql = "update c_emp set title = (select title from c_emp where emp_id=100)"+
//			"where emp_name='이자바'";
			String sql = "update c_emp set salary = salary +"+args[1]+" where title = '"+args[0]+"'";
			//db 전송
			st = conn.createStatement();
			// 실행
			int updaterow = st.executeUpdate(sql);
			// 리턴결과 검색
			System.out.println(updaterow+" 개의 행 삽입");
			
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
