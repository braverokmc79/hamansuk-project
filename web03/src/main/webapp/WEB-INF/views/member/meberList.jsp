<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>회원 목록</h2>

<table border="1">

 <tr>
 	<th>아이디</th>
 	<th>이름</th>
 	<th>이메일</th>
 	<th>회원 가입 일자</th>
 </tr>

	<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.userid }</td>
			<td><a href="/member/memeberInfo?userid=${vo.userid }" >${vo.username }</a></td>
			<td>${vo.email }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd hh-mm" value="${vo.regdate }"  /></td>
		</tr>
	</c:forEach>


</table>




</body>
</html>


