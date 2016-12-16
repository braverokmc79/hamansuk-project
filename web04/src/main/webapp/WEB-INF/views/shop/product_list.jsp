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
        <h3>Folio</h3>
         </article>
        <div class="clear"></div>
        
        <ul class="portfolio clearfix">
        	<c:forEach items="${list }" var="row">	
        		<li class="box">
	        		<p>${row.product_id }</p>
	        		<p>
	        		<a href="/product_detail.do?product_id=${row.product_id }" >
	        		${row.product_name }</a></p>
	        		<p>${row.price}</p>
	        		
        		</li>
        	
        	</c:forEach>  
        </ul>
        
         <ul class="portfolio clearfix">           
          <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img1.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img2.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img3.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img4.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img5.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img6.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img7.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img8.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img9.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img10.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img11.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img12.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img13.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img14.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img15.jpg"></a></li> 
           <li class="box"><a href="/resources/template/img/image-blank.png" class="magnifier" ><img alt="" src="/resources/template/img/page3-img16.jpg"></a></li>                       
            </ul> 
      </div>
        </div>
  </div>
    </div>


<%@  include file="../include/footer.jsp" %>
