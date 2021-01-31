/*===========================================================
 * @FileName : 연차정보  Store Interface
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-19;김미옥;최초생성
=============================================================*/
package store;

import java.sql.Timestamp;
import java.util.List;

import domain.dto.UserInfoDto;
import domain.dto.YrvcInfoDto;

/**
 * @desc YrvcInfoStore.java는 연차정보 Store Interface이다.
 * @author 김미옥
 * @version 0.1
 */
public interface YrvcInfoStore {
	
	/**
	 * @desc 연차정보를 PK로(ID)로 조회하는 메소드이다.
	 * @param userId		사원id
	 * @return YrvcInfoDto
	 */
	public YrvcInfoDto retrieve(String userId);
	
	/**
	 * @desc 연차정보리스트 전체조회 메소드이다. (스케줄러사용중)
	 * @return List<YrvcInfoDto>
	 */
	public List<YrvcInfoDto> retrieveList();
	
	/**
	 * @desc 연차정보 등록 메소드이다.
	 * @param UserInfoDto dto		사원정보(userId, userNm, userHireDt set)
	 * @param Timestamp createDt	등록일자
	 * @param String createId		등록id
	 * @param Double occrYrvcCnt	연차발생갯수
	 * @param int workYear			근속연수
	 */
	public void create(UserInfoDto dto, Timestamp createDt, String createId, Double occrYrvcCnt, int workYear);
	
	/**
	 * @desc 연차정보 수정 메소드이다.
	 * @param YrvcInfoDto dto		연차정보
	 * @param Timestamp updateDt	수정일자
	 * @param String updateId		수정id
	 */
	public void update(YrvcInfoDto dto, Timestamp updateDt, String updateId);
	
	/**
	 * @desc 연차정보 수정 메소드이다. >> 스케쥴러 사용중
	 * @param YrvcInfoDto dto
	 * @param Timestamp updateDt	수엉일자
	 * @param double nowYrvcCnt		발생연차갯수(갱신용)
	 */
	public void updateForSchedule(YrvcInfoDto dto, Timestamp updateDt, double nowYrvcCnt);
	
	/**
	 * @desc 연차정보 삭제 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	public void delete(YrvcInfoDto dto);

}
