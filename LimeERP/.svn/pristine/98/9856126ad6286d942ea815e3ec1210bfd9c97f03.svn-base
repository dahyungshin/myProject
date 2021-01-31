/*===========================================================
 * @FileName : 테스트서비스(도메인 인터페이스)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-05;백유빈;최초생성
=============================================================*/
package domain.spec;

import java.util.List;

import domain.dto.TestDto;

/**
 * @desc TestService.java는 테스트용 도메인 인터페이스이다. 
 * @author 백유빈
 * @version 0.1
 */
public interface TestService {
	
	/**
	 * @desc 테스트용 메소드
	 * @return String
	 */
	public String test();
	
	/**
	 * @desc 테스트용 회원정보를 PK로(이름, ID)로 조회하는 메소드이다.
	 * @param dto (TestDto 객체)
	 * @return TestDto
	 */
	public TestDto find(TestDto dto);
	
	/**
	 * @desc 테스트용 회원정보 데이터 전체를 조회하는 메소드이다.
	 * @return List<TestDto>
	 */
	public List<TestDto> findList();
	
	/**
	 * @desc 테스트용 회원정보를 등록하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	public void register(TestDto dto);
	
	/**
	 * @desc 테스트용 회원정보를 수정하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	public void modify(TestDto dto);
	
	/**
	 * @desc 테스트용 회원정보를 삭제하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	public void remove(TestDto dto);
}
