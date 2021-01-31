<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/LimeERP.tld" prefix="limeERP" %>

<c:set var="page" value="1" />
<c:if test="${!empty param.currentPage}"><c:set var="page" value="${param.currentPage}" /></c:if>
<c:set var="indexPerPage" value="10" />
<c:if test="${!empty param.indexPerPage}"><c:set var="indexPerPage" value="${param.indexPerPage}" /></c:if>

<script type="text/javascript">

	function goPage(pageNum, url){
		
		if(pageNum == 0){
			return;
		}
		
		$("body").append($("<form id='pageFrm'>"));
		
		var postUrl  = url.split("?")[0];
		var arrParam = url.split("?")[1];
		var paramObj = JSON.parse('{"' + decodeURI(arrParam.replace(/&/g, "\",\"").replace(/=/g,"\":\"")) + '"}')
		
		$.each(paramObj, function(key, value){
			$("#pageFrm").append($("<input>",{ 
		        type:"hidden",
				name: key,
		        id: key,
		        value : value, 
		    }));
		});
		$("#pageFrm").attr("method","post");
		$("#pageFrm").attr("action",postUrl);
		$("#pageFrm").submit();
	}

</script>

<div class="paginate">
    <limeERP:paging name="paging" recordsPerPage="${recordsPerPage}" totalRecordCount="${totalRecordCount}" currentPage="${page}" indexPerPage="${indexPerPage}">

        <%-- First --%>
        <c:if test="${!empty paging.firstPage.href}">
            <a class="direction first disabled" href="javascript:goPage(${paging.firstPage.index}, '${paging.firstPage.href}')"><span>처음</span></a><!-- 비활성화 시 a태그에 disabled 클래스 추가  -->
        </c:if>

        <%-- Prev --%>
        <c:if test="${!empty paging.previousPage.href}">
            <a class="direction prev" href="javascript:goPage(${paging.previousPage.index}, '${paging.previousPage.href}')"><span>이전</span></a>
        </c:if>
        <%-- Numbering --%>
        <span class="num">
            <c:forEach var="numbering" items="${paging.pages}" varStatus="status">
              <c:choose>
                <c:when test="${numbering.index eq paging.currentPage}">
                    <strong>${numbering.index}</strong>
                </c:when>

                <c:otherwise>
                    <a href="javascript:goPage(${numbering.index}, '${numbering.href}')" title="${numbering.index} 페이지">${numbering.index}</a>
                </c:otherwise>
              </c:choose>
            </c:forEach>
        </span>

        <%-- Next --%>
        <c:if test="${!empty paging.nextPage.href}">
            <a class="direction next" href="javascript:goPage(${paging.nextPage.index}, '${paging.nextPage.href}')"><span>다음</span></a>
        </c:if>

        <%-- Last --%>
        <c:if test="${!empty paging.lastPage.href}">
            <a class="direction last disabled" href="javascript:goPage(${paging.lastPage.index}, '${paging.lastPage.href}')"><span>마지막</span></a>
        </c:if>
    </limeERP:paging>
</div>