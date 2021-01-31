/*===========================================================
 * @FileName : 연차정보 SpringLogic(Transaction 관리)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-19;김미옥;최초생성
=============================================================*/
package service.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.dto.UserInfoDto;
import domain.dto.YrvcInfoDto;
import domain.logic.YrvcInfoLogic;
import store.YrvcInfoStore;
/**
 * @desc YrvcInfoSpringLogic.java는 테스트용 SpringLogic 클래스이다. 
 * @author 김미옥
 * @version 0.1
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class YrvcInfoSpringLogic extends YrvcInfoLogic {

	/**
	 * @desc 생성자
	 * @param testStore
	 */
	public YrvcInfoSpringLogic(YrvcInfoStore yrStore) {
		super(yrStore);
	}
	
	/**
	 * @desc 연차정보를 등록하는 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	@Override
	public void register(UserInfoDto dto, String createId) {
		super.register(dto, createId);
	}
	
	/**
	 * @desc 연차정보를 수정하는 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	@Override
	public void modify(YrvcInfoDto dto) {
		super.modify(dto);
	}
	
	/**
	 * @desc 연차정보 수정 메소드이다. >> 스케쥴러갱신용
	 * @param YrvcInfoDto dto
	 */
	@Override
	public void modifyYrvcForSchedule() {
		super.modifyYrvcForSchedule();
	}

	
	/**
	 * @desc 연차정보를 삭제하는 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	@Override
	public void remove(YrvcInfoDto dto) {
		super.remove(dto);
	}
}
