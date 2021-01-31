/*===========================================================
 * @FileName : 테스트서비스(Rest controller)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-05;백유빈;최초생성
=============================================================*/
package service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.dto.UserInfoDto;
import domain.spec.UserInfoService;

/**
 * @desc TestController.java는 테스트용 Rest Controller이다.
 * @author 백유빈
 * @version 0.1
 */
@Controller
@RequestMapping(path = "/", method = {RequestMethod.GET, RequestMethod.POST})
public class UserInfoController {
	
	private UserInfoService userInfoService;
	
	/**
	 * @desc 생성자
	 * @param testService
	 */
	public UserInfoController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	@GetMapping(value = "/")
	public String loginPage() {
		return "/userInfo/login";
	}
	
	/**
	 * @desc 로그인 기능을 제공하는 메소드이다. 아이디와 비밀번호를 체크하고 페이지를 Return한다.
	 * @param userInfoDto
	 * @param request
	 * @param response
	 * @return String
	 */
	@PostMapping(value = "/login.do") 
	public String loginCheck(@ModelAttribute UserInfoDto userInfoDto, HttpServletRequest request, HttpServletResponse response) {
		String userId = userInfoDto.getUserId();
		String userPw = userInfoDto.getUserPw();
		String resultPage = this.userInfoService.loginCheck(userId, userPw);
		//0: 아이디가 존재하지 않음, 1: Login 성공, 2: 비밀번호가 틀림
		if(resultPage.equals("0")) {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "존재하지 않는 아이디입니다. 관리자에게 문의하세요.");
		}
		if(resultPage.equals("1")) {
			return null;
		}
		if(resultPage.equals("2")) {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "비밀번호가 틀렸습니다. 확인 후 다시 입력하세요.");
		}
		return "/userInfo/login";
	}
	

}
