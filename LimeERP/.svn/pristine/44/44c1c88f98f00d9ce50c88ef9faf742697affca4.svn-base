/*===========================================================
 * @FileName : 테스트(도메인 로직)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-05;백유빈;최초생성
=============================================================*/
package domain.logic;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import domain.dto.TestDto;
import domain.spec.TestService;
import store.TestStore;

/**
 * @desc TestLogic.java는 테스트용 도메인 Logic 클래스이다. 
 * @author 백유빈
 * @version 0.1
 */
public class TestLogic implements TestService {
	
	private TestStore testStore;
	
	/**
	 * @desc 생성자
	 * @param testStore
	 */
	public TestLogic(TestStore testStore) {
		this.testStore = testStore;
	}
	
	/**
	 * @desc 테스트용 메소드 (home.jsp return)
	 */
	@Override
	public String test() {
		return "home";
	}

	/**
	 * @desc 테스트용 회원정보를 PK로(이름, ID)로 조회하는 메소드이다.
	 * @param dto (TestDto 객체)
	 * @return TestDto
	 */
	@Override
	public TestDto find(TestDto dto) {
		//원래는 화면에서 값을 받아오지만 화면이 없어서 강제로 SET해서 테스트진행하였습니다.
		dto.setUserNm("백유빈");
		dto.setUserId("백유빈");
		return this.testStore.retrieve(dto.getUserNm(), dto.getUserId());
	}

	/**
	 * @desc 테스트용 회원정보 데이터 전체를 조회하는 메소드이다.
	 * @return List<TestDto>
	 */
	@Override
	public List<TestDto> findList() {
		return this.testStore.retrieveList();
	}

	/**
	 * @desc 테스트용 회원정보를 등록하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	@Override
	public void register(TestDto dto) {
		//원래는 화면에서 값을 받아오지만 화면이 없어서 강제로 SET해서 테스트진행하였습니다.
		dto.setUserNm("TEST");
		dto.setUserId("TESTID");
		dto.setUserRrNo("111111-1");
		dto.setUserPhoneNo("010-1111-1111");
		Timestamp userHireDt = this.currentTime();
		dto.setUserHireDt(userHireDt); 
		//myBatis insert는 return 값이 integer이지만, SpringLogic에서 따로 Transaction 관리를 하기 때문에 Logic에서 void를 return 하였습니다.
		this.testStore.create(dto);  
	}

	/**
	 * @desc 테스트용 회원정보를 수정하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	@Override
	public void modify(TestDto dto) {
		
	}
	
	/**
	 * @desc 테스트용 회원정보를 삭제하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	@Override
	public void remove(TestDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @desc 현재시간을 구하는 메소드이다.
	 * @return Timestamp
	 */
	private Timestamp currentTime() {
		LocalDateTime current = LocalDateTime.now();
		return Timestamp.valueOf(current);
	}

}
