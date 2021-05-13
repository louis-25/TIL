package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }


    @ResponseBody
    @GetMapping("/user")
    public User user(){
        // 타입추론 User user = new User(); 랑 같은코드로 보면된다
        // 자바 11버전부터 추가됨
        var user = new User();
        user.setName("Louis");
        user.setAddress("헬로우");
        return user;
    }
}
