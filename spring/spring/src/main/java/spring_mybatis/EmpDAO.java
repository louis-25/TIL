package spring_mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao") //EmpDAO객체를생성하여 dao로 다른곳에서도 이용가능
public class EmpDAO {
	@Autowired //Autowired를 써주면 setter가 필요없다
	SqlSession session; //sql에 접근할때 사용

//	public void setSession(SqlSession session) {
//		this.session = session;
//	}

	public EmpVO getOneEmp(int employee_id) {
		EmpVO vo = session.selectOne("kdigital.oneEmp", employee_id);
		return vo;
	}

	public List<EmpVO> getAllEmp() {
		List<EmpVO> list = session.selectList("kdigital.manyEmp");
		return list;
	}

	public void insertEmp(EmpVO vo) {
		session.insert("kdigital.insertEmp", vo);
	}

	public void updateEmp(EmpVO vo) {
		session.update("kdigital.updateEmp", vo);
	}

	public void deleteEmp(int employee_id) {
		session.delete("kdigital.deleteEmp", employee_id);
	}

	public List<EmpVO> getPageEmp(int[] nums) {
		return session.selectList("kdigital.pageEmp", nums);
	}

	public void insertEmp2(EmpVO vo) {
		session.insert("kdigital.insertEmp", vo);
	}
	
	public List<EmpVO> getEmpDept(List<Integer> deptList){
		return session.selectList("kdigital.selectwithlist", deptList);
	}
	
	public void updateEmpMap(Map<String, String> map) {
		session.update("kdigital.updatewithmap", map);
	}
}