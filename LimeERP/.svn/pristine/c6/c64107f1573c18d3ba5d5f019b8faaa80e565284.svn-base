<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%@ include file="cssLink.jsp" %>
<script type="text/javascript">
	function check() {
		if(f.userId.value == "") {
			$('#checkMessage').html('아이디를 입력해주세요.');
			$('#checkType').attr('class', 'modal-content panel-danger');
			$('#checkModal').modal("show");
			return
		}
		if(f.userPw.value == "") {
			$('#checkMessage').html('비밀번호를 입력해주세요.');
			$('#checkType').attr('class', 'modal-content panel-danger');
			$('#checkModal').modal("show");
			return
		}
		document.f.submit();
	}
</script>
<title>Home</title>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
		if(userID != null){
			session.setAttribute("messageType", "오류 메시지");
			session.setAttribute("messageContent", "현재 로그인이 되어 있는 상태입니다.");
			response.sendRedirect("login.do");
			return;
		}
	%>
	<div class="container" style="margin-top:350px; width:800px;"> 
		<form name = "f" method="post" action="./login.do">
			<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
				<thead>
				</thead>
				<tbody>
					<tr>
						<td rowspan="3" style="width: 150px"><img src="<c:url value="/resources/logo.png"/>" width="300" style="margin-top:12"></td>
						<td style="width: 110px;"><h5>아이디</h5></td>
						<td id="input"><input class="form-control" type="text" name="userId" maxlength="20" placeholder="아이디를 입력하세요."></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>비밀번호</h5></td>
						<td id="input"><input class="form-control" type="password" name="userPw" maxlength="20" placeholder="비밀번호를 입력하세요."></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<button class="btn btn-warning" type="button">비밀번호찾기</button>
							<button class="btn btn-primary" onclick="check();" type="button">로그인</button>  
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<%@ include file="modal.jsp" %>
</body>
</html>