package spring_mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("service")
public class EmpServiceImpl implements EmpService {
    @Autowired
	EmpDAO dao;
    
	
	@Override
	public EmpVO getOneEmp(int employee_id) {
		return dao.getOneEmp(employee_id);
	}

	@Override
	public List<EmpVO> getAllEmp() {
		return dao.getAllEmp();
	}

	@Override
	public List<EmpVO> getPageEmp(int num) {
		return dao.getPageEmp(num);
	}

	@Override
	public void registerEmp(EmpVO vo) {
		System.out.println("성="+vo.getLast_name());
		//사번, 이메일 중복 검사
		//job_id -jobs테이블 조회 존재 여부
		//last_name null인지 여부 -db sql 실행  전에 알수 있음(controller에서해두된다)
		if(vo.getLast_name() !=null)
		{
			EmpVO vo2 = dao.checkEmp(vo);
			String job_id = dao.checkJob(vo);
			System.out.println("vo2=" + vo2 + ", job_id="+job_id);
			if(vo2==null&&job_id!=null) {
			dao.insertEmp(vo);
			}
		}
		
	}

	@Override
	public void updateEmp(EmpVO vo) {
		dao.updateEmp(vo);
	}
	
	

//	@Override
//	public void insertEmp(EmpVO vo) {
//		dao.insertEmp(vo);
//	}
//
//	@Override
//	public void insertEmp2(EmpVO vo) {
//		dao.insertEmp2(vo);
//		
//	}
//
//	@Override
//	public List<EmpVO> getEmpDept(List<Integer> deptlist) {
//		return dao.getEmpDept(deptlist);
//	}
//
//	@Override
//	public void updateEmpMap(Map<String, String> map) {
//		dao.updateEmpMap(map);
//		
//	}
//
//	@Override
//	public void deleteEmp(int employee_id) {
//		dao.deleteEmp(employee_id);
//		
//	}
//
//	@Override
//	public List<EmpVO> getPageEmp(int[] nums) {
//		return dao.getPageEmp(nums);
//	}
//
//	@Override
//	public void updateEmp(EmpVO vo) {
//		dao.updateEmp(vo);
//		
//	}
//	

}
