package day6;

class Multi1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1; i<=10; i++) {
			System.out.println(this.getName()+":다른 작업 수행");
		}
	}
}
public class MultiThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multi1 m1 = new Multi1();
		m1.setName("m1");
		m1.start();
		
		Multi1 m2 = new Multi1();
		m2.setName("m2");
		m2.start();
		
		for(int i = 1; i<=10; i++) {
			System.out.println("메인 작업 수행");
		}
	}

}
