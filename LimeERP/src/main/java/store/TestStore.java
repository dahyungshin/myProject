/*===========================================================
 * @FileName : 테스트용 Store Interface
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-05;백유빈;최초생성
=============================================================*/
package store;

import java.util.List;

import domain.dto.TestDto;

/**
 * @desc TestStore.java는 테스트용 Store Interface이다.
 * @author 백유빈
 * @version 0.1
 */
public interface TestStore {
	
	/**
	 * @desc 테스트용 회원정보를 PK로(이름, ID)로 조회하는 메소드이다.
	 * @param userNm (회원이름)
	 * @param userId (회원ID)
	 * @return TestDto
	 */
	public TestDto retrieve(String userNm, String userId);
	
	/**
	 * @desc 테스트용 조회 리스트 메소드이다.
	 * @return List<TestDto>
	 */
	public List<TestDto> retrieveList();
	
	/**
	 * @desc 테스트용 등록 메소드이다.
	 */
	public void create(TestDto dto);
	
	/**
	 * @desc 테스트용 업데이트 메소드이다.
	 */
	public void update();
	
	/**
	 * @desc 테스트용 삭제 메소드이다.
	 */
	public void delete();

}
