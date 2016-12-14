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
$(document).ready( function() { //onload 이벤트
	memo_list();
	$("#btnWrite").click(function(){ //버튼클릭이벤트
		memo_insert();		
	});
});
function memo_insert(){
	var writer = $("#writer").val();
	var memo = $("#memo").val();
	var param = "writer="+writer+"&memo="+memo;
	$.ajax({
		type: "post",
		data: param,
		url: "<%=context%>/memo_insert.do",
		success: function(){
			//메모목록 갱신
			memo_list();
			//폼입력값 초기화
			//$("#writer").val("");
			$("#memo").val("");
		}
	});
}

function memo_list(){
	$.ajax({
		type: "post",
		url: "<%=context%>/memo_list.do",
		success: function( data ){
			$("#memoList").html( data );
		}
	});
}

function memo_view( num ) {
	$(location).attr( "href", "<%=context%>/memo_view.do?idx="+num );
	//location.href = "<%=context%>/memo_view.do?idx="+num;
}
</script>
</head>

<body <c:if test="${sessionScope.second != null }">onload="javascript:startTimer('${sessionScope.second}');"</c:if> >
	<div class="page">
		<!-- Header -->
		<!-- Header -->
		
		<!-- main contents 영역 -->
		<div id="main">
			<h2>한줄메모장</h2>
			<div id="memoInput">
				<form name="form1" id="form1" method="post">
					이름 <input type="text" name="writer" id="writer" 
						value="${sessionScope.name}"  />
					메모 <input type="text" name="memo" id="memo" size="50" />
					<input type="button" id="btnWrite" value="확인" />
				</form>
			</div>
			<div id="memoList"></div>			
		</div>
		<!-- main contents 영역 -->
		
	</div>
</body>
</html>


