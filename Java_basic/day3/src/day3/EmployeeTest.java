package day3;

class Employee{
	String id = "100-12345";
	String name = "회사원";
	String title = "사원";
	String dept = "교육부";
	
	String work() {
		System.out.println(name + " 사원이"+dept);
		return "이달의 급여처리 업무 완료";
	}
}

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		e1.id = "100";
		e1.name = "박대리";
		e1.title = "대리";
		e1.dept = "인사부";
		System.out.println(e1.id+":"+e1.name+":"+e1.title+":"+e1.dept);
		
		Employee e2 = new Employee();
		e2.id = "200";
		e2.name = "최사원";
		e2.title = "신입사원";
		e2.dept = "인사부";
		System.out.println(e1.id+":"+e1.name+":"+e1.title+":"+e1.dept);
	}

}
