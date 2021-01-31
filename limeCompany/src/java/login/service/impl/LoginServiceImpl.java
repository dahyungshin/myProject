package login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import login.dao.LoginDao;
import login.service.LoginService;
import login.vo.UserVO;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;
	
	@Resource(name="bcryptPasswordEncoder")
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public UserVO getUser(UserVO userVO) {
		userVO.setPw(bcryptPasswordEncoder.encode(userVO.getPw()));
		userVO = loginDao.selectUser(userVO);
		return userVO;
	}

	@Override
	public List getUserList() {
		return loginDao.selectUserList();
	}

	@Override
	public void addFailCnt(UserVO userVO) {
		loginDao.addFailCnt(userVO);
	}

	@Override
	public void addUser(UserVO userVO) {
		userVO.setPw(bcryptPasswordEncoder.encode(userVO.getPw()));
		loginDao.insertUser(userVO);
	}

	@Override
	public void modifyUser(UserVO userVO) {
		userVO.setPw(bcryptPasswordEncoder.encode(userVO.getPw()));
		loginDao.updateUser(userVO);		
	}

	@Override
	public String resetPassword(UserVO userVO) {
		//초기비밀번호
		String tempPass = "";
		
		//8글자 임시 비밀번호 생성
		String charList = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
		for(int i=0; i<8;i++){
			int idx = (int) Math.floor(Math.random() * charList.length());
			tempPass+=charList.substring(idx, idx+1);
		}
		
		tempPass = bcryptPasswordEncoder.encode(tempPass);
		userVO.setResetYn("Y");
		userVO.setPw(tempPass);
		modifyUser(userVO);
		return tempPass;	
	}

	@Override
	public void modifyPassRequest(UserVO userVO) {
		loginDao.resetPass(userVO);
	}
	
	
	
}
