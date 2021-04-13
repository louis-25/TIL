package emp;

public class EmpMain {
	public static void main(String args[]) {
		VO vo = new EmpVO();
		vo.setId(100);
		vo.setName("이사원");
		//vo.setSalary(12300);
		VO vo2 = new MemberVo();
		vo2.setId(200);
		vo2.setName("정대리");
		//vo2.setEmail("test@googlc.com");
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(vo);
		dao.insertEmp(vo2);
		System.out.println("회원등록을 마쳤습니다.");
	}
}
