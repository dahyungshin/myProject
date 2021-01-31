<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){
	getList();
	$("#logout").click(function(){
		location.href = '/logout.ino';
	});
	
});

function getList(page){
	ajaxCall('/user/getAttendanceList.ino','',function(data){
		var start   = 0;
		var current = 1;
		if(page){
			var start   = (page-1)*10;
			var current = page;
		}	
		
		var param = {"start":start,
				 "current":current};		
		ajaxCall('getAttendanceList.ino',param,function(data){
			$('#punctualityList').empty();
			console.log(data)
			var html = "";
			var list = data.punctualityList;
			var max = 0;
			for(var i=0; i<list.length; i++){
				var item = list[i];
				if(i==0){
					max = item.max;
				}
				html += '<tr>';
				html += '	<td>';
				html += '		'+item.no;
				html += '	</td>';
				html += '	<td>';
				html += '		'+item.codeNm;
				html += '	</td>';
				html += '	<td>';
				html += '		'+item.userId;
				html += '	</td>';
				html += '	<td>';
				html += '		'+item.date;
				html += '	</td>';
				html += '	<td>';
				html += '		'+item.dateCnt;
				html += '	</td>';
				html += '	<td>';
				if(item.approvalYn == 'Y'){
					html += '결재완료';
				}else if(item.approvalYn =='N'){
					html += '결재미완료'
				}else if(item.approvalYn =='F'){
					html += '반려'	
				}
				html += '	</td>';
				html += '</tr>';
			}
			$('#punctualityList').html(html);
			$('#info').text('총'+max+"건")
			setPaging(max,current,'searchVacation');			
		});	
	});
}


function setPaging(max,current,func){
	$('#pagingNav').empty();
	var start = Math.floor(current/10)+1;
	var end = start+9;
	max = Math.floor(max/10+1);
	console.log("start:"+start+"  end :"+end+"  max"+max+"  current"+current)
	var html= "";
	for(var i=start;i<=(end<max?end:max);i++){
		if(i==current){
			html+="<span>"+i+"</span>";
		}else{
			html+="<a onclick=\""+func+"('"+i+"')\">"+i+'</a>';
		}
	}
	$('#pagingNav').html(html);	
}
</script>
<div>
	<h1>여기는메인</h1>
	<button id="logout">로그아웃</button><br/>
	<button type="button" onclick="getList()">테스트</button>
	<button type="button" onclick="location.href='newAttendance.ino'">신규작성</button>
	
	<table class="table">
		<thead>
			<tr class="center">
				<th>번호</th>
				<th>종류</th>
				<th>이름</th>
				<th>날짜</th>
				<th>일수</th>
				<th>결재</th>
			</tr>
		</thead>
		<tbody id="punctualityList">
		
		
		</tbody>
	</table>
	<div id="pagingNav">
	</div>
</div>
