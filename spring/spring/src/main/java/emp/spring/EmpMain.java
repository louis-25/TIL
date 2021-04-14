package emp.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class EmpMain {
	public static void main(String args[]) {
		//Derecated - 스프링 더이상 사용하지 않도록 권고
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("emp.xml"));
		
		//ApplicationContext factory = new ClassPathXmlApplicationContext("emp/spring/emp.xml");
		
		VO vo = factory.getBean("vo", VO.class);
		VO vo2 = factory.getBean("vo2", VO.class);
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		dao.insertEmp(vo);
		dao.insertEmp(vo2);
		System.out.println("등록이 완료되었습니다.");
	}
}
