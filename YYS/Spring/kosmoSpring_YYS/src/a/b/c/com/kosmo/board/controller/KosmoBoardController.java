package a.b.c.com.kosmo.board.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.kosmo.board.service.KosmoBoardService;
import a.b.c.com.kosmo.board.vo.KosmoBoardVO;
import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.FileUploadUtil;
import a.b.c.com.kosmo.common.service.ChabunService;


@Controller
public class KosmoBoardController {
	Logger logger=LogManager.getLogger(KosmoBoardController.class);
	
	// 필드 오토와이드
	@Autowired(required=false)
	private ChabunService chabunService;
	
	
	@Autowired(required=false)
	private KosmoBoardService kosmoBoardService;
	
	
	// 게시판 글쓰기 폼
	@RequestMapping(value="kosmoBoardInsertForm", method=RequestMethod.GET)
	public String kosmoBoardInsertForm(){
		logger.info("KosmoBoardController :: kosmoBoardInsertForm 함수 진입 >>> : ");
		return "board/kosmoBoardInsertForm";
	}
	
	// 게시판 입력
	@RequestMapping(value="kosmoBoardInsert", method=RequestMethod.POST)
	public String kosmoBoardInsert(HttpServletRequest req){
		logger.info("KosmoBoardController :: kosmoBoardInsert 함수 진입 >>> : ");
		
		// 채번 구하기
		List<KosmoBoardVO> bList=null;
		String chanum="";
		String kbnum="";
		
		bList=chabunService.getKosmoBoardChabun();
		logger.info("bList >>> : "+bList);
		logger.info("bList.size() >>> : "+bList.size());
		logger.info("bList.get(0) >>> : "+bList.get(0));
		
		
		KosmoBoardVO _bvo=null;
		_bvo=bList.get(0);
		
		chanum=_bvo.getKbnum();
		logger.info("chanum >>> : "+chanum);
		
		kbnum=ChabunUtil.getKosmoBoardChabun("D", chanum);
		logger.info("게시판 번호 >>> : "+kbnum);
		
		KosmoBoardVO bvo=null;
		bvo=new KosmoBoardVO();
		bvo.setKbnum(kbnum);
		
		// 이미지 업로드
		FileUploadUtil fu=new FileUploadUtil(CommonUtils.BOARD2_IMG_UPLOAD_PATH
                ,CommonUtils.BOARD2_IMG_FILE_SIZE
                ,CommonUtils.BOARD2_EN_CODE);
				
		// 이미지 파일 원본 사이즈
		boolean bool=fu.imgfileUpload(req);
		logger.info("KosmoBoardController :: kosmoBoardInsert :: bool >>> : "+bool);
		
		bvo.setKbsubject(fu.getParameter("kbsubject"));
		bvo.setKbname(fu.getParameter("kbname"));
		bvo.setKbpw(fu.getParameter("kbpw"));
		bvo.setKbcontent(fu.getParameter("kbcontent"));
		bvo.setKbfile(fu.getFileName("kbfile"));
		
		logger.info("bvo.getKbsubject() >>> : "+bvo.getKbsubject());
		logger.info("bvo.getKbname() >>> : "+bvo.getKbname());
		logger.info("bvo.getKbpw() >>> : "+bvo.getKbpw());
		logger.info("bvo.getKbcontent() >>> : "+bvo.getKbcontent());
		logger.info("bvo.getKbfile() >>> : "+bvo.getKbfile());
		
		// 서비스 호출
		int nCnt=kosmoBoardService.kosmoBoardInsert(bvo);
		logger.info("KosmoBoardController :: kosmoBoardInsert :: nCnt >>> : "+nCnt);
		
		if(nCnt>0) {return "board/kosmoBoardInsert";}
		
		return "board/kosmoBoardInsertForm";
	}
	
	// 게시판 전체 조회
	@RequestMapping(value="kosmoBoardSelectAll", method=RequestMethod.GET)
	public String kosmoBoardSelectAll(KosmoBoardVO bvo, Model model){
		logger.info("KosmoBoardController :: kosmoBoardSelectAll 함수 진입 >>> : ");
		
		// 서비스 호출
		List<KosmoBoardVO> listAll=kosmoBoardService.kosmoBoardSelectAll(bvo);
		if(listAll.size()>0) {
			logger.info("KosmoBoardController :: kosmoBoardSelectAll :: listAll.size() >>> : "+listAll.size());
			model.addAttribute("listAll", listAll);
			return "board/kosmoBoardSelectAll";
		}
		return "board/kosmoBoardSelectAll";
	}
	
	// 게시판 선택 조회
	@RequestMapping(value="kosmoBoardSelect", method=RequestMethod.GET)
	public String kosmoBoardSelect(KosmoBoardVO bvo, Model model){
		logger.info("KosmoBoardController :: kosmoBoardSelect 함수 진입 >>> : ");
		logger.info("KosmoBoardController kosmoBoardSelect ::  bvo.getKbnum() >>> : " + bvo.getKbnum());
		
		// 서비스 호출
		List<KosmoBoardVO> listS=kosmoBoardService.kosmoBoardSelect(bvo);
		if(listS.size()==1){
			logger.info("KosmoBoardController :: kosmoBoardSelect listS >>> : "+listS);
			model.addAttribute("listS", listS);
			return "board/kosmoBoardSelect";
		}
		return "board/kosmoBoardSelect";
	}
	
	// 패스워드 체크하기
	@RequestMapping(value="kosmoBoardPwCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object kosmoBoardPwCheck(KosmoBoardVO bvo){
		logger.info("KosmoBoardController :: kosmoBoardPwCheck 함수 진입 >>> :  ");
		logger.info("KosmoBoardController :: bvo.getKbnum() >>> : "+bvo.getKbnum());
		logger.info("KosmoBoardController :: bvo.getKbpw() >>> : "+bvo.getKbpw());
		
		List<KosmoBoardVO> list=kosmoBoardService.kosmoBoardPwCheck(bvo);
		logger.info("KosmoBoardController :: kosmoBoardPwCheck :: list.size() >>> : "+list.size());
		
		String msg="";
		if(list.size()==1) {msg="ID_YES";}
		else {msg="ID_NO";}
		
		return msg;
	}
	
	// 게시판 수정
	
}
