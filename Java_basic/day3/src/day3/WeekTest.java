package day3;

import java.util.Calendar;

public class WeekTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Week today = null;
		System.out.println(today);
		
		java.util.Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		switch(cal.get(Calendar.DAY_OF_WEEK)+1) {
		
		}
	}

}
