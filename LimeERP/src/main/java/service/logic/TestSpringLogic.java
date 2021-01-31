/*===========================================================
 * @FileName : 테스트 SpringLogic(Transaction 관리)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-05;백유빈;최초생성
=============================================================*/
package service.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.dto.TestDto;
import domain.logic.TestLogic;
import store.TestStore;
/**
 * @desc TestSpringLogic.java는 테스트용 SpringLogic 클래스이다. 
 * @author 백유빈
 * @version 0.1
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TestSpringLogic extends TestLogic {

	/**
	 * @desc 생성자
	 * @param testStore
	 */
	public TestSpringLogic(TestStore testStore) {
		super(testStore);
	}
	
	/**
	 * @desc 테스트용 회원정보를 등록하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	@Override
	public void register(TestDto dto) {
		super.register(dto);
	}
	
	/**
	 * @desc 테스트용 회원정보를 수정하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	@Override
	public void modify(TestDto dto) {
		super.modify(dto);
	}
	
	/**
	 * @desc 테스트용 회원정보를 삭제하는 메소드이다.
	 * @param dto (TestDto 객체)
	 */
	@Override
	public void remove(TestDto dto) {
		super.remove(dto);
	}
}
