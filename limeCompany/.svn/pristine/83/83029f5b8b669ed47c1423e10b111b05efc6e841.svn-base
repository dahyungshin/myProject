<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	getAttendanceList();
	$("#logout").click(function(){
		location.href = '/logout.ino';
	});
	
	$('.icheck').iCheck({
	    radioClass: 'iradio_flat-purple'
	});
	
	getUserList();
})



function setPaging(max,current,func,target){
	$(target).empty();
	var start = Math.floor(current/10)+1;
	var end = start+9;
	max = Math.floor(max/10+1);
	var html= "";
	for(var i=start;i<=(end<max?end:max);i++){
		if(i==current){
			html+="<span>"+i+"</span>";
		}else{
			html+="<a onclick=\""+func+"('"+i+"')\">"+i+'</a>';
		}
	}
	$(target).html(html);	
}

function setTooltip(){
	$('[data-toggle="tooltip"]').tooltip()
}
function getAttendanceList(page){
	var start = 0;
	var current = 1;
	if(page){
		var start   = (page-1)*10;
		var current = page;
	}
	var chkApproval = $('input[name=chkApproval]:checked').val();
	var chkval = $('input[name=chkRadio]:checked').val();
	var param = {"code":chkval,
				 "start":start,
				 "current":current,
				 "approvalYn":chkApproval};
		var max = 0;
		ajaxCall('getAttendanceList.ino',param, function(data){
			$('#punctualityList').empty();
			var html = "";
			var list = data.punctualityList;
			
			for(var i=0; i<list.length; i++){
				var item = list[i];
				if(i==0){
					max = item.max;
				}
				html += '<tr>';
				html += '	<td>';
				html += '		'+item.no;
				html += '	</td>';
				html += '	<td><div data-toggle="tooltip" title="'+item.remark+'">';
				html += '		'+item.codeNm;
				html += '	</div></td>';
				html += '	<td>';
				html += '		'+item.userId;
				html += '	</td>';
				html += '	<td>';
				html += '		'+item.date;
				html += '	</td>';
				html += '	<td>';
				if(item.approvalYn == 'Y'){
					html += '결재완료';
				}else if(item.approvalYn == 'F'){
					html += '반려완료<button onclick="approval(\'Y\','+item.no+','+current+')">결재</button>'					
				}else{
					html += '<button onclick="approval(\'Y\','+item.no+','+current+')">결재</button>';
					html += '<button onclick="approval(\'F\','+item.no+','+current+')">반려</button>';
				}
				html += '	</td>';
				html += '</tr>';
			}
			$('#punctualityList').html(html);
			$('#info').text('총'+max+"건")
			setPaging(max,current,'getAttendanceList','#pagingNav');
			setTooltip();
		});		
}


function approval(ynf , no, page){
	var param = {"approvalYn":ynf, "no":no};	
		ajaxCall('approval.ino',param, function(data){
			getAttendanceList(page);
		})
	
}

function searchVacation(page){
	var userNm = $('input[name="userNm"]').val();
	if(userNm != ""){
		var start = 0;
		var current = 1;
		if(page){
			var start   = (page-1)*10;
			var current = page;		
		}	
		
		var param = {
				 "start":start,
				 "current":current,
				 "approvalYn":'Y',
				 "userId":userNm};		
		ajaxCall('getAttendanceList.ino',param,function(data){
			$('#punctualityList').empty();
			var html = "";
			var list = data.punctualityList;
			
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
				if(item.approvalYn == 'Y'){
					html += '결재완료';
				}
				html += '	</td>';
				html += '</tr>';
			}
			$('#punctualityList').html(html);
			$('#info').text('총'+max+"건")
			setPaging(max,current,'searchVacation','#pagingNav');			
		});				
	}else{
		alert('검색하실 이름을 입력하세요');
	}
}


function getUserList(){
	var param = {};
	ajaxCall('getUserList.ino',param,function(data){
		$('#userList').empty();
		var html = "";
		var list = data.userList;
		var max = data.max;

		for(var i=0; i<list.length; i++){
			var item = list[i];
			if(i==0){
			}
			html += '<tr>';
			html += '	<td>';
			html += '		'+item.id;
			html += '	</td>';
			html += '	<td>';
			html += '		'+item.userNm;
			html += '	</td>';
			html += '	<td>';
			html += '		'+item.bDate;
			html += '	</td>';
			html += '	<td>';
			html += '		<button type="button" onclick="updateUserPop(\''+item.id+'\')">수정</button>';
			html += '	</td>';
			html += '	<td>';
			if(item.failCnt==5){
				html += '		<button type="button" onclick="resetUserKey(\''+item.id+'\')">수정</button>';
			}
			html += '	</td>';
			html += '</tr>';
		}
		$('#userList').html(html);
		$('#userInfo').text('총'+max+"명")
		setPaging(max,current,'getUserList','#pagingNav_user');			
	});				

}




</script>
	<div class="form-group tab" id="tab1">
		<div class="tableDiv">
			<div class="info-wrap">
				<div class="left">
				<h3>조회결과<span class="badge" id="userInfo"></span></h3>
				</div>
				<div class="right" style="margin-top:17px">
					<button type="button" class="btn btn-default" onclick="openJoinPop()">계정생성</button>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>수정</th>
						<th>초기화</th>
					</tr>
				</thead>
				<tbody id="userList">
				</tbody>
			</table>			
			<div id="pagingNav_user"></div>
		</div>
	</div>
	
	<div class="form-group tab" id="tab2" style="display:none;">
		<div>
			<div class="col-sm-8">
			<label>
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-info active" for="radio1">
						<input type="radio" id="radio1" name="chkApproval" class="form-controll" value="" checked="checked"/>전체
					</label>
					<label class="btn btn-info" for="radio2">
						<input type="radio" id="radio2" name="chkApproval" class="form-controll" value="N"/>미결
					</label>
					<label class="btn btn-info" for="radio3">
						<input type="radio" id="radio3" name="chkApproval" class="form-controll" value="F"/>반려
					</label>
					<label class="btn btn-info" for="radio4">
						<input type="radio" id="radio4" name="chkApproval" class="form-controll" value="Y"/>결재
					</label>
				</div>
			</label>
			<div>
				전체<input type="radio" name="chkRadio" class="icheck" value="" checked="checked">			
				<c:forEach items="${codeList }" var="code" varStatus="i">
					${code.codeName}<input type="radio" name="chkRadio" class="icheck" value="${code.no }"/>
	<%-- 				<c:if test="${(i.count+1)%5 eq 0 }"><br/>	</c:if> --%>
				</c:forEach>
				<button type="button" class="btn btn-default btn-info right" onclick="getAttendanceList()">검색</button>
			</div>
			</div>
			<div class="col-sm-4">
				<h3>휴가리스트 출력</h3>
				<div class="w100">
					<input type="text" class="form-control" name="userNm" placeholder="조회하실 이름을 입력해주세요" style="width:78%;display:inline-block">
					<button type="button" class="btn btn-default btn-info" onclick="searchVacation();" style="width:20%;display:inline-block">검색</button>
			    </div>
			</div>
		</div>
		
		<div class="tableDiv">
			<h3>조회결과<span class="badge" id="info"></span></h3>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>종류</th>
						<th>이름</th>
						<th>날짜</th>
						<th>결재</th>
					</tr>
				</thead>
				<tbody id="punctualityList">
				</tbody>
			</table>
			
			<div id="pagingNav"></div>
		</div>
	</div>