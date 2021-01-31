package user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.vo.AttendanceVO;
import user.dao.UserDao;
import user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public List getAttendanceList(AttendanceVO attendanceVO) {
		return userDao.selectUserAttendance(attendanceVO);
	}

	@Override
	public int getAttendanceCount(AttendanceVO attendanceVO) {
		return userDao.selectUserAttendanceCount(attendanceVO);
	}

	@Override
	public int writeAttendance(AttendanceVO attendanceVO) {
		return userDao.insertAttendance(attendanceVO);
	}
	
	
}
