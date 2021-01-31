/*===========================================================
 * @FileName : 연차정보서비스(도메인 인터페이스)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-19;김미옥;최초생성
=============================================================*/
package domain.spec;

import java.util.List;

import domain.dto.UserInfoDto;
import domain.dto.YrvcInfoDto;

/**
 * @desc YrvcInfoService.java는 연차정보 도메인 인터페이스이다. 
 * @author 김미옥
 * @version 0.1
 */
public interface YrvcInfoService {
	
	/**
	 * @desc 연차정보를 PK로(ID)로 조회하는 메소드이다.
	 * @param YrvcInfoDto dto
	 * @return YrvcInfoDto
	 */
	public YrvcInfoDto find(YrvcInfoDto dto);
	
	/**
	 * @desc 연차정보 데이터 전체를 조회하는 메소드이다. >> 스케줄러사용중
	 * @return List<YrvcInfoDto>
	 */
	public List<YrvcInfoDto> findList();
	
	/**
	 * @desc 사원의 연차정보를 등록하는 메소드이다.
	 * @param UserInfoDto dto	사원정보 (userId, userNm, userHireDt 참조)
	 * @param String createId	등록id
	 */
	public void register(UserInfoDto dto, String createId);
	
	/**
	 * @desc 연차정보를 수정하는 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	public void modify(YrvcInfoDto dto);
	
	/**
	 * @desc 연차정보를 삭제하는 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	public void remove(YrvcInfoDto dto);
	
	/**
	 * @desc 매월 연차정보를 갱신하는 메소드이다. (스케쥴러에 사용)
	 * @return List<YrvcInfoDto>
	 */
	public void modifyYrvcForSchedule();

}
