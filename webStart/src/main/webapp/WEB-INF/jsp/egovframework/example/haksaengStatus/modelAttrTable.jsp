<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

$(function() {
	
	$("tbody > tr").click(function() {
		var $allTd = $(this).children();
		
// 		alert(1);
// 		console.log($(this).children().eq(2).text());  //alert(1);
// 		$("#haksaengName").val($(this).children().eq(2).text());  //alert(1);
		$("#userId").val($allTd.eq(1).text());  //alert(1);
		$("#userNm").val($allTd.eq(2).text());  //alert(1);
		
		leftInitC.leftClkA("modelAttr");
	});
});


</script>

<%-- <c:out value="${haksaengChartList}"></c:out> --%>
<!-- contents -->
<div id="contents">
	<!-- 컨텐츠 -->
	<div class="content_wrap">

	<h2 class="fs-18 fw-b">수강생 테이블</h2><br>
	
<%-- 	<c:out value="${userNm}"></c:out> --%>
	<c:out value="${vo.userNm}"></c:out>
<%-- 	<c:out value="${haksaengStatusVO.userNm}"></c:out> --%>

	<table class="tbl type02">
		<colgroup>
			<col style="width:10%;">
			<col style="width:20%;">
			<col style="width:20%;">
			<col style="width:20%;">
			<col style="width:20%;">
			</colgroup>
			<thead>
				<tr>
					<th scope="row">순번</th>
					<th scope="row">아이디</th>
					<th scope="row">이름</th>
					<th scope="row">나이</th>
					<th scope="row">닉네임</th>
					<th scope="row">폰번호</th>
					<th scope="row">수업과정</th>
					<th scope="row">기수</th>
					<th scope="row">주차</th>
				</tr>
			
			</thead>
			
			<tbody>
				<c:forEach items="${haksaengList}" var="haksaengInfo">
				<tr>
					<td><c:out value="${haksaengInfo.num}"></c:out></td>
					<td><c:out value="${haksaengInfo.userId}"></c:out></td>
					<td><c:out value="${haksaengInfo.userNm}"></c:out></td>
					<td><c:out value="${haksaengInfo.age}"></c:out></td>
					<td><c:out value="${haksaengInfo.cafeNick}"></c:out></td>
					<td><c:out value="${haksaengInfo.phone}"></c:out></td>
					<td><c:out value="${haksaengInfo.classNm}"></c:out></td>
					<td><c:out value="${haksaengInfo.gisuNm}"></c:out></td>
					<td><c:out value="${haksaengInfo.juchaNm}"></c:out></td>
				</tr>
				</c:forEach>


<!-- 						<tr> -->
<!-- 							<th scope="row">순번</th> -->
<!-- 							<th scope="row">이름</th> -->
<!-- 							<th scope="row">나이</th> -->
<!-- 							<th scope="row">닉네임</th> -->
<!-- 							<th scope="row">신청한수업</th> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="ta-c">1</td> -->
<!-- 							<td class="ta-c">한큐</td> -->
<!-- 							<td class="ta-c">25</td> -->
<!-- 							<td class="ta-c">hanq</td> -->
<!-- 							<td class="ta-c">Yellow</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="ta-c">2</td> -->
<!-- 							<td class="ta-c">두큐</td> -->
<!-- 							<td class="ta-c">26</td> -->
<!-- 							<td class="ta-c">twoq</td> -->
<!-- 							<td class="ta-c">생존전략</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="ta-c">3</td> -->
<!-- 							<td class="ta-c">석삼</td> -->
<!-- 							<td class="ta-c">27</td> -->
<!-- 							<td class="ta-c">suksam</td> -->
<!-- 							<td class="ta-c">Green</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="ta-c">4</td> -->
<!-- 							<td class="ta-c">너구리</td> -->
<!-- 							<td class="ta-c">28</td> -->
<!-- 							<td class="ta-c">youcu</td> -->
<!-- 							<td class="ta-c">Yellow</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="ta-c">5</td> -->
<!-- 							<td class="ta-c">오징어</td> -->
<!-- 							<td class="ta-c">29</td> -->
<!-- 							<td class="ta-c">jing-a</td> -->
<!-- 							<td class="ta-c">Yellow</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="ta-c">6</td> -->
<!-- 							<td class="ta-c">육개장</td> -->
<!-- 							<td class="ta-c">30</td> -->
<!-- 							<td class="ta-c">sixdog</td> -->
<!-- 							<td class="ta-c">Green</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td class="ta-c">7</td> -->
<!-- 							<td class="ta-c">칠면조</td> -->
<!-- 							<td class="ta-c">31</td> -->
<!-- 							<td class="ta-c">seven</td> -->
<!-- 							<td class="ta-c">Blue</td> -->
<!-- 						</tr> -->
			</tbody>
		</table>
	</div>
</div>