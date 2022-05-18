package a.b.c.com.kosmo.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.FileUploadUtil;
import a.b.c.com.kosmo.common.service.ChabunService;
import a.b.c.com.kosmo.product.service.KosmoProductService;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;


@Controller
public class KosmoProductController {
		Logger logger = LogManager.getLogger(KosmoProductController.class);
		
		// 필드 오토와이드
		// 컨트롤러에서 서비스 연결
		@Autowired(required=false)
		private KosmoProductService kosmoProductService;
		@Autowired(required=false)
		private ChabunService chabunService;
		
		/*
		// 생성자에 @Autowired 어노테이션으로 DI(의존성 주입하기)
		@Autowired(required=false)
		public KosmoProductController(KosmoProductService kosmoProductService, ChabunService chabunService){
			this.kosmoProductService=kosmoProductService;
			this.chabunService=chabunService;
		}
		*/
		
		
		// INSERT FORM importing
		@RequestMapping(value="kosmoProductInsertForm", method=RequestMethod.GET)
		public String kosmoProductInsertForm(Model model){
			logger.info("KosmoProductController :: kosmoProductInsertForm 함수 진입 >>> : ");
			return "product/kosmoProductInsertForm";
		}
		
		
		// INSERT 
		@RequestMapping(value="kosmoProductInsert", method=RequestMethod.POST)
		public String kosmoProductInsert(HttpServletRequest req){
			//KosmoProductVO kvo, Model model 
			// HttpServletRequest req
			logger.info("KosmoProductController :: kosmoProductInsert 함수 진입 >>> : ");
			
			// 상품번호 만드는 로직
			List<KosmoProductVO> cList=null;
			String chanum="";
			String mnum="";
			
			cList=chabunService.getKosmoProductChabun();
			logger.info("cList >>> : "+cList);
			logger.info("cList.size() >>> : "+cList.size());
			logger.info("cList.get(0) >>> : "+cList.get(0));
			
			
			KosmoProductVO _kvo=null;
			_kvo=cList.get(0);
			logger.info("_kvo.getMnum() >>> : "+_kvo.getMnum());
			
			chanum=_kvo.getMnum();
			logger.info("chanum >>> : "+chanum);
			// chanum >>> : 1
			
												   
			mnum= ChabunUtil.getKosmoProductChabun("D", chanum);
			// mnum="채번쿼리";
			logger.info("상품번호 >>> : "+mnum);
			// 상품번호 >>> : M202205130001
			KosmoProductVO kvo=null;
			kvo=new KosmoProductVO();
			kvo.setMnum(mnum);
			
			// 이미지 업로드 
			FileUploadUtil fu = new FileUploadUtil(	CommonUtils.BOARD_IMG_UPLOAD_PATH
                    ,CommonUtils.BOARD_IMG_FILE_SIZE
                    ,CommonUtils.BOARD_EN_CODE);
			boolean bool = fu.imgfileUpload(req);
			logger.info("KosmoProductController :: kosmoProductInsert 함수 :: bool >>> : "+bool);
			
			kvo.setMid(fu.getParameter("mid"));
			kvo.setMcnt(fu.getParameter("mcnt"));
			kvo.setMname(fu.getParameter("mname"));
			kvo.setMprice(fu.getParameter("mprice"));
			kvo.setMdes(fu.getParameter("mdes"));
			kvo.setMcom(fu.getParameter("mcom"));
			kvo.setMimg(fu.getFileName("mimg"));		
			
			
			logger.info("kvo.getMnum() >>> : "+kvo.getMnum());
			logger.info("kvo.getMid() >>> : "+kvo.getMid());
			logger.info("kvo.getMcnt() >>> : "+kvo.getMcnt());
			logger.info("kvo.getMname() >>> : "+kvo.getMname());
			logger.info("kvo.getMprice() >>> : "+kvo.getMprice());
			logger.info("kvo.getMdes() >>> : "+kvo.getMdes());
			logger.info("kvo.getMcom() >>> : "+kvo.getMcom());
			logger.info("kvo.getMimg() >>> : "+kvo.getMimg());
			
			
			int nCnt=kosmoProductService.kosmoProductInsert(kvo);
			logger.info("KosmoProductController :: kosmoProductInsert nCnt >>> : "+nCnt);
			
			if (nCnt > 0) { return "product/kosmoProductInsert";}
			
			return "product/kosmoProductInsertForm";
		}
		
		
		// SELECT ALL :: 상품 목록 페이징 조회
		@RequestMapping(value="kosmoProductSelectAll", method=RequestMethod.GET)
		public String kosmoProductSelectAll(KosmoProductVO kvo, Model model){
			logger.info("KosmoProductController :: kosmoProductSelectAll 함수 진입 >>> : ");
			
			// 페이징 처리
			int pageSize=CommonUtils.PRODUCT_PAGE_SIZE;
			logger.info("pageSize >>>> : "+pageSize);
			int groupSize=CommonUtils.PRODUCT_GROUP_SIZE;
			logger.info("groupSize >>> : "+groupSize);
			int curPage=CommonUtils.PRODUCT_CUR_PAGE;
			logger.info("curPage >>> : "+curPage);
			int totalCount=CommonUtils.PRODUCT_TOTAL_COUNT;
			logger.info("totalCount >>> : "+totalCount);
			
			if(kvo.getCurPage()!=null){
				curPage=Integer.parseInt(kvo.getCurPage());
			}
			
			kvo.setPageSize(String.valueOf(pageSize));
			kvo.setGroupSize(String.valueOf(groupSize));
			kvo.setCurPage(String.valueOf(curPage));
			kvo.setTotalCount(String.valueOf(totalCount));
			
			logger.info("kvo.getPageSize() >>> : "+kvo.getPageSize());
			logger.info("kvo.getGroupSize() >>> : "+kvo.getGroupSize());
			logger.info("kvo.getCurPage() >>> : "+kvo.getCurPage());
			logger.info("kvo.setTotalCount() >>> : "+kvo.getTotalCount());
			
			// 서비스 호출
			List<KosmoProductVO> listAll=kosmoProductService.kosmoProductSelectAll(kvo);
			int nCnt=listAll.size();
			logger.info("KosmoProductController :: kosmoProductSelectAll nCnt >>> : "+nCnt);
			
			if(listAll.size() >0){
				logger.info("listAll.size() >>> : "+listAll.size());
				model.addAttribute("pagingKVO", kvo);
				model.addAttribute("listAll", listAll);
				return "product/kosmoProductSelectAll";
			}
			
			return "product/kosmoProductInsertForm";
		}
		
		
		// SELECT FORM
		@RequestMapping(value="kosmoProductSelectForm", method=RequestMethod.GET)
		public String kosmoProductSelectForm(@ModelAttribute KosmoProductVO kvo, Model model){
			logger.info("KosmoProductController :: kosmoProductSelectForm 함수 진입 >>> : ");
			
			return "product/kosmoProductSelectForm";
		}
		
