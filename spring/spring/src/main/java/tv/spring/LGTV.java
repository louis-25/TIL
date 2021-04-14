package tv.spring;

public class LGTV implements TV{	
	public void powerOn() {
		System.out.println("LGTV-전원on");
	}
	public void powerOff() {
		System.out.println("LGTV-전원off");
	}
	public void soundUp() {
		System.out.println("LGTV-볼륨up");
	}
	public void soundDown() {
		System.out.println("LGTV-볼륨down");
	}
}
