package a.b.c.com.kosmo.board.service;

import java.util.List;

import a.b.c.com.kosmo.board.vo.KosmoBoardVO;

public interface KosmoBoardService {
	public int kosmoBoardInsert(KosmoBoardVO bvo);
	public List<KosmoBoardVO> kosmoBoardSelectAll(KosmoBoardVO bvo);
	public List<KosmoBoardVO> kosmoBoardSelect(KosmoBoardVO bvo);
	public List<KosmoBoardVO> kosmoBoardPwCheck(KosmoBoardVO bvo);
}
