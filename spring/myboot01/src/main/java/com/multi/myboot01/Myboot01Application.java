package com.multi.myboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import spring_mybatis.EmpController;
import spring_mybatis.EmpDAO;

 
//spring_mybatis의 내용도 읽어들인다
//@ComponentScan//(basePackageClasses = EmpController.class)
//부트 시작클래스를 알리는 어노테이션
@SpringBootApplication
@ComponentScan(basePackageClasses = EmpController.class)
@MapperScan(basePackageClasses = EmpDAO.class) // EmpDAO매퍼를 읽어온다
public class Myboot01Application {

	public static void main(String[] args) {
		// spring boot tomcat 내장 서버 자동 실행
		SpringApplication.run(Myboot01Application.class, args);
	}

}
