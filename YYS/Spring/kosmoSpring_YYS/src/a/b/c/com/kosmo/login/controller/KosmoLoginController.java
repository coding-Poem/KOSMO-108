package a.b.c.com.kosmo.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.login.service.KosmoLoginService;
import a.b.c.com.kosmo.member.vo.KosmoMemberVO;

@Controller
public class KosmoLoginController {
	Logger logger = LogManager.getLogger(KosmoLoginController.class);
	
	// 필드 오토와이어드
	@Autowired(required=false)
	private KosmoLoginService kosmoLoginService;
	
	// 로그인 폼
	@RequestMapping(value="kosmoLoginForm", method=RequestMethod.GET)
	public String kosmoLoginForm() {
		logger.info("KosmoLoginController kosmoLoginForm 함수 진입 >>> : ");	
		return "login/kosmoLoginForm";
	}
	
	// 로그인
	@RequestMapping(value="kosmoLoginCheck", method=RequestMethod.GET)
	public String kosmoLoginCheck(HttpServletRequest req, KosmoMemberVO mvo, Model model){
		logger.info("KosmoLoginController :: kosmoLoginCheck 함수 진입 >>> : ");
				
		// 서비스 호출
		List<KosmoMemberVO> listLogin=kosmoLoginService.kosmoLoginCheck(mvo);
		
		
		
		
		return "login/kosmoLoginForm";
	}
	
}
