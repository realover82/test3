<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:out value="${haksaengChartList}"></c:out> --%>
		<script>
		
// 		var fieldC = {
// 				labelArrA : [],
// 				dataArrA : [],
// 				myPieA : null
// // 				labelArr = [],
// // 				dataArr = []
// // 				messageA : "한큐"
// 		}

// 		var initC = {
				
// 				settingM : function() {
					
// 					chartC.createM.call(this);
					
// 					eventC.clickM.call(this);
// 				}
// 		}
		
		var fieldC = {
			labelArrA : [],
			dataArrA : [],
			myPieA : null
// 				labelArr = [],
// 				dataArr = []
// 				messageA : "한큐"
	}
		
		var chartC = {
				configM : function() {
					
					<c:forEach items="${haksaengChartList}" var="haksaengChartInfo" 
	 					varStatus="status">
// 	 					labelArr[${status.index}] = "${haksaengChartInfo.classNm}";
// 	 					dataArr[${status.index}] = "${haksaengChartInfo.cnt}";
// 	 					fieldC.labelArrA[${status.index}] = "${haksaengChartInfo.classNm}";
	 					fieldC.labelArrA[${status.index}] = "${haksaengChartInfo.classNm}";
	 					fieldC.dataArrA[${status.index}] = "${haksaengChartInfo.cnt}";
	 				</c:forEach>
						
	 					var config = {     //오브젝트
	 							type: 'pie',
	 							data: {
	 								datasets: [{    //배열
	//			 						data: [1, 3, 2, 1],
// 	 									data: dataArr,
	 									data: fieldC.dataArrA,
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
	 								labels: fieldC.labelArrA
	 							},
	 							options: {
	 								responsive: true
	 							},
	 						};	
	 					
	 					return config;
					
				},
				
				createM : function() {
					var ctx = $("#chart-area")[0].getContext("2d");
					
// 	 				window.myPie = new Chart(ctx, config);
// 	 				fieldC.myPieA = new Chart(ctx, config);
// 	 				fieldC.myPieA = new Chart(ctx, chartC.configM());
// 	 				this.myPieA = new Chart(ctx, chartC.configM.call(fieldC));
	 				fieldC.myPieA = new Chart(ctx, chartC.configM());
					
				}
		}
		var eventC = {
				
				clickM : function() {
// 					var that = this;
				
					
					$("#chart-area").click(function(e) {
						// 					alert(1);
						// 				console.log(myPie);	
// 						 			    var firstPoint = myPie.getElementAtEvent(e)[0];	
						 			    var firstPoint = fieldC.myPieA.getElementAtEvent(e)[0];	
						// 				console.log(e);	
						 				if (firstPoint) {
// 						         			var label = myPie.data.labels[firstPoint._index];
						         			var label = fieldC.myPieA.data.labels[firstPoint._index];
						        			
						         			if ($("tbody > tr").length > 0) {
						         				$("tbody > tr").remove();
						         			}
						//         var value = myChart.data.datasets[firstPoint._datasetIndex].data[firstPoint._index];
										
						// 				console.log(firstPoint);	
						// 				console.log(label);	

						 					$.ajax({
													 
						 						url : "/selectHaksaengStatusList.do",
						 						type : "post",
						 						data : {"param" : label},
						// 						data : {},
												
						 						success : function(d) {
													
						 							d.forEach(function(obj, i) {
														
						// 							console.log(obj);	
						// 							console.log(i);	
						// 							console.log(document.createElement("tr"));
						 							var tr = document.createElement("tr");
													
						 							for (var k in obj) {
														
						// 	 							console.log("key : ",k);
						// 	 							console.log("key : ",obj);
						// 	 							console.log(obj[k]);
						 	 							var td = document.createElement("td");
							 							
						 	 							$(td).text(obj[k]);
							 							
						// 	 							console.log(td);
						 								$(tr).append(td);

						 	 							}
						 								$("tbody").append(tr);
						 							});
													
						 						}
						 					});

						     			}


						 				});
					
// 					var that = this;
// 					alert(fieldC.messageA);
// 					console.log("메서드안 : " , this);
// 				$("#btn").click(function() {
// 					console.log("이벤트리스너 안: " , this);
					
// 					alert(this.messageA);
// 					alert(that.messageA);
// 				});
				}
		}

// 			window.onload = function () {
			$(function () {
				
// 				chartC.configM();
				
// 				initC.settingM.call(fieldC);
				
				chartC.createM();
				
				eventC.clickM();

// 				chartC.createM.call(fieldC);
				
// 				eventC.clickM.call(fieldC);
				
			});

					
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
			<canvas id="chart-area" style="cursor:pointer; display: block; height: 242px; width: 484px;" width="605"
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