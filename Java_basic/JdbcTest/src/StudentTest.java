
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDTO dto = new StudentDTO();
		StudentDAO dao = new StudentDAO();
		
		//DB에 삽입할 레코드 1줄
//		dto.setNo(3);
//		dto.setName("나길동");
//		dto.setDet("영문학과");
//		dto.setAddr("제주");
//		dto.setTel("010-3333-3333");
//				
//		dao.insertStudent(dto); //삽입
		dao.printAllStudents(); //조회
	}

}
