package day5;

public class ObjectClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyObject o1 = new MyObject("java");
		MyObject o2 = new MyObject("java");
		System.out.println(o1);
		System.out.println(o2);

		
		if(o1 == o2) {
			System.out.println("o1==o2 true");
		}
		if(o1.equals(o2)) {
			System.out.println("o1.equals(o2) true");
		}
	}

}

class MyObject{
	String msg;
	MyObject(String msg){
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof MyObject) {
			String s = ((MyObject) obj).msg;
			return this.msg == s;
		}
		return super.equals(obj);
	}
}