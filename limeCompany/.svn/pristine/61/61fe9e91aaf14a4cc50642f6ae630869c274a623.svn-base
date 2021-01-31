package main.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping("main.ino")
	public String main(HttpServletRequest request){
		logger.debug("main.ino");
		String admin = (String) request.getSession().getAttribute("admin");
		System.out.println(admin);
		try{
		if(admin.equals("Y")){
			return "redirect:admin/main.ino";
		}
		}catch(Exception e){
			
		}
		
		return "redirect:user/main.ino";
	}
}
