<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- p95부터 -->

<script>
function createOpts(menuDtlArr) {
	var $menuDtlID = $("#menuDtl"),
		optStr		= "";  // 셀렉트박스에 들어갈 html 스트링
	// 데이터를 지우지 않으면 두번째 셀렉트 박스는 계속 쌓이기만 한다.
	$menuDtlID.children("option").remove();
	
	// 데이터가 없을시 없음 옵션을 넣어주기 위한 구문
	if (menuDtlArr.length > 0) {
		
		menuDtlArr.forEach(function(map, i) {
			
			var optStr = "<option value=" + map.menuCd + ">" +
					map.menuNm + "</option>";
					
			$menuDtlID.append(optStr);

		});
		
	} else {
		var optStr = "<option>없음</option>";
		
		
	}

// //$menuDtlID.append(optStr); $menuDtlID변수에 optStr을 append한다.
// //$menuDtlID변수에 selectric으로 refresh 해준다.
// //
	$menuDtlID.append(optStr);
	$menuDtlID.selectric("refresh");

}

$(function() {
	$(".sel").selectric();
	
	$("#menuCat").change(function() {
		
		//data 는 두번째 셀렉트 where 조건인 메뉴 분류코드다
		//첫번째 셀렉트박스 선택값
		
		$.ajax({
			url 	:"/selectMenuDtl.do",
			data 	:{menuCatCd : $("#menuCat").val()},
			
			success : function(menuDtlObj) {
				console.log(menuDtlObj);
// 			success : function(m) {
// 				console.log(m);

		// 두번째 셀렉트박스 데이터를 생성하는 함수
				createOpts(menuDtlObj);
			},
			
			error : function(res, errorStatus, errorMsg) {
				console.log(res);
				console.log(errorStatus);
				console.log(errorMsg);
			}
		});
	});
});

</script>

<div id="contents">
	<table class="tbl type02">	
		<tbody> 
			<tr>
				<th scope="row">메뉴 분류</th>
				<td class="ta-l">
					<select id="menuCat" name="menuCat" class="sel short">
					<option>없음</option>
					<c:forEach items="${menuCatList}" var="menuCatInfo">
						
						<option value="${menuCatInfo.menuCatCd}">
							<c:out value="${menuCatInfo.menuCatNm}"/>
						</option>
						</c:forEach>
					</select>
<!-- 					<select id="" name="" class="sel middle"> -->
					<select id="menuDtl" name="menuDtl" class="sel middle">
					<option>없음</option>
<!-- 						<option value=""></option> -->
<!-- 						<option value=""></option> -->
					</select>              
				</td>   
			</tr>
		</tbody>
	</table>
</div>

<!-- <div id="contents"> -->
<!-- 	<table class="tbl type02">	 -->
<!-- 		<tbody>  -->
<!-- 			<tr> -->
<!-- 				<th scope="row">메뉴 분류</th> -->
<!-- 				<td class="ta-l"> -->
<!-- 					<select id="menuCat" name="menuCat" class="sel short">				 -->
<!-- 					<select id="" name="" class="sel short"> -->
<!-- 						<option value=""></option> -->
<!-- 					</select> -->
<!-- 					<select id="" name="" class="sel middle"> -->
<!-- 						<option value=""></option> -->
<!-- 						<option value=""></option> -->
<!-- 					</select>         -->
<!-- 				</td>    -->
<!-- 			</tr> -->
<!-- 		</tbody> -->
<!-- 	</table> -->
<!-- </div> -->
