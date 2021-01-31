/*===========================================================
 * @FileName : 스케줄러 실행 class
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-26;김미옥;최초생성
=============================================================*/
package service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import domain.spec.YrvcInfoService;

/**
 * @desc Scheduler.java는 스케률러 실행을 위한 class이다.
 * @author 김미옥
 * @version 0.1
 */
@Component
public class Scheduler {
	
	@Autowired
	private YrvcInfoService yrvcService;

    /*
     * 5초 마다 실행 (test용 >> 삭제예정)
     */
//    @Scheduled(fixedDelay=5000)
//    public void init() {
//    	this.yrvcService.modifyYrvcForSchedule();
//        System.out.println("Scheduler test: 5초마다 실행 >> init() ");
//    }

    /**
     * 매월 0시에 연차정보 update 수행
     */    
    @Scheduled(cron="0 0 0 1 1/1 ?")
    public void yrvcCntScheduler() {
    	this.yrvcService.modifyYrvcForSchedule();
    }
    
}
