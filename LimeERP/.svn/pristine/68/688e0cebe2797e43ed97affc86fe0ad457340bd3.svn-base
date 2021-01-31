/*===========================================================
 * @FileName : 테스트서비스(Rest controller)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-05;백유빈;최초생성
=============================================================*/
package service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.dto.TestDto;
import domain.spec.TestService;

/**
 * @desc TestController.java는 테스트용 Rest Controller이다.
 * @author 백유빈
 * @version 0.1
 */
@Controller
@RequestMapping(path = "/test", method = {RequestMethod.GET, RequestMethod.POST})
public class TestController {
	
	private TestService testService;
	
	/**
	 * @desc 생성자
	 * @param testService
	 */
	public TestController(TestService testService) {
		this.testService = testService;
	}

	/**
	 * @desc 테스트용 페이지를 반환하는 메소드이다.
	 * @return String
	 */
	@GetMapping(value = "/")
	public String test() {
		return this.testService.test();
	}
	
	/**
	 * @desc 회원명과 회원아이디(PK)로 회원정보를 조회하는 메소드이다.
	 * @return String (jsp 파일 이름)
	 */
	@PostMapping(value = "/find")
	public String findDto() {
		//실제로는 View에서 넘어온 값을 @ModelAttribute로 받아서 처리하지만 현재는 View 페이지가 존재하지않아서 DTO를 생성해서 테스트합니다.
		TestDto dto = new TestDto();
		this.testService.find(dto);
		//화면이 구성되면 조회된 DTO를 HttpServletRequest에 setAtrribute하고, JSP 파일명(String)을 리턴하는 형식으로 Logic을 구현하면 됩니다. 
		return null;
	}
	
	@PostMapping(value = "/register")
	public String register() {
		//실제로는 View에서 넘어온 값을 @ModelAttribute로 받아서 처리하지만 현재는 View 페이지가 존재하지않아서 DTO를 생성해서 테스트합니다.
		TestDto dto = new TestDto();
		this.testService.register(dto);
		//화면이 구성되면 JSP 파일명(String)을 리턴하는 형식으로 Logic을 구현하면 됩니다. 
		return null;

	}
}
