package day5;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 0;
		try {
			int i = Integer.parseInt(args[0]);
			j = Integer.parseInt(args[1]);
			System.out.println(i/j);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		finally {
			System.out.println("항상 실행합니다.");
		}
		System.out.println("main종료");
	}

}

