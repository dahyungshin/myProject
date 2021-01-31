package domain.logic;

import java.util.List;

import domain.dto.CodeDto;
import domain.spec.CodeInfoService;
import store.CodeInfoStore;

/**
 * @desc	코드 정보 관리 Logic
 * @author	조승아
 * @version	0.1
 */
public class CodeInfoLogic implements CodeInfoService {

	private CodeInfoStore codeInfoStore;
	
	/**
	 * @desc	생성자
	 * @param	CodeInfoStore codeInfoStore
	 */
	public CodeInfoLogic(CodeInfoStore codeInfoStore) {
		this.codeInfoStore = codeInfoStore;
	}

	/**
	 * @desc	코드 구분 리스트 조회 (중분류)
	 * @param	CodeDto codeDto
	 * @return	List<CodeDto>
	 * @throws Exception 
	 */
	@Override
	public List<CodeDto> retrieveCommCdDivList() throws Exception {
		return this.codeInfoStore.retrieveCodeDivList();
	}
	
	/**
	 * @desc	구분별 코드 totalCount 조회
	 * @param	CodeDto codeDto
	 * @return	Integer
	 */
	@Override
	public int retrieveCommCdCnt(CodeDto codeDto) throws Exception {
		return this.codeInfoStore.retrieveCodeListCnt(codeDto);
	}

	/**
	 * @desc	구분별 코드 조회
	 * @param	CodeDto codeDto
	 * @return	List<CodeDto>
	 */
	@Override
	public List<CodeDto> retrieveCommCdList(CodeDto codeDto) throws Exception {
		return this.codeInfoStore.retrieveCodeList(codeDto);
	}

	/**
	 * @desc	코드 정보 등록
	 * @param	CodeDto codeDto
	 * @return	
	 */
	@Override
	public void createCodeInfo(CodeDto codeDto) throws Exception {
		this.codeInfoStore.createCodeInfo(codeDto);
	}

}
