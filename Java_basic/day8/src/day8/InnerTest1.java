package day8;
//중첩클래스 -  현재 소스 예시는 크게 종류 3가지 
//아래는 멤버변수 활용. 
class Outer{ //class 앞에 static x. public과 abstract는 가능 
	class Inner{ //non-static(=인스턴스) 멤버중첩클래스
		void m() {
			System.out.println("중첩클래스 메소드 실행");
		}
	}//inner end
	static class Inner2{ //static 멤버중첩클래스.
		//static 여부에 띠라 방식이 달라진다. 
		void m2() {
			System.out.println("중첩클래스 메소드 실행2");
		}
	}
	//아래는 지연변수 활용. 
	void test() { //메소드 호출 test 안에서 할 것. 
		//지역중첩클래스 
		class Inner3 {
			void m3() {
				System.out.println("중첩클래스 메소드 실행3");
			}
		}
		new Inner3().m3(); // test메소드만 사용가능하도록 함. test 메소드 안에 있어야 함. 
	}//test end 
}

public class InnerTest1 {

	public static void main(String[] args) {
		//Outer o = new Outer(); //외부 클래스 객체 먼저 만들고
		Outer.Inner i = new Outer(). new Inner(); //내부 클래스 객체를 만들어라!
		i.m();
		
		Outer.Inner2 i2 = new Outer.Inner2(); //static이라면 outer 클래스 객체를 만들지 않는다. 바로 inner 객체만 만든다.
		i2.m2();
		
		Outer o = new Outer();
		o.test();
		
	}

}
