package ino.web.freeBoard.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import ino.web.freeBoard.dto.FreeBoardDto;

@Service
public class FileBoardService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List freeBoardList(ModelMap map){
		return sqlSessionTemplate.selectList("freeBoardGetList",map);
	} 
	
	public List freeBoardSearchList(ModelMap map){
		return sqlSessionTemplate.selectList("freeBoardSearchList", map);
	}
	
	public void freeBoardInsertPro(FreeBoardDto dto){
		sqlSessionTemplate.insert("freeBoardInsertPro",dto);
	}
	
	public FreeBoardDto getDetailByNum(int num){
		return sqlSessionTemplate.selectOne("freeBoardDetailByNum", num);
	}
	
	public int freeBoardModify(FreeBoardDto dto){
		int count = sqlSessionTemplate.update("freeBoardModify" , dto);
		return count;
	}
	
	public int freeBoardDelete(int num){
		int count = sqlSessionTemplate.delete("freeBoardDelete",num);
		return count ; 
	}
	
	public int TotalCnt(){
		int TotalCnt =  sqlSessionTemplate.selectOne("freeBoardTotalCnt");
		return TotalCnt;
	}
	
	public int SearchTotalCnt(ModelMap map){
		int TotalCnt =  sqlSessionTemplate.selectOne("freeBoardSearchTotalCnt",map);
		return TotalCnt;
	}

	
}
