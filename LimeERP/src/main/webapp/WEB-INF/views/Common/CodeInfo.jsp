<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
    
<!-- tagLib start --> 
<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"		prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"	prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"		prefix="fmt" %>
--%>
<%@ taglib uri="/WEB-INF/tld/LimeERP.tld"				prefix="limeERP" %>
<!-- tagLib finish -->

<!-- class import start -->
<%@ page import="domain.dto.*" %>
<%@ page import="java.util.*" %>
<!-- class import finish -->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="/erpapp/resources/lib/jquery-3.4.1.min.js"></script>

<title>Code Info Test</title>

<!-- 임시 적용 style -->
<style>
	table, th, td {
		border: 1px solid;
	}
	
	th {
		padding: 0px 10px 0px 10px;
	}
	
	td {
		padding: 0 0 0 0;
	}
</style>

<script>

	// Page Onload
	$(document).ready(function() {
		console.log("page's Ready");

		// 수정버튼 클릭
		$("#updCodeInfoBtn").on("click", function(){
			console.log("삭제버튼 클릭");
			
			var dataArr = new Array(); // servlet 으로 data 를 넘기기 위한 array
			var checkBox = $("input[name=codeListChkBox]:checked"); // check 된 checkBox 를 파싱
			
			// FIXME validation
			
			// 체크된 체크박스 값을 가져온다
	    	checkBox.each(function(i) {
	    
	    		var rowData = {};
	    		
		        // checkbox.parent() : checkbox의 부모는 <td>이다.
		        // checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
		        var tr = checkBox.parent().parent().eq(i);
		        var td = tr.children();
		        
		        // 당 화면에서 td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
		        // <td> 에 있는 input elem 을 찾아, input 의 value 를 반환한다. 
		        var vsDetCd = td.eq(1).find("input").val();	// 상세코드
		        var vsDetNm = td.eq(2).find("input").val();	// 상세코드명
		        
		        // 임시 생성한 배열에 key=value 형식으로 값 초기화
		        rowData["detailCd"] = vsDetCd;
		        rowData["detailNm"] = vsDetNm;
		        
		        // 초기화 된 배열을 servlet 으로 넘길 array 에 담아준다.
		        dataArr.push(rowData);
	    	}); // 체크된 데이터 파싱
	    	
	    	// 수정 및 삭제된 데이터가 있는 경우
	    	if ( dataArr != null && dataArr.length != 0 ) {
	    		console.log("dataArr 있땅");
	    		
	    		// ajax start
	    		$.ajax({
	    			contentType: "application/json",
	    			url: "/erpapp/codeMgmt/updateCodeInfo",
	    			type: "post",
	    			dataType: "json",
	    			data: {
	    				updCodeInfo: JSON.stringify(dataArr)
	    			},
	    			success: function(data) {
	    				console.log("ajax success");
	    			},
	    			error: function(e) {
	    				console.log("ajax error : ");
	    			}
	    		}); // ajax finish
	    		
	    	// 수정 및 삭제된 데이터가 없는 경우
	    	} else {
	    		console.log("dataArr 없땅");
	    	}
	    	
		});	// 삭제버튼 이벤트
	});
	
	
</script>

