<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    

<script type="text/javascript">
<!--

$(document).ready(function(){
	

	var loginUser ="${loginUser.userid}";
	
	if(loginUser!="admin"){
		
		alert("관리자만 접근 가능합니다.");
		location.href="/shop/product_list";
	}
	



});



//-->
</script>    