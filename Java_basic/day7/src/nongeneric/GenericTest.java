package nongeneric;

class Apple {
	String origin = "대구";
}
class Paper {
	String size = "A4";
}

//Box<Apple과 하위클래스, Paper>
class Box<T, K>{// 컴파일 시점전달
	T t1;
	K k1;
	String name = "상자";
	Box(T t1, K k1) {
		this.t1 = t1;
		this.k1 = k1;
	}
	public T getT1() {
		return t1;
	}
	public void setT1(T t1) {
		this.t1 = t1;
	}
	public K getK1() {
		return k1;
	}
	public void setK1(K k1) {
		this.k1 = k1;
	}
	
	
}
class BoxManager { // 클래스는 제네릭이 아니다
	
	//제네릭 메소드
	public <P1, P2> Box<P1, P2> test(P1 a, P2 p) {
		Box<P1, P2> box2 = new Box<P1, P2>(a, p);
		return box2;
	}
}
public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a = new Apple();
		Paper p = new Paper();
		//<Apple> <Paper> 제네릭 타입사용
		Box<Apple, Paper> box = new Box<Apple, Paper>(a, p);		
		//제네릭 타입을 사용하면 아래와같이 코드가 간략해진다
		System.out.println(box.getT1().origin);
		System.out.println(box.getK1().size);
		
		BoxManager manager = new BoxManager();
		Box<Apple, Paper> box2 = manager.test(a, p);
		System.out.println(box2.getT1().origin);
		System.out.println(box2.getK1().size);
		
		//제네릭 타입을 사용하지 않는경우
//		if(appleBox.getO() instanceof Apple) { //appleBox는 Apple객체인가?
//			System.out.println(((Apple)(appleBox.getO())).origin);
//		}
//		if(paperBox.getO() instanceof Paper) { //paperBox는 Paper객체인가?
//			System.out.println(((Paper)(paperBox.getO())).size);
//		}
	}

}
