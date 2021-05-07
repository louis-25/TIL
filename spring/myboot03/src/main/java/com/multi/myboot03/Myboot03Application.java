package com.multi.myboot03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import spring_mybatis.EmpController;
import spring_mybatis.EmpDAO;

@SpringBootApplication
@ComponentScan//생략가능(basePackageClasses = Myboot01Application.class)
@ComponentScan(basePackageClasses = EmpController.class)//empcontroller가 있는 패키지 스캔하겠다
@MapperScan(basePackageClasses = EmpDAO.class)
public class Myboot03Application {

	public static void main(String[] args) {
		SpringApplication.run(Myboot03Application.class, args);
	}

}
