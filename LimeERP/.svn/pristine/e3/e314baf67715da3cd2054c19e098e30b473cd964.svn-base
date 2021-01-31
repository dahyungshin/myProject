package service.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.dto.CodeDto;
import domain.spec.CodeInfoService;

/**
 * @desc	코드 정보 관리 Rest Controller
 * @author	조승아	
 * @version	0.1
 */
@Controller
@RequestMapping( path="/codeMgmt", method = {RequestMethod.GET, RequestMethod.POST} )
public class CodeInfoController {
	
	private CodeInfoService codeInfoService;
	
	/**
	 * @desc	생성자
	 * @param	codeInfoService
	 */
	public CodeInfoController(CodeInfoService codeInfoService) {
		this.codeInfoService = codeInfoService;
	}
	
	/**
	 * @desc	CodeInfo 페이지로 이동
	 * @param	HttpServletRequest request
	 * @param	HttpServletResponse response
	 * @param	@ModelAttribute CodeDto params
	 * @return 
	 * @return	String - view
	 * 
	 * @test	http://localhost:port/erpapp/codeInfo/retrieveCommCdList
	 */
	@PostMapping( value="/codeInfo" )
	public String codeInfoPage(HttpServletRequest request
							 , HttpServletResponse response
							 , @ModelAttribute CodeDto params) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		/** Paging 관련 처리 start **/
		// request 객체에 Paging.jsp 에서 사용할 attribute 셋팅
		request.setAttribute("totalRecordCount", this.codeInfoService.retrieveCommCdCnt(params)); // mapper.CodeInfoMapper.retrieveCodeInfoCnt
		request.setAttribute("recordsPerPage", params.getRecordCountPerPage());
		/** Paging 관려 처리 finish **/

		// 반환할 데이터를 request 에 셋팅
		request.setAttribute("commCdDivList", this.retrieveCommCdDivList()); // 코드 구분 리스트
		request.setAttribute("commCdList", this.retrieveCommCdList(params)); // 상세 코드 리스트
		
		return "Common/CodeInfo";
	}
	
	/**
	 * @desc	코드 목록 중분류 조회
	 * @param	
	 * @return	List<CodeDto>
	 */
	@RequestMapping( value="/retrieveCommCdDivList" )
	public List<CodeDto> retrieveCommCdDivList() throws Exception {
		return this.codeInfoService.retrieveCommCdDivList();
	}
	
	/**
	 * @desc	휴가 관련 코드 리스트 조회
	 * @param	CodeDto params
	 * @return	List<CodeDto>
	 */
	@RequestMapping( value="/retrieveCommCdList" )
	public List<CodeDto> retrieveCommCdList(CodeDto codeDto) throws Exception {
		return this.codeInfoService.retrieveCommCdList(codeDto);
	}
	
	/**
	 * @desc	코드 정보 등록
	 * @param	HttpServletRequest request
	 * @param	HttpServletResponse response
	 * @param	@ModelAttribute CodeDto params
	 * @return	
	 */
	@PostMapping( value="/createCodeInfo" )
	public void createCodeInfo(HttpServletRequest request
							 , HttpServletResponse response
							 , @ModelAttribute CodeDto params) throws Exception {
		
		this.codeInfoService.createCodeInfo(params);
		
		// 코드 등록 후 재조회를 위하여, 현재 컨트롤러의 codeInfoPage() 로 redirect
		response.sendRedirect("codeInfo");
	}
	
	/**
	 * @desc	코드 정보 수정
	 * @param	HttpServletRequest request
	 * @param	HttpServletResponse response
	 * @param	@RequestBody Map<Object, Object> paramMap
	 * @return	
	 */
	@PostMapping( value="/updateCodeInfo" )
	public void updateCodeInfo(HttpServletRequest request
							 , HttpServletResponse response
							 , @RequestBody Map<Object, Object> paramMap) throws Exception {
		
		System.out.println("########## Controller:updateCodeInfo ##########");
		
		if ( !CollectionUtils.isEmpty(paramMap) ) {
			System.out.println("데이터 들어옴");
			
			// TODO paramMap to CodeDto
		} else {
			System.out.println("뽀큐");
		}
	}
	
}
