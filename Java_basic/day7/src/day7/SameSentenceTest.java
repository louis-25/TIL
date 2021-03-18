package day7;

import java.util.ArrayList;

//실습

// import 자리
class SameSentence{
	String[] compare(ArrayList<String> list1, ArrayList<String> list2){
		String[] result = new String[4];	
		ArrayList<String> resultList = new ArrayList<String>();
		
		int len1 = list1.size();
		int len2 = list2.size();
		
		//구현하시오.
		/* list1, list2 데이터 갯수 비교
		 * 다르면  "최소 (작은쪽의 갯수)3개, 최대 (큰쪽 갯수)4개의 리스트입니다"  를  result   배열에 넣어서 리턴
		 * 같으면 2개 ArrayList  각 인덱스마다 문자열 내용 비교하고 같을 문자열 내용 같으면  result  배열에 넣어서 리턴
		 * */
		if(len1 > len2) {
//			result[0] = "최소" + len2 + " 개, 최대" + len1 +" 개의 리스트입니다.";
			resultList.add("최소" + len2 + " 개, 최대" + len1 +" 개의 리스트입니다.");
		}else if (len1 < len2) {
			resultList.add("최소" + len1 + " 개, 최대" + len2 +" 개의 리스트입니다.");
		}else { // len1 == len2
			for(int i = 0; i < len1; i++) {
				if(list1.get(i).equals(list2.get(i))) {
//					result[i] = list1.get(i);
					resultList.add(list1.get(i));
				}
			}
		}		
				
		result = new String[resultList.size()]; //resultList의 크기만큼 배열을 만든다
		//ArrayList 데이터를 배열 변경 메소드
		result = resultList.toArray(result); //resultList의 데이터를 result배열로 리턴
		return result;//
	}
}
public class SameSentenceTest {
public static void main(String[] args) {
	ArrayList<String> list1 = new ArrayList<String>();
	list1.add("자바는 객체지향 언어입니다");
	list1.add("우리는 멀티캠퍼스에서 자바를 배우는 중입니다");
	list1.add("오늘은 컬렉션 프레임워크를 배우죠! ");
	list1.add("람다, 입출력과 네트워크도 배울 예정입니다 ");
	
	ArrayList<String> list2 = new ArrayList<String>();
	list2.add("자바는 객체지향 언어입니다");
	list2.add("우리는 multicampus에서 자바를 배우는 중입니다");
	list2.add("오늘은 컬렉션 프레임워크를 배우죠! ");
	list2.add("입출력과 네트워크도 배울 예정입니다 ");
	
	ArrayList<String> list3 = new ArrayList<String>();
	list3.add("자바는 객체지향 언어입니다");
	list3.add("우리는 multi에서 자바를 배우는 중입니다");
	list3.add("오늘은 컬렉션 프레임워크를 배우죠! ");
	
	SameSentence ss = new SameSentence();
	String[] a = ss.compare(list1, list2);//list1, list2에서 같은 내용만 출력
	for(String one: a) {
//		if(one != null) System.out.println(one);
		System.out.println(one);
	}
	
	String[] b = ss.compare(list1, list3);//최소 3개, 최대 4개의 리스트입니다 출력	
	for(String one: b) {
//		if(one != null) System.out.println(one);
		System.out.println(one);
	}
}
}