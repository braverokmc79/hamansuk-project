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

        			<form role="form1" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">이름</label> <input type="text"
								name='name' class="form-control" placeholder="이름">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">이메일</label> <input type="email"
								name='email' class="form-control" placeholder="email">
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">패스워드</label> <input type="password"
								name='passwd' class="form-control" >
						</div>
						
						
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3"></textarea>
						</div>
				
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-info">등록하기</button>
						<button type="reset" class="btn btn-danger">취소</button>
					</div>
				</form>
        
        
        
        </div>
        
        
          
        </div>
  </div>
    </div>
  



<%@  include file="../include/footer.jsp" %>

