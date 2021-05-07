package spring_mybatis;

import java.util.List;
//import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("dao") //EmpDAO객체를생성하여 dao로 다른곳에서도 이용가능
public interface EmpDAO {	

	public EmpVO getOneEmp(int employee_id);

	public List<EmpVO> getAllEmp(); //테이플 모든열 조회
	
	public List<EmpVO> getPageEmp(int[] page); // 페이징처리
	
	public EmpVO checkEmp(EmpVO vo); //사번, 이메일 중복검사
	
	public String checkJob(EmpVO vo); //job_id가 테이블에 존재할 경우 등록가능
	
	public void insertEmp(EmpVO vo); //checkEmp와 checkJob의 조건이 충족하면 삽입
	
}