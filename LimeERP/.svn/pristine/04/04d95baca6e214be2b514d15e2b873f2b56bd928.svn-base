/*===========================================================
 * @FileName : 사원정보 Store Interface
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-11;백유빈;최초생성
=============================================================*/
package store;

import java.sql.Timestamp;
import java.util.List;

import domain.dto.UserInfoDto;

/**
 * @desc UserInfoStore.java는 사원정보 Store Interface이다.
 * @author 백유빈
 * @version 0.1
 */
public interface UserInfoStore {
	
	/**
	 * @desc 회원정보 테이블에 데이터를 등록하는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @param createdId (테이블에 데이터 접근이 가능한 ID, 관리자계정)
	 */
	public void create(UserInfoDto dto, String createdId);
	
	/**
	 * @desc 회원정보 테이블의 데이터를 조회하는 메소드이다.
	 * @return List<UserInfoDto> 
	 */
	public List<UserInfoDto> retrieve();
	
	/**
	 * @desc 회원정보 테이블의 데이터를 수정하는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @param updatedDt 수정날짜
	 * @param updatedId (테이블에 데이터 접근이 가능한 ID, 관리자계정)
	 */
	public void update(UserInfoDto dto, Timestamp updatedDt, String updatedId);
	
	/**
	 * @desc 회원정보 테이블의 데이터를 삭제하는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 */
	@Deprecated
	public void delete(UserInfoDto dto); 
	
}
