package day9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	int id = 0;
	String name = "";
	int salary = 0;
	
	Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return id+"|"+name+"|"+salary;
	}
	
}

public class IoSalary {

	@SuppressWarnings("resource")
	public static void main(String[] args) { 
		
		int id = 0;
		String name = "";
		int salary = 0;
		int choice;		
		Scanner scanner = new Scanner(System.in);
		Employee e = null;
		//ArrayList<Employee> list = new ArrayList<Employee>(5);
		FileReader fr = null;
		FileWriter fw = null;		
		
		while(true) {		
			System.out.println("====다음과 같은 메뉴 이용 가능합니다====");
			System.out.println("1.사원등록");
			System.out.println("2.사원정보조회");
			System.out.println("3.사원정보수정");
			System.out.println("4.사원탈퇴");
			System.out.println("5.프로그램종료");
			choice = scanner.nextInt();
			
			switch(choice) {							
				case 1: //입력
					/*day9/employee.txt 파일에 e객체의 id, name, salary 3변수의 내용을 1줄에 출력*/
					System.out.print("사번입력 :");
					id = scanner.nextInt();
					System.out.print("이름입력 :");
					name = scanner.next();
					System.out.print("급여입력 :");
					salary = scanner.nextInt();
					e = new Employee(id, name, salary);
					
					try {
						fw = new FileWriter("employee.txt", true);
						fw.write(e.id+"|"+e.name+"|"+e.salary+"\n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						try {//							
							fw.close();
						}catch (IOException e1) {}
					}							
					System.out.println("사원등록을 마쳤습니다");				
					break;
				case 2: //출력
					/*day9/employee.txt 파일 저장 employee 객체만큼 입력 + Scanner는 적절히 사용
					 * id+"|"+nama+"|"+salary의 1.5배 형식으로 콘솔 출력*/
					try {
						fr = new FileReader("employee.txt");
						scanner = new Scanner(fr);
						String line="";
						String[] result = null;
						while(scanner.hasNextLine()) { //읽을 라인이 있는가?
							line = scanner.nextLine(); //한줄읽기
							//|는 패턴에서 "또는" 의미 가진 문자이므로 원래의 의미미를 제거한 형태로만 사용하려면 \\| 로 표현합니다.
							result = line.split("\\|");
							String id2 = result[0];
							String name2 = result[1];
							double salary2 = Double.parseDouble(result[2]);
							System.out.println(id2+"|"+name2+"|"+salary2*1.5);							
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} finally {
						try {				
							fr.close();
						}catch (IOException e1) {}
					}							//					
					break;
				case 3: //수정
					//수정 사번 입력 : 100 --> 사번이 100번인 객체를 찾아라
					//수정항목 입력: name 박수정 -> 이름을 박수정으로 변경 -> split메소드 사용
					//			 salary 3000 -> 급여를 3000으로 변경
					//employee.txt 파일에서 1라인씩 읽어서 '|\분리 첫번째 요소(=사번)이'
					//100인 라인을 찾아서 두번째 분리요소 이름을 박수정으로 변경
					// 모든 라인을 다시 employee.txt로 다시 저장
					try {
						fr = new FileReader("employee.txt");
						fw = new FileWriter("employee.txt");
						System.out.print("수정할 사번을 입력해주세요 : ");
						String inputId = scanner.next();
						System.out.print("이름을 입력해주세요 : ");
						String inputName = scanner.next();
						
						scanner = new Scanner(fr);
						String line="";
						String[] result = null;	
						ArrayList<String> list = new ArrayList<String>();
						
						while(scanner.hasNextLine()) { //읽을 라인이 있는가?
							line = scanner.nextLine(); //한줄읽기
							//|는 패턴에서 "또는" 의미 가진 문자이므로 원래의 의미미를 제거한 형태로만 사용하려면 \\| 로 표현합니다.
							result = line.split("\\|");							
							String id2 = result[0];
							name = result[1];
							String salary2 = result[2];
							if(id2.equals(inputId)) {
								name = inputName;
							}
							System.out.println(id2+"|"+name+"|"+salary2+"\n");
//							fw.write(id2+"|"+name+"|"+salary2+"\n");																					
						}
						System.out.println("수정이 완료됐습니다.");
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {				
							fr.close();
							fw.close();
//							for(int i =0; i< list.size(); i++) {
//							fw.write(list.get(i));
//							}
							for(String one : list) {
								fw.write(one+"\n");
							}
						}catch (IOException e1) {}
					}	
					break;
				case 4: //삭제
//					list.remove(list.size()-1);
					//퇴사한 사번 입력 : 100
					//100사번 list에서 삭제
					break ;
				case 5: //종료
					return;
			}							
		}
	}

}
