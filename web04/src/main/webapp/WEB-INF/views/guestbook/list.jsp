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
              <h3>Services</h3>
              <button type="button" class="btn btn-primary"  style="float: right; margin-bottom: 10px;" id="regBtn">등록</button>
             
        </article>
        <div class="clear"></div>
        <ul class="thumbnails thumbnails-1 list-services">
         
         <c:forEach items="${gblist }" var="list">
         <li class="span4">
            <div class="thumbnail thumbnail-1"> <img  src="/resources/template/img/page2-img1.jpg" alt="">
                  <section> <a href="#" class="link-1">${list.name } </a>
                <p>${list.content } </p>
                <p>${list.email } </p>
                <p><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.post_date }"  /> </p>
                
            
            	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button>
              </section>
                </div>
          </li>
   		</c:forEach>
       
       
        </ul>
        
        

        
        
      </div>
        </div>
  </div>
    </div>



<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        
        <form >
        		<div class="form-group">
							<label for="exampleInputEmail1">Title</label> <input type="text"
								name='title' class="form-control" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3"
								placeholder="Enter ..."></textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Writer</label> <input type="text"
								name="writer" class="form-control" placeholder="Enter Writer">
						</div>
        
        </form>
        
        <p>Some text in the modal.</p>
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<script>

$(document).ready(function(){
	
	$("#regBtn").click(function(){
		
		//alert("등록");	
		location.href="/guestbook/write";
		
	});
	
});

</script>

<%@  include file="../include/footer.jsp" %>

