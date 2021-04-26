package spring_mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public abstract class EmpServiceImpl implements EmpService {
	@Autowired //dao가 변경됐으면 자동으로 값이 적용됨 -> setter가 필요없다
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
	public List<EmpVO> getPageEmp(int[] page) {
		return dao.getPageEmp(page);
	}
	
	@Override
	public void registerEmp(EmpVO vo) {
		//사번, 이메일 중복 검사
		//job_id -jobs테이블 조회 존재 여부
		//last_name null인지 여부
		//last_name null 인지 여부
		System.out.println("성="+vo.getLast_name());
		if(vo.getLast_name()!=null) {
			EmpVO vo2 = dao.checkEmp(vo); // 사번 이메일조회
			String job_id = dao.checkJob(vo); // 직업조회
			System.out.println("vo2="+vo2+", job_id="+job_id);
			if(vo2==null && job_id !=null) {
				dao.insertEmp(vo);
			}
		}
		
	}
//
//	@Override
//	public void insertEmp(EmpVO vo) {
//		dao.insertEmp(vo);
//	}
//
//	@Override
//	public void updateEmp(EmpVO vo) {
//		dao.updateEmp(vo);
//	}
//
//	@Override
//	public void deleteEmp(int employee_id) {
//		dao.deleteEmp(employee_id);
//	}
//
//	@Override
//	public List<EmpVO> getPageEmp(int[] nums) {
//		return dao.getPageEmp(nums);
//	}
//
//	@Override
//	public void insertEmp2(EmpVO vo) {
//		dao.insertEmp2(vo);
//	}
//
//	@Override
//	public List<EmpVO> getEmpDept(List<Integer> deptList) {
//		return dao.getEmpDept(deptList);
//	}
//
//	@Override
//	public void updateEmpMap(Map<String, String> map) {
//		dao.updateEmpMap(map);
//		
//	}

	

	

}