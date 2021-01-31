<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<jsp:include page="/WEB-INF/jsp/comInclude.jsp"/>
<script type="text/javascript">
function validate(){
	var id=$('input[name=id]').val();
	if(id==''){
		alert('이름중복 확인을 해주세요');
		return false;
	}
	
	
	var bDate = $('input[name=bDate]').val();
	if(bDate == ''){
		alert('생년월일을 입력해주세요');
		return false;
	}

	var pw = $('input[name=pw]').val();
	var pw1 = $('input[name=pw1]').val();
	if(pw.length<6){
		alert('비밀번호는 6글자 이상이여야합니다.');
		return false;
	}else if(pw!=pw1){
		alert('비밀번호가 다릅니다.');
		return false;
	}else{
		return true;	
	}	
}

function duplicateChk(){
	var userNm = $('input[name=userNm]').val();
	if(userNm ==''){
		alert('이름을 입력하세요');
		return;
	}
	ajaxCall('/admin/duplicateChk.ino',{"userNm":userNm},function(data){
			console.log(data)
			alert(data.id+"가 가능합니다.");
			$('#id').val(data.id);
	});
}

function saveData(){
	var formData = $('#form1').serialize();
	if(validate()){
		ajaxCall('/admin/join.ino', formData, function(data){
			if(data.result==1){
				alert('회원가입되었습니다.');
				window.close();
			}else{
				alert('오류가 발생했습니다. 관리자에게 문의해주시기 바랍니다.')
			}
		})
	}
	
	
	
	
}
</script>
<style>
.form-inline > div>label,
.form-inline > div>input{
display:inline-block;
}
</style>
</head>
<body>
<div class="inner">
	<h1>계정생성</h1>
	<form  class="form-inline" id="form1">	
		  <div class="form-group">
		  		<label for="userNm">아이디</label>
		  		<input type="text" class="form-control" id="id" name="id" style="backgroud-color:#dddddd;" readonly=readonly placeholder="이름을 확인해주세요"/>
		  </div>	
		  <div class="form-group">
		  		<label for="userNm">이름</label>
		  		<div class="w100">
					<input class="form-control" type="text" name="userNm" style="width:79%;display:inline-block"/>
				    <button class='btn btn-default w20' type="button" onclick="duplicateChk()" style="width:20%;display:inline-block">중복확인</button>
			    </div>
		  </div>
			
		  <div class="form-group">
		  		<label for="userNm">생년월일</label>
				<input class="form-control" type="text" name="bDate"/>
		  </div>
  		  <div class="form-group">
		  		<label for="userNm">비밀번호</label>
				<input class="form-control" type="password" name="pw"//>
		  </div>
		  <div class="form-group">
		  		<label for="userNm">비밀번호</label>
				<input class="form-control" type="password" name="pw1"//>
		  </div>
		<div class="w100">
		<button class='btn btn-default left' type="reset">다시입력</button>
		<button class='btn btn-default btn-info right' type="button" onclick="saveData()">계정생성</button>
		</div>
	</form>
</div>
</body>
</html>