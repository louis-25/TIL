package spring_mybatis;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) throws IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring_mybatis/mybatis_spring.xml");
		EmpService service = factory.getBean("service", EmpService.class);
//		
//		List<EmpVO> list = service.getAllEmp();
//		for(EmpVO vo:list) {
//			System.out.println(vo);
//		}
		//test1 : 1개 vo
		EmpVO vo = service.getOneEmp(200);
		System.out.println(vo);
		//test2 : 여러개 리스트 조회
		//List<EmpVO> list = service.getAllEmp();
		//for(EmpVO vo:list) {
		//	System.out.println(vo);
		//}
		//test3 : insert
		//EmpVO vo= new EmpVO(300,"사원","김","kim@a.com","01022223333","IT_PROG",100,30000,50);
		//service.insertEmp(vo);
		//System.out.println("1명의 사원 저장 완료");
	
		
		//test4 : update 300사번의 사원 이름을 대리로 변경
		//EmpVO vo3= new EmpVO();
		//vo3.setEmployee_id(300);
		//vo3.setFirst_name("대리");
		//service.updateEmp(vo3);
		
	    //test5 : delete 300사번 사원 삭제
		//int employee_id =300;
		//service.deleteEmp(employee_id);
		
		//test6페이지처리
	   // int[] nums= {11,20};
	   // List<EmpVO> list = service.getPageEmp(nums);
	   // for(EmpVO vo :list) {
	    //	System.out.println(vo);
	   // }
		
		//test7 : insert
		//EmpVO vo = new EmpVO();
		//vo.setEmployee_id(2000);
		//vo.setFirst_name("과장");
		//vo.setLast_name("김");//not null
//		vo.setJob_id("IT_PROG");//jobs테이블 참조
//		vo.setDepartment_id(100);//departments테이블 참조
//		vo.setEmail("kim2@kitri.com");//unique
//		vo.setPhone_number("010222222");
//		vo.setSalary(1000);
//		service.insertEmp2(vo);
//		System.out.println("===insert seq 완료===");
		
		//test8: Arraylist
//		List<Integer> deptList = new ArrayList<Integer>(); 
//		deptList.add(10);
//		deptList.add(50);
//		deptList.add(80);
//		deptList.add(100);
//		List<EmpVO> list = service.getEmpDept(deptList);
//		for(EmpVO vo:list) {
//			System.out.println(vo.getEmployee_id()+":"+vo.getFirst_name()+":"+vo.getDepartment_id());
//		}
		
		//test9: HashMap
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("dept", "50");
//		map.put("email", "a3@b.com");
//		//map.put("employee_id", "300");
//		service.updateEmpMap(map);
//		System.out.println("업데이트 수행완료");

	}

}
