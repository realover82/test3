<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

function createOpts(d) {
// 	JSON.parse(d);
// 	consol.log(JSON.parse(d));
	
// 	alert(d);

// 	if (JSON.parse(d).length > 0) {
		
// 		JSON.parse(d).forEach(function(item, i){
			
			
// 		});
		
// 	} else {
		
// 	}

	var partsDtlArr = JSON.parse(d);
	
	$("#partsDtl > option").remove();

	if (partsDtlArr.length > 0) {
		
// 		partsDtlArr.forEach(function(item, i) {
		partsDtlArr.forEach(function(map, i) {
			
			var optStr = "<option value=" + map.optCd + ">" +
					map.optNm + "</option>";
					
			$("#partsDtl").append(optStr);
			$("#partsDtl").selectric("refresh");

// 			console.log(map);
// 			console.log(i);

		});
		
	} else {
// 		var optStr = "<option>없음</option>";
		
		
	}
// 	$("#partsDtl").append(optStr);
// 	$("#partsDtl").selectric("refresh");
// 	<option value="O0001">인텔 10세대</option>
// 	<option value="O0002">라이젠 3세대</option>

}

$(function() {
	$(".sel").selectric();
	
	$("#partsMst").change(function() {
// 		alert(1);
		$.ajax({
			
			url : "/selectPartsDtl.do",
// 			data : {partsCd : "P0001"},
			data : {partsCd : $("#partMst").val()},
// 			data : "{partsCd : 'P0001'}",
			
// 			success : function(data) {
			success : function(d) {
// 				console.log(d);
// 				console.log(typeof d );
// 				console.log(JSON.parse(d));

				createOpts(d);
			}
		});
	});
});

</script>

<div id="contents">
	<table class="tbl type02">	
		<tbody> 
			<tr>
				<th scope="row">컴퓨터 부품 선택</th>
				<td class="ta-l">
					<select id="partsMst" name="partsMst" class="sel short">
<!-- 					<option>없음</option> -->
						<c:forEach items="${mainPartsList}" var="mainPartsInfo">
						
<!-- 						<option value="P0001">CPU</option> -->
						<option value="${mainPartsInfo.partsCd}">
							<c:out value="${mainPartsInfo.partsNm}"/>
						</option>
						</c:forEach>
					</select>
					<select id="partsDtl" name="partsDtl" class="sel middle">
<!-- 					<option>없음</option> -->
<!-- 						<option value="O0001">인텔 10세대</option> -->
<!-- 						<option value="O0002">라이젠 3세대</option> -->
					</select>        
				</td>   
			</tr>
		</tbody>
	</table>
</div>

