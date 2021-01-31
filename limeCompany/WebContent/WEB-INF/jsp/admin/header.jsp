<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var joinPop;
function openJoinPop(){
	joinPop = window.open('/admin/joinPop.ino','라임컴퍼니','width=500px,height=500px');
	
}
function moveTab(tabNo){
	$('.tab').hide();
	$('#tab'+tabNo).show();
}
</script>
<h1>여기는 운영자용메인</h1>
<div class="btn-wrap w100">
	<div class="left">
		<button id="userTab" class="btn btn-default" onclick="moveTab(1)">사용자관리</button>
		<button id="puntualityTab" class="btn btn-default" onclick="moveTab(2)">출결관리</button>
	</div>
	<div class="right">
	<button id="logout" class="btn btn-default">로그아웃</button>
	</div>
</div>
