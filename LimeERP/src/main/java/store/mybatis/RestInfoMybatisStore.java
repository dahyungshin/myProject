package store.mybatis;

import domain.dto.CodeDto;
import domain.dto.RestInfoDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import store.RestInfoStore;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc RestInfoMybatisStore.java는 휴가정보 MyBatis Repository이다.
 * @author 초지현
 * @version 0.1
 */
@Repository
public class RestInfoMybatisStore implements RestInfoStore {

    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * @desc	생성자
     * @param	SqlSessionTemplate sqlSessionTemplate
     */
    public RestInfoMybatisStore(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /**
     * @desc 휴가정보 테이블의 데이터를 조회하는 메소드이다.
     * @return List<RestInfoDto>
     */
    @Override
    public List<RestInfoDto> retrieve() {
        return this.sqlSessionTemplate.selectList("mapper.RestInfoMapper.selectRestInfo");
    }
}
