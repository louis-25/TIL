package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DATA ACCESS OBJECT = 데이터 직접 접근 객체
public class EmployeeDAO {
	public ArrayList<EmployeeDTO> getEmployees(String first, String last){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // db검색
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결성공");
			
//			String sql = "select r, first_name, salary"
//					+" from (select rownum r, first_name, salary"
//					+"	from (select * from employees order by salary desc)"
//					+" )"
//					+ " where r >= ? and <= ?";
			
			String sql = "select r, first_name, salary"
					+" from (SELECT rownum r, first_name, salary"
					+"       from (select * from employees order by salary desc)"
					+"      )"
					+ "	where r >= ? and r <= ?";
			
			//db 전송
			ps = conn.prepareStatement(sql);			
			
			ps.setInt(1, Integer.parseInt(first));
			ps.setInt(2, Integer.parseInt(last));
			
			// 실행
			rs = ps.executeQuery();
			
			// 리턴결과 ResultSet - ArrayList<EmployeeDTO>복사
			while(rs.next()) {// 1행 이동
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				list.add(dto);
				salary = rs.getDouble("salary");
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
				rs.close();
				ps.close();
				conn.close();
			}
			catch(SQLException e) {}
		}// finally end
		return list;
	}
}
