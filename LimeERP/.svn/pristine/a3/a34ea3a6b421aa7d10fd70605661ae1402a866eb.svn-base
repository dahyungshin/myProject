package service.logic;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.dto.CodeDto;
import domain.logic.CodeInfoLogic;
import store.CodeInfoStore;

/**
 * @desc	코드 정보 관리 SpringLogic 
 * @author	조승아
 * @version 0.1
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CodeInfoSpringLogic extends CodeInfoLogic {
	
	/**
	 * @desc	생성자
	 * @param	CodeInfoStore codeInfoStore
	 */
	public CodeInfoSpringLogic(CodeInfoStore codeInfoStore) {
		super(codeInfoStore);
	}
	
	/**
	 * @desc	코드 중분류 조회
	 * @param	
	 * @return	List<CodeDto>
	 */
	@Override
	public List<CodeDto> retrieveCommCdDivList() throws Exception  {
		return super.retrieveCommCdDivList();
	}

	/**
	 * @desc	코드 totalCount 조회
	 * @param	CodeDto codeDto
	 * @return	Integer
	 */
	@Override
	public int retrieveCommCdCnt(CodeDto codeDto) throws Exception  {
		return super.retrieveCommCdCnt(codeDto);
	}
	
	/**
	 * @desc	코드 totalCount 조회
	 * @param	CodeDto codeDto
	 * @return	List<CodeDto>
	 */
	@Override
	public List<CodeDto> retrieveCommCdList(CodeDto codeDto) throws Exception  {
		return super.retrieveCommCdList(codeDto);
	}
	
	@Override
	public void createCodeInfo(CodeDto codeDto) throws Exception {
		super.createCodeInfo(codeDto);
	}
	
}
