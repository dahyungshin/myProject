/*===========================================================
 * @FileName : 연차정보 Domain Logic
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-19;김미옥;최초생성
=============================================================*/
package domain.logic;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import domain.dto.UserInfoDto;
import domain.dto.YrvcInfoDto;
import domain.spec.YrvcInfoService;
import store.UserInfoStore;
import store.YrvcInfoStore;

/**
 * @desc YrvcInfoLogic.java는 연차정보 도메인 Logic 클래스이다. 
 * @author 김미옥
 * @version 0.1
 */
public class YrvcInfoLogic implements YrvcInfoService {
	
	@Autowired
	private YrvcInfoStore yrvcInfoStore;
	@Autowired
	private UserInfoStore userInfoStore;
	
	/**
	 * @desc 생성자
	 * @param yrvcStore
	 */
	public YrvcInfoLogic(YrvcInfoStore yrvcStore) {
		this.yrvcInfoStore = yrvcStore;
	}
	
	/**
	 * @desc 연차정보를 PK로(ID)로 조회하는 메소드이다.
	 * @param YrvcInfoDto dto
	 * @return YrvcInfoDto
	 */
	@Override
	public YrvcInfoDto find(YrvcInfoDto dto) {
		return this.yrvcInfoStore.retrieve(dto.getUserId());
	}
	
	/**
	 * @desc 연차정보 데이터 전체를 조회하는 메소드이다. >> 스케줄러사용중
	 * @return List<YrvcInfoDto>
	 */
	@Override
	public List<YrvcInfoDto> findList() {
		return this.yrvcInfoStore.retrieveList();
	}
	
	/**
	 * @desc 사원의 연차정보를 등록하는 메소드이다.
	 * @param UserInfoDto dto	사원정보 (userId, userNm, userHireDt 참조)
	 * @param String createId	등록id
	 */
	@Override
	public void register(UserInfoDto dto, String createId) {
		// 연차정보 조회
		YrvcInfoDto infoDto = new YrvcInfoDto();
		infoDto = this.yrvcInfoStore.retrieve(dto.getUserId());
		
		// 연차, 근속연수
		double nowYrvcCnt = this.calOccrrncYrvcCnt(dto.getUserHireDt(), this.currentTime());
		int workYear = this.calWorkYear(dto.getUserHireDt());
		
		// 해당데이터가 없을 경우 create
		if(infoDto == null) {
			this.yrvcInfoStore.create(dto, this.currentTime(), createId, nowYrvcCnt, workYear);
		}
	}
	
	/**
	 * @desc 연차정보를 수정하는 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	@Override
	public void modify(YrvcInfoDto dto) {
		// 잔여연차 set
		dto.setRemYrvcCnt(dto.getRemYrvcCnt());
		
		// update 정보
		String updateId = "admin";
		Timestamp updateDt = this.currentTime();
		this.yrvcInfoStore.update(dto, updateDt, updateId);
	}

	/**
	 * @desc 연차정보를 삭제하는 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	@Override
	public void remove(YrvcInfoDto dto) {
		this.yrvcInfoStore.delete(dto);
	}
	
	/**
	 * @desc 현재시간을 구하는 메소드이다.
	 * @return Timestamp
	 */
	private Timestamp currentTime() {
		LocalDateTime current = LocalDateTime.now();
		return Timestamp.valueOf(current);
	}
	
	/**
	 * @desc 입사일을 기준으로 연차를 계산하는 메소드이다.
	 * @param Timestamp userHireDt		입사일자
	 * @param Timestamp currentTime		현재시간
	 * @return int
	 */
	private int calOccrrncYrvcCnt(Timestamp userHireDt, Timestamp currentTime) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.get(Calendar.MONTH);
		
		// 입사일
		Date hireDate = userHireDt;
		Long hireTimestamp = userHireDt.getTime();
		Calendar hireCal = Calendar.getInstance();
		hireCal.setTime(hireDate);
		int hireMonth = hireCal.get(Calendar.MONTH);

