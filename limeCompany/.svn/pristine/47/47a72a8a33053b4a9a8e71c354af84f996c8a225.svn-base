<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function selChange(obj){
	var selOption = $(obj).find(":selected").val();
	

	var day = 1;
	switch(selOption){
	case 1:	//연차		
		break;
	case 2:	//병가
		break;
	case 3:	//지각
		day = 0.5;
		break;
	case 4:	//조퇴
		day = 0.5;
		break;
	case 5: //무단조퇴
		break;
	case 6:	//무단결근
		day =2;
		break;
	case 7: //기타
		break;
	}
	$('#annualCnt').val(day);
}

function validate(){
	if($("#DATE").val() == ""){
		alert("날짜를 입력하세요!");
		return false;
	}
	return true;
}


</script>




<div>
<h1>신규작성</h1>
<form class="form-inline" action="/user/writeAttendance.ino" method="post" onsubmit="return validate();">
	<input type="hidden" name="userId" value="${id}" />
	<input type="hidden" name="annualCnt" id="annualCnt" value="1"/>
	<div id="form-group">
		<label for="DATE">날짜 : </label>
		<input class="form-control" type="date" id="DATE" name="date"/>
	</div>
	<div id="form-group">
		<label for="dateCnt">일 수 : </label>
		<input id="dateCnt" class="form-control" type="number" name="dateCnt" value="1" max="10" min="1"/>
	</div>
	<div id="form-group">
	<label for="code">사유 : </labal>
	<select class="form-control" name="code" id="code" onchange="selChange(this)">
		<c:forEach items="${codeList}" var="code">
			<option value="${code.no}">${code.codeName}</option>
		</c:forEach>
	</select>
	</div>
	<div id="form-group">
	<label for="remark">자세한 사항 : </label>
	<textarea class="form-control" name="remark" placeholder="사유에 관한 자세한 사항을 입력해주세요"></textarea>
	</div>
	<div>
		<input type="submit" class="btn btn-default" value="작성"/>
	</div>
</form>
</div>