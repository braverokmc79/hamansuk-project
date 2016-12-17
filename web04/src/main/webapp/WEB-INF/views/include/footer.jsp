<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form method="post" name="formPw" id="formPw" action="/shop/product_write">

</form>


<script>

$(document).ready(function(){
	
	
	var logOutMessage ="${logOutMessage}" ;
	
	if(logOutMessage.length >3){
		alert(logOutMessage);
	}
	
	$("#product_write").click(function(event){
		
		event.preventDefault();
		
		//alert("상품등록 페이지로 이동");
		$("#formPw").submit();
	});
	
	$("#productWriteBtn").click(function(event){
		$("#formPw").submit();
	});
	
	
});


</script>


<!--============================== footer =================================-->
<footer>
      <div class="container clearfix">
    <ul class="list-social pull-right">
          <li><a class="icon-1" href="#"></a></li>
          <li><a class="icon-2" href="#"></a></li>
          <li><a class="icon-3" href="https://twitter.com/oswt"></a></li>
          <li><a class="icon-4" href="#"></a></li>
        </ul>
    <div class="privacy pull-left">Website Template designed by <a href="http://store.templatemonster.com?aff=awdawd" target="_blank" rel="nofollow">TemplateMonster.com</a><br />Popular free web templates <a href="http://www.oswt.co.uk" target="_blank">at www.Oswt.co.uk</a></div>
  </div>
    </footer>
<script type="text/javascript" src="/resources/template/js/bootstrap.js"></script>
</body>
</html>