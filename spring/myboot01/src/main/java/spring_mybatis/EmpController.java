package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	//페이징처리
	@RequestMapping("/emplistpage") // /emplist요청이 들어오면 아래의 코드실행
	public ModelAndView getPageEmp(int page){ //page변수 전달값이 보여줄 페이지. 한페이지당 출력갯수 10개. 입사일이 빠른 사원부터 출력
		//mybatis SqlSession -> EmpDAO -> EmpService -> EmpMain
		int rownum[] = new int[2];
		rownum[0] = (page -1)*10 + 1;
		rownum[1] = page * 10;
		List<EmpVO> list = service.getPageEmp(rownum);
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
	
	@RequestMapping(value="/empadd", method=RequestMethod.GET)
	public String addEmp() {
		return "/mybatis/addform";
	}
	
	@RequestMapping(value="/empadd", method=RequestMethod.POST)
	public String addEmp2(EmpVO vo) {
		//System.out.println();
		service.registerEmp(vo);
		return "redirect:/emplist"; // redirect:/emplist -> /emplist 매핑URL 메소드 호출 -> getEmpList호출
	}
	/*
	//수정
	@RequestMapping(value="/empmodify", method=RequestMethod.GET)
	public ModelAndView modifyEmp(int id) {
		//미리 폼 입력값 설정 후 업데이트 고고
		ModelAndView mv = new ModelAndView();
		EmpVO vo = service.getOneEmp(id);
		mv.addObject("emp",vo);
		mv.setViewName("/mybatis/modifyform");
		return mv;
	}
	//삭제
	
	@RequestMapping(value="/empmodify", method=RequestMethod.GET)
	public String deleteEmp(int id) {
		//미리 폼 입력값 설정 후 업데이트 고고		
		//삭제service		
		return "redirect:/emplist";
	}*/
}
