/*===========================================================
 * @FileName : 사원정보 SpringLogic (Transaction 관리)
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-13;백유빈;최초생성
=============================================================*/
package service.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.dto.UserInfoDto;
import domain.logic.UserInfoLogic;
import store.UserInfoStore;
/**
 * @desc UserInfoSpringLogic.java는 사원정보 SpringLogic 클래스이다. 
 * @author 백유빈
 * @version 0.1
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserInfoSpringLogic extends UserInfoLogic {

	/**
	 * @desc 생성자
	 * @param testStore
	 */
	public UserInfoSpringLogic(UserInfoStore userInfoStore) {
		super(userInfoStore);
	}
	
	@Override
	public void register(UserInfoDto dto, String createdId) {
		super.register(dto, createdId);
	}
	
	@Override
	public void modify(UserInfoDto dto, String updatedId) {
		super.modify(dto, updatedId);
	}
	
	@Override
	public void remove(UserInfoDto dto) {
		super.remove(dto);
	}

	
}
