package day3;

public class Week {
	String name;
	static Week SUNDAY = new Week("SUNDAY");
	static Week MONDAY = new Week("MONDAY");
	static Week TUESDAY = new Week("TUESDAY");
	static Week WEDNESDAY = new Week("WEDNESDAY");
	static Week THURSDAY = new Week("THURSDAY");
	static Week FRIDAY = new Week("FRIDAY");
	static Week SATURDAY= new Week("SATURDAY");
	
	Week(String name){
		this.name = name;
	}
	
	public String name() {
		String name = this.name;
		return name;
	}
}
