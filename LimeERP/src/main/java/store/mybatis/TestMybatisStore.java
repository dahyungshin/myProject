/*===========================================================
 * @FileName : 테스트용 Store myBatis Repository
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-05;백유빈;최초생성
=============================================================*/
package store.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.dto.TestDto;
import store.TestStore;
/**
 * @desc TestMybatisStore.java는 테스트용 myBatis Repository이다.
 * @author 백유빈
 * @version 0.1
 */
@Repository
public class TestMybatisStore implements TestStore {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @desc 생성자
	 * @param sqlSessionTemplate
	 */
	public TestMybatisStore(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * @desc 테스트용입니다.
	 * @desc 회원정보테이블에서 이름으로 해당 정보를 가져오는 메소드입니다.
	 */
	@Override
	public TestDto retrieve(String userNm, String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userNm", userNm);
		params.put("userId", userId);
		return sqlSessionTemplate.selectOne("mapper.TestMapper.TestDto", params);
	}

	/**
	 * @desc 테스트용입니다.
	 * @desc 회원정보테이블에서 전체 리스트를 조회하는 메소드입니다.
	 */
	@Override
	public List<TestDto> retrieveList() {
		return sqlSessionTemplate.selectList("mapper.TestMapper.TestList");
	}

	/**
	 * @desc 테스트용입니다.
	 * @desc 회원정보테이블에서 이름으로 해당 정보를 가져오는 메소드입니다.
	 */
	@Override
	public void create(TestDto dto) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNm", dto.getUserNm());
		params.put("userId", dto.getUserId());
		params.put("userRrNo", dto.getUserRrNo());
		params.put("userPhoneNo", dto.getUserPhoneNo());
		params.put("userHireDt", dto.getUserHireDt());
		sqlSessionTemplate.insert("mapper.TestMapper.TestInsert", params);
	}

	/**
	 * @desc 테스트용입니다.
	 * @desc 회원정보테이블에서 이름으로 해당 정보를 가져오는 메소드입니다.
	 */
	@Override
	public void update() {
		
	}

	/**
	 * @desc 테스트용입니다.
	 * @desc 회원정보테이블에서 이름으로 해당 정보를 가져오는 메소드입니다.
	 */
	@Override
	public void delete() {
		
	}
	
}
