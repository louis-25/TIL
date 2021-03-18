package edu;
class A{
	int i;
	A(){
		i = 10;
		System.out.println("A 생성자 호출");
	}
	
}
class B extends A{
	int j;
	B(){
		j = 100;
		System.out.println("B 생성자 호출");
	}
}
public class SuperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);
	}

}
