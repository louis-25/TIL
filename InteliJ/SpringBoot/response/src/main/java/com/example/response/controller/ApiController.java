package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // TEXT
    @GetMapping("/text") //http://localhost:9094/api/text?account=hello
    public String text(@RequestParam String account){
        return account;
    }

    // JSON
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    // ResponseEntity
    // 조금 더 명확하게 값을 내려주는 방식
    // 응답에 대한 커스터마이징이 가능하다
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        // ResponseEntity라는곳에 HttpStatus코드를 지정해줄 수 있고 user객체는 json데이터로 보내준다
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
