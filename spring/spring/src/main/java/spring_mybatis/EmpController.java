package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@RequestMapping("/emplist") // /emplist요청이 들어오면 아래의 코드실행
	public ModelAndView getEmpList(){
		//mybatis SqlSession -> EmpDAO -> EmpService -> EmpMain
		List<EmpVO> list = service.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", list);
		mv.setViewName("/mybatis/emplist"); // WEB-INF/views/mybatis/emplist.jsp
		return mv;
		
	}
	//클라이언트 입력 id 파라미터 = 200
	// /empdetail url
	//employees 테이블 클라이언트 입력 id = 100 - 1개 레코드 조회
	//model로 생성
	// /mybatis/empdetail
	// empdetail.jsp출력
	@RequestMapping("/empdetail") // /emplist요청이 들어오면 아래의 코드실행
	public ModelAndView getOneEmpList(int id){ // /empdetail?id=10
		//mybatis SqlSession -> EmpDAO -> EmpService -> EmpMain
		EmpVO vo = service.getOneEmp(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empdetail", vo); //jsp에서 empdetail로 접근하자
		mv.setViewName("/mybatis/empdetail"); // WEB-INF/views/mybatis/emplist.jsp
		return mv;
		
	}
	
	
}
