package template;

import java.util.ArrayList;

public class Controller {
	//private접근자를 붙임으로 인해 외부에서 Controller를 쉽게생성X
	//현재 클래스에서는 사용가능
	static private Controller con = new Controller();
	private Controller(){ }
	public static Controller getInstance() { //getInstance는 Controller를 반환한다
		return con;
	}
	
	//사원등록 제어 부분
	void insert(int id, String name, double salary) {
		// 어떤 VO에저장할것이고 DAO로 어떻게 저장할것인지?
		// insert -> controller -> VO -> DAO
		EmployeeVo e = new EmployeeVo(id, name, salary); // 임시저장 데이터
		EmployeeDAO dao = new EmployeeDAO();
		dao.insert(e); //
	}
	
	ArrayList<EmployeeVo> getAll() {
		//EmployeeDAO객체에서 
		EmployeeDAO dao = new EmployeeDAO();		
		ArrayList<EmployeeVo> list = dao.getAll();
		return list;
	}
}

// 단 한개의 객체만 만들 수 있도록한다 -> singleton pattern
// 다른클래스에서는 아래와같이 Controller객체를 생성할 수 있다 -> Singleton Pattern
// Controller c = Controller.getInstance();