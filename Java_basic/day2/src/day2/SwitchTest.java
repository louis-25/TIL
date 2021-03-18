package day2;

public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = (int)Math.random()*12 +1;
		System.out.println(m+"월:");
		switch(m) {
		case 3, 4, 5:
			System.out.println("계절은 봄입니다");
			break;
		case 6, 7, 8:
			System.out.println("계절은 여름입니다");
			break;
		case 9,10,11:
			System.out.println("계절은 가을입니다");
			break;
		case 12,1,2:
			System.out.println("계절은 겨울입니다");
			break;
		}
		
	}

}
