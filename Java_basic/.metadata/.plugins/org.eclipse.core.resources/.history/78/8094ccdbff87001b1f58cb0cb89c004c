package day7;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<Employee> set = new HashSet<Employee>();
//		set.add(100);
//		set.add(3.14);
//		set.add("java");
		Employee e1 = new Employee(400, "박부장", 88000.99);
		set.add(e1);		
		set.add(new Employee(500, "박부장", 88000.99));//새로운 객체생성 (e1과 같지않다(중복x) -> set으로 추가가능)
		System.out.println(set.size());
		
		//for(int i=0; i< set.size(); i++) {
			Iterator<Employee> it = set.iterator();
			while(it.hasNext()) { // 다음 데이터 존재 여부
				Employee o = it.next(); //다음 데이터 조회
				System.out.println(o.name);
			}
		//}
			
		System.out.println("========================");
		HashSet<Integer> lotto = new HashSet<Integer>();
		// 1-45 난수 생성하여 lotto 저장하여
		// lotto 출력하면 6개 정수 나오도록 처리(저장 - 조회 출력 순서 일치하지 않아도 된다)
		// 10분
		while(true) {
			int num = (int)(Math.random()*45)+1;
			lotto.add(num);
			System.out.println("생성된 난수===>"+num);
			if(lotto.size() == 6) {break;}
		}
		/*Iterator<Integer> it2 = lotto.iterator();
		while(it2.hasNext()) { //lotto안에 데이터가 있는지?
//			Integer o = it2.next();
			System.out.println(it2.next()); //항상 6개
		}*/
		for(Integer one : lotto) { //Iterator를 사용하지 않고도 for문으로 객체를 반복할 수 있다
			System.out.println(one);
		}
//		int ar[] = new int[5];
//		for( int one : ar ) { //ar배열의 하나
//			System.out.println(one);
//		}
//		
//		ArrayList list = new ArrayList();
//		
//		for(Object one : list) {
//			System.out.println(one);
//		}
//		
//		ArrayList<Employee> list = new ArrayList();
//		
//		for(Employee one : list) {
//			System.out.println(one);
//		}

	}

}
