<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"  %>

<%@ include file="../include/menu.jsp"  %>

<div class="bg-content">       
  <!--============================== content =================================-->      


<div class="container">




 <h3>상품 상세 보기</h3>

<div class="mini-layout">
            <div class="mini-layout-body">
       	
	
	<div class="row">
	
	
		<div class="span12" style="margin-bottom: 10px; text-align: center;" >
	     	<div class="thumb-pad">
				<div class="thumbnail">
					
					<div class="box" style="text-align: center;">
					<a href="/resources/template/img/image-blank.png" class="magnifier"> 
						<img src="${dto.picture_url }" alt="">
					</a>
					</div>
					
					
<div class="table-responsive">
<table class="table table-bordered table-striped" style="background-color: white; margin: 10px 0 10px 0;">
<colgroup>

<col class="col-lg-1">
<col class="col-lg-7"></colgroup>

<thead>
<tr class="alt">
<th>클래스</th>
<th>설명</th></tr></thead>

<tbody>
<tr>
<td><code>상품 번호</code> </td>
<td>${dto.product_id }</td></tr>
<tr class="alt">
<td><code>상품명</code> </td>
<td>${dto.product_name }</td></tr>
<tr>
<td><code>상품 가격</code> </td>
<td>${dto.price}</td></tr>
<tr class="alt">
<td><code>비고</code> </td>
<td>${dto.description }</td></tr>
</tbody>
<tfoot>
<tr>
	<td><code style="btn btn-primary">장바구니</code></td>
	<td>
	<form name="form1" method="post" action="/cart/cart_add">
	 
		<input type="hidden" name="product_id" value="${dto.product_id }">
		<input type="hidden" name="price" value="${dto.price }">
		<input type="hidden" name="product_name" value="${dto.product_name }">
		<input type="hidden" name="picture_url" value="${dto.picture_url }">
		<select name="amount" >
			<c:forEach begin="1" end="10" var="i">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		<input type="submit" value="장바구니에 담기" class="btn btn-info" >
	</form>
	</td>
</tr>
</tfoot>

</table>
</div>
					
					

			
				  </div>
			   </div>
		  </div>
     </div>

 
</div> <!-- row -end -->


            </div>
  </div>
	      


</div>
	         




	         



<%@  include file="../include/footer.jsp" %>
