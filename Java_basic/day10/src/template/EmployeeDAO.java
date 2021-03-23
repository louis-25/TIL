package template;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeDAO {
	void insert(EmployeeVo vo) {
		//파일 저장-->EmployeeDAO
		/* day9/employee.txt 파일에 e객체의 id, name, salary  3 변수 내용을  1줄에 출력 */
		try {
		FileWriter fw = new FileWriter("employee.txt", true);
		fw.write(vo.toString() + "\n"); // id+"|"+name+"|"+salary
		fw.close();
		}
		catch(IOException ex) {	ex.printStackTrace(); }
		
		ArrayList<EmployeeVo> getAll() {
			// 1라인 -> EmployeeVo -> ArrayList로 리턴
			EmployeeVo vo = new EmployeeVo();
			return;
		}
	}
}
