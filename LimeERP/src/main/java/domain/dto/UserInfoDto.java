/*===========================================================
 * @FileName : 사원 정보 DTO
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-11;백유빈;최초생성
=============================================================*/
package domain.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @desc UserInfoDto.java는 사원들 정보 객체이다. 
 * @author 백유빈
 * @version 0.1
 */
@Getter
@Setter
@ToString
public class UserInfoDto {
	
	private String userNm;         /* 사원명          */
	private String userId;         /* 이름             */
	private String userPw;         /* 비밀번호       */
	private String userRrNo;       /* 주민등록번호 */
	private String userPhoneNo;    /* 핸드폰번호    */
	private Timestamp userHireDt;  /* 입사일          */
	private String userEmail;      /* 이메일주소    */
	private String userAddress;    /* 주소             */
	
	
}
