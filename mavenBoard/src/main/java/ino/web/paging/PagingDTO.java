package ino.web.paging;

import org.springframework.web.bind.annotation.RequestParam;

public class PagingDTO {
	
	public static String PagingMaker(int cp , int TotalCnt , int ListSize, int PageSize , String Url ){
		StringBuffer sb = new StringBuffer();
		//전체리스트 개수
		int TotalPage = (TotalCnt/ListSize)+1;
		if(TotalCnt%ListSize != 0)TotalPage++;
		if(TotalPage < cp)cp=TotalPage;
		int StartPage = ((cp-1)/PageSize)*PageSize+1;
		int EndPage = StartPage + PageSize - 1;
		int PageGroup = cp / PageSize ;
		if(cp%PageSize == 0) PageGroup--;
		if(cp > 1){
			sb.append("<a href='"+Url+"?cp=1' class='page'>처음</a>&nbsp;");
		}
		if(cp > 1){ 
			sb.append("<a href='"+Url+"?cp="+(StartPage-10)+"' class='page'>이전</a>&nbsp;");
		}
		for(int i=PageGroup*PageSize+1; i<=PageGroup*PageSize+PageSize; i++ ){
			sb.append("<a href='"+Url+"?cp="+i);
			sb.append("' class='page'>"+i+"</a>&nbsp;");   
			if(i == TotalPage)break;
		}    
		if(cp <= TotalPage){
			if((EndPage+1) < TotalPage){
				sb.append("<a href='"+Url+"?cp="+(EndPage+1)+"' class='page'>다음</a>&nbsp;");
			} 
		}
		if(cp < TotalPage){ 
			sb.append("<a href='main.ino?cp="+TotalPage+"' class='page'>끝</a>");
		} 
		System.out.println("cp : " + cp); 
		System.out.println("이전페이지 : " + (StartPage));  
		System.out.println("TotalCnt : " + TotalCnt); 
		System.out.println("TotalPage : " + TotalPage);  
		System.out.println("StartPage : " + StartPage); 
		System.out.println("EndPage : " + EndPage);
		return sb.toString();   
	}
	
	public static String SearchPagingMaker(@RequestParam(value="cp",defaultValue="1")int cp , int TotalCnt , int ListSize
			, int PageSize , String type , String SearchText ,String Url ){
		StringBuffer sb = new StringBuffer();
		//전체리스트 개수
		int TotalPage = (TotalCnt/ListSize)+1;
		if(TotalCnt%ListSize == 0)TotalPage--;
		if(TotalPage < cp)cp=TotalPage;
		int StartPage = ((cp-1)/PageSize)*PageSize+1;
		int EndPage = StartPage + PageSize - 1;
		int PageGroup = cp / PageSize ;
		if(cp%PageSize == 0) PageGroup--;
		System.out.println("type : "+type); 
		System.out.println("SearchText : "+SearchText);
		if(TotalCnt <= 0){
			sb.append("<a href='"+Url+"?cp=1");
			sb.append("' class='page'>1</a>&nbsp;");
			return sb.toString();
		}else{
		
		 
		if(cp > 1){
			sb.append("<a href='"+Url+"?cp=1");
			sb.append("&type="+type);
			sb.append("&SearchText="+SearchText);
			sb.append("' class='page'>처음</a>&nbsp;");
		}
		if(cp > 1){ 
			sb.append("<a href='"+Url+"?cp="+(StartPage-10));
			sb.append("&type="+type);
			sb.append("&SearchText="+SearchText);
			sb.append("' class='page'>이전</a>&nbsp;");
		}
		for(int i=PageGroup*PageSize+1; i<=PageGroup*PageSize+PageSize; i++ ){
			sb.append("<a href='"+Url+"?cp="+i);
			sb.append("&type="+type);
			sb.append("&SearchText="+SearchText);
			sb.append("' class='page'>"+i+"</a>&nbsp;");   
			if(i == TotalPage)break;
		}    
		if(cp <= TotalPage){
			if((EndPage+1) < TotalPage){
				sb.append("<a href='"+Url+"?cp="+(EndPage+1));
				sb.append("&type="+type);
				sb.append("&SearchText="+SearchText);
				sb.append("' class='page'>다음</a>&nbsp;");
			} 
		}
		if(cp < TotalPage){ 
			sb.append("<a href='"+Url+"?cp="+TotalPage);
			sb.append("&type="+type);
			sb.append("&SearchText="+SearchText);
			sb.append("' class='page'>끝</a>");
		} 
		System.out.println("cp : " + cp); 
		System.out.println("이전페이지 : " + (StartPage));  
		System.out.println("TotalCnt : " + TotalCnt); 
		System.out.println("TotalPage : " + TotalPage);  
		System.out.println("StartPage : " + StartPage); 
		System.out.println("EndPage : " + EndPage);
		return sb.toString();   
		}
	}
	
}