package com.project.semi;

import java.util.List;

public interface BoardService {
	public List<BoardDTO> getAllBoard();
	public List<BoardDTO> getAllBoard(BoardPageDTO dto);
	public BoardDTO getDetailBoard(int seq);
}
