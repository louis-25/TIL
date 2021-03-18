package edu;
class Parent{
	int su1 = 10;
	void pr() {
		System.out.println(su1);
	}
	void mp() {
		System.out.println("Parent");
	}
}
class Child extends Parent{
	int su2 = 20;
	void pr() {
		System.out.println(su2);
	}
	void mc() {
		System.out.println("Child");
	}
}
public class TypeCastingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p1 = new Parent();
		Child c1 = new Child();
		Parent p2 = new Child();
		System.out.println(p2.su1);
		p2.mp();
		p2.pr();
		
		Child c2 = null;
		if(p2 instanceof Child) {
			System.out.println("test1");
			c2 = (Child)p2;
		}
		Parent p3 = new Parent();
		if(p3 instanceof Child) {
			System.out.println("test2");
			Child c3 = (Child)p3;
		}
		System.out.println(c2.su2);
		c2.mc();
		//child c3 = new Parent();
//		Child c3 = (Child)new Parent();
		
	}

}
