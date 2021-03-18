package day7;

class Student<T> {
	T id;
	String name;
	int kor, eng, mat;
	public Student(T id, String name, int kor, int eng, int mat) {
	//	super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//toString, equals 오버라이딩
	@Override
	public String toString() {
		return "id:"+id+" name:"+name+" 총점: "+(kor+eng+mat);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eng;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + kor;
		result = prime * result + mat;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		int total = kor+eng+mat;
		int total2 = ((Student)obj).kor+ ((Student)obj).eng+ ((Student)obj).mat;
		
		if(total == total2) return true;
		else return false;
	}
	
	
}

public class StudentMapTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student<Integer> s1 = new Student<Integer>(100, "김자바", 50, 60, 70);
		Student<String> s2 = new Student<String>("200", "박지원", 50, 60, 70);		
		System.out.println(s1); // id-name-총점
		System.out.println(s2);
		
		System.out.println(s1.equals(s2));
		
	}

}
