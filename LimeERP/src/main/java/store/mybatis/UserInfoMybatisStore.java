/*===========================================================
 * @FileName : 사원정보  MyBatis Repository
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-11;백유빈;최초생성
=============================================================*/
package store.mybatis;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.dto.UserInfoDto;
import store.UserInfoStore;

/**
 * @desc UserInfoMybatisStore.java는 사원정보 MyBatis Repository이다.
 * @author 백유빈
 * @version 0.1
 */
@Repository
public class UserInfoMybatisStore implements UserInfoStore {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @desc 생성자
	 * @param sqlSessionTemplate
	 */
	public UserInfoMybatisStore(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * @desc 회원정보 테이블에 데이터를 등록하는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @param createdId (테이블에 데이터 등록이 가능한 ID, 관리자계정)
	 */
	@Override
	public void create(UserInfoDto dto, String createdId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNm", dto.getUserNm());
		params.put("userId", dto.getUserId());
		params.put("userRrNo", dto.getUserRrNo());
		params.put("userPhoneNo", dto.getUserPhoneNo());
		params.put("userHireDt", dto.getUserHireDt());
		params.put("createdId", createdId);
		this.sqlSessionTemplate.insert("mapper.UserInfoMapper.insertUserInfo", params);
	}

	/**
	 * @desc 회원정보 테이블의 데이터를 조회하는 메소드이다.
	 * @return List<UserInfoDto> 
	 */
	@Override
	public List<UserInfoDto> retrieve() {
		return this.sqlSessionTemplate.selectList("mapper.UserInfoMapper.selectUserInfo");
	}

	/**
	 * @desc 회원정보 테이블의 데이터를 수정하는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @param updatedDt (수정날짜)
	 * @param updatedId (테이블에 데이터 접근이 가능한 ID, 관리자계정)
	 */
	@Override
	public void update(UserInfoDto dto, Timestamp updatedDt, String updatedId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNm", dto.getUserNm());
		params.put("userPw", dto.getUserPw());
		params.put("userPhoneNo", dto.getUserPhoneNo());
		params.put("userAddress", dto.getUserAddress());
		params.put("userEmail", dto.getUserEmail());
		params.put("updatedDt", updatedDt);
		params.put("updatedId", updatedId);
		params.put("userId", dto.getUserId());
		this.sqlSessionTemplate.insert("mapper.UserInfoMapper.updateUserInfo", params);
	}

	/**
	 * @desc 회원정보 테이블의 데이터를 삭제하는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 */
	@Override
	public void delete(UserInfoDto dto) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNm", dto.getUserNm());
		params.put("userId", dto.getUserId());
		this.sqlSessionTemplate.delete("mapper.UserInfoMapper.deleteUserInfo", params);
	}
	
}
