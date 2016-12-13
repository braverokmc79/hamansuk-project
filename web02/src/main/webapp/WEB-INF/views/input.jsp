<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


구구단 입력 
<br>
 
<form method="post" action="gugu">
몇단 ?<input type="text" name="gugu" > <br>
<input type="submit" value="전송" >
</form>

${ gugu }

</body>
</html>