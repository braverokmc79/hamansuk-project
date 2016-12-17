<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"  %>

<%@ include file="../include/menu.jsp"  %>

<div class="bg-content">       
  <!--============================== content =================================-->      


<div class="container">




 <h3>상품 등록</h3>

<div class="mini-layout">
            <div class="mini-layout-body">
       	
	
	<div class="row">
	
	
		<div class="span12" style="margin-bottom: 10px; text-align: center;" >
	     	<div class="thumb-pad">
				<div class="thumbnail">
					

					
<div class="table-responsive">

<form  role="formW1" 	method="post"  enctype="multipart/form-data" action="/shop/product_write_w">
<table class="table table-bordered table-striped" style="background-color: white; margin: 10px 0 10px 0;">
<colgroup>

<col class="col-lg-1">
<col class="col-lg-7"></colgroup>

<thead>
<tr class="alt">
<th>클래스</th>
<th>설명   <span style="color: red;"> ${uploadError }</span></th></tr></thead>

<tbody>
<tr>
<td><code>상품 번호</code> </td>
<td>${dto.product_id }</td></tr>
<tr class="alt">
<td><code>상품명</code> </td>
<td><input class="span5" type="text"   name="product_name"></td></tr>
<tr>
<td><code>상품 가격</code> </td>
<td><input class="span5" type="text" name="price"></td></tr>
<tr class="alt">
<td><code>상세 내용</code> </td>
<td> <textarea class="span5"  name="description"></textarea></td>
</tr>

<tr class="alt">
<td><code>상품 이미지</code> </td>
<td> <input type="file" class="span5"  name="file1" /></td>
</tr>


<tr class="alt">
<td colspan="2"><button type="submit" class="btn btn-info btn-lg">제출</button></td>
</tr>
</tbody>


</table>
</form>	




</div>
					
				


 






				  </div>
			   </div>
		  </div>
     </div>

 
</div> <!-- row -end -->


            </div>
  </div>
	      




</div>
	         
	  
<script type="text/javascript">

$(document).ready(function(){
	
	var loginUser ="${loginUser.userid}";
	
	if(loginUser!="admin"){
		
		alert("관리자만 접근 가능합니다.");
		location.href="/";
	}
	
});


</script>

<%@  include file="../include/footer.jsp" %>