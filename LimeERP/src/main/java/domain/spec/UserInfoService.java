/*===========================================================
 * @FileName : 사원정보 Service Interface
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-11;백유빈;최초생성
=============================================================*/
package domain.spec;

import java.util.List;

import domain.dto.UserInfoDto;

/**
 * @desc UserInfoService.java는 사원정보 도메인 인터페이스이다. 
 * @author 백유빈
 * @version 0.1
 */
public interface UserInfoService {
	
	/**
	 * @desc 사원정보 데이터를 조회하는 메소드이다. 
	 * @param dto (UserInfoDto 객체)
	 * @return List<UserInfoDto>
	 */
	public List<UserInfoDto> findList(UserInfoDto dto);
	
	/**
	 * @desc 사원정보를 등록하는 메소드이다. (관리자만 사용가능)
	 * @param dto (UserInfoDto 객체)
	 * @param createdId (테이블에 데이터 접근이 가능한 ID, 관리자계정)
	 */
	public void register(UserInfoDto dto, String createdId);
	
	/**
	 * @desc 사원정보를 수정하는 메소드이다.
	 * @desc 관리자 계정이 아닐시 비밀번호, 핸드폰번호, 이메일, 주소만 변경 가능
	 * @param dto (UserInfoDto 객체)
	 * @param updatedId (테이블에 데이터 접근이 가능한 ID, 관리자계정)
	 */
	public void modify(UserInfoDto dto, String updatedId);
	
	/**
	 * @desc 사원정보를 삭제하는 메소드이다. (나중에 필요하면 사용 -> 불용시 삭제예정)
	 * @param dto (UserInfoDto 객체)
	 */
	@Deprecated
	public void remove(UserInfoDto dto);
	
	/**
	 * @desc 로그인 버튼 클릭시 비밀번호를 Check하는 메소드이다.
	 * @param userId (로그인 ID)
	 * @param userPw (로그인 PW)
	 * @return String (True -> Page 리턴 / False -> Error 메시지)
	 */
	public String loginCheck(String userId, String userPw);
	
	/**
	 * @desc 비밀번호를 찾아주는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @return String (비밀번호)
	 */
	public String findPassword(UserInfoDto dto);
	
	/**
	 * @desc 아이디 중복체크을 해주는 메소드이다.
	 * @param userId (중복체크할 아이디)
	 * @return String (체크를 안했을시 0, 중복시1, 중복이 아닐시 2)
	 */
	public String idDuplicateCheck(String userId);
	
	/**
	 * @desc 아이디를 찾아주는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @return String (아이디)
	 */
	public String findId(UserInfoDto dto);

}
