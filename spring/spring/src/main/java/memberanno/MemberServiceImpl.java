package memberanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl implements MemberService {

	@Autowired // MemberDAO에 연결
	MemberDAO dao;
	
	@Override
	public void register() {
		boolean result = dao.selectMember();
		if(!result) {
			dao.insertMember();
		}
	}

	@Override
	public void login() {
		boolean result = dao.selectMember();
		if(result) {
			System.out.println("정상 로그인 사용자");
		}

	}

}
