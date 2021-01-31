/*===========================================================
 * @FileName : 연차정보 DTO
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-19;김미옥;최초생성
=============================================================*/
package domain.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @desc YrvcInfoDto.java는 사원별 연차정보  DTO 클래스이다. 
 * @author 김미옥
 * @version 0.1
 */
@Getter
@Setter
@ToString
public class YrvcInfoDto {
	
	private String     userNm        ;         /* 사원명		*/
	private String     userId        ;         /* 사원ID		*/
	private Timestamp  userHireDt    ;         /* 입사일		*/
	private Timestamp  createDt      ;         /* 등록일자		*/
	private String     createId      ;         /* 등록ID		*/
	private Timestamp  updateDt      ;         /* 수정일자		*/
	private String     updateId      ;         /* 수정ID		*/
	private double	   occrrncYrvcCnt;         /* 연차발생갯수	*/
	private double     remYrvcCnt	 ;         /* 잔여연차갯수	*/
	private int		   workYear		 ;		   /* 근속연수		*/

	
}
