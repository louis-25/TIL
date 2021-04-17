package day4;

class Person{
	String name;
	int age;
	static String nation = "대한민국";
	
}
public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Person.nation);
		Person p1=new Person();
		p1.name = "박민국";
		p1.age = 20;
//		p1.nation = "대한민국";
		System.out.println(p1.name + ":" + p1.age + ":"+ p1.nation);
		Person p2=new Person();
		p2.name = "김대한";
		p2.age = 30;
//		p2.nation = "대한민국";
		System.out.println(p2.name + ":" + p2.age + ":"+ p2.nation);
		
	}

}
