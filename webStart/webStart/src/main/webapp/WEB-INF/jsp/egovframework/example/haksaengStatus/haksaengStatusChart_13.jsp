<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:out value="${haksaengChartList}"></c:out> --%>
		<script>

		var fieldC = {
				
				messageA : "한큐"
		}
		
		var eventC = {
				
				clickM : function() {
// 					alert(fieldC.messageA);
					console.log(this);
					alert(this.messageA);
				}
		}

// 			window.onload = function () {
			$(function () {
				
				$("#btn").click(function() {
// 					console.log(this);
// 					alert($(this).text())

// 					fieldC.click();
// 					eventC.clickM();
					eventC.clickM.call(fieldC);
				});
				//명시적바인딩  바인딩코드
				
				var labelArr = [];
					dataArr = [];
					
					<c:forEach items="${haksaengChartList}" var="haksaengChartInfo" 
					varStatus="status">
					labelArr[${status.index}] = "${haksaengChartInfo.classNm}";
					dataArr[${status.index}] = "${haksaengChartInfo.cnt}";
					</c:forEach>
					
					var config = {     //오브젝트
							type: 'pie',
							data: {
								datasets: [{    //배열
//			 						data: [1, 3, 2, 1],
									data: dataArr,
									backgroundColor: [
										window.chartColors.red,
										window.chartColors.yellow,
										window.chartColors.green,
										window.chartColors.blue,
									],
									label: 'Dataset 1'
								}],
//			 					labels: [
//			 						'생존전략',
//			 						'Yellow',
//			 						'Green',
//			 						'Blue'
//			 					]
								labels: labelArr
							},
							options: {
								responsive: true
							}
						};	
				
				console.log("labelArr = " + labelArr);	
				console.log("dataArr = " + dataArr);	
					
// 				var ctx = document.getElementById('chart-area').getContext('2d');
				var ctx = $("#chart-area")[0].getContext("2d"); //canvas 타켓잡을때 [0]번을잡아야함
				
				window.myPie = new Chart(ctx, config);
				
				$("#chart-area").click(function(e) {
					var firstPoint = myPie.getElementAtEvent(e)[0];
					
					if (firstPoint) {
						var label = myPie.data.labels[firstPoint._index];
						
						if ($("tbody > tr").length > 0) {
							$("tbody > tr").remove();
						}
						
						$.ajax({
							 
						url : "/selectHaksaengStatusList.do",
						type : "post",
						data : {"param" : label},
						
						success : function(d) {
							
							d.forEach(function(obj, i) {
// 								console.log(document.createElement("tr"));
								var tr = document.createElement("tr");
// 							console.log(obj);
// 							console.log(i);
							for (var k in obj) {
								
// 							console.log("key : ",k);
// 							console.log("key : ",obj);
// 							console.log(obj[k]);
								var td = document.createElement("td");
								
								$(td).text(obj[k]);
								
// 								console.log(td);
								$(tr).append(td);
							}
							$("tbody").append(tr);
							
							});
// 							console.log(d);
							
						}
						
						});
						
					}
				});
			});
// 			};
			//도큐먼트 레디로 바꿔야함
			

		</script>
<!-- contents -->
<div id="contents">
	<!-- 컨텐츠 -->
	<div class="content_wrap">
		<h2 class="fs-18 fw-b">수강생 현황 차트</h2>
		<div id=" canvas-holder" style="width:40%">
			<div class="chartjs-size-monitor">
				<div class="chartjs-size-monitor-expand">
					<div class="">
					</div>
				</div>
				<div class="chartjs-size-monitor-shrink">
					<div class="">
					</div>
				</div>
			</div>
			<canvas id="chart-area" style="display: block; height: 242px; width: 484px;" width="605"
					height="302" class="chartjs-render-monitor">
			</canvas>
		</div>
		<div class="btn-wrap mgt-20">
		  <div class="f-r">
			<ul>
			  <li>
				<button id="btn" type="button" class="btn type03 f-r">검색</button>
			  </li>
			</ul>
		  </div>
		</div>
		<h2 class="fs-18 fw-b">수강생 테이블</h2><br>
		<table class="tbl type02">
			<thead>
				<tr>
					<th scope="row">순번</th>
					<th scope="row">아이디</th>
					<th scope="row">이름</th>
					<th scope="row">나이</th>
					<th scope="row">닉네임</th>
					<th scope="row">핸드폰번호</th>
					<th scope="row">수업과정</th>
					<th scope="row">기수</th>
					<th scope="row">주차</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</div>
<!--// contents -->