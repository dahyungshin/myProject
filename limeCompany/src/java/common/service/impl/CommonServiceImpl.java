package common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dao.CommonDao;
import common.service.CommonService;
import login.vo.CodeVO;
@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private CommonDao commonDao;
	
	
	@Override
	public List getCodeList(CodeVO codeVO) {
		codeVO.setCodeGroup("1");
		return commonDao.selectCodeList(codeVO);
	}


	@Override
	public List getAdminCodeList(CodeVO codeVO) {
		// TODO Auto-generated method stub
		return commonDao.selectCodeList(codeVO);
	}
	
	
	
}
