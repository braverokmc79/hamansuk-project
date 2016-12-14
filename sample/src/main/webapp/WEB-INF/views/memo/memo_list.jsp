<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<table border="1" style="width:700px">
	<tr>
		<td>No</td>
		<td>이름</td>
		<td>메모</td>
		<td>날짜</td>
	</tr>
<!-- 달러{맵변수명.변수명} or 달러{맵변수명["변수명"]} -->	
<c:forEach var="row" items="${map.items}">
	<tr>
		<td>${row.idx}</td>
		<td>${row.writer}</td>
		<td>
			<a href="#" onclick="javascript:memo_view('${row.idx}')">
			${row.memo}
			</a>
		</td>
		<td>${row.post_date}</td>
	</tr>
</c:forEach>	
</table>
</body>
</html>










