package runna;


class Multi1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1; i<=10; i++) {
			System.out.println(Thread.currentThread().getName()+":다른 작업 수행");
		}
	}
}
public class MultiThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multi1 m1 = new Multi1();
		Thread t1 = new Thread(m1);
		
		t1.setName("t1");
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		
		Multi1 m2 = new Multi1();
		Thread t2 = new Thread(m2);
		
		t2.setName("t2");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		
		for(int i = 1; i<=10; i++) {
			System.out.println("메인 작업 수행");
		}
	}

}