</head>
<body>

	<!-- 페이지 Title -->
	<h2>
		Code Info Page Test
	</h2>
	
	<br>
	
	<!-- 검색조건 영역 start -->
	<div id="srchGrp" style="width: 1080px; background-color: #EFEFEF; display: inline-block;">
		<form method="post" action="/erpapp/codeMgmt/codeInfo">
			<div id="srchParamGrp" style="width:85%; float:left; display: table-cell;">
				<span style="vertical-align: middle;">
					<Label for="srchCode">상세코드&nbsp&nbsp&nbsp&nbsp</Label><input name="detailCd"><br>
					<Label for="srchCodeNm">상세코드명&nbsp</Label><input name="detailNm"><br>
				</span>
			</div>
			<div id="srchBtnGrp" style="width:15%; float:right; display: table-cell;">
				<span style="vertical-align: middle;">
					<button id="resetBtn" style="width: 100px;">초기화</button>
					<input type="submit" id="srchBtn" style="width: 100px;" value="조회">
				</span>
			</div>
		</form>
	</div>
	<!-- 검색조건 영역 finish -->
	
	<br><br>
	
	<!-- 컨텐츠 영역 start -->
	<div id="content" style="clear:both; width: 1080px;">

		<!-- 코드 목록 영역 start -->
		<div id="codeInfo" style="width: 50%; float: left;">

			<!-- 코드 테이블 start -->
			<table id="codeList" style="width: 80%;">
				<caption> 코드 목록 </caption>
				<colgroup>
					<col width="14%">
					<col width="43%">
					<col width="43%">
				</colgroup>
				<thead>
					<tr>
						<th>선택</th>
						<th>코드</th>
						<th>코드명</th>
					</tr>
				</thead>
				<tbody>
				<!-- 테이블 body 구성 start -->
				<%
					List<CodeDto> commCdList = (List<CodeDto>) request.getAttribute("commCdList");

					/* data 가 있는 경우 */
					if ( commCdList != null && commCdList.size() > 0 ) {
						
						/* dataSize 만큼 tr 구성(paging 설정에 따라 size=10) */
						for ( int i=1; i<commCdList.size()+1; i++ ) {
							CodeDto dataRow = commCdList.get(i-1);
							String detailCd = dataRow.getDetailCd();
							String detailNm = dataRow.getDetailNm();
				%>
					<tr>
						<td style="text-align: center;"><input type="checkbox" name="codeListChkBox"></td>
						<td><input id="code<%= i %>" value="<%= detailCd %>" readonly></td>
						<td><input id="codeNm<%= i %>" value="<%= detailNm %>" readonly></td>
					</tr>
				<%
						}
					/* data 가 없는 경우 */
					} else {
				%>
					<tr><td colspan="3" style="text-align: center;"> 데이터가 없습니다. </td></tr>
				<%
					}
				%>
				</tbody>
			</table>
			<!-- 코드 테이블 finish -->
			
			<br>
			
			<!-- 페이징 영역 start : 임시 div-->
			<div id="pagination">
				<!-- paging.jsp include -->
				<%@ include file="/WEB-INF/include/Paging.jsp" %>
			</div>
			<!-- 페이징 영역 finish -->
			
			<br>
			
			<!-- 테이블 버튼 영역 start -->
			<div id="tableBtn" style="width: 80%; text-align: right;">
				<span><input type="button" id="rmvCodeInfoBtn" value="삭제"></span>
				<span><input type="button" id="updCodeInfoBtn" value="수정"></span>
			</div>
			
			<!-- 테이블 버튼 영역 finish -->
		</div>
		<!-- 코드 목록 영역 finish -->
		
		<!-- 입출력 영역 start -->
		<div id="codeContent" style="width: 50%; float: right; background-color: #FF00FF; display: inline-block;">
			<form method="post" action="/erpapp/codeMgmt/createCodeInfo">
				<table id="codeManager">
					<caption> 코드 정보 등록 </caption>
					<thead>
						<tr>
							<th>코드 구분 선택</th>
							<th>코드 입력</th>
							<th>코드명 입력</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<select name="comDivCd">
									<option value="">선택하세요</option>
									<c:forEach items="${commCdDivList}" var="divList" varStatus="varNum">
										<option value="${divList.comDivCd}">${divList.comDivNm}</option>
									</c:forEach>
								</select>
							</td>
							<td><input name="detailCd"></td>
							<td><input name="detailNm"></td>
						</tr>
					</tbody>
				</table>
				<br>
				<div id="regBtn" style="text-align: right; background-color: #00FF00; padding: 0 20px 0 0;">
					<input type="submit" id="codeReg" style="width: 100px;" value="등록">
				</div>
			</form>
		</div>
		<!-- 입출력 영역 finish -->
		
	</div>
	<!-- 컨텐츠 영역 finish -->
	
</body>
</html>