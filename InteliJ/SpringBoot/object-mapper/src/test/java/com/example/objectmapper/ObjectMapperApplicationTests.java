package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("----------------");

        // 요청받은 데이터를 Object나 String으로 변환해주는 방법
        // ObjectMapper를 사용하면된다

        var objectMapper = new ObjectMapper();

        // object -> text
        var user = new User("Louis", 10, "010-1234-4321");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);


    }

}
