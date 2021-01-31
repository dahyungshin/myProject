package ino.web.freeBoard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.dto.SearchDTO;
import ino.web.freeBoard.service.FreeBoardService;
import ino.web.paging.PagingDTO;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("main.ino")
	public ModelAndView main(HttpServletRequest request,@RequestParam(value="cp" , defaultValue="1") int cp , ModelMap map){
		ModelAndView mav = new ModelAndView();
		int ListSize = 15;
		int PageSize = 10;
		int StartList = (cp-1) * ListSize +1;
		int EndList = StartList+ListSize - 1;
		map.put("StartList", StartList);
		map.put("EndList", EndList);
		int TotalCnt = freeBoardService.TotalCnt();
		String paging = ino.web.paging.PagingDTO.PagingMaker(cp, TotalCnt, ListSize, PageSize , "main.ino");
		List list = freeBoardService.freeBoardList(map);
		mav.addObject("freeBoardList",list); 
		mav.addObject("paging",paging); 
		mav.setViewName("boardMain"); 
	return mav; 
	}
	
	@RequestMapping("/freeBoardInsert.ino")
	public String freeBoardInsert(){
		return "freeBoardInsert";
	}
	
	@RequestMapping("/freeBoardInsertPro.ino")
	public String freeBoardInsertPro( FreeBoardDto dto){
		ModelAndView mav = new ModelAndView();
		
		freeBoardService.freeBoardInsertPro(dto);
		
		 System.out.println("num : " + dto.getNum()); 
		return "redirect:freeBoardDetail.ino?num="+dto.getNum(); 
	}
	
	@RequestMapping("/freeBoardDetail.ino")
	public ModelAndView freeBoardDetail(HttpServletRequest request){
		
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);

		System.out.println(dto.toString());
		 
		return new ModelAndView("freeBoardDetail", "freeBoardDto", dto);
	}
	
	@RequestMapping("/freeBoardModify.ino") 
	public ModelAndView freeBoardModify(HttpServletRequest request){ 
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);
		return new ModelAndView("freeBoardModify", "freeBoardDto", dto);
	} 
	
	@RequestMapping("/freeBoardModifyPro.ino")
	public ModelAndView freeBoardModifyPro(HttpServletRequest request){
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		FreeBoardDto dto = new FreeBoardDto();
		dto.setName(name);
		dto.setContent(content);
		dto.setNum(num);
		int count = freeBoardService.freeBoardModify(dto);
		if(count > 0){	
			FreeBoardDto ndto = freeBoardService.getDetailByNum(num);
			return new ModelAndView("freeBoardModify","freeBoardDto", ndto);
		}else{
			return null;
		}
		
		
	}
	
	@RequestMapping("/freeBoardDelete.ino")
	public String freeBoardDelete(@RequestParam("num") int num){
		int count = freeBoardService.freeBoardDelete(num);
		if(count > 0){
			return "redirect:main.ino";	
		}else{
			return null; 
		}
		 
	}
	
	@RequestMapping("/freeBoard_Search.ino")
	public ModelAndView freeBoard_Search(SearchDTO sdto , @RequestParam(value="cp" , defaultValue="1") int cp , ModelMap map ){
		ModelAndView mav = new ModelAndView();
		int ListSize = 15;
		int PageSize = 10;
		int StartList = (cp-1) * ListSize +1;
		int EndList = cp*ListSize;
		String type = sdto.getType();
		String SearchText = sdto.getSearchText();
		map.put("StartList", StartList);
		map.put("EndList", EndList);
		System.out.println("StartList : "+StartList);
		System.out.println("EndList : "+EndList); 
		map.put("type",type);
		map.put("SearchText", SearchText);
		List list = freeBoardService.SearchTextList(map);
		int SearchTotalCnt = freeBoardService.SearchTotalCnt(map);
		System.out.println("TotalCnt : "+SearchTotalCnt);
		String paging = ino.web.paging.PagingDTO.SearchPagingMaker(cp, SearchTotalCnt, ListSize, PageSize, type, SearchText , "main.ino");
		mav.addObject("paging", paging);
		mav.setViewName("boardMain"); 
		mav.addObject("freeBoardList",list); 
		return mav; 
	}
	
	
	
} 
