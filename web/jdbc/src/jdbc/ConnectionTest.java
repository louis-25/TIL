package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	//1. 오라클 자동 시작 2. ojdbc6.jar
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			
			//jdbc 계정 c_emp 테이블에 데이터 저장
			// 600 이자바 사장 10000 10
			// 자바 sql정의 - db 전송 - 결과 검색
			/* c_emp 테이블 제약조건 설정
			 * desc user_constraints;
			 * */
			String sql = "insert into c_emp values(600, '이자바', '임원', 10000, 10)";
			//db 전송
			Statement st = conn.createStatement();
			// 실행
			int insertrow = st.executeUpdate(sql);
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
