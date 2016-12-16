<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"  %>

<%@ include file="../include/menu.jsp"  %>



<div class="bg-content"> 
      
      <!--============================== content =================================-->
      
      <div id="content"><div class="ic"></div>
    <div class="container">
          <div class="row">
        <article class="span12">
              <h3>등록</h3>
            
             
        </article>
        <div class="clear"></div>


  	</div>



		<div class="span12">
			
			
			<form name="form1" method="post">

         <div class="thumbnail thumbnail-1">
          	<input type="text" name="idx"  readonly="readonly" value="${list.idx }">
        		<div class="form-group" >
							<label for="exampleInputEmail1">이름</label> 
							<input type="text"	name='name' class="form-control" value="${list.name }" >
				</div>
				<div class="form-group" >
							<label for="exampleInputEmail1">이메일</label> 
							<input type="email"	name='email' class="form-control"  value="${list.email }">
				</div>
				<div class="form-group">
							<label for="exampleInputPassword1">내용</label>
							<textarea class="form-control" name="content" rows="3" >${list.content }</textarea>
				</div>
			
				
           	 	<button type="button" class="btn btn-info btn-lg" id="viewModify" >수정</button>
           	 	<button type="button" class="btn btn-danger"  id="viewDelete">삭제</button>
             
           
           
           	<hr>
	              
           </div>
       
           </form>
        
        
        </div>
        
        
          
        </div>
  </div>
    </div>
  
<script>
$(document).ready(function(){
	
	$("#viewModify").click(function(){
		
		document.form1.action="/guestbook/modify";
		
		document.form1.submit();
		
	});
	
	
	$("#viewDelete").click(function(){
		if(confirm("정말 삭제 하시겠습니까?")){
			document.form1.action="/guestbook/delete";
			document.form1.submit();
			//alert("삭제");
				
		}
		
	});
	
});

</script>


<%@  include file="../include/footer.jsp" %>

