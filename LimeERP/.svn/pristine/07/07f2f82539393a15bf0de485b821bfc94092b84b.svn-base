package domain.spec;

import java.util.List;

import domain.dto.CodeDto;

/**
 * @desc	코드 정보 관리 도메인 인터페이스
 * @author	조승아
 * @version	0.1
 */
public interface CodeInfoService {

	/**
	 * @desc	공통코드 구분 리스트 조회
	 * @param	
	 * @return	List<CodeDto>
	 */
	public List<CodeDto> retrieveCommCdDivList() throws Exception;

	/**
	 * @desc	공통코드 리스트 Cnt 조회 - 페이징 처리용
	 * @param	codeDto
	 * @return	Integer
	 */
	public int retrieveCommCdCnt(CodeDto codeDto) throws Exception;

	/**
	 * @desc	공통코드 리스트 조회
	 * @param	codeDto
	 * @return	List<CodeDto>
	 */
	public List<CodeDto> retrieveCommCdList(CodeDto codeDto) throws Exception;

	/**
	 * @desc	공통코드 리스트 조회
	 * @param	codeDto
	 * @return	
	 */
	public void createCodeInfo(CodeDto params) throws Exception;
	
}
