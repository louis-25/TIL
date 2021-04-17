package day2;

public class PrimeNumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int su = 30;
		int num = 0;
		for(int i = 1; i<=su; i++) {
			if(su%i==0)
				num++;
		}
		if(num<=2) {
			System.out.println("소수");
		}
		else {
			System.out.println("소수아님");
		}
	}

}
