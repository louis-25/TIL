package day6;

import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1> 010- 시작 2> 국번 3-4자리 번호- 3> 전화번호 4자리 숫자
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-1234-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "012-1234-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-123-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-123ㅁ-5678"));
		
		//1> id- 알파벳, 숫자, !#$%_ 구성. 8-10자리 가능 [a-zA-Z0-9!#$%_]{8,10}
		//2> @
		//3> 이메일 서버- 알파벳, 숫자 구성. 3-10자리 가능 [a-zA-Z0-9]{3,10}
		//4> . ---> 정규표션식에서 아무 문자 갯수 무관 의미. \\.
		//5> com or co.kr or go.kr (com|co.kr|go.kr)
		String my_email = "javadosa1!@campus.com";
		boolean result = Pattern.matches("[a-zA-Z0-9!#$%_]{8,10}@[a-zA-Z0-9]{3,10}\\.(com|co.kr|go.kr)", my_email);
		if(result) {
			System.out.println(my_email+" 은 이메일로 적합합니다");
		}
		
		//[표현형태(0-9..)]{최소횟수, 최대횟수}(com)
		
	}

}
