package day7;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
//		s1배열과 s2배열은 같은 내용이다
//		String s1[] = new String[3];
//		s1[0] = "010-1234-5678";
//		s1[1] = "02-3429-0987";
//		s1[2] = "ss@multicampus.com";
//		
//		s1 = new String[30];
//		String s2[] = {"010-1234-5678", "02-3429-0987", "ss@multicampus.com"};
		
		HashMap<String, String[]> phone = 
				new HashMap<String, String[]>();
				
		
		phone.put("초등친구", new String[]{"010-1234-5678", "02-3429-0987", "초등친구@multicampus.com"});
		phone.put("초등친구", new String[]{"010-1223-5678", "02-3429-0987", "고등친구@multicampus.com"});
		phone.put("회사동기", new String[]{"010-1234-5678", "02-2432-0987", "회사동기@multicampus.com"});
		phone.put("회사상사", new String[]{"010-1234-5678", "02-3559-0987", "회사상사@multicampus.com"});
		
		System.out.println("총연락처갯수="+phone.size());
		
		//회사동기의 연락처 정보 조회
		String phonelist[] = phone.get("회사동기");
		for(String one : phonelist) {
			System.out.println(one);
		}
		
		// 사장님의 연락처 정보조회
		if(phone.containsKey("사장님")) { // phone Map에 사장님key값이 있는지? 
			String phonelist2[] = phone.get("사장님");
			for(String one : phonelist) {
				System.out.println(one);
			}
		}
		else {
			System.out.println("사장님은 연락처에 없어요.");
		}
		
		System.out.println();
		//내 연락처 모든 정보 조회
		Set<String> keys = phone.keySet(); //key를 set의 형태로 보여준다
		for(String key : keys) {
			phone.get(key + " : "); // key값을 조회하여 value값을 반환한다
			String phonelist1[] = phone.get(key);
			for(String one: phonelist1) {
				System.out.print(one + " | ");
			}
			System.out.println();
		}
		
	}	

}

/*
 * "work dir" = 나의 작업디렉토리
 * "os" = windows10
 * key = value
 * */
