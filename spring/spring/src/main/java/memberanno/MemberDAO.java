package memberanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	@Autowired // MemberVo에 전달
	@Qualifier("vo2") //같은객체 중 사용할 객체 선택
	MemberVO vo;
	
	public boolean selectMember(){
		if(vo.getId().equals("spring") && vo.getPw().equals("work")) {
			return true;
		}
		else {
			return false;
		}
	}
	public void insertMember(){
		System.out.println(vo.getId()+" 회원님 정상 가입되셨습니다.");
	}
}
