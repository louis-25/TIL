package nongeneric1;

class Apple {
	String origin = "대구";
}
class Paper {
	String size = "A4";
}
class Box<T>{
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
public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a = new Apple();
		Paper p = new Paper();
		//<Apple> <Paper> 제네릭 타입사용
		Box<Apple> appleBox = new Box<Apple>(a);
		Box<Paper> paperBox = new Box<Paper>(p);
		//제네릭 타입을 사용하면 아래와같이 코드가 간략해진다
		System.out.println(appleBox.getO().origin);
		System.out.println(paperBox.getO().size);
		
		//제네릭 타입을 사용하지 않는경우
//		if(appleBox.getO() instanceof Apple) { //appleBox는 Apple객체인가?
//			System.out.println(((Apple)(appleBox.getO())).origin);
//		}
//		if(paperBox.getO() instanceof Paper) { //paperBox는 Paper객체인가?
//			System.out.println(((Paper)(paperBox.getO())).size);
//		}
	}

}