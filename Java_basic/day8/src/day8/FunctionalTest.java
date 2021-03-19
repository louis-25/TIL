package day8;

@FunctionalInterface
interface Math{
	public int calc(int first, int second);	
}

@FunctionalInterface
interface C{
	public int calc(int first, int second);	
}

@FunctionalInterface
interface A {
	int ma();
}

@FunctionalInterface
interface B{
	int mb(int i);
}

class C1 {
	static int mc1(int i, int j) {return i / j;}
	int mc2(int i, int j) { return i % j; }
}
//class A implements Math {
//	public int calc(int first, int second) {return first * second;}
//}
//
//class B implements Math {
//	public int calc(int first, int second) {return first + second;}
//}
public class FunctionalTest {
	String name = "멤버변수";
	public static void main(String[] args) {
		
		C1.mc1(10, 2);
		C1 c = new C1();
		c.mc2(10, 2);
		
		
		String name = "메인지역변수";		
		
//		Math m = (a, b) -> a*b;
//		System.out.println(m.calc(10, 2));
		
		//람다식
//		Math m2 = (int first, int second) -> {return first - second;};
//		Math m2 = (i, j) -> i-j;
//		System.out.println(m2.calc(10, 2));
//		
//		Math m3 = (i, j) -> i+j;
//		System.out.println(m3.calc(10, 2));
//		
//		Math m4 = (i, j) -> i/j;
//		System.out.println(m4.calc(10, 2));
//		
//		Math m5 = (i, j) -> C1.mc1(i, j);
		Math m5 = C1::mc1; // 위의 코드와 똑같다
		
//		C1 c = new C1();
		Math m6 = new C1()::mc2;
		//객체생성 변수명::non-static메소드명
		System.out.println(m6.calc(10, 2));
//		System.out.println("람쥐썬더"+m5.calc(2,1));
		
		
		A a1 = ()->{ return 1;}; // A a1 = () -> 1; 같은코드
		System.out.println(a1.ma());
		
		B b1 = (a) -> {
			String name2 = "람다";
			System.out.println("람다식 실행");
			System.out.println(name); // 람다 포함 메소드 지역변수 사용가능
			System.out.println(name2);
			// static변수 --> 클래스명.static변수
			// non-static변수 --> new 클래스명().non-static변수
			System.out.println(new FunctionalTest().name);
			return a*a;};
		System.out.println(b1.mb(2));
	}
}
