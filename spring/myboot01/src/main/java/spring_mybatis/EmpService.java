package spring_mybatis;

import java.util.List;

public interface EmpService {
	public EmpVO getOneEmp(int employee_id);
	public List<EmpVO> getAllEmp();
	public List<EmpVO> getPageEmp(int[] page);	
	public void registerEmp(EmpVO vo);

}