		// SELECT
		@RequestMapping(value="kosmoProductSelect", method=RequestMethod.GET)
		public String kosmoProductSelect(@ModelAttribute KosmoProductVO kvo, Model model){
			logger.info("KosmoProductController :: kosmoProductSelect 함수 진입 >>> : ");
			logger.info("KosmoProductController :: kvo.getSearchFilter() >>> : "+kvo.getSearchFilter());
			logger.info("KosmoProductController :: kvo.getKeyword() >>> : "+kvo.getKeyword());
			logger.info("KosmoProductController :: kvo.getStartDate() >>> : "+kvo.getStartDate());
			logger.info("KosmoProductController :: kvo.getEndDate() >>> : "+kvo.getEndDate());
			
			List<KosmoProductVO> searchList =kosmoProductService.kosmoProductSelect(kvo);
			int nCnt=searchList.size();
			logger.info("KosmoProductController :: kosmoProductSelect nCnt >>> : "+nCnt);
			
			if(nCnt>0){
				model.addAttribute("searchList", searchList);
				return "product/kosmoProductSelect";
			}
			
			return "product/kosmoProductSelectForm";
		}
		
		// SELECT Merchandise
		@RequestMapping(value="kosmoProductMSelect", method=RequestMethod.GET)
		public String kosmoProductMSelect(KosmoProductVO kvo, Model model){
			logger.info("KosmoProductController :: kosmoProductMSelect 함수 진입 >>> : ");
			logger.info("KosmoProductController :: kvo.getMnum() >>> : "+kvo.getMnum());
			
			List<KosmoProductVO> listS=kosmoProductService.kosmoProductMSelect(kvo);
			if (listS.size() > 0) { 
				logger.info("KosmoProductController ::  listS.size() >>> : "+listS.size());
				model.addAttribute("listS", listS);
				return "product/kosmoProductMSelect";
			}
			return "product/kosmoProductSelectAll";
		}
		
		
		// Update FORM
		@RequestMapping(value="kosmoProductUpdateForm", method=RequestMethod.GET)
		public String kosmoProductUpdateForm(@ModelAttribute KosmoProductVO kvo, Model model){
			logger.info("KosmoProductController :: kosmoProductUpdateForm 함수 진입 >>> : ");
			
			return "product/kosmoProductUpdateForm";
		}
		
