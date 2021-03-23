package template;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertProcess {	
	void process() {
		Scanner key = new Scanner(System.in);
	
		// 사원등록 추가 입력 -> InsertProcess
		System.out.println("사번 입력 : ");
		int id = key.nextInt();
		System.out.println("이름 입력 : ");
		String name = key.next();
		System.out.println("급여 입력 : ");
		double salary = key.nextDouble();
		
		//singleton pattern
		Controller c = Controller.getInstance();
		c.insert(id, name, salary);
		
		//Controller 클래스 입력 내용 전달
		//EmployeeVo e = new EmployeeVo(id, name, salary);
		//EmployeeDAO ??? 메소드 호출
		
		
	
	}	
}
