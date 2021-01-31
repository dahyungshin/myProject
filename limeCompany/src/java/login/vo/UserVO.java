package login.vo;

public class UserVO {
	private	String id;
	private String pw;
	private String userNm;
	private String adminYn;
	private String resetYn;
	private int failCnt;
	private String bDate;
	
	
	
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getAdminYn() {
		return adminYn;
	}
	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}
	public String getResetYn() {
		return resetYn;
	}
	public void setResetYn(String resetYn) {
		this.resetYn = resetYn;
	}
	public int getFailCnt() {
		return failCnt;
	}
	public void setFailCnt(int failCnt) {
		this.failCnt = failCnt;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", userNm=" + userNm + ", adminYn=" + adminYn + ", resetYn="
				+ resetYn + "]";
	}
	
	
	
}
