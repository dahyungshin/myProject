<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>글쓰기</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./main.ino">리스트로</a>
	</div>
	<hr style="width: 600px">
	
	<form action="./freeBoardInsertPro.ino">
		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="name" required /></div>
		
		<div style="width: 150px; float: left;">제목 :</div>  
		<div style="width: 500px; float: left;" align="left"><input type="text" name="title" required/></div>
	  
		<div style="width: 150px; float: left;">내용 :</div>
		<div style="width: 500px; float: left;" align="left"><textarea name="content" rows="25" cols="65" required ></textarea></div>
		<div align="right"> 
		<input type="submit" value="글쓰기" >
		<input type="reset" value="다시쓰기" >
		<input type="button" value="취소" onclick="confirm_cancel()"> 
		&nbsp;&nbsp;&nbsp;
		</div> 
	  
	</form> 
	
	
	  
</body> 
<script  type="text/javascript">




function confirm_cancel(){
	var cancel= confirm("취소하시겠습니까?");     
	if(cancel = true) {  
		alert("취소되었습니다."); 
		location.href='./main.ino'     
	}else{             
		return;	
	}
}



</script>
</html>