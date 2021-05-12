package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //path -> 명시적인 방법
    @GetMapping(path = "/hello") // http://localhost:9094/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method= RequestMethod.GET) // get http://localhost:9094/api/get/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:9094/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    // http://localhost:9094/api/get/query-param?user=steave&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    // http://127.0.0.1:9094/api/get/query-param02?name=정동현&email=louis@naver.com&age=10
    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    @GetMapping("query-param03") // 가장 많이쓰는방법 - DTO방식(QueryParameter와 dto의 변수가 자동매칭된다)
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
