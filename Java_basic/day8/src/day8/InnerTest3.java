package day8;

public class InnerTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int out = 10;
		class Inner {
			public int count() {
				int cnt = 0;
				for(int i = 0; i<out; i++) {
					cnt += i;
				}// for end
				return cnt;
			}// count end
		}//class Inner end
		System.out.println(new Inner().count());
		
		//무명객체
		//interface Runnable { public void run(); }
//		class RunnableSub implements Runnable {
//			public void run() {
//				System.out.println("실행중");
//			}
//		}
//		
//		// 지역 내부 객체 생성
//		RunnableSub sub = new RunnableSub();
//		// 메소드 호출
//		Thread t1 = new Thread(sub);
//		t1.run();

		//무명의 클래스		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("실행중");
			}
		}).start();
		
		//위의 코드를 람다식으로 바꾸면 아래와같다
		//()괄호만 써도 run()메소드로 인식한다
		new Thread(() -> {System.out.println("람다실행");}).start();
		
		myInter i = new myInter() {
			@Override
			public void mi1() {
				System.out.println("mi1");
			}
			@Override
			public void mi2() {
				System.out.println("mi2");
			}
			//인터페이스에서 정의되지않은내용 이므로 여기에서만 사용가능
			String name="100";
			public void mi3() {
				System.out.println(name);
			}
		};
		i.mi1();
		i.mi2();
	}//main end
}

interface myInter {
	/*public abstract*/void mi1();
	void mi2();
}
