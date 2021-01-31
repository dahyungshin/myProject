package store;

import java.util.List;

import domain.dto.CodeDto;

/**
 * @desc	코드 정보 관리 스토어 인터페이스
 * @author	조승아
 * @version	0.1
 */
public interface CodeInfoStore {
	
	/**
	 * @desc	코드 구분 목록 조회
	 * @param	CodeDto codeDto
	 * @return	List<CodeDto>
	 */
	public List<CodeDto> retrieveCodeDivList();

	/**
	 * @desc	코드 totalCount 조회
	 * @param	CodeDto codeDto
	 * @return	Integer
	 */
	public int retrieveCodeListCnt(CodeDto codeDto);

	/**
	 * @desc	구분별 코드 조회
	 * @param	CodeDto codeDto
	 * @return	List<CodeDto>
	 */
	public List<CodeDto> retrieveCodeList(CodeDto codeDto);

	/**
	 * @desc	코드 정보 등록
	 * @param	CodeDto codeDto
	 * @return	
	 */
	public void createCodeInfo(CodeDto codeDto) throws Exception;

	
}
