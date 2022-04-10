package a.b.c.kos.mem.dao;

import java.util.ArrayList;

import a.b.c.kos.mem.vo.MemVO;

public interface MemDAO {
	// **DQL :: SELECT**
	public ArrayList<MemVO> memSelectAll(MemVO mvo);
	public ArrayList<MemVO> memSelect(MemVO mvo);
	
	// **DML :: INSERT, UPDATE, DELETE**
	public boolean memInsert(MemVO mvo);
	public boolean memUpdate(MemVO mvo);
	public boolean memDelete(MemVO mvo);
}
