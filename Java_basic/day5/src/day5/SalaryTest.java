package day5;

class Employee{
	int id;
	String name;
	int salary;
	int incentive;
	int total_salary;
	Employee(){
		
	}
	Employee(int id, String name, int sal, int incen){
		this.id = id;
		this.name = name;
		this.salary = sal;
		this.incentive = incen;
	}
	
	public void total_sal() {
		total_salary = salary+incentive;
	}
}
class Manager extends Employee{
	int manager_incen;
	Manager(int id, String name, int sal, int incen, int manager_incen){
		super(id, name, sal, incen);
		this.manager_incen = manager_incen;
	}
	
	public void total_sal() {
		super.total_sal();
		total_salary += manager_incen;
	}
}

class Engineer extends Employee{
	int require_incen;
	int skill_incen;
	Engineer(int id, String name, int sal, int incen, int require_incen, int skill_incen ){
		super(id, name, sal, incen);
		this.require_incen = require_incen;
		this.skill_incen = skill_incen;
	}
	public void total_sal() {
		super.total_sal();
		total_salary += require_incen+skill_incen;
	}
	
}

class Secretary extends Employee{
	int secret_incen;
	Secretary(int id, String name, int sal, int incen, int secret_incen){
		super(id, name, sal, incen);
		this.secret_incen = secret_incen;
	}
	public void total_sal() {
		super.total_sal();
		total_salary += secret_incen;
	}
}
public class SalaryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e [] = new Employee[4];
		// 1.상속 2.생성자(타입 순서 갯수....)
		e[0] = new Employee
		(1000,"이사원",10000,5000);
		e[1] = new Manager
		(2000,"김간부",20000,10000,10000);
		e[2] = new Engineer
		(3000,"박기술",15000,7500,5000,5000);
		e[3] = new Secretary
		(4000,"최비서",15000,7000,10000);
		
		System.out.println("사번:이름:본봉:총급여");
		for(Employee i : e) {
			i.total_sal();
			System.out.println(i.id +":"+i.name+":"+i.salary+":"+i.total_salary);
		}
		
	}

}
