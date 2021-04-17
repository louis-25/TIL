package day5;

class StudentTeacher implements Student, Teacher{
	String name = "조교";
	@Override
	public void lunch() {
		// TODO Auto-generated method stub
		System.out.println("점심먹다");
	}@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println(Student.name);
		System.out.println(Teacher.name);
		System.out.println("학생-공부하다");
	}@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println("선생님-가르치다");
		
	}
}
public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentTeacher st = new StudentTeacher();
		st.study();
		st.teach();
		
		System.out.println(st.name);
		
		Teacher [] t = new Teacher[2];
		t[0] = new StudentTeacher();

	}

}
