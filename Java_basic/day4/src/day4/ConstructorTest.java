package day4;

class Employee{
	String id;
	String name;
	String title ;
	String dept;
	Employee(){
		this.id = "---";
		this.name = "none";
	}
	Employee(String id, String name){
		this.id = id;
		this.name = name;
	}
	Employee(String id){
		this.id = id;
		this.name = "none";
	}
	
	void work() {
		System.out.println(name + " 사원이 "+dept + " 부서에서 일한다.");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("100", "이사원");
		Employee e2 = new Employee("200");
		Employee e3 = new Employee();
		System.out.println(e1.id + ":" + e1.name);
		System.out.println(e2.id + ":" + e2.name);
		System.out.println(e3.id + ":" + e3.name);
		e1.work();
		e2.work();
		e3.work();
		
	}

}
