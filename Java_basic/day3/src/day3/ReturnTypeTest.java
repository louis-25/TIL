package day3;

class Test{
	int ma() {
		int i = 10;
		return i*i;
	}
	String mb (){
		String s = "java";
		return s.toUpperCase();
	}
	int[] mc() {
		int[] i = new int[3];
		i[0] = 100;
		i[1] = 100;
		i[2] = 100;
		return i;
	}
	void md() {
		int i = 10;
		System.out.println(i*i);
	}
	void me() {
		System.out.println("메소드시작");
		
		System.out.println("메소드종료");
	}
}
public class ReturnTypeTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		int r1 = t.ma();
		System.out.println(r1);
		String r2 = t.mb();
		System.out.println(r2);
		int[] r3 = t.mc();
		for(int one : r3) {
			System.out.println(one);
		}
		t.md();
	}

}
