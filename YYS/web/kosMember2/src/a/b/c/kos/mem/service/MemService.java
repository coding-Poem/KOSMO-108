package a.b.c.kos.mem.service;

import a.b.c.kos.mem.vo.MemVO;
import java.util.ArrayList;

public interface MemService {
	// **DQL :: SELECT**
	public ArrayList<MemVO> memSelectAll(MemVO mvo);
	public ArrayList<MemVO> memSelect(MemVO mvo);
	
	// **DML :: INSERT, UPDATE, DELETE**
	public boolean memInsert(MemVO mvo);
	public boolean memUpdate(MemVO mvo);
	public boolean memDelete(MemVO mvo);
}
