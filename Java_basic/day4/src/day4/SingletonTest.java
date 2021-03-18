package day4;

class A{
	private static A a1 = new A();
	private A() {
		System.out.println("A 생성자 호출");
	}
	static A getInstance() {
		return a1;
	}
}
public class SingletonTest {
	public static void main(String[] args) {
		A.getInstance();
		A.getInstance();
		A.getInstance();
	}
}
