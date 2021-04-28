package com.multi.myboot02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/")
	//@ResponseBody //더이상 view로 인식을 안하고 그냥 hello를 반환
	public String test() {
		return "hello";
	}
}

// http://.../static/google.png

/*spring mvc project == servlet-context.xml 파일 설정 /web-inf/views/*.jsp
						http://ip:port/컨텍스트명/uri
*spring boot == http://ip:port/매핑uri
*				스프링에서는 기본 view가 jsp가 아니다
*/						