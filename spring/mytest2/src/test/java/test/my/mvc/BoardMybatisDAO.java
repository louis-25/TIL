package test.my.mvc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao") //BoardMybatisDAO객체를생성하여 dao로 다른곳에서도 이용가능
public class BoardMybatisDAO {
	@Autowired
	SqlSession session; //mybatis.jar에서 제공해주는 api
	
	public List<BoardDTO> getAllBoard() {
		List<BoardDTO> list = session.selectList("board.all");
		return list;
	}
}
