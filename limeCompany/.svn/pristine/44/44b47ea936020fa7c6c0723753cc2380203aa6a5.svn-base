package login.service;

import java.util.List;

import login.vo.UserVO;

public interface LoginService {
	//유저검색
	public UserVO getUser(UserVO userVO);
	
	//운영자용 검색
	public List getUserList();
	
	//로그인 실패 횟수 추가
	public void addFailCnt(UserVO userVO);	
	
	//유저추가 (운영자만 가능하도록)
	public void addUser(UserVO userVO);
	
	//유저업데이트
	public void modifyUser(UserVO userVO);
	
	//유저비밀번호 초기화
	public String resetPassword(UserVO userVO);
	
	//비밀번호 초기화 신청
	public void modifyPassRequest(UserVO userVO);
}
