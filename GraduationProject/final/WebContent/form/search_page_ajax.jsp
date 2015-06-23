<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<title>트레블메이트</title>
<!-- 이미지 오토 슬라이딩 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- Important Owl stylesheet -->
<link rel="stylesheet" href="owl-carousel/owl.carousel.css">

<!-- Default Theme -->
<link rel="stylesheet" href="owl-carousel/owl.theme.css">

<!-- Include js plugin -->
<script src="assets/owl-carousel/owl.carousel.js"></script>

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="//code.jquery.com/jquery.js"></script>


<meta charset="EUC-KR">

<!-- 방문자 카운트 -->
<SCRIPT LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
	expireDate = new Date
	expireDate.setMonth(expireDate.getMonth() + 6)
	hitCt = eval(cookieVal("pageHit"))
	hitCt++
	document.cookie = "pageHit=" + hitCt + ";expires="
			+ expireDate.toGMTString()

	function cookieVal(cookieName) {
		thiscookie = document.cookie.split("; ")
		for (i = 0; i < thiscookie.length; i++) {
			if (cookieName == thiscookie[i].split("=")[0]) {
				return thiscookie[i].split("=")[1]
			}
		}
		return 0
	}
</SCRIPT>
<script type="text/javascript">
		
		var clkImg = "";

		window.onload=function(){
			send('play');
		}
			//XMLHttpRequest 객체를 저장할 전역변수.
			var httpRequest = null;

			//XMLHttpRequest를 생성하는 함수.
			function getXMLHttpRequest() {

				//IE7.0, Firefox, safari, opera, chrome...
				if (window.XMLHttpRequest) {

					return new XMLHttpRequest();

				} else {
					// IE6.0 이하
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			// 클라이언트로부터 이벤트가 발생했을 때, 실행되는 함수.
			function send(category) {
				document.getElementById("play").src = "img/order_play_after.png";
				document.getElementById("eat").src = "img/order_eat_after.png";
				document.getElementById("sleep").src = "img/order_sleep_after.png";
				
				document.getElementById("new").src = "img/order_new_after.png";
				document.getElementById("like").src = "img/order_like_after.png";
				document.getElementById("dis").src = "img/order_dis_after.png";
			
			
				httpRequest = getXMLHttpRequest();
				// 서버에 보낼 요청 설정
				if(category == 'play'){
					document.getElementById("play").src = "img/order_play.png"
					clkImg = category;
					httpRequest.open("GET", "search_contents.do?category=play", true);
				}
				else if(category == 'eat'){
					document.getElementById("eat").src = "img/order_eat.png"
					clkImg =category;
					httpRequest.open("GET","search_contents.do?category=eat", true);
				}
				else if(category == 'sleep'){
					document.getElementById("sleep").src = "img/order_sleep.png"
					clkImg =category;
					httpRequest.open("GET","search_contents.do?category=sleep", true);
				}
				
				else if(category == 'new'){
					if(clkImg =='play'){
						document.getElementById("new").src = "img/order_new.png";
						document.getElementById("play").src = "img/order_play.png"
						
						httpRequest.open("GET","search_new_contents.do?category=new_play", true);	
					}else if(clkImg =='eat'){
						document.getElementById("new").src = "img/order_new.png";
						document.getElementById("eat").src = "img/order_eat.png"
						
						httpRequest.open("GET","search_new_contents.do?category=new_eat", true);
					}else if(clkImg =='sleep'){
						document.getElementById("new").src = "img/order_new.png";
						document.getElementById("sleep").src = "img/order_sleep.png"
						
						httpRequest.open("GET","search_new_contents.do?category=new_sleep", true);
					}
				}
				else if(category == 'like'){
					if(clkImg =='play'){
						document.getElementById("like").src = "img/order_like.png";
						document.getElementById("play").src = "img/order_play.png"
						
						httpRequest.open("GET","search_like_contents.do?category=like_play", true);	
					}else if(clkImg =='eat'){
						document.getElementById("like").src = "img/order_like.png";
						document.getElementById("eat").src = "img/order_eat.png"
						
						httpRequest.open("GET","search_like_contents.do?category=like_eat", true);
					}else if(clkImg =='sleep'){
						document.getElementById("like").src = "img/order_like.png";
						document.getElementById("sleep").src = "img/order_sleep.png"
						
						httpRequest.open("GET","search_like_contents.do?category=like_sleep", true);
					}
				}else{
					
					if(clkImg =='play'){
						document.getElementById("like").src = "img/order_like.png";
						document.getElementById("play").src = "img/order_play.png"
						
						httpRequest.open("GET","dateSearch.do?s_when="+category+"&ctg=date_play", true);

					}else if(clkImg =='eat'){
						document.getElementById("like").src = "img/order_like.png";
						document.getElementById("eat").src = "img/order_eat.png"
						
						httpRequest.open("GET","dateSearch.do?s_when="+category+"&ctg=date_eat", true);
						
					}else if(clkImg =='sleep'){
						document.getElementById("like").src = "img/order_like.png";
						document.getElementById("sleep").src = "img/order_sleep.png"
						
						httpRequest.open("GET","dateSearch.do?s_when="+category+"&ctg=date_sleep", true);
					}
				}
				
				httpRequest.onreadystatechange = callbackFunction;
				httpRequest.send(null);
			}

			function callbackFunction() {
				var log = document.getElementById("log");
				var la = document.getElementById("lodingArea");

				switch (httpRequest.readyState) {
				case 1:
					la.innerHTML = "<img src='img/loading.gif' />";
					//log.value = "initializing...\n";
					break;
				case 2:
					la.innerHTML = "<img src='img/loading.gif' />";
					//log.value += "sending...\n";
					break;
				case 3:
					la.innerHTML = "<img src='img/loading.gif' />";
					//log.value += "interactive...\n";
					break;
				case 4:
					/* log.value += "complete...\n";
					if (httpRequest.status == 200) {
						log.value += "정상 응답 완료\n";
						log.value += httpRequest.responseText;
					} */
					la.innerHTML = httpRequest.responseText;
					break;
				}
			}
		</script>
<!-- CSS -->
<!-- 이미지슬라이딩 CSS -->
<style type="text/css">
#owl-demo .item {
	margin: 3px;
}

#owl-demo .item img {
	display: block;
	width: 100%;
	height: auto;
}
</style>
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
<!-- 콘텐츠 -->
<style>
#content {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
}

