<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>TravelMate</title>




<meta charset="EUC-KR">

<!-- 서브메뉴 스무스 내려오는 script -->
<script type="text/javascript">
	////버튼 이미지 바꾸기
	var clkImg = "";

	function clickImg(c) {

		document.getElementById("eat").src = "img/eat-2.png";
		document.getElementById("play").src = "img/play-2.png";
		document.getElementById("ride").src = "img/ride-2.png";
		document.getElementById("sleep").src = "img/sleep-2.png";

		var act = document.getElementById("act");

		if (c == "eat") {
			document.getElementById("eat").src = "img/eat-3.png"
			clkImg = c;
			act.value = "같이먹자!";
		} else if (c == 'play') {
			document.getElementById("play").src = "img/play-3.png"
			clkImg = c;
			act.value = "같이놀자!";
		} else if (c == 'ride') {
			document.getElementById("ride").src = "img/ride-3.png"
			clkImg = c;
			act.value = "같이타자!";
		} else if (c == 'sleep') {
			document.getElementById("sleep").src = "img/sleep-3.png"
			clkImg = c;
			act.value = "같이자자!";
		}

	}

	function setOnImg(i) {
		if (i == 'eat') {
			document.getElementById("eat").src = "img/eat-3.png"
		} else if (i == 'play') {
			document.getElementById("play").src = "img/play-3.png"
		} else if (i == 'ride') {
			document.getElementById("ride").src = "img/ride-3.png"
		} else if (i == 'sleep') {
			document.getElementById("sleep").src = "img/sleep-3.png"
		}
	}

	function setOutImg(o) {
		if (o == clkImg)
			return false;
		else {
			if (o == 'eat') {
				document.getElementById("eat").src = "img/eat-2.png"
			} else if (o == 'play') {
				document.getElementById("play").src = "img/play-2.png"
			} else if (o == 'ride') {
				document.getElementById("ride").src = "img/ride-2.png"
			} else if (o == 'sleep') {
				document.getElementById("sleep").src = "img/sleep-2.png"
			}
		}
	}
	function chgPlace() {
		var place = document.f.placetxt.value;
		document.getElementById("place").value = place;

		$("#placetxt").css({
			"background-color" : "#3b5998",
			"color" : "white"
		});
	}
	function chgnum() {
		var p = document.f.people.value;
		document.getElementById("pnum").value = p + "명이";

		$("#people").css({
			"background-color" : "#3b5998",
			"color" : "white"
		});

	}
</script>


<!-- CSS -->
<!-- 초기화 -->
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: '맑은 고딕', bold;
	font-size: 15px;
}

li {
	list-style: none;
}

a {
	text-decoration: none;
}

img {
	border: 0;
}

hr {
	border-color: white;
	border-width: 2px;
	margin-bottom: 50px;
}
</style>
<!-- 헤더 -->
<style>
#main_header {
	/*절대 좌표*/
	position: relative;
	height: 48px;
	background: #3b5998;
}

#main_header>#main_lnb {
	bottom: 20px;
}
</style>
<!-- 콘텐츠 -->
<style>
#content {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	padding-top: 50px;
	padding-bottom: 50px;
}

#mm {
	padding-top: 50px;
	padding-bottom: 100px;
}
</style>
<!-- 버튼 -->
<style>
.btn {
	border: none;
	font-family: inherit;
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	padding: 15px 30px;
	display: inline-block;
	margin: 30px 0px;
	text-transform: uppercase;
	letter-spacing: 1px;
	font-weight: 700;
	outline: none;
	position: relative;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
	border-radius: 0px 0px 0px 0px;
}

.btn:after {
	content: '';
	position: absolute;
	z-index: -1;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.btn-1 {
	background: #3b5998;
	color: #ffffff;
}

.btn-1a:hover, .btn-1a:active {
	background: #ffffff;
	color: #3b5998;
}

.imgsleep {
	border: none;
	display: block;
	width: 140px;
	height: 140px;
	cursor: pointer;
}
</style>

<!-- DatePicker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	jQuery.noConflict();
</script>
<script>
// 바깥에서는 $를 다른 라이브러리가 사용
	$(document).ready(function() {
		$("#datepicker").datepicker(
				{
					showMonthAfterYear : true,
					minDate : '-0d',
					yearSuffix : '년',
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],

					onSelect : function(dateText, datePicker) {
						var mm = (datePicker.selectedMonth + 1);
						var dd = datePicker.selectedDay;

						if (mm < 10)
							mm = "0" + mm;
						if (dd < 10)
							dd = "0" + dd;

						$("#currentDate").val(
								datePicker.selectedYear + "/" + mm + "/" + dd);

						$("#currentDate").css({
							"background-color" : "#3b5998",
							"color" : "white"
						});

						$("#date").val(
								datePicker.selectedYear + "년 " + mm + "월 " + dd
										+ "일에");
					}
				});
	});

	$('img').bind('mouseenter mouseleave', function() {
		$(this).attr({
			src : $(this).attr('data-other-src'),
			'data-other-src' : $(this).attr('src')
		})
	});
