package generic2;

class Fruit {
	String name = "과일";
}

class Apple extends Fruit {
	String origin;
	Apple(String name, String origin){
		this.origin = origin;
		this.name = name;
	}
}

class Orange extends Fruit {
	String imported;
	Orange(String name, String imported) {
		this.name = name;
		this.imported = imported;
	}
}

class Paper {
	String size = "A4";
}

class Box<T extends Fruit> { // 제한 정의
	//멤버변수 / 생성자 / 메소드 순서 없다
	T o;
	Box(T o) {
		this.o = o;
	}
	public T getO() {
		return o;
	}
	public void setO(T o) {
		this.o = o;
	}
}

class BoxManager {
	public void test(Box<? extends Fruit> b) { //제한 타입 전달
		System.out.println(b.getO().name);
	}
}
public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit f = new Fruit();
		Apple a = new Apple("사과", "대구");
		Orange o = new Orange("오렌지", "미국");
		Paper p = new Paper();
		Box<Apple> box1 = new Box<Apple>(a);
		Box<Orange> box2 = new Box<Orange>(o);
		Box<Fruit> box3 = new Box<Fruit>(f);
		//Box<Paper> box4 = new Box<Paper>(p);
		
		BoxManager m = new BoxManager();
		m.test(box1);
		m.test(box2);
		m.test(box3);
//		m.test(new Box<Paper>)(p)); 불가능
		
	}

}
