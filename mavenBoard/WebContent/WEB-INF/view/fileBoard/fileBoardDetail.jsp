<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1>��������</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./main.ino">����Ʈ��</a> 
	</div>
	<hr style="width: 600px">
	
	<form action="./freeBoardInsertPro.ino">
		<div style="width: 150px; float: left;">�̸� :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="name" value="${freeBoardDto.name }" readonly/></div>
		
		<div style="width: 150px; float: left;">���� :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="title"  value="${freeBoardDto.title }"readonly/></div>
	
		<div style="width: 150px; float: left;">�ۼ�����</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="title"  value="${freeBoardDto.regdate }"readonly/></div>
	
		<div style="width: 150px; float: left;">���� :</div>
		<div style="width: 500px; float: left;" align="left"><textarea name="content" rows="25" cols="65"  readonly>${freeBoardDto.content }</textarea></div>
		<div align="right">
		<input type="button" value="����" onclick="location.href='./freeBoardModify.ino?num=${freeBoardDto.num }'">  
		<input type="button" value="����" onclick="freeBoard_Delete(${freeBoardDto.num })">
		<input type="button" value="���" onclick="confirm_cancel()"> 
		&nbsp;&nbsp;&nbsp;  
		</div>
	 
	</form>
	
</body>
<script>
function freeBoard_Delete(num){
	var delete_confirm = confirm("�����Ͻðڽ��ϱ�?");
	if(delete_confirm == true){  
		location.href='freeBoardDelete.ino?num='+num;   
	}else{
		return;
	}
	
}
function confirm_cancel(){
	var cancel= confirm("����Ͻðڽ��ϱ�?");     
	if(cancel = true) {  
		alert("��ҵǾ����ϴ�."); 
		location.href='./main.ino'     
	}else{             
		return;	
	}
}
</script>
</html>