package tv.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		//spring 설정 객체 주입 설정파일 읽어온다
		ApplicationContext factory = new ClassPathXmlApplicationContext("tv/spring/tv.xml");
		
		TV tv = factory.getBean("tv", TV.class);		
		
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		
		TV tv2 = factory.getBean("tv", TV.class);
		TV tv3 = factory.getBean("tv", TV.class);
		TV tv4 = factory.getBean("tv", TV.class);
	}

}
