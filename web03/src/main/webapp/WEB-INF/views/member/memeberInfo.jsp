<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>


<h2>회원 정보 수정</h2>

<form  method="post" role='form1'>
이름 : <input type="text" name="username"  value="${ dto.username}"/> <br>
아이디 : <input type="text" name="userid"  value="${ dto.userid }" readonly="readonly"/> <br>
패스워드 : <input type="text" name="userpw"  value="${ dto.userpw}"/> <br>
이메일 : <input type="text" name="email" value="${ dto.email }" /> <br>

변경할 패스워드 : <input type="text" name="updatepw"  /> <br>
<input type="submit" value="수정"  id="btnUpdate" />
<input type="submit" value="삭제"  id="btnDelete" />
</form>






<script>
$(document).ready(function(){
	
	
	$("#btnUpdate").click(function(){
		
		var formObj =$("form[role='form1']");
		
		formObj.attr("action", "/member/memberUpdate");
		
		formObj.submit();
		//alert("formObje" +  formObj);
		
	});
	
	
	
	$("#btnDelete").click(function(){
		if(confirm("삭제 하시겠습니까? ")){
			
			var formObj =$("form[role='form1']");
			
			formObj.attr("action", "/member/memberDelete");
			
			formObj.submit();
			//alert("formObje" +  formObj);
				
			
		}
		
	});
	
	
	
	
	
	var str="${pwError}";
	
	if(str.length >1){
		alert(str);
	}
	
});


</script>


</body>
</html>