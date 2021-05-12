package com.multi.myboot04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import naver.cloud.NaverController;
import spring_mybatis.EmpController;
import spring_mybatis.EmpDAO;
//부트시작클래스 알려주는 어노테이션
@SpringBootApplication //부트시작클래스안에는 @ComponentScan(basepackages="패키지명") 포함되어있음 단 다른 패키지추가시 다시써줘야함
@ComponentScan //(basePackageClasses = Myboot01Application.class) 생략해도 기본페키지 (기본패키지 어노테이션 사용하기위해)
@ComponentScan(basePackageClasses = EmpController.class) //spring_mybatis 패키지안에있는 어노테이션도 사용하겠다
@ComponentScan(basePackageClasses = NaverController.class)
@MapperScan(basePackageClasses = EmpDAO.class)
public class Myboot04Application {

	public static void main(String[] args) {
		//spring boot tomcat 내장 서버 자동 실행
		SpringApplication.run(Myboot04Application.class, args);
	}

}
