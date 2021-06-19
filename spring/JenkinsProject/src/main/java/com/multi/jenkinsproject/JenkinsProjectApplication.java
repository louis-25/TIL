package com.multi.jenkinsproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import spring_mybatis.EmpController;
import spring_mybatis.EmpDAO;

@ComponentScan
@ComponentScan(basePackageClasses =EmpController.class )
@MapperScan(basePackageClasses = EmpDAO.class)
@SpringBootApplication
public class JenkinsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsProjectApplication.class, args);
	}

}
