package spring_mybatis;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper //@MapperScan
@Repository("dao") //EmpDAO dao = new EmpDAO(); 와 동일
public interface EmpDAO {
	public EmpVO getOneEmp(int employee_id);
	public List<EmpVO> getAllEmp();
	public List<EmpVO> getPageEmp(int num);
    public EmpVO checkEmp(EmpVO vo); //중복체크
    public String checkJob(EmpVO vo); //job_id 존재여부확인
    public void insertEmp(EmpVO vo);
    public void updateEmp(EmpVO vo);
//	  insertEmp(EmpVO vo) { session.insert("kdigital.insertEmp",vo); } public void
//	  updateEmp(EmpVO vo) { session.update("kdigital.updateEmp", vo); } public void
//	  deleteEmp(int employee_id) {
//	  session.delete("kdigital.deleteEmp",employee_id); } public List<EmpVO>
//	  getPageEmp(int[] nums){ return session.selectList("kdigital.pageEmp",nums);
//	  
//	  } public void insertEmp2(EmpVO vo) {
//		  session.insert("kdigital.insertEmp2",vo); } public List<EmpVO>
//	 getEmpDept(List<Integer> deptList){ return
//	 session.selectList("kdigital.selectwithlist", deptList); } public void
//	 updateEmpMap(Map<String, String> map) {
//	 session.update("kdigital.updatewithmap", map); }
	 

}
