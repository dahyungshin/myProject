package admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.AdminDao;
import admin.service.AdminService;
import login.vo.AttendanceVO;
import login.vo.UserVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public UserVO duplicateChk(UserVO userVO) {
		return adminDao.duplicateChk(userVO);
	}

	@Override
	public List getAttendanceList(AttendanceVO attendanceVO) {	
		return adminDao.selectAttendanceList(attendanceVO);
	}


	@Override
	public int getAttendanceCount(AttendanceVO attendanceVO) {
		return adminDao.selectAttendanceCount(attendanceVO);
	}

	@Override
	public int updateAttendance(AttendanceVO attendanceVO) {
		return adminDao.updateAttendance(attendanceVO);
	}

	@Override
	public int joinUser(UserVO userVO) {
		return adminDao.insertUser(userVO);
	}

	@Override
	public List getUserList() { 
		return adminDao.selectUserList();
	}

	@Override
	public int getUserCnt() {
		// TODO Auto-generated method stub
		return adminDao.selectUserCnt();
	}
	
	
	
	
}
