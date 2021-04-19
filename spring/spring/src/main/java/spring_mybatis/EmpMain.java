package spring_mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) throws IOException{		
		//팩토리의 정보는 mybatis_spring.xml에있다
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring_mybatis/mybatis_spring.xml");
//		SqlSession session = factory.getBean("sqlSession", SqlSession.class); // 팩토리에서 빈얻어오기(sqlSession)
		EmpService service = factory.getBean("service", EmpService.class);
		
		
		
//		EmpService service = new EmpServiceImpl();
		//dao에서는 Autowired를 사용했기때문에 아래의 2줄은 필요가없다
		//EmpDAO dao = new EmpDAO();
		//dao.setSession(session);
		//((EmpServiceImpl)service).setDao(dao);
		//EmpVO vo = service.getOneEmp(200);
		//System.out.println(vo);
		//service.getOneEmp(100); //100번 id조회
		
		List<EmpVO>list = service.getAllEmp();
		int i = 0;
		for(EmpVO vo : list) { //EmpVO여러개리턴
			System.out.print(i+" ");
			System.out.println(vo);
			i++;
		}
		
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
		
		/*				
		EmpVO vo = new EmpVO(300,"사원", "김", "kim@a.com", "01012344321", "IT_PROG", 100, 30000, 50);
		service.insertEmp(vo); //DB에 저장
		System.out.println("1명의 사원 저장 완료");*/
		
//		EmpVO vo = new EmpVO();
////		vo.setEmployee_id(2000);
//		vo.setFirst_name("호우");
//		vo.setLast_name("김");//not null
//		vo.setJob_id("IT_PROG");//jobs테이블 참조
//		vo.setDepartment_id(100);//departments테이블 참조
//		vo.setEmail("hou@naver.com");//unique - 이메일은 하나만 존재해야하므로 DB에없는값으로 입력하자
//		vo.setPhone_number("010222222");
//		vo.setSalary(1000);
//		service.insertEmp2(vo);
//		System.out.println("===insert seq 완료===");
		
		//ArrayList
//		List<Integer> deptList = new ArrayList<Integer>();
//		deptList.add(10);
//		deptList.add(50);
//		deptList.add(80);
//		deptList.add(100);
//		List<EmpVO> list = service.getEmpDept(deptList);
//		for(EmpVO vo :list) {
//			System.out.println(vo.getEmployee_id()+":"+vo.getFirst_name()+":"+vo.getDepartment_id());//
//		}
		
		//Update
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("dept", "50");
//		map.put("email", "a2@b.com");
//		map.put("id", "0");
//		
//		service.updateEmpMap(map);
//		System.out.println("업데이트 수행완료");
	}

}
