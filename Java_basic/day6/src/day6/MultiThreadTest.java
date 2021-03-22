package day6;

class Multi1 extends Thread{
	@Override
	public void run() {
		for(int i = 1; i<=10; i++) {
			System.out.println(this.getName()+":다른 작업 수행");
		}
	}
}
public class MultiThreadTest {

	public static void main(String[] args) {
		Multi1 m1 = new Multi1();
		m1.setName("m1");
		m1.start(); //run() 동시 실행 = m1
		
		Multi1 m2 = new Multi1();
		m2.setName("m2");
		m2.start(); //run() 동시 실행 = m2
		
		for(int i = 1; i<=10; i++) {
			System.out.println("메인 작업 수행"); // 메인 스레드
		}
	}
}
