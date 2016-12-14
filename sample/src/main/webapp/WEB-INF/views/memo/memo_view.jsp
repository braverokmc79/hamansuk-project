<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>홈 페이지</title>

<script type="text/javascript"  src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready( function(){
	$("#btnUpdate").click(function(){
		$("#form1").attr("action","<%=context%>/memo_update.do");
		$("#form1").submit();
	});
	$("#btnDelete").click( function(){
		if( confirm("삭제하시겠습니까?")) {
			$("#form1").attr("action", "<%=context%>/memo_delete.do");
			$("#form1").submit();
		}
	});
});
</script>
</head>

<body <c:if test="${sessionScope.second != null }">onload="javascript:startTimer('${sessionScope.second}');"</c:if> >
	<div class="page">
		<!-- Header -->
		<!-- Header -->
		
		<!-- main contents 영역 -->
		<div id="main">

			<h2>메모장</h2>
			<form id="form1" name="form1" method="post">
				이름 <input type="text" name="writer" id="writer" 
					value="${dto.writer}"  /><br>
				메모 <input type="text" name="memo" id="memo" 
					value="${dto.memo}" size="50" />
				<br>
				<input type="hidden" id="idx" name="idx" value="${dto.idx}" />
				<input type="button" id="btnUpdate" value="수정" />
				&nbsp;
				<input type="button" id="btnDelete" value="삭제" />
				&nbsp;
				<input type="button" id="btnList" value="목록" 
				onclick="location.href='<%=context%>/memo/memo.jsp';"/>
			</form>
			
		</div>
		<!-- main contents 영역 -->
		
	</div>
</body>
</html>
