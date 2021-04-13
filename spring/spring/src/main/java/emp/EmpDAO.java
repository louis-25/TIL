package emp;

public class EmpDAO {
	void insertEmp(VO vo){		
		vo.setId(100);
		vo.setName("이사원");
		//vo.setSalary(12300);
		System.out.println("db 등록 완료했습니다.");
	}
}
