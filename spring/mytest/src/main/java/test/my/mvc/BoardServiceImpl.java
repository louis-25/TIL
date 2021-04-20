package test.my.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("service")
public class BoardServiceImpl implements BoardService {
    @Autowired
	BoardMybatisDAO dao;
	@Override
	public List<BoardDTO> getAllBoard() {
		return dao.getAllBoard();
	}

}
