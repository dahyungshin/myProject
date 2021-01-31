package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import admin.service.AdminService;
import common.service.CommonService;
import login.vo.CodeVO;
import login.vo.AttendanceVO;
import login.vo.UserVO;

@Controller
@RequestMapping("/admin")
public class AdminController{
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MappingJackson2JsonView jsonView; 
	
	@RequestMapping("/main.ino")
	public ModelAndView main(HttpServletRequest request,CodeVO codeVO){
		logger.debug("/admin/main.ino");
		System.out.println("/admin/main.ino");
		ModelAndView mav = new ModelAndView();	
		
		
		List<CodeVO> codeList = commonService.getAdminCodeList(codeVO);
		mav.addObject("codeList",codeList);
		
		mav.setViewName("/admin/main");
		return mav;
	}
	
	@RequestMapping("/joinPop.ino")
	public ModelAndView joinForm(HttpServletRequest request){
		System.out.println("/admin/joinPop.ino");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/joinPop");
		return mav;
	}
	
	@RequestMapping("/duplicateChk.ino")
	public ModelAndView duplicateChk(HttpServletRequest request, UserVO userVO){
		ModelAndView mav = new ModelAndView(jsonView);
		mav.addObject("id",adminService.duplicateChk(userVO).getId());
		return mav;
	}
	
	//조회
	@RequestMapping("/getAttendanceList.ino")
	public ModelAndView getPuncuality(AttendanceVO punctualityVO){
		ModelAndView mav = new ModelAndView(jsonView);
		System.out.println("/getAttendanceList.ino");
		List<AttendanceVO> punctualityList = adminService.getAttendanceList(punctualityVO);
		if(punctualityList.size()>0)
			punctualityList.get(0).setMax(adminService.getAttendanceCount(punctualityVO));
		mav.addObject("punctualityList",punctualityList);
		return mav;
	}
	
	//결재, 반려
	@RequestMapping("/approval.ino")
	public ModelAndView approval(AttendanceVO punctualityVO){
		System.out.println("/approval.ino");
		System.out.println(punctualityVO.toString());
		ModelAndView mav = new ModelAndView(jsonView);
		int result = adminService.updateAttendance(punctualityVO);
		mav.addObject("result",result);
		return mav;
	}
	
	@RequestMapping("/join.ino")
	public ModelAndView join(UserVO userVO){
		System.out.println("/join.ino"+userVO.toString());
		ModelAndView mav = new ModelAndView(jsonView);
		int result = adminService.joinUser(userVO);
		mav.addObject("result",result);
		return mav;
	}
	
	
	@RequestMapping("/getUserList.ino")
	public ModelAndView getUserList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView(jsonView);
		int max =0;
		List list = adminService.getUserList();
		if(list.size()>0){
			max = adminService.getUserCnt();
		}
		mav.addObject("userList",list);
		mav.addObject("max",max);
		return mav;		
	}
	
	
}