		// 현재시간
		Date nowDate = currentTime;
		Long nowTimestamp = currentTime.getTime();
		Calendar nowCal = Calendar.getInstance();
		nowCal.setTime(nowDate);
		int nowMonth = nowCal.get(Calendar.MONTH);

		// 현재일 - 입사일 : 입사이후 몇일이 지났는지 계산
		long calDate = (nowTimestamp - hireTimestamp) / (24*60*60*1000);
		int yrvcCnt = 0;
		// 1년미만
		if(calDate < 365) {
			yrvcCnt = nowMonth - hireMonth;
			if(yrvcCnt < 0) {
				yrvcCnt = 12 - yrvcCnt;
			}
		} else {
			// 연차가산일 (1년차: 15일, 3년차: +(16일), 매 2년: +1)
			int addYrvc = (int)(((calDate - 365) / 365) / 2);
			yrvcCnt = 15 + addYrvc;
		}
		return yrvcCnt;
	}// end calOccrrncYrvcCnt()
	
	/**
	 * @desc 매월 연차정보를 갱신하는 메소드이다. >> 스케줄러사용중
	 */
	@Override
	public void modifyYrvcForSchedule() {
		// 사원정보데이터 확인 후 연차계산
		// 사원정보리스트 조회
		List<UserInfoDto> userInfoList = new ArrayList<UserInfoDto>();
		userInfoList = this.userInfoStore.retrieve();
		
		// 연차정보가 등록되지 않은 사원이 있을 경우 연차테이블에 등록 (재확인용 >> 불필요시 삭제)
		if(this.yrvcInfoStore.retrieveList().size() != this.userInfoStore.retrieve().size()) {
			for(UserInfoDto userDto : userInfoList) {
				YrvcInfoDto dbDto = this.yrvcInfoStore.retrieve(userDto.getUserId());
				if(dbDto == null) {
					String createId = "admin";
					double occrYrvcCnt = this.calOccrrncYrvcCnt(userDto.getUserHireDt(), this.currentTime());
					yrvcInfoStore.create(userDto, this.currentTime(), createId, occrYrvcCnt, this.calWorkYear(userDto.getUserHireDt()));
				}
			}
		}
		
		// 최신연차가 반영되었는지 확인
		// db에 있는 연차정보
		List<YrvcInfoDto> dtos = this.yrvcInfoStore.retrieveList();
		for(YrvcInfoDto dto : dtos) {
			dto.setWorkYear(this.calWorkYear(dto.getUserHireDt()));
			// 조회시점기준으로 계산한 연차정보
			double nowYrvcCnt = this.calOccrrncYrvcCnt(dto.getUserHireDt(), this.currentTime());
		
			// 최신연차가 반영되지 않았을 경우 update
			if(dto.getOccrrncYrvcCnt() != nowYrvcCnt) {
				// 사용연차 계산
				if(nowYrvcCnt >= 15) {	// 근속년수가 1년 이상
					double remYrvcCnt = dto.getRemYrvcCnt();
					if(remYrvcCnt > 0) { // 잔여연차 초기화 (잔여연차가 음수값이면 잔여연차유지)
						dto.setRemYrvcCnt(0);
					}
				}
				this.yrvcInfoStore.updateForSchedule(dto, this.currentTime(), nowYrvcCnt);
			}
		}
	}// end modifyYrvcForSchedule()
	
	/**
	 * @desc 근속연수를 계산하는 메소드이다.
	 * @param Timestamp userHireDt	입사일
	 * @return int					근속연수
	 */
	private int calWorkYear(Timestamp userHireDt) {
		int workYear = 0;
		
		Timestamp nowTimestamp = this.currentTime();
		long calDate = (nowTimestamp.getTime() - userHireDt.getTime()) / (24*60*60*1000);
		// 1년미만
		if(calDate < 365) {
			workYear = 0;
		} else {
			workYear = (int)(calDate / 365);
		}
		
		return workYear; 
	}// end calWorkYear()
	
}
