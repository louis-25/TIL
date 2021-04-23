package com.web.test;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController { //  / --> 127.0.0.1:9090/ajax/login
@RequestMapping(value="/ajax/login",method=RequestMethod.GET)
public String loginform() { //폼 출력요청
	return "ajax/loginajax";//뷰이름
}

@RequestMapping(value="/ajax/login",method=RequestMethod.POST,
produces= {"application/json;charset=utf-8"})
@ResponseBody
public LoginDTO loginform(String id, String pw) {
	System.out.println(id+":"+pw);
	LoginDTO dto = new LoginDTO();
	dto.setId(id);
	dto.setPw(pw);	
	
	return dto;
}


}
