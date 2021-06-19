package com.multi.jenkinsproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class jenkinsController {
	@RequestMapping("/jenkins")
	public String jenkins() {
		return "jenkins";
	}

}