		// Update
		@RequestMapping(value="kosmoProductUpdate", method=RequestMethod.POST)
		public String kosmoProductUpdate(HttpServletRequest req){
			logger.info("KosmoProductController :: kosmoProductUpdate 함수 진입 >>> : ");
			
			FileUploadUtil fu = new FileUploadUtil(	CommonUtils.BOARD_IMG_UPLOAD_PATH
                    ,CommonUtils.BOARD_IMG_FILE_SIZE
                    ,CommonUtils.BOARD_EN_CODE);
			boolean bool = fu.imgfileUpload(req);
			logger.info("KosmoProductController :: kosmoProductUpdate 함수 :: bool >>> : "+bool);
			
			KosmoProductVO kvo=null;
			kvo=new KosmoProductVO();
			
			kvo.setMnum(fu.getParameter("mnum"));
			kvo.setMid(fu.getParameter("mid"));
			kvo.setMcnt(fu.getParameter("mcnt"));
			kvo.setMname(fu.getParameter("mname"));
			kvo.setMprice(fu.getParameter("mprice"));
			kvo.setMdes(fu.getParameter("mdes"));
			kvo.setMcom(fu.getParameter("mcom"));
			kvo.setMimg(fu.getFileName("mimg"));		
			
			
			logger.info("kvo.getMnum() >>> : "+kvo.getMnum());
			logger.info("kvo.getMid() >>> : "+kvo.getMid());
			logger.info("kvo.getMcnt() >>> : "+kvo.getMcnt());
			logger.info("kvo.getMname() >>> : "+kvo.getMname());
			logger.info("kvo.getMprice() >>> : "+kvo.getMprice());
			logger.info("kvo.getMdes() >>> : "+kvo.getMdes());
			logger.info("kvo.getMcom() >>> : "+kvo.getMcom());
			logger.info("kvo.getMimg() >>> : "+kvo.getMimg());
			
			
			int nCnt=kosmoProductService.kosmoProductUpdate(kvo);
			logger.info("KosmoProductController :: kosmoProductUpdate nCnt >>> : "+nCnt);
			
			if (nCnt > 0) { return "product/kosmoProductUpdate";}
			
			return "product/kosmoProductUpdateForm";
		}
		
		// Delete Form
		// kosmoProductDeleteForm.yys
		@RequestMapping(value="kosmoProductDeleteForm", method=RequestMethod.GET)
		public String kosmoProductDeleteForm(@ModelAttribute KosmoProductVO kvo, Model model){
			logger.info("KosmoProductController :: kosmoProductDeleteForm 함수 진입 >>> : ");
			
			return "product/kosmoProductDeleteForm";
		}
		
		@RequestMapping(value="kosmoProductDelete", method=RequestMethod.GET)
		public String kosmoProductDelete(@ModelAttribute KosmoProductVO kvo, Model model){
			logger.info("KosmoProductController :: kosmoProductDelete 함수 진입 >>> : ");
			logger.info("KosmoProductController :: kvo.getMnum() >>> : "+kvo.getMnum());
			
			int deleteCnt=kosmoProductService.kosmoProductDelete(kvo);
			if(deleteCnt>0){
				logger.info("KosmoProductController :: deleteCnt  >>> : "+deleteCnt);
				
				model.addAttribute("deleteCnt", new Integer(deleteCnt));
				return "product/kosmoProductDelete";
			}
			
			return "product/kosmoProductDeleteForm";
		}
}
