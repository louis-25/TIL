package day7;

import java.util.ArrayList;

class Employee /*extends Object*/{
	int id;
	String name;
	double salary;
	Employee(int id, String name, double salary) {
		//super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return id+"-"+name+"-"+salary;
	}
	
}

public class ArrayListTest {

	public static void main(String[] args) {		
		//ArrayList 조회 자주하면 효율적
		//LinkedList 저장 수정 삭제 자주하면 효율적
		
		//ArrayList = 여러 타입 데이터 저장 가능
		//ArrayList<타입> = 동일타입 데이터만 저장하되 갯수 유동적으로 바껴야할때
		/*1> 컴파일러 컴파일시점 타입 체크
		 *2> 형변환 필요없다
		 *3> 타입 정적 유지
		 *4> 타입 지정 x --> add(Object o) / get(0) --> Object
		 *5> 타입 지정 o --> add(타입 o) / get(0) --> 타입
		 * */
		//ArrayList list = new ArrayList(5);
		ArrayList<Employee> list = new ArrayList<Employee>(5);
//		list.add(100); //new Integer(100)으로 자동 형변환
//		list.add(new Integer(200));
//		list.add(2.55);
//		list.add(new Double(32.14));
//		list.add(300);
//		list.add(9.99);
//		list.add("자바프로그램"); //6번인덱스 저장
//		list.add(0, "변경"); //0번 인덱스에 변경 저장
//		list.set(0, "변경확인"); //0번 인덱스 저장 데이터를 "변경확인" 수정
//		list.remove(1); //1번 인덱스 삭제
		
		Employee e1 = new Employee(100, "이사원", 56000.55);
		Employee e2 = new Employee(200, "최대리", 66000.55);
		Employee e3 = new Employee(300, "박과장", 76000.55);
		list.add(e1); //toString이 오버라이딩 돼있지않다
		list.add(e2);
		list.add(e3);
		System.out.println(list.size());
		
		//list 내에 멀티캠퍼스 문자열 삭제
		if(list.contains("멀티캠퍼스")) {
			System.out.println(list.indexOf("멀티캠퍼스"));
			list.remove("멀티캠퍼스");
		}		
		for(int i = 0; i< list.size(); i++) {
			Employee o = list.get(i);
			//day7.Employee@15db
			System.out.println(i+" 번 인덱스="+ o/*.toString()*/);
			//만약 조회 데이터가 Employee 객체의 name 변수 출력
			//Integer, Double, String, Employee
			
			if(o instanceof Employee) { // o객체가 Employee타입으로 만들어졌는가?
				System.out.println(((Employee)o).name); //Employee객체 타입으로 명시적 형변환
			}
		}
		
//		//autoboxing, unboxing
//		int i = new Integer(500);
//		Integer in = 100;
	}

}
