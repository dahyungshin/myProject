/*===========================================================
 * @FileName : 연차정보 Store myBatis Repository
 * Change history
 * @수정 날짜;수정자;수정내용
 * @2019-12-19;김미옥;최초생성
=============================================================*/
package store.mybatis;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.dto.UserInfoDto;
import domain.dto.YrvcInfoDto;
import store.YrvcInfoStore;
/**
 * @desc YrvcInfoMybatisStore.java는 연차정보 myBatis Repository이다.
 * @author 김미옥
 * @version 0.1
 */
@Repository
public class YrvcInfoMybatisStore implements YrvcInfoStore {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * @desc 생성자
	 * @param sqlSessionTemplate
	 */
	public YrvcInfoMybatisStore(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * @desc 연차정보를 PK로(ID)로 조회하는 메소드이다.
	 * @param userId		사원id
	 * @return YrvcInfoDto
	 */
	@Override
	public YrvcInfoDto retrieve(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		return sqlSessionTemplate.selectOne("mapper.YrvcInfoMapper.selectYrvcInfo", params);
	}

	/**
	 * @desc 연차정보리스트 전체조회 메소드이다.
	 * @return List<YrvcInfoDto>
	 */
	@Override
	public List<YrvcInfoDto> retrieveList() {
		return sqlSessionTemplate.selectList("mapper.YrvcInfoMapper.selectYrvcInfos");
	}

	/**
	 * @desc 연차정보 등록 메소드이다.
	 * @param UserInfoDto dto		사원정보(userId, userNm, userHireDt set)
	 * @param Timestamp createDt	등록일자
	 * @param String createId		등록id
	 * @param Double occrYrvcCnt	연차발생갯수
	 * @param int workYear			근속연수
	 */
	@Override
	public void create(UserInfoDto dto, Timestamp createDt, String createId, Double occrYrvcCnt, int workYear) {
		YrvcInfoDto param = new YrvcInfoDto();
		param.setUserNm(dto.getUserNm());
		param.setUserId(dto.getUserId());
		param.setUserHireDt(dto.getUserHireDt());
		param.setCreateDt(createDt);
		param.setCreateId(createId);
		param.setOccrrncYrvcCnt(occrYrvcCnt);
		param.setRemYrvcCnt(occrYrvcCnt);
		param.setWorkYear(workYear);

		sqlSessionTemplate.insert("mapper.YrvcInfoMapper.insertYrvcInfo", param);
	}

	/**
	 * @desc 연차정보 수정 메소드이다.
	 * @param YrvcInfoDto dto		연차정보
	 * @param Timestamp updateDt	수정일자
	 * @param String updateId		수정id
	 */
	@Override
	public void update(YrvcInfoDto dto, Timestamp updateDt, String updateId) {
		YrvcInfoDto param = new YrvcInfoDto();
		param.setUserNm(dto.getUserNm());
		param.setUserId(dto.getUserId());
		param.setUpdateDt(updateDt);
		param.setUpdateId(updateId);
		param.setRemYrvcCnt(dto.getRemYrvcCnt());
		sqlSessionTemplate.update("mapper.YrvcInfoMapper.updateYrvcInfo", param);
	}
	
	/**
	 * @desc 연차정보 수정 메소드이다. >> 스케쥴러 사용중
	 * @param YrvcInfoDto dto
	 * @param Timestamp updateDt	수엉일자
	 * @param double nowYrvcCnt		발생연차갯수(갱신용)
	 */
	@Override
	public void updateForSchedule(YrvcInfoDto dto, Timestamp updateDt, double nowYrvcCnt) {
		YrvcInfoDto param = new YrvcInfoDto();
		param.setUserNm(dto.getUserNm());
		param.setUserId(dto.getUserId());
		param.setUpdateDt(updateDt);
		param.setUpdateId("scheduler");
		param.setOccrrncYrvcCnt(nowYrvcCnt);
		param.setRemYrvcCnt(dto.getRemYrvcCnt());
		param.setWorkYear(dto.getWorkYear());
		sqlSessionTemplate.update("mapper.YrvcInfoMapper.updateYrvcInfoForSchedule", param);
	}
	
	/**
	 * @desc 연차정보 삭제 메소드이다.
	 * @param YrvcInfoDto dto
	 */
	@Override
	public void delete(YrvcInfoDto dto) {
		sqlSessionTemplate.delete("mapper.YrvcInfoMapper.deleteYrvcInfo", dto);
	}
	
}
