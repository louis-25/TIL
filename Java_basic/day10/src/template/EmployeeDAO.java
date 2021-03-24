package template;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
				
		
	}
	
	ArrayList<EmployeeVo> getAll() {
		System.out.println("사원정보조회를 선택하셨습니다.");
		/* day9/employee.txt 파일 저장 employee 객체만큼 입력
		 * id+"|"+name+"|"+ salary의 1.5배  형식으로 콘솔 출력
		*/	
		// 1라인 -> EmployeeVo -> ArrayList로 리턴			
		ArrayList<EmployeeVo> list = new ArrayList<EmployeeVo>();
		
		try {
			FileReader fr = new FileReader("employee.txt");		
			Scanner sc = new Scanner(fr);
			//id+"|"+name+"|"+salary
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				//line 의 내용을 분리(|)
				String items[] = line.split("\\|");
			
				int id = Integer.parseInt(items[0]);
				String name = items[1];
				double salary = Double.parseDouble(items[2]);// 급여
//				System.out.println(id+"|"+name+"|"+salary*1.5);
				list.add(new EmployeeVo(id, name, salary));
			}
			sc.close();
			fr.close();
			}catch(IOException ex) {ex.printStackTrace();}
		
		return list;			
	}
}
