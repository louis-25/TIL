package day5;

public class CheckedExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("day5.CheckedExceptionTest");
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		int su = Integer.parseInt("-100");
		try {
			if(su<=0) {
				throw new NumberFormatException("소수 구하기 부적합합니다.");
			}
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}

