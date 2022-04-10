package a.b.c.kos.dao;

import java.util.ArrayList;
import a.b.c.kos.vo.MemVO;

public interface MemDAO {
	// **DQL :: SELECT**
	public ArrayList<MemVO> memSelectAll();
	public ArrayList<MemVO> memSelectNum(MemVO mvo);
	public ArrayList<MemVO> memSelectName(MemVO mvo);
	public ArrayList<MemVO> memSelectDate(MemVO mvo);
	
	// **DML :: INSERT, UPDATE, DELETE**
	public boolean memInsert(MemVO mvo);
	public boolean memUpdate(MemVO mvo);
	public boolean memDelete(MemVO mvo);
}
