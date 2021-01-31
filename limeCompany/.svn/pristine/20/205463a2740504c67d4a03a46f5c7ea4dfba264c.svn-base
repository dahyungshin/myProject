<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function change(){
	var pw = $('input[name=pw]').val();
	var pw1 = $('input[name=pw1]').val();
	if(pw.length<6){
		alert('비밀번호는 6글자 이상이여야합니다.');
		return;
	}else if(pw!=pw1){
		alert('비밀번호가 다릅니다.');
		return;
	}
		$('#form1').submit();	
		
}
</script>
</head>
<body>
	<h1>비밀번호 재설정</h1>
	<form id="form1" action="changePass.ino" method="post">
		<input type="hidden" name="id" value="${id}"/>
		비밀번호 : <input type="password" name="pw"/><br/>
		비빌번호 확인 : <input type="password" name="pw1"/><br/>
		<button type="button" onclick="change()">변경</button>
	</form>
</body>
</html>