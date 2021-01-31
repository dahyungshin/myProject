package store.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.dto.CodeDto;
import store.CodeInfoStore;

/**
 * @desc	코드 정보 관리 Repository
 * @author	조승아
 * @version	0.1
 */
@Repository
public class CodeInfoMybatisStore implements CodeInfoStore {

	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @desc	생성자
	 * @param	SqlSessionTemplate sqlSessionTemplate
	 */
	public CodeInfoMybatisStore(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	/**
	 * @desc	코드 구분 목록 조회
	 * @param	CodeDto codeDto
	 * @return	List<CodeDto>
	 */
	@Override
	public List<CodeDto> retrieveCodeDivList() {
		return sqlSessionTemplate.selectList("mapper.CodeInfoMapper.retrieveCodeDiv");
	}
	
	/**
	 * @desc	코드 정보 totalCount 조회
	 * @param	CodeDto codeDto
	 * @return	Integer
	 */
	@Override
	public int retrieveCodeListCnt(CodeDto codeDto) {
		return sqlSessionTemplate.selectOne("mapper.CodeInfoMapper.retrieveCodeInfoCnt", codeDto);
	}
	
	/**
	 * @desc	코드 정보 목록 조회
	 * @param	CodeDto codeDto
	 * @return	List<CodeDto>
	 */
	@Override
	public List<CodeDto> retrieveCodeList(CodeDto codeDto) {
		
		// FIXME NPE 방어용
		List<CodeDto> tempList = new ArrayList<>();
		
		try {
			tempList = sqlSessionTemplate.selectList("mapper.CodeInfoMapper.retrieveCodeInfo", codeDto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return tempList;
	}

	/**
	 * @desc	코드 정보 등록
	 * @param	CodeDto codeDto
	 * @return	
	 */
	@Override
	public void createCodeInfo(CodeDto codeDto) throws Exception {
		sqlSessionTemplate.insert("mapper.CodeInfoMapper.createCodeInfo", codeDto);
	}

}
