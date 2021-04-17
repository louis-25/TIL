package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedSelectTest2 {
	//1. 오라클 자동 시작 2. ojdbc6.jar
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
//		Statement st = null; // db저장
		ResultSet rs = null; // db검색
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결성공");
			
			//hr 계정의 employees 테이블 급여 많은순서 정렬하여
			// 1- 10번째 사원 이름과 급여 조회
			// rownum, row_number(), rank(), dense_rank()
			/*
			 * 데이터 페이징처리조회
			 1. select first_name, salary from ( select * from employees order by salary desc) where rownum <= 10
			 1-1 select r, salary from(select rownum r, salary from (select * from employees order by salary desc)) where r >= 11 and r < 20
			 2. select r, salary from(select row_number() over(order by salary desc) as r, salary from employees) where r <=10;
			 2-1. select r, salary from(select row_number() over(order by salary desc) as r, salary from employees) where r between 11 and 20;
			 3. select r, salary from(select dense_rank() over(order by salary desc) as r, salary from employees) where r <=10
			 3-1. select r, salary from(select dense_rank() over(order by salary desc) as r, salary from employees) where r between 11 and 20;
			 4. select r, salary from(select rank() over(order by salary desc) as r, salary from employees) where r <=10
			 4-1. select r, salary from(select rank() over(order by salary desc) as r, salary from employees) where r between 11 and 20;
			 
			 
			 */
			String sql = "select r, first_name, salary"
					+"from (select rownum r, first_name, salary"
					+" from (select * from employees order by salary desc))"
					+" where r >= ? and <= ?";

			
			//db 전송
			ps = conn.prepareStatement(sql);			
			
			ps.setInt(1, Integer.parseInt(args[0]));
			ps.setInt(2, Integer.parseInt(args[1]));
			
			// 실행
			rs = ps.executeQuery(sql);
			// 리턴결과 검색
			while(rs.next()) {
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				System.out.println(r+" | "+emp_name+" | "+salary);				
				
			}
			
			
			System.out.println("db연결해제성공");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace(); // 자세한 원인 출력
		}finally {
			try {
				ps.close();
				conn.close();
			}
			catch(SQLException e) {}
		}

	}

}
