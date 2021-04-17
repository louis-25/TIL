package day1_test;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time = 10000; //초단위시간
		// 시분초단위 변경 출력
		
		int hour = time/3600;
		int min = (time%3600)/60;
		int sec = (time%3600)%60;
		
		System.out.println("10000초는 "+ hour + " 시간 " + min +" 분 "
		+ sec+" 초입니다.");
		
		
	}

}
