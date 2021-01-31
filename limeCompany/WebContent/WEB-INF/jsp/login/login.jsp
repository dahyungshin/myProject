<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
// 	<c:if test="${!empty message}">
// 		alert("${message}");
// 	</c:if>
$(document).ready(function () {
	
	
});


function fn_passReset(){
	var reset = confirm("비밀번호 초기화 신청을 하시겠습니까?");
	if(reset){
		$.ajax({
			type : "post",
			data: {reset : "reset"},
			dataType : "json",
			url : "/login/resetRequest.ino",
			success : function(data) {
				alert("비밀번호 초기화를 신청했습니다. 관리자에게 문의바랍니다.")
			},
			error: function (request, status, error) {
				ajaxErrorInfo(request, status, error);
		    }
		});
	}
};



</script>
<jsp:include page="/WEB-INF/jsp/comInclude.jsp"/>
<link rel="stylesheet" href="/css/login/login.css">
</head>
<body>
<div class="inner">
<h1>라임컴퍼니 사원관리시스템</h1>
<form method="post" action="loginTry.ino">
	
	<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked="checked" style="display:none"><label for="tab-1" class="tab">Sign In</label>
		<div class="login-form">
			<div class="sign-in-htm">
				<div class="group">
					<label for="user" class="label">Username</label>
					<input id="user" type="text" name="id" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="pass" type="password" name="pw" class="input" data-type="password">
				</div>
				<div class="group">
					<input id="check" type="checkbox" class="check" checked style="display:none">
					<label for="check"><span class="icon"></span> Keep me Signed in</label>
				</div>
				<div class="group">
					<input type="submit" class="button" value="Sign In">
				</div>
				<div class="hr"></div>
				<div class="foot-lnk">
					<p id="forgot" onclick="fn_passReset();"><a href="#">Forgot Password?</a></p>
				</div>
			</div>
		</div>
	</div>
</div>
</form>
</div>
</body>
</html>