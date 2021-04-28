package com.multi.myboot02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import spring_mybatis.EmpController;
import spring_mybatis.EmpDAO;

@SpringBootApplication
@ComponentScan(basePackageClasses = EmpController.class)
@MapperScan(basePackageClasses = EmpDAO.class)
public class Myboot02Application {

	public static void main(String[] args) {
		SpringApplication.run(Myboot02Application.class, args);
	}

}
