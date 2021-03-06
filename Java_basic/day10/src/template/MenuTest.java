package template;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Scanner;


public class MenuTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
				
		while(true) {
			System.out.println
			("===다음과 같은 메뉴 이용 가능합니다===\n" + 
					"1.사원등록\n" + 
					"2.사원정보조회\n" + 
					"3.사원정보수정\n" + 
					"4.사원탈퇴\n" + 
					"5.프로그램종료\n" + 
					"\n" + "번호입력 : ");
			int menu = key.nextInt();
			if(menu == 1) {
				InsertProcess p = new InsertProcess();
				p.process();
			}else if(menu == 2) {
				ViewProcess view = new ViewProcess();
				ArrayList<EmployeeVo> list = view.process();
				for (EmployeeVo vo : list) System.out.println(vo);
			}else if(menu == 3) {
				System.out.println("사원정보수정을 선택하셨습니다.");
			//수정 사번 입력 : 200
			//수정항목 입력 :  "name  박수정" ->   이름 	박수정으로 변경
			/* employee.txt 파일에서 1라인씩 읽어서 
			 '|' 분리 첫번째 요소(=사번)이 200 인 라인을 찾아서 
			 '|' 분리 두번째 요소(=이름을) 박수정으로 변경
			 모든 라인을 다시 employee.txt로 다시 저장
			 
			 
			100|이자바|10000.0
			200|박자바|30000.0
			300|김사원|20000.0
			
			
			FileWriter fw = new FileWriter("employee.txt");
			*/
			System.out.println("수정 사번 입력 : ");		
			String inputId = key.next();//200
			System.out.println("수정 항목 입력 : ");//name 박수정 
			key.next();	//name or salary
			String inputName = key.next();
			
			try {
			FileReader fr = new FileReader("employee.txt");				
			Scanner sc = new Scanner(fr);
			
			
			ArrayList<String> list = new ArrayList<String>();
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				//line 의 내용을 분리(|)
				String items[] = line.split("\\|");
			
				String id = items[0];
				String name = items[1];
				String salary = items[2];
				if(id.equals(inputId)) {
					name = inputName;
				}
				
				//System.out.println(id+"|"+name+"|"+salary);
				list.add(id+"|"+name+"|"+salary);
				
			}//while end
			
			sc.close();
			fr.close();
			
			FileWriter fw = new FileWriter("employee.txt");
			//for(int i = 0; i < list.size(); i++) {
			//	fw.write(list.get(i) +"\n");
			//}
			for(String one : list) {
			fw.write(one +"\n");
			}
			fw.close();
			}catch(IOException ex) {ex.printStackTrace();}
			
			}else if(menu == 4) {
				System.out.println("사원탈퇴를 선택하셨습니다.");
				//퇴사한 사번 입력 : 100
				//100 사번 list에서 삭제
			}else if(menu == 5) {
				System.out.println("프로그램 종료합니다.");
				break;
			}else {
				System.out.println("해당 기능의 메뉴는 존재하지 않습니다");
			}
		}
		
	}

}


