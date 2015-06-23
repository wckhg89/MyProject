<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>트레블메이트</title>

<!-- calender -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker")
				.datepicker(
						{
							onSelect : function(dateText, datePicker) {
								var mm = (datePicker.selectedMonth + 1);
								var dd = datePicker.selectedDay;

								if (mm < 10)
									mm = "0" + mm;
								if (dd < 10)
									dd = "0" + dd;

								location.href = "dateSearch.do?s_when="
										+ datePicker.selectedYear + "/" + mm
										+ "/" + dd;
							}
						});
	});
	function begin(cate) {
		var act = document.getElementById("act");
		var all = document.getElementById("condi_all");
		var all_more = document.getElementById("condi_all_more");
		var eat = document.getElementById("condi_eat");
		var eat_more = document.getElementById("condi_eat_more");
		var play = document.getElementById("condi_play");
		var play_more = document.getElementById("condi_play_more");
		var ride = document.getElementById("condi_ride");
		var ride_more = document.getElementById("condi_ride_more");
		var sleep = document.getElementById("condi_sleep");
		var sleep_more = document.getElementById("condi_sleep_more");
		var date = document.getElementById("condi_date");
		var cate_more = document.getElementById("cate_more");

		all.style.display = 'none';
		all_more.style.display = 'none';
		eat.style.display = 'none';
		eat_more.style.display = 'none';
		play.style.display = 'none';
		play_more.style.display = 'none';
		ride.style.display = 'none';
		ride_more.style.display = 'none';
		sleep.style.display = 'none';
		sleep_more.style.display = 'none';
		date.style.display = 'none';
		cate_more.style.display = 'none';

		if (cate == 'all') {
			all.style.display = 'block';
			cate_more.style.display = 'block';
		} else if (cate == 'date') {
			date.style.display = 'block';
		} else if (cate == 'play') {
			play.style.display = 'block';
			cate_more.style.display = 'block';
		} else if (cate == 'eat') {
			eat.style.display = 'block';
			cate_more.style.display = 'block';
		} else if (cate == 'ride') {
			ride.style.display = 'block';
			cate_more.style.display = 'block';
		} else if (cate == 'sleep') {
			sleep.style.display = 'block';
			cate_more.style.display = 'block';
		} else if (cate == 'ride_more') {
			ride.style.display = 'block';
			ride_more.style.display = 'block';
		} else if (cate == 'play_more') {
			play.style.display = 'block';
			play_more.style.display = 'block';
		} else if (cate == 'eat_more') {
			eat.style.display = 'block';
			eat_more.style.display = 'block';
		} else if (cate == 'sleep_more') {
			sleep.style.display = 'block';
			sleep_more.style.display = 'block';
		} else if (cate == 'all_more') {
			all.style.display = 'block';
			all_more.style.display = 'block';
		}
	}
</script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script src="js/respond.js"></script>

<meta charset="EUC-KR">

<script type="text/javascript">
	////버튼 이미지 바꾸기
	var clkImg = "";

	function clickImg(c) {

		document.getElementById("eat").src = "img/eat.png";
		document.getElementById("play").src = "img/play.png";
		document.getElementById("ride").src = "img/ride.png";
		document.getElementById("sleep").src = "img/sleep.png";

		var act = document.getElementById("act");
		var all = document.getElementById("condi_all");
		var eat = document.getElementById("condi_eat");
		var play = document.getElementById("condi_play");
		var ride = document.getElementById("condi_ride");
		var sleep = document.getElementById("condi_sleep");

		if (c == "eat") {
			document.getElementById("eat").src = "img/eat-3.png";
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
				document.getElementById("eat").src = "img/eat.png"
			} else if (o == 'play') {
				document.getElementById("play").src = "img/play.png"
			} else if (o == 'ride') {
				document.getElementById("ride").src = "img/ride.png"
			} else if (o == 'sleep') {
				document.getElementById("sleep").src = "img/sleep.png"
			}
		}
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
	border: 1;
}

hr {
	border-color: white;
	border-width: 2px;
	margin-bottom: 50px;
}
</style>

<!-- 콘텐츠 -->
<style>
#content {
	width: 1200px;
	/* 	height: 1200px; */
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	margin-top: 40px;
}

#meeting_search {
	width: 900px;
	margin: 30px;
}

#meeting_menu {
	width: 200px;
	float: left;
	margin: 0 30px;
}

.meeting_contents {
	width: 700px;
	margin: 0 0 0 420px;

	/* background: white; */
}

.m_c {
	background: white;
}

#dc {
	text-align: center;
}

#img {
	width: 120px;
	height: 130px;
	padding-bottom: 10px;
	padding-left: 10px;
	padding-right: 5px;
}

#select {
	margin-top: 0px;
	margin-bottom: 30x;
	text-align: center;
}

.s_select {
	width: 200px;
	height: 27px;
	outline-color: #3b5998;
}

#m_select {
	margin-top: 0px;
	margin-bottom: 30x;
	text-align: center;
}

