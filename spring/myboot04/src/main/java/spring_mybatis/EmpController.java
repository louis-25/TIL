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
	//employees 테이블 전체 조회
	@RequestMapping("/emplist")
	public ModelAndView getEmpList(){ 
		//mybatis Sqlsession -- EmpDAO --EmpServiec 하위-
		List<EmpVO> list = service.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist",list); //request.setAttribute("boardlist",list)
		mv.setViewName("/mybatis/emplist");
		return mv;
	}
	
	//employees 테이블 전체 조회
	@RequestMapping("/emplistpage")
	public ModelAndView getEmpList(int num){ //page변수 전달값이 보여줄 페이지 , 한페이지당 출력갯수 10개
		//mybatis Sqlsession -- EmpDAO --EmpServiec 하위-
		List<EmpVO> list = service.getPageEmp(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist",list); //request.setAttribute("boardlist",list)
		mv.setViewName("/mybatis/emplist");
		return mv;
	}
	//클라이언트 입력 id 파라미터 = 100
	// /empdetail url
	//employees 테이블 1개 레코드 조회
	// /mybatis/empdetail.jsp
	@RequestMapping("/empdetail")
	public ModelAndView getOneEmp(int id) {
		EmpVO vo = service.getOneEmp(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail",vo);
		mv.setViewName("/mybatis/empdetail");
		return mv;
	}
	@RequestMapping(value="/empadd",method=RequestMethod.GET)
	public String addEmp() {
		return "mybatis/addform";
	}
	
	@RequestMapping(value="/empadd",method=RequestMethod.POST)
	public String addEmp2(EmpVO vo) {
		service.registerEmp(vo);
		//return "mybatis/emplist";
		return "redirect:/emplist";
	}
	
	//수정폼
	@RequestMapping(value="/empmodify", method=RequestMethod.GET)
	public ModelAndView modifyEmp(int id) {
		ModelAndView mv = new ModelAndView();
		EmpVO vo = service.getOneEmp(id);
		mv.addObject("emp",vo);
		mv.setViewName("/mybatis/modifyform");
		return mv;
	}
	//수정처리
	@RequestMapping(value="/empmodify", method=RequestMethod.POST)
	public String modifyEmp(EmpVO vo) {
		 service.updateEmp(vo);
		return "redirect:/emplist";
	}
	
	//삭제
	@RequestMapping(value="/empdelete", method=RequestMethod.GET)
	public String deleteEmp(int id) {
		
		//service.xxxx();
		return "redirect:/emplist";
	}
	
}
