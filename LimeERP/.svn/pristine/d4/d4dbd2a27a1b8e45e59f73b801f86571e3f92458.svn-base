package service.logic;

import domain.dto.RestInfoDto;
import domain.dto.UserInfoDto;
import domain.logic.RestInfoLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import store.RestInfoStore;

/**
 * @desc RestInfoSpringLogic.java는 휴가정보 SpringLogic 클래스이다.
 * @author 최지현
 * @version 0.1
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RestInfoSpringLogic extends RestInfoLogic {

    /**
     * @desc 생성자
     * @param
     */
    public RestInfoSpringLogic(RestInfoStore restInfoStore) {
        super(restInfoStore);
    }
}
