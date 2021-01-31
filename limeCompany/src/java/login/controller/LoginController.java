package login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import login.service.LoginService;
import login.vo.UserVO;

@Controller
public class LoginController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("login.ino")
	public String login(HttpServletRequest request){		
		logger.debug("login.ino");
		return "login/login";
	}
	
	@RequestMapping("loginTry.ino")
	public ModelAndView loginTry(HttpServletRequest request, UserVO userVO){
		logger.debug("loginTry.ino");
		ModelAndView mav  =new ModelAndView();
		//login 확인 id체크 session체크
		System.out.println(userVO.toString());
		//조회한 회원정보
		UserVO user = loginService.getUser(userVO);
		
		String pw = request.getParameter("pw");
		String message = "";		
		if(user ==null){ //아이디로 검색한 결과가 없을경우 ..
			message = "아이디를 확인해주세요.";		
			mav.addObject("message", message);
			mav.setViewName("login/login");
		}else if(pw.equals(user.getPw())){
			//로그인성공시 실패카운트 초기화
			userVO.setFailCnt(0);
			loginService.modifyUser(userVO);
			
			if(user.getResetYn().equals("Y")){
				//리셋여부확인하여 패스워드 변경폼으로 이동
				mav.setViewName("login/resetPassword");
				mav.addObject("id",userVO.getId());
			}else{
			//성공시 메인으로 redirect , 세션에 아이디 저장.
				request.getSession().setAttribute("id", user.getId());
				request.getSession().setAttribute("admin", user.getAdminYn());
				mav.setViewName("redirect:main.ino");
			}
		}else{
			//실패시 다시 로그인창으로
			int failCnt = user.getFailCnt();
			if(failCnt<5){//실패카운트 체크
				failCnt++;
				message = "로그인에 "+failCnt+"회 실패하셨습니다. 남은 횟수는 "+(5-failCnt)+"회 입니다.";
				//실패횟수 추가
				loginService.addFailCnt(userVO);
				mav.addObject(userVO);
			}else{
				message = "로그인에 5회 실패하여 계정이 잠금 되었습니다. 관리자에게 문의해주세요.";
			}
			mav.addObject("message", message);
			mav.setViewName("login/login");
		}		
		return mav;		
	}
	
	@RequestMapping("logout.ino")
	public String logout(HttpServletRequest request){
		logger.debug("logout.ino");
		request.getSession().removeAttribute("id");
		request.getSession().removeAttribute("admin");
		return "redirect:main.ino";
	}
	
	//비밀번호 변경
	@RequestMapping("changePass.ino")
	public String changePass(HttpServletRequest request, UserVO userVO){
		System.out.println("changePass.ino");
		userVO.setFailCnt(0);
		userVO.setResetYn("N");		
		System.out.println(userVO.toString());
		loginService.modifyUser(userVO);		
		return "redirect:login.ino";
	}
	
	//비밀번호 변경
	@RequestMapping("passReset.ino")
	public void resetPassRequest(HttpServletRequest request, UserVO userVO){
		System.out.println("resetPassRequest.ino");
		System.out.println(userVO.toString());
		loginService.modifyUser(userVO);		
	}
	
}
