<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/jsp/comInclude.jsp"/>
</head>
<body>
<div id="wrapper" style="height:100%; background-color:#eee; padding:10px 0  10px 0;">
	<div class="inner">
        <div id="header">
        	<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
        </div>
        <div id="container">
	            <decorator:body></decorator:body>
        </div>
   	</div>
</div>
</body>
</html>