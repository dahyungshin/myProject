package user.dao;

import java.util.List;

import login.vo.AttendanceVO;

public interface UserDao {
	public List selectUserAttendance(AttendanceVO punctualityVO);
	public int selectUserAttendanceCount(AttendanceVO punctualityVO);
	public int insertAttendance(AttendanceVO punctualityVO);	
}