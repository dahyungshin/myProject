package admin.service;

import java.util.List;

import login.vo.AttendanceVO;
import login.vo.UserVO;

public interface AdminService {
	public UserVO duplicateChk(UserVO userVO); 
	public List getAttendanceList(AttendanceVO AttendanceVO);
	public int getAttendanceCount(AttendanceVO attendanceVO);
	public int updateAttendance(AttendanceVO attendanceVO);
	public int joinUser(UserVO userVO);
	
	/*
	 * 전체유저조회
	 **/
	public List getUserList();
	
	public int getUserCnt();
	
}
