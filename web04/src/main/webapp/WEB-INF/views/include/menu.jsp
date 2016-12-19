<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
		String uri="";
 %>    


    
    <div class="spinner"></div>
<!--============================== header =================================-->
<header>
      <div class="container clearfix">
    <div class="row">
          <div class="span12">
        <div class="navbar navbar_">
              <div class="container">
            <h1 class="brand brand_"><a href="/"><img alt="" src="/resources/template/img/logo.gif"> </a></h1>
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse_">Menu <span class="icon-bar"></span> </a>
            <div class="nav-collapse nav-collapse_  collapse">
                  <ul class="nav sf-menu">
                
                <%
                   uri=request.getRequestURI();
                // pageContext.setAttribute("uri", uri);
               //  out.print(uri.contains("guestbook"));
                
                 out.print(application.getRealPath("/") +"<br>");
                  //out.print(request.getSession().getServletContext().getRealPath("/"));
                %>
                
                
                
                <li  <c:if test='<%= uri.contains("guestbook") %>' > class="sub-menu active" </c:if>  >
              	<a href="/guestbook/list" >방명록</a>
              		<ul>
                    <li><a href="/guestbook/write">방명록 등록</a></li>
                  </ul>
              	</li>
             	
             	<li ><a href="index-2.html">수산물관리</a></li>
             
                <li <c:if test='<%= uri.contains("shop") %>' > class="sub-menu active" </c:if> >
                <a href="/shop/product_list">상품</a>
                <c:if test="${loginUser.userid=='admin' }">
                	<ul>
                		 <li><a href="/shop/product_write" id="product_write">상품등록</a></li>
                	</ul>
                </c:if>
                
                </li>
                
               <li <c:if test='<%= uri.contains("cart") %>' > class="sub-menu active" </c:if>><a href="/cart/cart_list">장바구니</a></li>
             
             
                <li> 
                <a href="index-1.html">게시판</a>
                 <ul>
                    <li><a href="#">수산물관리 </a></li>
                    <li><a href="#">Consecte</a></li>
                    <li><a href="#">Conseq</a></li>
                  </ul>
               </li>
               <c:choose>
               
               
              <c:when test="${ not empty loginUser }">
              	<li><a href="">${ loginUser.username} 님 </a></li>
              	<li><a href="/member/logout">로그아웃</a></li>
              </c:when>
                <c:otherwise>
                <li><a href="/member/login">로그인</a></li>
              </c:otherwise>
              </c:choose>

              </ul>
                </div>
          </div>
            </div>
      </div>
        </div>
  </div>
    </header>
  