</script>
</head>
<body onload="initTmap()">
	<jsp:include page="navibar_main.jsp" />
	<hr>
	<center>
		<div id="content">
			<img src="img/meetmake.png"> <br> <br> <br>
			<form name="f" enctype="multipart/form-data"
				action="meet_make_process.do" method="post">
				<div id="mm">
					<img src="img/when.png">
					<table id="meeting_date">
						<tr>
							<td>
								<div id="datepicker"></div> <br> <input type="text"
								id="currentDate" name="currentDate"
								placeholder="달력에서 날짜를 선택해주세요!" size="42px"
								style="text-align: center">
							</td>
						</tr>
					</table>
				</div>
				<div id="mm">
					<img src="img/where.png">
					<!-- T맵 -->
					<script>
						//초기화 함수
						var markers;
						function initTmap() {
							centerLL = new Tmap.LonLat(14145677.4, 4511257.6);
							map = new Tmap.Map({
								div : 'map_div',
								width : '100%',
								height : '400px',
								transitionEffect : "resize",
								animation : true
							});
							markers = new Tmap.Layer.Markers("MarkerLayer");
							map.addLayer(markers);
							map.events.register("click", map, onClickMap)
						};

						function onClickMap(evt) {
							LonLatFromPixel(evt.clientX, evt.clientY)			
						}

						function LonLatFromPixel(x, y) {
							var lonlat = map.getLonLatFromPixel(new Tmap.Pixel(
									x, y));
							AddMarker(lonlat);
						}
						function AddMarker(lonlat) {
							
							markers.clearMarkers(); 
							
							
							var tmp = lonlat.toString();
							var arr = tmp.split(",");
							
							var lon = arr[0].substr(4);
							var lat = arr[1].substr(4);
						
							var placetxt = document.getElementById("placetxt");
							
							
							placetxt.value = lon +","+ lat;
							chgPlace();
							
							var size = new Tmap.Size(44,60);
							var offset = new Tmap.Pixel(-335,-285);
							var icon = new Tmap.Icon('img/maker_play.png',
									size, offset);
							/* alert(lonlat); */
							var marker = new Tmap.Marker(lonlat, icon);
							
							markers.addMarker(marker);
							
		
					       // loadGetAddressFromLonLat(lonlat);
						}
						
						function loadGetAddressFromLonLat(ll) {
							var tdata = new Tmap.TData();
							tdata.events.register("onComplete", tdata,
									onCompleteLoadGetAddressFromLonLat);
							tdata.getAddressFromLonLat("06296168-a5d4-3a11-bfe0-d178d3db6ccd", "xml", 1, ll);
						}
						
						function onCompleteLoadGetAddressFromLonLat() {
							alert(this.responseXML);
							 alert(jQuery(this.responseXML).find("fullAddress").text());
						}
					</script>
					
					<script language="javascript"
						src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=06296168-a5d4-3a11-bfe0-d178d3db6ccd"></script>
					
					<div id="map_div"></div>
					<br>
					<table id="meeting_where">
						<tr>
							<td><div id="map_canvas" style="width: 100%; height: 100%"></div></td>
							<td><input type="text" onchange="chgPlace()" id="placetxt"
								name="placetxt" style="width: 400px; text-align: center;"
								value="" placeholder="모임 장소"></td>
						</tr>
					</table>
				</div>

				<div id="mm">
					<img src="img/howmany.png">
					<table>
						<tr>
							<td><select style="width: 120px;" id="people" name="people"
								onchange="chgnum()">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select><label>&nbsp;명</label></td>
						</tr>
					</table>
				</div>

				<div id="mm">
					<img src="img/what.png">
					<table>
						<tr>
							<td><img src="img/eat-2.png" id="eat"
								onclick="clickImg(this.id)" onmouseover="setOnImg(this.id)"
								onmouseout="setOutImg(this.id)"></td>
							<td><img src="img/play-2.png" id="play"
								onclick="clickImg(this.id)" onmouseover="setOnImg(this.id)"
								onmouseout="setOutImg(this.id)"></td>
							<td><img src="img/ride-2.png" id="ride"
								onclick="clickImg(this.id)" onmouseover="setOnImg(this.id)"
								onmouseout="setOutImg(this.id)"></td>
							<td><img src="img/sleep-2.png" id="sleep"
								onclick="clickImg(this.id)" onmouseover="setOnImg(this.id)"
								onmouseout="setOutImg(this.id)"></td>
						</tr>

					</table>
				</div>

				<div id="mm">
					<img src="img/how.png"><br> <br> <br> <input
						type="text" size="100" name="title" style="text-align: center"
						placeholder="모임 제목"><br>
					<div style="position: relative; width: 67px; height: 27px;">
						<input type="file" name="fileName1" /><br>
					</div>
					<br>
					<br>
					<br>

				
				<c:import url="web_editor.jsp" />
				
				</div>
				<div id="mm">
					<img src="img/line.png"><br> <br>
					<table
						style="border: 1px solid #3b5998; background: white; cellspacing: 10px; cellpadding: 10px;">
						<tr>
							<td><label
								style="font-size: 20px; color: #3b5998; font-family: '맑은 고딕' bold;">
									{ </label></td>
							<td><input type="text" id="date" name="date"
								readonly="readonly" style="text-align: center; border: 0px"></td>
							<td><input type="text" id="place" name="place"
								readonly="readonly" style="text-align: center; border: 0px">
								</td>
							<td><input type="text" id="pnum" name="pnum"
								readonly="readonly" style="text-align: center; border: 0px"
								value=""></td>
							<td><input type="text" id="act" name="act"
								readonly="readonly" style="text-align: center; border: 0px"
								value=""></td>
							<td style="background: white;"><label
								style="font-size: 20px; color: #3b5998; font-family: bold;">
									} </label></td>
						</tr>
					</table>
					<br> <br> <input type="submit" class="btn btn-1 btn-1a"
						value="모임등록하기">
				</div>

			</form>
	</center>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>