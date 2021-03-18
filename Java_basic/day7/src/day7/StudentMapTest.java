package day7;

class Student<T1, T2, T3> {
	T1 id;
	T2 name;
	T3 kor, eng, mat;
	public Student(T1 id, T2 name, T3 kor, T3 eng, T3 mat) {
	//	super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//toString, equals 오버라이딩
}

public class StudentMapTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student(100, "김자바", 100, 90, 80);
		Student s2 = new Student("200", "박지원", 50, 60, 70);
		
		System.out.println(s1.id);
		System.out.println(s1.name);
		System.out.println(s1.kor);
		System.out.println(s1.eng);
		System.out.println(s1.mat);
	}

}
