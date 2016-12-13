<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--    userid       varchar(50),
   userpw       varchar(50),
   username     varchar(50),
   email        varchar(100),
   regdate      timestamp DEFAULT 'CURRENT_TIMESTAMP',
   updatedate   timestamp DEFAULT '0000-00-00 00:00:00'
 -->
<form  method="post" action ="/member/memebrInsert">
이름 : <input type="text" name="username" /> <br>
아이디 : <input type="text" name="userid" /> <br>
패스워드 : <input type="text" name="userpw" /> <br>
이메일 : <input type="text" name="email" /> <br>
<input type="submit" value="전송" />

</form>

<script>

var insertMsg ="${insertMsg}";

if(insertMsg=="FAIL"){
	
	alert("등록에 실패 했습니다." );	
}


</script>

</body>
</html>