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
        <h3>상품관리</h3>
        <c:if test="${ loginUser.userid=='admin' }">     
        	<button type="button" class="btn btn-info btn-lg" style="float: right; margin-bottom: 10px;" id="productWriteBtn">상품등록</button>
        </c:if>
        
        
         </article>
        <div class="clear"></div>
          			
<div class="container">
	<div class="row">
	
	<c:forEach items="${list }" var="row">	
		<div class="span4" style="margin-bottom: 10px;">
	     	<div class="thumb-pad">
				<div class="thumbnail">
					
					<div class="box" style="text-align: center;">
					<a href="/resources/template/img/image-blank.png" class="magnifier"> 
						<img src="${row.picture_url }" alt="">
					</a>
					</div>
					
					<div class="caption">
					<h5> <small>상품번호</small> : ${row.product_id }</h5>
					<p>
	        		상품명 : <a href="/shop/product_detail?product_id=${row.product_id }" >${row.product_name }</a>
					</p>
					<p>상품 가격 : ${row.price}</p>
					<a href="/shop/product_detail?product_id=${row.product_id }" class="btn">상세보기</a>
				  </div>
			   </div>
		  </div>
     </div>

   </c:forEach>
     
     
</div>
</div>
	         
	         

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
