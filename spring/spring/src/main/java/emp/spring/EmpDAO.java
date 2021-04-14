package emp.spring;

public class EmpDAO {
	void insertEmp(VO vo){		
		if(vo instanceof EmpVO) {
			EmpVO e = (EmpVO)vo;
			System.out.println(e.getId()+":"+e.getName());
		}
		else if (vo instanceof MemberVo) {
			MemberVo m = (MemberVo)vo;
			System.out.println(m.getId()+":"+m.getName());
			
		}
	}
}
