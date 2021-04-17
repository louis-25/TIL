package io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	int id = 0;
	String name = "";
	int salary = 0;
	
	Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return id+"|"+name+"|"+salary;
	}
	
}

public class IoSalary {

	public static void main(String[] args) { 
		
		int id = 0;
		String name = "";
		int salary = 0;
		int choice;
		Scanner scanner = new Scanner(System.in);
		Employee e = null;
		ArrayList<Employee> list = new ArrayList<Employee>(5);
		
		while(true) {		
			System.out.println("====다음과 같은 메뉴 이용 가능합니다====");
			System.out.println("1.사원등록");
			System.out.println("2.사원정보조회");
			System.out.println("3.사원정보수정");
			System.out.println("4.사원탈퇴");
			System.out.println("5.프로그램종료");
			choice = scanner.nextInt();
			
			switch(choice) {							
				case 1: //입력
					System.out.print("사번입력 :");
					id = scanner.nextInt();
					System.out.print("이름입력 :");
					name = scanner.next();
					System.out.print("급여입력 :");
					salary = scanner.nextInt();
					e = new Employee(id, name, salary);
					list.add(e);
					System.out.print("사원등록을 마쳤습니다");
					//ArrayList 정의하고 등록 사원을 ArrayList 가장 끝 저장
					break;
				case 2: //출력
					for(int i=0; i<list.size();i++) {
						System.out.println("사번 :"+ list.get(i).id);
						System.out.println("이름 :"+ list.get(i).name);
						System.out.println("급여 :"+ list.get(i).salary);
						System.out.println();
					}
					break;
				case 3: //수정
//					System.out.print("사번입력 :");
//					id = scanner.nextInt();
//					System.out.print("이름입력 :");
//					name = scanner.next();
//					System.out.print("급여입력 :");
//					salary = scanner.nextInt();
//					e = new Employee(id, name, salary);
//					System.out.print("사원수정을 마쳤습니다");
					//수정 사번 입력 : 100 --> 사번이 100번인 객체를 찾아라
					//수정항목 입력: name 박수정 -> 이름을 박수정으로 변경 -> split메소드 사용
					//			 salary 3000 -> 급여를 3000으로 변경
					break;
				case 4: //삭제
					list.remove(list.size()-1);
					//퇴사한 사번 입력 : 100
					//100사번 list에서 삭제
					break ;
				case 5: //종료
					return;
			}							
		}
	}

}
