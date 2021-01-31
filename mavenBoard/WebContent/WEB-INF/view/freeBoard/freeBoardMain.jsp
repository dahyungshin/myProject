<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.paging {
	list-style: none;
	display: flex;
}

.page {
	text-align: center;
}
</style>
</head>
<body>

	<div>
		<h1>자유게시판</h1>
	</div>
	<div style="width: 650px;" align="right">
		<a href="./freeBoardInsert.ino">글쓰기</a>
	</div>
	<hr style="width: 600px">

	<c:forEach items="${freeBoardList }" var="dto">
		<div style="width: 50px; float: left;">${dto.num }</div>
		<div style="width: 300px; float: left;">
			<a href="./freeBoardDetail.ino?num=${dto.num }">${dto.title }</a>
		</div>
		<div style="width: 150px; float: left;">${dto.name }</div>
		<div style="width: 150px; float: left;">${dto.regdate }</div>
		<hr style="width: 600px">
	</c:forEach>
	<div>
		<form action="./freeBoard_Search.ino">
			<select name="type">
				<option value="name">이름</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select> <input type="text" name="searchText">
			<button type="submit" onClick="Search_Click()">검색</button>
		</form>  
	</div> 
	<div style="text-align: center;">   
		<div style="display: inline-block;"> 
			<ul class="paging">     
				<li class="page">${paging }</li> 
			</ul>
		</div>
	</div>


</body>
</html>