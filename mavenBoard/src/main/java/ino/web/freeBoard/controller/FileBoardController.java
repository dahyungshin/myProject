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
public class FileBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("filemain.ino")
	public ModelAndView main(HttpServletRequest request,@RequestParam(value="cp" , defaultValue="1") int cp , ModelMap map ){
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
		mav.setViewName("fileMain"); 
	return mav; 
	}
	
	@RequestMapping("/fileBoardInsert.ino")
	public String freeBoardInsert(){
		return "freeBoardInsert";
	}
	
	@RequestMapping("/fileBoardInsertPro.ino")
	public String freeBoardInsertPro( FreeBoardDto dto){
		ModelAndView mav = new ModelAndView();
		
		freeBoardService.freeBoardInsertPro(dto);
		
		 System.out.println("num : " + dto.getNum()); 
		return "redirect:fileBoardDetail.ino?num="+dto.getNum(); 
	}
	
	@RequestMapping("/fileBoardDetail.ino")
	public ModelAndView freeBoardDetail(HttpServletRequest request){
		
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);

		System.out.println(dto.toString());
		 
		return new ModelAndView("fileBoardDetail", "freeBoardDto", dto);
	}
	
	@RequestMapping("/fileBoardModify.ino") 
	public ModelAndView freeBoardModify(HttpServletRequest request){ 
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);
		return new ModelAndView("fileBoardModify", "freeBoardDto", dto);
	} 
	
	@RequestMapping("/fileBoardModifyPro.ino")
	public ModelAndView file(HttpServletRequest request){
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
			return new ModelAndView("fileBoardModify","freeBoardDto", ndto);
		}else{
			return null;
		}
		
		
	}
	
	@RequestMapping("/fileBoardDelete.ino")
	public String freeBoardDelete(@RequestParam("num") int num){
		int count = freeBoardService.freeBoardDelete(num);
		if(count > 0){
			return "redirect:filemain.ino";	
		}else{
			return null; 
		}
		 
	}
	/*
	@RequestMapping("/freeBoard_Search.ino")
	public ModelAndView freeBoard_Search(SearchDTO sdto , @RequestParam(value="cp" , defaultValue="1") int cp , ModelMap map){
		ModelAndView mav = new ModelAndView();
		int PageSize = 5;
		int ListSize = 5;  
		int StartList = (cp - 1 )  * ListSize + 1 ; 
		int EndList = cp + ListSize;
		map.put("StartList", StartList); 
		map.put("EndList", EndList);
		map.put("type", sdto.getType());
		map.put("SearchText", sdto.getSearchText());
		List list = freeBoardService.freeBoardSearchList(map);
		int SearchTotalCnt = freeBoardService.SearchTotalCnt(map);
		System.out.println("TotalCnt : "+SearchTotalCnt);
		mav.addObject("paging", paging);
		mav.setViewName("boardMain"); 
		mav.addObject("freeBoardList",list); 
		return mav; 
	}*/
	
	
	
} 