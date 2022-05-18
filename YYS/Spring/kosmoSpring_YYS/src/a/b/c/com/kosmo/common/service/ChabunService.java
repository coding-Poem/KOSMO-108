package a.b.c.com.kosmo.common.service;

import java.util.List;

import a.b.c.com.kosmo.member.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

public interface ChabunService {
	public List<KosmoProductVO> getKosmoProductChabun();
	public List<KosmoMemberVO> getKosmoMemberChabun();
}
