/*===========================================================
 * @FileName : 사원정보 Domain Logic
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-11;백유빈;최초생성
=============================================================*/
package domain.logic;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import domain.dto.UserInfoDto;
import domain.spec.UserInfoService;
import store.UserInfoStore;

/**
 * @desc UserInfoLogic.java는 사원정보 도메인 Logic 클래스이다. 
 * @author 백유빈
 * @version 0.1
 */
public class UserInfoLogic implements UserInfoService {
	
	private UserInfoStore userInfoStore;
	
	/**
	 * @desc 생성자
	 * @param userInfoStore
	 */
	public UserInfoLogic(UserInfoStore userInfoStore) {
		this.userInfoStore = userInfoStore;
	}

	/**
	 * @desc 사원정보 데이터를 조회하는 메소드이다. 
	 * @param dto (UserInfoDto 객체)
	 * @return List<UserInfoDto>
	 */
	@Override
	public List<UserInfoDto> findList(UserInfoDto dto) {
		List<UserInfoDto> userInfoList = this.userInfoStore.retrieve();
		//1.이름검색
		if(dto.getUserNm() != null) {
			userInfoList = userInfoList.stream().filter(t -> t.getUserNm().equals(dto.getUserNm())).collect(Collectors.toList());
		}
		//2.아이디로 검색
		if(dto.getUserId() != null) {
			userInfoList = userInfoList.stream().filter(t -> t.getUserId().equals(dto.getUserId())).collect(Collectors.toList());
		}
		//3.전체검색(Default)
		return userInfoList;
	}

	/**
	 * @desc 사원정보를 등록하는 메소드이다. (관리자만 사용가능)
	 * @param dto (UserInfoDto 객체)
	 * @param createdId (테이블에 데이터 접근이 가능한 ID, 관리자계정)
	 */
	@Override
	public void register(UserInfoDto dto, String createdId) {
		//TODO createdId가 관리자계정이 아닐지 return;
		this.userInfoStore.create(dto, createdId);
	}

	/**
	 * @desc 사원정보를 수정하는 메소드이다.
	 * @desc 관리자 계정이 아닐시 비밀번호, 핸드폰번호, 이메일, 주소만 변경 가능
	 * @param dto (UserInfoDto 객체)
	 * @param updatedId (테이블에 데이터 접근이 가능한 ID, 관리자계정)
	 */
	@Override
	public void modify(UserInfoDto dto, String updatedId) {
		//TODO updatedId가 관리자계정이 아닐지 return;
		Timestamp updatedDt = this.currentTime();
		this.userInfoStore.update(dto, updatedDt, updatedId);
	}

	/**
	 * @desc 사원정보를 삭제하는 메소드이다. (나중에 필요하면 사용 -> 불용시 삭제예정)
	 * @param dto (UserInfoDto 객체)
	 */
	@Override
	public void remove(UserInfoDto dto) {
		this.userInfoStore.delete(dto);
	}

	/**
	 * @desc 로그인 버튼 클릭시 비밀번호를 Check하는 메소드이다.
	 * @param userId (로그인 ID)
	 * @param userPw (로그인 PW)
	 * @return String (True -> Page 리턴 / False -> Error 메시지)
	 */
	@Override
	public String loginCheck(String userId, String userPw) {
		List<UserInfoDto> userInfoList = this.userInfoStore.retrieve();
		userInfoList = userInfoList.stream().filter(p -> p.getUserId().equals(userId)).collect(Collectors.toList());
		if(userInfoList == null || userInfoList.size() == 0) {
			return "0";  //아이디가 존재하지 않음
		}
		for(UserInfoDto dto : userInfoList) {
			if(dto.getUserPw().equals(userPw)) {
				return "1"; //TODO 로그인 후 페이지 
			}
		}
		return "2";    //비밀번호가 틀림
	}

	/**
	 * @desc 비밀번호를 찾아주는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @return String (비밀번호)
	 */
	@Override
	public String findPassword(UserInfoDto dto) {
		String userNm = dto.getUserNm();
		String userId = dto.getUserId();
		List<UserInfoDto> userInfoList = this.userInfoStore.retrieve();
		userInfoList = userInfoList.stream().filter(p -> {
			if(p.getUserNm().equals(userNm) && p.getUserId().equals(userId)) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		
		if(userInfoList == null || userInfoList.size() == 0) {
			return "등록되지 않은 사원입니다. 관리자에게 문의하세요";
		}
		return userInfoList.get(0).getUserPw();
	}

	/**
	 * @desc 아이디 중복체크을 해주는 메소드이다.
	 * @param userId (중복체크할 아이디)
	 * @return String (체크를 안했을시 0, 중복시1, 중복이 아닐시 2)
	 */
	@Override
	public String idDuplicateCheck(String userId) {
		String idCheckState = "1";
		List<UserInfoDto> userInfoList = this.userInfoStore.retrieve();
		userInfoList = userInfoList.stream().filter(t -> t.getUserId().equals(userId)).collect(Collectors.toList());
		if(userInfoList == null || userInfoList.size() == 0) {
			idCheckState = "2";
		}
		return idCheckState;
	}
	
	/**
	 * @desc 아이디를 찾아주는 메소드이다.
	 * @param dto (UserInfoDto 객체)
	 * @return String (아이디)
	 */
	@Override
	public String findId(UserInfoDto dto) {
		String userNm = dto.getUserNm();
		String userPhoneNo = dto.getUserPhoneNo();
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		if(!Pattern.matches(regEx, userPhoneNo)) {
			return "휴대폰 번호 자리수가 잘못되었습니다.";
		}
		String phoneNo = userPhoneNo.replaceAll(regEx, "$1-$2-$3");
		List<UserInfoDto> userInfoList = this.userInfoStore.retrieve();
		userInfoList = userInfoList.stream().filter(p -> {
			if(p.getUserNm().equals(userNm) && p.getUserPhoneNo().equals(phoneNo)) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		
		if(userInfoList == null || userInfoList.size() == 0) {
			return "등록되지 않은 사원입니다. 관리자에게 문의하세요";
		}
		return userInfoList.get(0).getUserId();
	}
	
	/**
	 * @desc 현재시간 구하는 method 이다.
	 * @return Timestamp 현재시간
	 */
	private Timestamp currentTime() {
		LocalDateTime current = LocalDateTime.now();
		return Timestamp.valueOf(current);
	}

}
