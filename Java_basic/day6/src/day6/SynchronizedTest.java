package day6;


class MyStack{
	char [] ch = new char[10];
	int idx = 0;
	void push(char c) {
		synchronized (ch) {
			ch[idx] = c;
			System.out.println(Thread.currentThread().getName() + ":idx="+idx+" , ch[idx]="+ch[idx]);
			idx++;
		}
		
	}
}

class MyStackThread extends Thread{
	MyStack st;
	char c;
	MyStackThread(MyStack st, char c){
		this.st = st;
		this.c = c;
	}
	public void run() {
		for(int i = 1; i<=5; i++) {
			st.push(c);
		}
	}
}
public class SynchronizedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack st = new MyStack();
		MyStackThread t1 = new MyStackThread(st, 'a');
		MyStackThread t2 = new MyStackThread(st, 'b');
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
		
	}

}
