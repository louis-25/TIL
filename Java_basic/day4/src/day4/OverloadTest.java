package day4;

class Adding{
	public int add(int i , int j) {
		return i + j;
	}
	public double add(double i , double j) {
		return i+j;
	}
	public String add(String i, String j) {
		return i+j;
	}
}

public class OverloadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "100";
		int dec = Integer.parseInt(s1);
		int bin = Integer.parseInt(s1, 2);
		System.out.println(dec);
		System.out.println(bin);
		
	}

}
