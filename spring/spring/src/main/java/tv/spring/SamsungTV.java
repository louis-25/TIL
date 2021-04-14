package tv.spring;

public class SamsungTV implements TV {	
	public SamsungTV() {
		System.out.println("삼성tV호출");
	}
	public void powerOn() {
		System.out.println("삼성tv - 전원on");
	}
	public void powerOff() {
		System.out.println("삼성tv - 전원off");
	}
	public void soundUp() {
		System.out.println("삼성tv - 볼륨up");
	}
	public void soundDown() {
		System.out.println("삼성tv - 볼륨down");
	}
}
