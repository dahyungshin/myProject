package user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import common.service.CommonService;
import login.vo.CodeVO;
import login.vo.AttendanceVO;
import user.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MappingJackson2JsonView jsonView; 
	
	@RequestMapping("/main.ino")
	public ModelAndView main(HttpServletRequest request, CodeVO codeVO){
		logger.debug("/user/main.ino");
		System.out.println("/user/main.ino");
		ModelAndView mav = new ModelAndView();	
		
		List<CodeVO> codeList = commonService.getCodeList(codeVO);
		
		mav.addObject("codeList",codeList);
		
		mav.setViewName("/user/main");
		return mav;
	}
	
	
	@RequestMapping("/getAttendanceList.ino")
	public ModelAndView getAttendanceList(HttpServletRequest request, AttendanceVO punctualityVO){
		String id = (String) request.getSession().getAttribute("id");//로그인된 아이디
		punctualityVO.setUserId(id);
		
		List<AttendanceVO> list = userService.getAttendanceList(punctualityVO);
		if(list.size()>0)
		list.get(0).setMax(userService.getAttendanceCount(punctualityVO));
		
		ModelAndView mav = new ModelAndView(jsonView);
		mav.addObject("punctualityList",list);
		return mav;
	}
	
	//휴가 신청 폼
	@RequestMapping("/newAttendance.ino")
	public ModelAndView newAttendance(HttpServletRequest request){
		String id = (String) request.getSession().getAttribute("id");
		ModelAndView mav = new ModelAndView();
		CodeVO codeVO = new CodeVO();
		List<CodeVO> codeList = commonService.getCodeList(codeVO);
		mav.addObject("codeList",codeList);
		mav.addObject("id",id);
		mav.setViewName("/user/newAttendance");
		return mav;
	}
	
	//휴가작성
	@RequestMapping("/writeAttendance.ino")
	public ModelAndView writeAttendance(HttpServletRequest request, AttendanceVO punctualityVO){
		ModelAndView mav = new ModelAndView();
		userService.writeAttendance(punctualityVO);
		mav.setViewName("redirect:/user/main.ino");
		return mav;
	}
	
	
}
