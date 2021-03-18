package day2;

public class TwoArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] two_ar = new int[3][];
		System.out.println(two_ar.length);
		for(int i = 0; i< two_ar.length; i++) {
			two_ar[i] = new int[i+2];
			for(int j = 0; j<two_ar[i].length; j++) {
				two_ar[i][j] = (i+1)*(j+1);
				System.out.print(two_ar[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
