package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO {
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

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
}