#datepicker {
	width: 300px;
	height: 250px;
}

#img2 {
	width: 150px;
	height: 160px;
}

<!--
검색 -->.cf:before,.cf:after {
	content: "";
	display: table;
}

.cf:after {
	clear: both;
}

.cf {
	zoom: 1.3;
}

<!--
버튼 -->.btn {
	border: none;
	font-family: inherit;
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	padding: 10px 10px;
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

.btn2 {
	border: none;
	font-family: inherit;
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	padding: 15px 283px;
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

.btn-1a:hover,.btn-1a:active {
	background: #ffffff;
	color: #3b5998;
}
</style>
</head>
<body onload="begin('<%=session.getAttribute("category")%>')">
	<jsp:include page="navibar_main.jsp" />
	<hr>
	<div id="content">
		<div id="meeting_search"></div>
		<div>
		<!-- 상세검색 조건 -->
			<form method="post" action="searchProcess.do">
				<table id="meeting_menu">
					<tr>
						<td align="center"><h2>날짜</h2> <br>
							<div id="datepicker"></div></td>
					</tr>

					<tr>
						<td align="center"><br>
							<h2>모임 선택</h2> <br> <a href="meeting_eat.do"> <img
								src="img/eat.png" id="eat" onmouseover="setOnImg(this.id)"
								onmouseout="setOutImg(this.id)"></a> <a href="meeting_play.do">
								<img src="img/play.png" id="play"
								onmouseover="setOnImg(this.id)" onmouseout="setOutImg(this.id)">
						</a></td>
					</tr>
					<tr>
						<td align="center"><a href="meeting_ride.do"><img
								src="img/ride.png" id="ride" onmouseover="setOnImg(this.id)"
								onmouseout="setOutImg(this.id)"></a> <a
							href="meeting_sleep.do"><img src="img/sleep.png" id="sleep"
								onmouseover="setOnImg(this.id)" onmouseout="setOutImg(this.id)"></a></td>
					</tr>

					<tr height="25px"></tr>

					<tr>
						<td align="center">
							<hr>
							<div id="dc">
								<a href="meeting_search.do"> <img src="img/socialall.png">
								</a>
							</div> <br>
						</td>
					</tr>
				</table>
			</form>

			<c:set var="r_list" value="${requestScope.r_list }" />
			<div id="condi_all">
				<table class="meeting_contents">
					<c:forEach items="${r_list}" var="r" begin="0" end="3">
						<tr>
							<td style="border: 1px solid #3b5998"><a
								href="socialDetail.do?s_num=${r.s_num }&s_id=${r.s_id}"><img
									src="upload/${r.s_img1 }" width="200" height="200"></a></td>
							<td class="m_c" style="width: 700px">
								<h2 align="center">" ${r.s_title} "</h2> <br> <h4 align="center">${r.s_content}</h4>
							</td>
						</tr>
						<tr>
							<td style="background: #f1f1f1"><br> <br></td>
							<td style="background: #f1f1f1"><br> <br></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="condi_all_more" class="meeting_contents">
				<div align="center" style="width: 700px;">
					<table>
						<c:forEach items="${r_list}" var="r_m" begin="4">
							<tr>
								<td style="border: 1px solid #3b5998"><a
									href="socialDetail.do?s_num=${r_m.s_num }&s_id=${r_m.s_id}"><img
										src="upload/${r_m.s_img1 }" width="200" height="200"></a></td>
								<td class="m_c" style="width: 700px">
									<h2 align="center">" ${r_m.s_title} "</h2> <br> <h4 align="center">${r_m.s_content}</h4>
								</td>
							</tr>
							<tr>
								<td style="background: #f1f1f1"><br> <br></td>
								<td style="background: #f1f1f1"><br> <br></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

			<c:set var="date_list" value="${requestScope.date_list }" />
			<div id="condi_date" class="meeting_contents">
				<div align="center" id="date_header" style="width: 700px;">
					<img src="img/date.png">
				</div>
				<br>
				<img src="img/line.png" width="730px">
				<div align="center" style="width: 700px;">
					<table style="padding-left: 30px">
						<c:forEach items="${date_list}" var="d">
							<tr>
								<td style="border: 1px solid #3b5998"><a
									href="socialDetail.do?s_num=${d.s_num }&s_id=${d.s_id}"><img
										src="upload/${d.s_img1 }" width="200" height="200"></a></td>
								<td class="m_c" style="width: 700px">
									<h2 align="center">" ${d.s_title} "</h2> <br> <h4 align="center">${d.s_content}</h4>
								</td>
							</tr>
							<tr>
								<td style="background: #f1f1f1"><br> <br></td>
								<td style="background: #f1f1f1"><br> <br></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div id="cate_more" class="meeting_contents">
			<center>
				<a
					href="meeting_more.do?catego=<%=session.getAttribute("category")%>"><button
						class="btn2 btn-1 btn-1a">더보기</button></a>
			</center>
		</div>

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>