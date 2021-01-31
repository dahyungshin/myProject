<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>Explosion</title>
<jsp:include page="/WEB-INF/tiles/commonInclude.jsp"/>
</head>
<body>
	<div class="container">
	<tiles:insertAttribute name="header" />
	</div>
	<div id="wrapper">
		<div id="content-wrapper">
		<tiles:insertAttribute name="content" />
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>