#pic_table {
	float: left;
	width: 430px;
	height: 433px;
	margin: 30px;
	background: white;
	border: 1px solid #DDDDDD;
}

.picture {
	height: 220px;
	width: 220px;
}

.picture_order {
	height: 70px;
	width: 70px;
}

#rank_table {
	width: 373px;
	height: 135px;
	margin: 30px;
	background: white;
	border: 1px solid #DDDDDD;
}

#help_table {
	width: 370px;
	height: 268px;
	margin: 30px;
	background: white;
	border: 1px solid #DDDDDD;
}

#content_table {
	width: 960px;
	margin: 0px;
}

.member {
	float: left;
}

.category_image {
	width: 140px;
}

.band_image {
	width: 95px;
}

#write_table {
	width: 960px;
	margin: 0px;
}

#recent_div {
	width: 900px;
	height: 320px;
	margin: 30px;
	background: white;
	border: 1px solid #DDDDDD;
}

.category_div {
	width: 215px;
	height: 350px;
	background: white;
	border: 1px solid #DDDDDD;
	margin-top: 30px;
	margin-bottom: 50px;
}

.content {
	width: 960px;
	margin: 0px;
}
</style>
<!-- 본문-->
<style>
.image_category {
	width: 200px;
	/* width:225 */
	height: 200px;
	margin: 3px;
}
</style>


<script src="//code.jquery.com/jquery.js"></script>
<style>
.btn {
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
	padding: 15px 400px;
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
</style>
<style>
* {
	margin: 0px;
	padding: 0px;
}

/*Animation Canvas*/
.animation_canvas_recent {
	width: 903px;
	height: 290px;
	position: relative;
	overflow: hidden;
}

/*Slider Panel*/
.slider_panel_recent {
	width: 3000px;
	position: relative;
}

.slider_image_recent {
	float: left;
	width: 219px;
	/* width:225 */
	height: 290px;
	margin: 3px;
}

/*Slider Text Panel*/
.slider_text_panel_recent {
	position: absolute;
	top: 200px;
	left: 50px;
	display: block;
}

.slider_text_recent {
	position: absolute;
	width: 250px;
	height: 150px;
}

/*Control Panel*/
.control_panel_recent {
	position: absolute;
	top: 300px;
	left: 435px;
	height: 13px;
	overflow: hidden;
}

.control_button_recent {
	width: 12px;
	height: 46px;
	position: relative;
	float: left;
	cursor: pointer;
	background: url('img/point_button.png');
}

.control_button_recent:hover {
	top: -16px;
}

.control_button_recent:active {
	top: -31px;
}

.content_table {
	margin: 10px;
}

.content_table_data {
	margin: 10px;
	border: 1px solid #DDDDDD;
}
#box1{
	width:650px;
	margin-left: 5px;
	float:left;
	background-color: white;
	border: 1px solid #DDDDDD;
}
#box2{
	width: 295px;
	margin-right:5px;
	padding-top: 5px;
	float:right;
	background-color: white;
	border: 1px solid #DDDDDD;
	
}
</style>
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

								send(datePicker.selectedYear + "-" + mm
										+ "-" + dd);
								/* location.href = "dateSearch.do?s_when="
										+ datePicker.selectedYear + "-" + mm
										+ "-" + dd; */
							}
						});
	});
</script>
</head>
<body>

	<jsp:include page="navibar_main.jsp" />
	<hr>

	<div id="content">
		<span>
			<img src='img/info_btn.png' onmouseover='img/band_btn.png'>
		</span>
		
		<!-- 컨텐츠 메인 -->			
					<section id='box1'>
						<!-- 컨텐츠 -->
						<table>
							<div id="lodingArea" align="center">
				
							</div>	
						</table>
					</section>
					<aside id='box2'> 
							<p align='center'>
								<a><img id='new' src="img/order_new_after.png" class='picture_order' onclick="send('new')">&nbsp;&nbsp;</a>
								<a><img id='like' src="img/order_like_after.png" class='picture_order' onclick="send('like')">&nbsp;&nbsp;</a>
								<a><img id='dis' src="img/order_dis_after.png" class='picture_order'></a>
							</p>
							<div id="datepicker"></div>
							<br>
							<p align='center'> 
							지역을 선택해주세요 : 
							<select>
								<option value="play">서울</option>
								<option value="eat">경기</option>
								<option value="sleep">지방</option>
								<option value="sleep">지방</option>
							</select> 
							<br>
								<a ><img id='play' src="img/order_play_after.png" class='picture_order' onclick="send('play')">&nbsp;&nbsp;</a>
								<a ><img id='eat' src="img/order_eat_after.png" class='picture_order' onclick="send('eat')">&nbsp;&nbsp;</a>
								<a ><img id='sleep' src="img/order_sleep_after.png" class='picture_order' onclick="send('sleep')"></a>
							</p>
					</aside>
	</div>
	

	<jsp:include page="footer.jsp" />
</body>
</html>