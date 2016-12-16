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
              <h3>방목록 [ ${listCount } ]</h3>
              <button type="button" class="btn btn-primary"  style="float: right; margin-bottom: 10px;" id="regBtn">등록</button>
             
        </article>
        <div class="clear"></div>
        <ul class="thumbnails thumbnails-1 list-services">
         
         <c:forEach items="${gblist }" var="list"  varStatus="status">
         
		
       		         
        
         <li class="span4" data-idx="${list.idx }"  data-email="${list.email}"  data-name="${list.name }" >
         
        	<c:set var="number" value="${ status.count}" />
          
            <div class="thumbnail thumbnail-1">
            <c:if test="${status.count > 6 }">
            	<c:set var="number"  value="1" />
            </c:if> 
            <img  src="<c:out  value="/resources/template/img/page2-img${number}.jpg" />" alt="">
            
                  <section> <a href="#" class="link-1">${list.name } </a>
            
               <div class="form-group">
							<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="3">${list.content }</textarea>
				</div>
                
                <p>${list.email } </p>
                <p><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.post_date }"  /> </p>
                
            
            	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button>
              </section>
           
           		<hr>
	           	 <form action="/guestbook/view" method="post">
	           		<input type="hidden" name="idx" value="${list.idx }" />
	        		<input type="password"  name="passwd" placeholder="비밀번호 입력"  />	
	        		<input type="submit" class="btn btn-primary"  value="비밀 번호 확인" />
	       		</form>
           
           </div>
           
        
       </li>
   		
         
   		
   		
   		</c:forEach>
       
       
        </ul>
<%--         
        <c:forEach var="list2" items="${gblist }"> 
        
        	<div>
        		${list2.content }
        	</div>
        	<hr>
        </c:forEach>
 --%>
        
        
      </div>
        </div>
  </div>
    </div>





<!-- Modal -->
<div id="myModal" class="modal modal-primary fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">  <img alt="" src="/resources/template/img/logo.gif"></h4>
      </div>
      <div class="modal-body" data-rno>
      
              
        <form role="modalForm" action=""  method="post">
        		<input type="text" name="idx" id="mIdx" >
        		<div class="form-group" >
							<label for="exampleInputEmail1">이름</label> 
							<input type="text"	name='name' class="form-control" id="mName">
				</div>
				<div class="form-group" >
							<label for="exampleInputEmail1">이메일</label> 
							<input type="email"	name='email' class="form-control" id="mEmail">
				</div>
				<div class="form-group">
							<label for="exampleInputPassword1">내용</label>
							<textarea class="form-control" name="content" rows="3" id="mContent"></textarea>
				</div>
				<div class="form-group">
							<label for="exampleInputEmail1">패스워드</label> 
							<input type="password"	name="passwdCk" class="form-control" id="mPasswdCk">
				</div>
        </form>
     
      
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>      
	




<script type="text/javascript">

$(document).ready(function(){
	
	$("#regBtn").click(function(){
		
		//alert("등록");	
		location.href="/guestbook/write";
		
	});
	
	$(".list-services").on("click", ".span4", function(event){
		
		var li =$(this);
		var idx=li.attr("data-idx");
		var name=li.attr("data-name");
		var email =li.attr("data-email");
		var content =li.find(".form-group").find("textarea").val();
		
		//alert(idx + " :  " +  name + " : " + email + " : " + content);
		
		$("#mIdx").val(idx);
		$("#mName").val(name);
		$("#mEmail").val(email);
		$("#mContent").val(content);
		
		
	} );
	
	$("#replyModBtn").click(function(){
		var  idx=$("#mIdx").val();
		var name=$("#mName").val();
		var eamil=$("#mEmail").val();
		var content=$("#mContent").val();
		var passwdCk=$("#mPasswdCk").val();
		//alert(idx + " :  " + name + " : " + eamil + " : " + " : "+ content + " : " + passwdCk );
		if(passwdCk==null || passwdCk.length <=0){ 
			alert("패스워드를 입력 하세요");
			return;
		}
		
		$.ajax({
			type:"PUT",
			url :"/guestbook/"+idx,
			headers : {
				"Content-Type" :"application/json",
				"X-HTTP-Method-Override" :"PUT"
			},	
			data:JSON.stringify({
					
					rno: idx,
					idx :idx,
					name:name,
					email :eamil,
					content :content,
					passwdCk :passwdCk
				
			}),
			dataType:"text",
			success :function(result){
				
				if(result=="SUCCESS"){
					alert("수정 했습니다.");
					$("#myModal").modal("hide");
					$("#mPasswdCk").val();
					
					getList();
				}else if(result =="pwError"){
					alert("비빌 번호가 틀립니다.");
					$("#mPasswdCk").val();
				}	
			}
			
		});
	});
	
	
	/* 리스트 목록 불러오기 */
	function getList(){
		
		$.getJSON("/guestbook/rlist", function(data){
			
			//alert(data.length);		
			printData(data, $(".list-services"), $("#template"));
		});
		
	}
	
	var printData =function (replyArr, taget, templateObject){
		
		var template =Handlebars.compile(templateObject.html());
	
		var html =template(replyArr);
		
		$(".list-services").html(html);
		
	}
	
	Handlebars.registerHelper("prettifyDate", function(timeValue){
		
		var dateObj =new Date(timeValue);
		var year =dateObj.getFullYear();
		var month =dateObj.getMonth() +1;
		var date =dateObj.getDate();
		
		return year +"/"+month+"/"+date;
		
		
	});
	
	//패스워트 체크 에러 메시지
	var error ="${pwdCkError}";
	if(error.length >3){
		alert(error);
	}
	
	
	//modal 삭제
	$("#replyDelBtn").click(function(){
		
		var  idx=$("#mIdx").val();
		var passwdCk=$("#mPasswdCk").val();
		
		
		if(passwdCk==null || passwdCk.length <=0){ 
			alert("패스워드를 입력 하세요");
			return;
		}
		
		
		$.ajax({
			type:"POST",
			url :"/guestbook/rdelete",
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType :"text",
			data :JSON.stringify({
				idx :idx,
				passwdCk :passwdCk
			}),
			success :function(result){
				if(result=="SUCCESS"){
					alert("삭제 되었습니다.");
					$("#myModal").modal("hide");
					$("#mPasswdCk").val();
					
					getList();
				}else if(result =="pwError"){
					alert("비빌 번호가 틀립니다.");
					$("#mPasswdCk").val();
				}	
			}
			
		});
		
		
	});
	
	
	
});


</script>

<script>

	

</script>


<script id="template" type="text/x-handlebars-template">
{{#each .}}
<li class="span4" data-idx="{{idx}}"  data-email="{{email}}"  data-name="{{name}}" >
<div class="thumbnail thumbnail-1"> <img  src="/resources/template/img/page2-img1.jpg" alt="">
      <section> <a href="#" class="link-1">{{name}} </a>

   <div class="form-group">
				<label for="exampleInputPassword1">Content</label>
	<textarea class="form-control" name="content" rows="3">{{content}}</textarea>
	</div>
    
    <p>{{email}} </p>
    <p>{{prettifyDate post_date}}</p>
    

	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button>
  </section>

           		<hr>
	           	 <form action="/guestbook/view" method="post">
	           		<input type="hidden" name="idx" value="${list.idx }" />
	        		<input type="password"  name="passwd" placeholder="비밀번호 입력"  />	
	        		<input type="submit" class="btn btn-primary"  value="비밀 번호 확인" />
	       		</form>
 </div>
</li>

{{/each}}
</script>


<%@  include file="../include/footer.jsp" %>

