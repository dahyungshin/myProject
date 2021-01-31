package store;


import domain.dto.RestInfoDto;

import java.util.List;

public interface RestInfoStore {

    /**
     * @desc 회원정보 테이블의 데이터를 조회하는 메소드이다.
     * @return List<UserInfoDto>
     */
    public List<RestInfoDto> retrieve();
}
