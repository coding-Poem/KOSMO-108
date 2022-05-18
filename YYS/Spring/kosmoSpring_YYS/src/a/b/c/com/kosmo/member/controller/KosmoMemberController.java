package a.b.c.com.kosmo.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.FileUploadUtil;
import a.b.c.com.kosmo.common.service.ChabunService;
import a.b.c.com.kosmo.member.service.KosmoMemberService;
import a.b.c.com.kosmo.member.vo.KosmoMemberVO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;


@Controller
public class KosmoMemberController {
	
	Logger logger = LogManager.getLogger(KosmoMemberController.class);
	
	// 필드 오토와이어드
	@Autowired(required=false)
	private ChabunService chabunService;
	
	@Autowired(required=false)
	private KosmoMemberService kosmoMemberService;
	
	// INSERT FORM importing
	@RequestMapping(value="kosmoMemberInsertForm", method=RequestMethod.GET)
	public String kosmoMemberInsertForm(Model model){
		logger.info("KosmoMemberController :: kosmoMemberInsertForm 함수 진입 >>> :  ");
		return "member/kosmoMemberInsertForm";
	}
	
	// INSERT 
	@RequestMapping(value="kosmoMemberInsert", method=RequestMethod.POST)
	public String kosmoMemberInsert(HttpServletRequest req){
		logger.info("KosmoMemberController :: kosmoMemberInsert 함수 진입 >>> :  ");
		
		// 회원번호 만드는 로직
		List<KosmoMemberVO> kList=null;
		String chanum="";
		String kmnum="";
		String kmhp="";
		String kmemail="";
		kList=chabunService.getKosmoMemberChabun();
		logger.info("kList >>> : "+kList);
		
		logger.info("kList.size() >>> : "+kList.size());
		logger.info("kList.get(0) >>> : "+kList.get(0));
		
		KosmoMemberVO _kmvo=null;
		_kmvo=kList.get(0);
		logger.info("_kvo.getMnum() >>> : "+_kmvo.getKmnum());
		
		chanum=_kmvo.getKmnum();
		logger.info("chanum >>> : "+chanum);
		
		kmnum= ChabunUtil.getKosmoMemberChabun("D", chanum);
		logger.info("회원번호 >>> : "+kmnum);
		
		KosmoMemberVO kmvo=null;
		kmvo=new KosmoMemberVO();
		kmvo.setKmnum(kmnum);
		
		// 이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil(	CommonUtils.MEMBER_IMG_UPLOAD_PATH
			            ,CommonUtils.BOARD_IMG_FILE_SIZE
			            ,CommonUtils.BOARD_EN_CODE);
		boolean bool = fu.imgfileUpload(req);
		logger.info("KosmoProductController :: kosmoMemberInsert 함수 :: bool >>> : "+bool);
		
		kmhp=fu.getParameter("kmhp")+fu.getParameter("kmhp1")+fu.getParameter("kmhp2");
		kmemail=fu.getParameter("kmemail")+"@"+fu.getParameter("kmemail1");
	
		kmvo.setKmid(fu.getParameter("kmid"));
		kmvo.setKmpw(fu.getParameter("kmpw"));
		kmvo.setKmname(fu.getParameter("kmname"));
		kmvo.setKmemail(kmemail);
		kmvo.setKmhp(kmhp);
		kmvo.setKmzone(fu.getParameter("kmzone"));
		kmvo.setKmroad(fu.getParameter("kmroad"));	
		kmvo.setKmroad2(fu.getParameter("kmroad2"));
		kmvo.setKmjibun(fu.getParameter("kmjibun"));
		kmvo.setKmimage(fu.getFileName("kmimage"));			

		
		logger.info("kmvo.getKmnum() >>> : "+kmvo.getKmnum());	
		logger.info("kmvo.getKmid() >>> : "+kmvo.getKmid());
		logger.info("kmvo.getKmpw() >>> : "+kmvo.getKmpw());
		logger.info("kmvo.getKmname() >>> : "+kmvo.getKmname());
		logger.info("kmvo.getKmhp() >>> : "+kmvo.getKmhp());
		logger.info("kmvo.getKmemail() >>> : "+kmvo.getKmemail());
		logger.info("kmvo.getKmzone() >>> : "+kmvo.getKmzone());
		logger.info("kmvo.getKmroad() >>> : "+kmvo.getKmroad());
		logger.info("kmvo.getKmroad2() >>> : "+kmvo.getKmroad2());
		logger.info("kmvo.getKmjibun() >>> : "+kmvo.getKmjibun());
		logger.info("kmvo.getKmimage() >>> : "+kmvo.getKmimage());
		
		int nCnt=kosmoMemberService.kosmoMemberInsert(kmvo);
		logger.info("KosmoMemberController :: kosmoMemberInsert nCnt >>> : "+nCnt);
		
		if (nCnt > 0) { return "member/kosmoMemberInsert";}
		
		return "member/kosmoMemberInsertForm";
	}
	
	// SELECT ALL
	@RequestMapping(value="kosmoMemberSelectAll", method=RequestMethod.GET)
	public String kosmoMemberSelectAll(KosmoMemberVO kmvo, Model model){
		logger.info("KosmoMemberController :: kosmoMemberSelectAll 함수 진입 >>> :  ");
		
		// 페이징 처리
		int pageSize=CommonUtils.PRODUCT_PAGE_SIZE;
		logger.info("pageSize >>>> : "+pageSize);
		int groupSize=CommonUtils.PRODUCT_GROUP_SIZE;
		logger.info("groupSize >>> : "+groupSize);
		int curPage=CommonUtils.PRODUCT_CUR_PAGE;
		logger.info("curPage >>> : "+curPage);
		int totalCount=CommonUtils.PRODUCT_TOTAL_COUNT;
		logger.info("totalCount >>> : "+totalCount);
		
		if(kmvo.getCurPage()!=null){
			curPage=Integer.parseInt(kmvo.getCurPage());
		}
		
		kmvo.setPageSize(String.valueOf(pageSize));
		kmvo.setGroupSize(String.valueOf(groupSize));
		kmvo.setCurPage(String.valueOf(curPage));
		kmvo.setTotalCount(String.valueOf(totalCount));
		
		// 서비스 호출
		List<KosmoMemberVO> listAll=kosmoMemberService.kosmoMemberSelectAll(kmvo);
		
		int nCnt=listAll.size();
		logger.info("KosmoProductController :: kosmoProductSelectAll nCnt >>> : "+nCnt);
		
		if(listAll.size() >0){
			logger.info("listAll.size() >>> : "+listAll.size());
			model.addAttribute("pagingKMVO", kmvo);
			model.addAttribute("listAll", listAll);
			return "member/kosmoMemberSelectAll";
		}
		
		return "member/kosmoMemberInsertForm";
	}
	
	
};
