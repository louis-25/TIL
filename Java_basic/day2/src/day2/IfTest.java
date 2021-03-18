package day2;

public class IfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "이자바";
		int kor = (int)(Math.random()*100)+1;
		int eng = 88;
		int mat = 77;
		int sum = kor+ eng+ mat;
		int avgInt = sum/3;
		double avgDouble = (double)sum/(double)3;
		
		System.out.println("학생이름=" + name);
		System.out.println("국어=" + kor);
		System.out.println("영어=" + eng);
		System.out.println("수학=" + mat);
		System.out.println("총점=" + sum);
		System.out.println("평균(정수)=" + avgInt);
		System.out.println("평균(실수)=" + avgDouble);
		
//		if(avgInt>=70) {
//			System.out.println("pass");
//		}
//		else {
//			System.out.println("fail");
//		}
		
//		if(avgInt >= 80 && avgInt <=100) {
//			System.out.println("A등급");
//		}
//		else if (avgInt>=60 && avgInt<80) {
//			System.out.println("B등급");
//		}
//		else if (avgInt>=40 && avgInt<60) {
//			System.out.println("C등급");
//		}
//		else {
//			System.out.println("낙제");
//		}
//		
		switch(avgInt/10) {
		case 8:
			System.out.println("A등급");
			break;
		case 6, 7:
			System.out.println("B등급");
			break;
		case 4,5:
			System.out.println("C등급");
			break;
		default:
			System.out.println("낙제");
			break;
		}
	}

}
