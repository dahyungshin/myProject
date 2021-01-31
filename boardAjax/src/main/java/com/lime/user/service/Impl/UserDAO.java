package com.lime.user.service.Impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("userDAO")
public class UserDAO extends EgovAbstractMapper{
	
	public int userIdCheck(String userId) throws EgovBizException  {
		int count = selectOne("userIdCheck", userId);
		return count ;
	}
}
