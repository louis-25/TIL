package template;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ViewProcess {
	void process() {
		//모든 사원 조회
		// Controller 싱글톤 생성
		//controller의 getAll() 호출
		
		System.out.println("사원정보조회를 선택하셨습니다.");
		/* day9/employee.txt 파일 저장 employee 객체만큼 입력
		 * id+"|"+name+"|"+ salary의 1.5배  형식으로 콘솔 출력
		*/
		try {
		FileReader fr = new FileReader("employee.txt");				
		Scanner sc = new Scanner(fr);
		//id+"|"+name+"|"+salary
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			//line 의 내용을 분리(|)
			String items[] = line.split("\\|");
		
			String id = items[0];
			String name = items[1];
			double salary = Double.parseDouble(items[2]);// 급여
			System.out.println(id+"|"+name+"|"+salary*1.5);
			
		}
		sc.close();
		fr.close();
		}catch(IOException ex) {ex.printStackTrace();}
	}
}

