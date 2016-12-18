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

<form  role="formW1"  	method="post"  enctype="multipart/form-data" action="/shop/product_update">
<table class="table table-bordered table-striped" style="background-color: white; margin: 10px 0 10px 0;">
<colgroup>

<col class="col-lg-1">
<col class="col-lg-7"></colgroup>

<thead>
<tr class="alt">
<th>클래스</th>
<th>설명   <span style="color: red;"> ${uploadError }</span><button type="button" id="goList" class="btn btn-info btn-lg" style="float:right;">상품 목록 가기</button> 
</th></tr></thead>

<tbody>
<tr>
	<td>상품 이미지</td>
	<td><img src="${dto.picture_url }"></td>
</tr>
<tr>
<td><code>상품 번호</code> </td>
<td>${dto.product_id }
<input type="hidden" name="product_id" value="${dto.product_id}">
<input type="hidden" name=picture_url value="${dto.picture_url}">
<input type="hidden" name="original_picture_url" value="${dto.original_picture_url}">
</td></tr>
<tr class="alt">
<td><code>상품명</code> </td>
<td><input class="span5" type="text"   name="product_name" id="product_name" value="${dto.product_name }"></td></tr>
<tr>
<td><code>상품 가격</code> </td>
<td><input class="span5" type="text" name="price" id="price" value="${dto.price }"></td></tr>
<tr class="alt">
<td><code>상세 내용</code> </td>
<td> <textarea class="span5"  name="description" id="description" >${dto.description }</textarea></td>
</tr>

<tr class="alt">
<td><code>상품 이미지</code> </td>
<td> <input type="file" class="span5"  name="file1"  id="file1" /></td>
</tr>


<tr class="alt">
<td colspan="2"><button type="submit" class="btn btn-info btn-lg" id="subBtn">수정</button>

</td>
</tr>
</tbody>


</table>
</form>	

						 <form method="post" action="/shop/product_delete">
						 <input type="hidden" value="${dto.product_id }" name="proudctId" >
						 <button class="btn btn-danger" type="submit" >삭제</button>
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
	         

<!--   관리자만 접급  -->
<%@ include  file="../include/adminConfirm.jsp" %>





<script type="text/javascript">




$(document).ready(function(){
	

	$("#btnAdd").click(function(){
		
		var formObj =new FormData($("form[role='formW1']"));
		
		if(!checkPrice()){
			return ;
		};
		
		
		formObj.append("product_name", $("#product_name").val());
		formObj.append("price", $("#price").val());
		formObj.append("description", $("#description").val());
		formObj.append("file1", $("#file1")[0].files[0]);
		
		//alert("전송" + formObj);
		$.ajax({
			
			url :"/shop/product_write_save",
			processData :false,
			contentType:false,
			data :formObj,
			type:"POST",
			success:function(result){
				if(result=="SUCCESS"){
					
					$("#product_name").val("");
					$("#price").val("");
					$("#description").val("");
					$("#file1").val("");
					
					alert("등록 했습니다.");	
				}else{
					alert("등록에 실패 했습니다.");
				}
				
			}
			
		});
		
		
	});
	
	$("#goList").click(function(event){
		
		location.href="/shop/product_list";
		
	});
	
	
	$("#subBtn").click(function(event){
		
		event.preventDefault();
		
		if(checkPrice()){
			$("form[role='formW1']").submit();
		}else{
			return;
		}
	});
	
	
	function checkPrice(){
		
		if(!isNumber($("#price").val())){
				
				if($("#price").val().length==0){
					alert("가격을 입력 하세요.");
				
				}else{
					$("#price").val("");
					alert("가격은 정수만 입력 가능합니다.");	
				}
				return false;
			}else{
				
				return true;
			}
	}
	
	function isNumber(s) {
		  s += ''; // 문자열로 변환
		  s = s.replace(/^\s*|\s*$/g, ''); // 좌우 공백 제거
		  if (s == '' || isNaN(s)) return false;
		  return true;
	}
	
	
	
	
});


</script>

<%@  include file="../include/footer.jsp" %>