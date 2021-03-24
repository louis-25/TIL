package template;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewProcess {
	ArrayList<EmployeeVo> process() {
		//모든 사원 조회
		// Controller 싱글톤 생성
		//controller의 getAll() 호출

		//singleton pattern
		Controller c = Controller.getInstance();
		return c.getAll();		
	}
}

