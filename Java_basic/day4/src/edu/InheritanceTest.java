package edu;

class Employee{
	int id;
	String name;
	String salary;
	String pw = "Employee";
	public void printEmp() {
		System.out.println(id+":"+name+":"+salary);
	}
}
class Manager extends Employee{
	String jobOfManage;
	int cntOfSub;
	
	String pw = "Manager";
	
	public void printEmp() {
		System.out.println(id+":"+name+":"+salary);
		System.out.println(jobOfManage+":"+cntOfSub );
	}
	void test() {
		String pw = "testmethod";
		System.out.println(pw);
		System.out.println(this.pw);
		System.out.println(super.pw);
	}
}
public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager m = new Manager();
		m.id = 12345;
		m.name = "김부장";
		m.jobOfManage = "it직종관리";
		m.cntOfSub = 10;
		System.out.println(m.id +":"+ m.name+":"+m.jobOfManage+":"+m.cntOfSub);
		m.test();
		m.printEmp();
	}

}

class AS {

}
