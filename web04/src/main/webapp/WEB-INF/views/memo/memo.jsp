<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"  %>

<%@ include file="../include/menu.jsp"  %>



<div class="bg-content">       
  <!--============================== content =================================-->      




<div class="container">

<h3>한줄 메모장</h3>
<div>
<input type="text" name="writer" class="form-control" placeholder="작성자"  id="writer">
<input type="text" name="memo" class="form-control" placeholder="메모 내용" id="memo" >
<button type="button" class="btn btn-info" id="btnW">작성하기</button>
</div>



<div class="table-responsive">
<table class="table table-bordered table-striped" style="background-color: white; margin: 10px 0 10px 0;">
<colgroup>

<col class="col-lg-1">
<col class="col-lg-7"></colgroup>



<thead>
<tr class="alt">
<td><code>번호</code> </td>
<td><code>글쓴이</code> </td>
<td><code>메모 내용</code> </td>
<td><code>등록 날짜</code> </td>

</tr>
</thead>

<tbody id="divList" style="margin-bottom: 30px;">



</tbody>


<tfoot>
</tfoot>

</table>
</div>
		




</div>


</div>




<script id="template" type="text/x-handlebars-template">
{{#each .}}
<tr>

<td>{{idx}}</td>>

<td>{{writer }}</td>


<td>{{memo }}</td>

<td>{{write_date }}</td>

</tr>

{{/each}}
</script>



<script>
$(document).ready(function(){
	
	list();
	
	
	
	$("#btnW").click(function(){
		
		var memo =$("#memo");
		var writer=$("#writer");
		
		if(memo.val().length <1){
			alert("내용을 입력하세요");
			return;
		}
		if(writer.val().length<1){
			alert("작성자를  입력하세요");
			return;
		}
		
		$.ajax({
			
			type:"post",
			url: "/memo/memo_add",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" :"POST"
			},
			data:JSON.stringify({
				memo :memo.val(),
				writer:writer.val()
			}),
			dataType:"text",
			success:function(result){
				
				if(result=="SUCCESS"){
					//alert(memo.val() + ": " + writer.val());
					list();
					memo.val("");
					writer.val("");
				}
			}
			
		});
		
		
	});
	
	
	
	
});

function list(){
	
	$.getJSON("/memo/memo_list", function(data){
		
		printData(data);
	});
	
	
}

function printData(data){
	
	var template1=Handlebars.compile($("#template").html());
	
	//alert(data.list);
	var html2 =template1(data.list);
	
	$("#divList").html(html2);
}


</script>





<%@  include file="../include/footer.jsp" %>