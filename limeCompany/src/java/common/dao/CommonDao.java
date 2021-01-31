package common.dao;

import java.util.List;

import login.vo.CodeVO;

public interface CommonDao {
	public List selectCodeList(CodeVO codeVO);
}
