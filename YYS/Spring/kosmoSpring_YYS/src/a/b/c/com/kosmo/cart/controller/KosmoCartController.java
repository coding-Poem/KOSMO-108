package a.b.c.com.kosmo.cart.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.cart.service.KosmoCartService;
import a.b.c.com.kosmo.cart.vo.KosmoCartVO;
import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.NumUtil;
import a.b.c.com.kosmo.common.service.ChabunService;
import a.b.c.com.kosmo.member.controller.KosmoMemberController;
import a.b.c.com.kosmo.member.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;


@Controller
public class KosmoCartController {
	
	Logger logger = LogManager.getLogger(KosmoMemberController.class);
	
	@Autowired(required=false)
	private ChabunService chabunService;
	
	@Autowired(required=false)
	private KosmoCartService kosmoCartService;
	
	@RequestMapping(value="kosmoCartInsert", method=RequestMethod.GET)
	public String kosmoCartInsert(KosmoCartVO cvo, Model model){
		logger.info("KosmoCartController :: kosmoCartInsert 함수 진입 >>> : ");
		
		// 채번
		List<KosmoCartVO> cList=null;
		String chanum="";
		String mcnum="";
		
		cList=chabunService.getKosmoCartChabun();
		logger.info("cList >>> : "+cList);
		logger.info("cList.size() >>> : "+cList.size());
		logger.info("cList.get(0) >>> : "+cList.get(0));
		
		
		KosmoCartVO _cvo=null;
		_cvo=cList.get(0);
		
		chanum=_cvo.getMcnum();
		logger.info("chanum >>> : "+chanum);
		
		mcnum= ChabunUtil.getKosmoCartChabun("D", chanum);
		logger.info("장바구니 번호 >>> : "+mcnum);
		
		cvo.setMcnum(mcnum);
		
		// 로그인 이전 GUEST 번호 (채번)
		logger.info("cvo.getMcnum() >>> : "+cvo.getMcnum());
		logger.info("cvo.getMnum() >>> : "+cvo.getMnum());
		logger.info("cvo.getMid() >>> : "+cvo.getMid());
		logger.info("cvo.getMname() >>> : "+cvo.getMname());
		logger.info("cvo.getMimg() >>> : "+cvo.getMimg());
		
		cvo.setMprice(NumUtil.comma_replace(cvo.getMprice()));
		logger.info("cvo.getMprice() >>> : "+cvo.getMprice());
		cvo.setMpricesum(NumUtil.comma_replace(cvo.getMpricesum()));
		logger.info("cvo.getMpricesum() >>> : "+cvo.getMpricesum());
		logger.info("cvo.getMcnum() >>> : "+cvo.getMcnum());
		
		// 회원번호는 따로 받아오지 않았음.
		String kmnum="";
		kmnum="GUEST";
		cvo.setKmnum(kmnum);
		logger.info("cvo.getKmnum() >>> : "+cvo.getKmnum());
		
		// 서비스 호출
		int nCnt = kosmoCartService.kosmoCartInsert(cvo);
		if (nCnt > 0) {
			logger.info("KosmoCartController kosmoCartInsert nCnt >>> : " + nCnt);
			return "cart/kosmoCartInsert";
		}
				
		return "product/kosmoProductSelectAll";
	}
	
	// 카트 목록
	@RequestMapping(value="kosmoCartSelectAll", method=RequestMethod.GET)
	public String kosmoCartSelectAll(KosmoCartVO cvo, Model model){
		logger.info("KosmoCartController :: kosmoCartSelectAll 함수 진입 >>> : ");

		// 서비스 호출
		 // 페이징 처리
		int pageSize=CommonUtils.PRODUCT_PAGE_SIZE;
		logger.info("pageSize >>>> : "+pageSize);
		int groupSize=CommonUtils.PRODUCT_GROUP_SIZE;
		logger.info("groupSize >>> : "+groupSize);
		int curPage=CommonUtils.PRODUCT_CUR_PAGE;
		logger.info("curPage >>> : "+curPage);
		int totalCount=CommonUtils.PRODUCT_TOTAL_COUNT;
		logger.info("totalCount >>> : "+totalCount);
		
		if(cvo.getCurPage()!=null){
			curPage=Integer.parseInt(cvo.getCurPage());
		}
		
		cvo.setPageSize(String.valueOf(pageSize));
		cvo.setGroupSize(String.valueOf(groupSize));
		cvo.setCurPage(String.valueOf(curPage));
		cvo.setTotalCount(String.valueOf(totalCount));
		
		// 서비스 호출
		List<KosmoCartVO> listAll=kosmoCartService.kosmoCartSelectAll(cvo);
		if (listAll.size() > 0) { 
			logger.info("KosmoCartController :: kosmoCartSelectAll listAll.size() >>> : " + listAll.size());
			model.addAttribute("listAll", listAll);
			return "cart/kosmoCartSelectAll";
		}
		return "cart/kosmoCartSelectAll";
	}
	
	
	// 장바구니 비우기
	@RequestMapping(value="kosmoCartDeleteAll", method=RequestMethod.GET)
	public String kosmoCartDelete(@ModelAttribute KosmoCartVO cvo, Model model){
		logger.info("KosmoCartController :: kosmoCartDelete 함수 진입 >>> : ");
		logger.info("KosmoCartController :: cvo.getKmnum() >>> : "+cvo.getKmnum());
		
		int deleteCnt=kosmoCartService.kosmoCartDelete(cvo);
		if(deleteCnt>0){
			logger.info("KosmoCartController ::kosmoCartDelete deleteCnt >>> : "+deleteCnt);
			return "cart/kosmoCartDeleteAll";
		}
		return "cart/kosmoCartDeleteAll";
	}
}
