<%@page import="com.example.wbe04.model.shop.dto.CartDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"  %>

<%@ include file="../include/menu.jsp"  %>

<div class="bg-content">       
  <!--============================== content =================================-->      


<div class="container" style="">


 <h3>장바구니 목록 <c:if test="${ not empty loginUser}"><span style="float: right;"> ${loginUser.username } 님</span></c:if></h3>
    
    
    
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
             <form action="">
               <div class="table-responsive">
                  
              
                  <table class="table">
                    <thead>
                      <tr>
                        <th>상품 번호</th>
                        <th>상품 이미지</th>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>수량</th>
                        <th>합계</th>
                      </tr>
                    </thead>
                    <tbody>
        

<c:choose>
	<c:when test="${ not empty loginUser.userid }">
	
	
		<c:choose>		 
			<c:when test="${ not empty userCart}">

				<c:forEach items="${ userCart }" var="dto">
					 <tr>	
							<td>${dto.product_id }</td>
							<td><img src="${dto.picture_url }" /></td>
							<td><a class="aa-cart-title" href="#">${dto.product_name }</a></td>
							<td>${dto.price }</td>
							<td><input class="aa-cart-quantity" type="number" value="${dto.amount }"></td>
							<td class="money">${dto.money }</td>
						</tr>
			
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>	
					<td colspan="6" style=" text-align: center;"><h5 style="color:white;">장바구니에 물건이 없습니다.</h5></td>
				</tr>
		 		
		 	</c:otherwise>
		</c:choose>
				
	</c:when>
	<c:otherwise>
	
	
		<c:choose>
			<c:when test="${ not empty sessionScope.cart_add }">
						
			 <% 
			 HashMap<String, Object> cartMap=(HashMap<String, Object>)session.getAttribute("cart_add");
			
				// 반복자를 이용해서 출력
				Iterator iterator =cartMap.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					CartDTO dto =(CartDTO)cartMap.get(key);
					pageContext.setAttribute("dto", dto);
			%>					
				<tr>	
					<td>${dto.product_id }</td>
					<td><img src="${dto.picture_url }" /></td>
					<td><a class="aa-cart-title" href="#">${dto.product_name }</a></td>
					<td>${dto.price }</td>
					<td><input class="aa-cart-quantity" type="number" value="${dto.amount }"></td>
					<td class="money">${dto.money }</td>
				</tr>
			<%		
				}
			%> 				
						
			</c:when>
			<c:otherwise>
				<tr>	
					<td colspan="6" style=" text-align: center;"><h5 style="color:white;">장바구니에 물건이 없습니다.</h5></td>
				</tr>
		 		
		 	</c:otherwise>
		 	
		 </c:choose>
	</c:otherwise>
	
</c:choose>
   
                      </tbody>
                  </table>
                </div>
             </form>
            
     <c:choose>
     	<c:when test="${ empty sessionScope.cart_add and empty loginUser.userid  }">
     	
     	</c:when>
     	<c:otherwise>
     	
     	
     		  <!-- Cart Total view -->
             <div class="cart-view-total" style="">
               <h5 style="color:white;">상품 금액</h5>
               <table class="table">
                 <tbody>
                   <tr>
                     <th>배송비</th>
                     <td>0</td>
                   </tr>
                   <tr>
                     <th>결제 예정금액</th>
                     <td id="totalSum">$450</td>
                   </tr>
                 </tbody>
               </table>
              <div style="margin: 10px 0px 50px 0; font-size: 25px ; text-align: center;">
                 <a href="#" class="aa-cart-view-btn">주문하기</a>
           		</div>
             </div>

     	</c:otherwise>
     </c:choose>       
           
           
           
           
           
           
           </div>
         </div>
       </div>
     </div>
   </div>


</div>


<script>

$(document).ready(function(){
	
	var size=$(".money").size();
	var sum=0;
	$(".money").each(function(index){
		
		  sum +=parseInt($(this).html());
		 
		  $("#totalSum").html(sum);
		  //alert(sum);
	});
	//alert(size);
	
	
});

</script>


<%@  include file="../include/footer.jsp" %>



