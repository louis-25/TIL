package mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws IOException{		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/db-config.xml"));
		SqlSession session = factory.openSession(true);

		EmpService service = new EmpServiceImpl();
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);
		((EmpServiceImpl)service).setDao(dao);
		//EmpVO vo = service.getOneEmp(200);
		//System.out.println(vo);
		//service.getOneEmp(100); //100번 id조회
		
		/*List<EmpVO>list = service.getAllEmp();
		int i = 0;
		for(EmpVO vo : list) { //EmpVO여러개리턴
			System.out.print(i+" ");
			System.out.println(vo);
			i++;
		}*/
		
		/*EmpVO vo = new EmpVO(300,"사원", "김", "kim@a.com", "01012344321", "IT_PROG", 100, 30000, 50);
		service.insertEmp(vo); //DB에 저장
		System.out.println("1명의 사원 저장 완료");*/
		
		
		
		//300사번의 사원 이름을 대리로 변경
		/*EmpVO vo3 = new EmpVO();
		vo3.setEmployee_id(300);
		vo3.setFirst_name("대리");
		service.updateEmp(vo3);
		System.out.println("1명의 사원 저장 완료");*/
		
		
		//300번지워
		/*int employee_id=300;
		service.deleteEMP(employee_id);*/
		
		//페이징처리
		/*int[] nums = {11,20};
		List<EmpVO> list = service.getPageEmp(nums);
		for(EmpVO vo : list) {
			System.out.println(vo);
		}*/
		EmpVO vo = new EmpVO(300,"사원", "김", "kim@a.com", "01012344321", "IT_PROG", 100, 30000, 50);
		service.insertEmp(vo); //DB에 저장
		System.out.println("1명의 사원 저장 완료");
	}

}
