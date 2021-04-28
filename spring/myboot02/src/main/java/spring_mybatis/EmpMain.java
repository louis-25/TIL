package spring_mybatis;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) throws IOException{		
		//팩토리의 정보는 mybatis_spring.xml에있다
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring_mybatis/mybatis_spring.xml");
		EmpService service = factory.getBean("service", EmpService.class);
		
		EmpVO vo = service.getOneEmp(200);
		System.out.println(vo);
		
	}

}
