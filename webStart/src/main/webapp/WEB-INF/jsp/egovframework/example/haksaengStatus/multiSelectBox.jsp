<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

// createOpts function 을 코딩한다.
// partsDtlArr 매개변수를 createOpts function에 대입한다.
// var로 $partsDtlID 변수에 $("#partsDtl")을 지정한다.
// optStr 변수에 "" 빈값으로 지정한다.
// $partsDtlID.children("option").remove(); 하여 두번째 목록박스를 매번 초기화 시켜준다.
// if문을 사용하여 partsDtlArr.length > 0  0보다 크다면 forEach문으로 map, i 값을 반복문으로 실행한다.
// $partsDtlID.append(optStr); $partsDtlID변수에 optStr을 append한다.
// else {} 문은 var optStr 변수에 option 없음으로 초기값을 부여한다.
// 


function createOpts(partsDtlArr) {
	var $partsDtlID = $("#partsDtl"),
		optStr		= "";
	
	$partsDtlID.children("option").remove();
	

	if (partsDtlArr.length > 0) {
		
		partsDtlArr.forEach(function(map, i) {
			
			var optStr = "<option value=" + map.optCd + ">" +
					map.optNm + "</option>";
					
			$partsDtlID.append(optStr);

		});
		
	} else {
		var optStr = "<option>없음</option>";
		
		
	}

//$partsDtlID.append(optStr); $partsDtlID변수에 optStr을 append한다.
//$partsDtlID변수에 selectric으로 refresh 해준다.
//
	$("#partsDtl").append(optStr);
	$("#partsDtl").selectric("refresh");

}

// function 을 코딩한다.
// selectric으로  .sel 값에 selectric을 작동시킨다.
// $("#partsMst")에 change function 으로 
// ajax 에 url , data, success, error 를 사용하여  결과값을 가져온다.
//
$(function() {
	$(".sel").selectric();
	
	$("#partsMst").change(function() {
		$.ajax({
			
			url : "/selectPartsDtl.do",
			data : {partsCd : $("#partsMst").val()},
			success : function(partsDtlObj) {
				createOpts(partsDtlObj);
			},
			
			error : function(res, errorStatus, errorMsg) {
				console.log(res);
				console.log(errorStatus);
				console.log(errorMsg);
			}
			
		});
	});
});

//function 을 코딩한다.
//목록으로 SQL에서 mainPartsList var= mainPartsInfo값을 불러온다.
// 두번째 목록박스에는 partsNm을 불러온다.
//
</script>

<div id="contents">
	<table class="tbl type02">	
		<tbody> 
			<tr>
				<th scope="row">컴퓨터 부품 선택</th>
				<td class="ta-l">
					<select id="partsMst" name="partsMst" class="sel short">
					<option>없음</option>
						<c:forEach items="${mainPartsList}" var="mainPartsInfo">
						
<!-- 						<option value="P0001">CPU</option> -->
						<option value="${mainPartsInfo.partsCd}">
							<c:out value="${mainPartsInfo.partsNm}"/>
						</option>
						</c:forEach>
					</select>
					<select id="partsDtl" name="partsDtl" class="sel middle">
					<option>없음</option>
<!-- 						<option value="O0001">인텔 10세대</option> -->
<!-- 						<option value="O0002">라이젠 3세대</option> -->
					</select>        
				</td>   
			</tr>
		</tbody>
	</table>
</div>

