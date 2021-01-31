package login.dao;

import java.util.List;

import login.vo.UserVO;

public interface LoginDao {
	
	public UserVO selectUser(UserVO userVO);
	public List selectUserList();
	public void addFailCnt(UserVO userVO);
	
	public void insertUser(UserVO userVO);
	public void updateUser(UserVO userVO);
	
	public void resetPass(UserVO userVO);
	
}
