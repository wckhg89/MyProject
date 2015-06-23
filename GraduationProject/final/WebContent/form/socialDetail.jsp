<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.vo.Band"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>트레블메이트</title>

<!-- 부트스트랩 -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="js/bootstrap.min.js"></script>

<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script src="js/respond.js"></script>

<meta charset="EUC-KR">
<!-- 이미지슬라이더 -->
<title>Index</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

/*Animation Canvas*/
.animation_canvas {
	width: 460px;
	height: 370px;
	position: relative;
	overflow: hidden;
}

/*Slider Panel*/
.slider_panel {
	width: 1500px;
	position: relative;
}

.slider_image {
	float: left;
	width: 460px;
	height: 300px;
}

/*Slider Text Panel*/
.slider_text_panel {
	position: absolute;
	top: 220px;
	left: 50px;
}

.slider_text {
	position: absolute;
	width: 250px;
	height: 150px;
}

/*Control Panel*/
.control_panel {
	position: absolute;
	top: 278px;
	left: 213px;
	height: 13px;
	overflow: hidden;
}

.control_button {
	width: 12px;
	height: 46px;
	position: relative;
	float: left;
	cursor: pointer;
	background: url('img/point_button.png'); /*temporaily button image*/

	/*여기 주소가 틀려서 안나와서 고침*/
	7
}

.control_button:hover {
	top: -16px;
}

.control_button:active {
	top: -31px;
}

.plus {
	margin-right: 30px;
	margin-bottom: 20px;
}
</style>
<script src="//code.jquery.com/jquery.js"></script>
<script>
	$(document).ready(
			function() {
				//슬라이더를 움직여주는 함수
				function moveSlider(index) {
					//슬라이더를 이동합니다
					var willMoveLeft = -(index * 460);
					$('.slider_panel').animate({
						left : willMoveLeft
					}, 'slow');

					//control button 에 active를 부여/제거합니다.
					$('.control_button[data-index=' + index + ']').addClass(
							'active');
					$('.control_button[data-index!=' + index + ']')
							.removeClass('active');

					//글자를 이동합니다.
					$('.slider_text[data-index=' + index + ']').show().animate(
							{
								left : 0
							}, 'slow');

					$('.slider_text[data-index!=' + index + ']').hide('slow',
							function() {
								$(this).css('left', -300);
							});
				}

				//초기 텍스트 위치 지정 및 data-index할당
				$('.slider_text').css('left', -300).each(function(index) {
					$(this).attr('data-index', index);
				});

				//컨트롤 버튼의 클릭 리스너 지정 및 data-index 할당
				$('.control_button').each(function(index) {
					$(this).attr('data-index', index);
				}).click(function() {
					var index = $(this).attr('data-index');
					moveSlider(index);
				});

				//초기 슬라이더 위치 지정
				var randomNumber = Math.round(Math.random() * 1);
				moveSlider(randomNumber);

			});
</script>

<script>
	function goP() {
		var form = document.getElementById("f");
		form.action = "s_joinProcess.do";
		form.submit();
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
	border-color: #f1f1f1;
	border-width: 1px;
	margin-bottom: 10px;
	margin-top: 10px;
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

<!-- 메인메뉴 -->
<style>
#main_lnb>ul {
	position: relative;
	overflow: hidden;
	width: 960px;
	margin: 0 auto;
}

#main_lnb>ul>li {
	float: left;
	text-align: center;
	/*이게 문제 */
}

#main_lnb>ul>li>a {
	background: white;
	color: white;
	display: block;
	background: #3b5998;
}

#main_lnb>ul>li>a:hover {
	background: #384F80;
	color: white;
	display: block;
	transition-duration: 2s;
}

#main_lnb>ul>li>a {
	background: #3b5998;
	color: white;
	display: block;
	padding: 13px 27px;
	transition-duration: 2s;
}
</style>
<!-- 서브 메뉴 -->
<style>
.sub_menu {
	background: #f1f1f1;
	visibility: hidden;
	font-family: '맑은 고딕', bold;
	font-size: 13px;
	margin: 10px 0 0 0;
	border: 1px solid #dddddd;
}

.sub_menu>li>a {
	color: black;
}
</style>
<!-- 콘텐츠 -->
<style>
.content {
	width: 1200px;
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	margin-top: 40px;
}

#meeting_detail {
	width: 1141px;
	margin-top: 30px;
	margin-left: 30px;
	margin-right: 30px;
	background: white;
	height: 400px;
	border: solid 2px #3b5998;
}

#meeting_menu {
	width: 690px;
	float: left;
	overflow:scroll;
	background: white;
	margin-top: 40px;
	margin-left: 30px;
	margin-right: 30px;
	margin-bottom: 30px;
	height: 700px;
}

#meeting_details {
	width: 400px;
	float: left;
	margin: 30px 30px;
	height: 300px;
}

#meeting_contents {
	width: 420px;
	margin: 40px 10px 30px 0;
	background: white;
	height: 700px;
}

#meeting_details2 {
	width: 400px;
	float: left;
	margin: 30px 30px;
	height: 300px;
	background: white;
	margin-left: 130px;
	text-align: center;
}

#na {
	padding-top: -50px;
}

<!--
tab 1-->tab css -->#css_tabs {
	font-family: '나눔고딕', '맑은고딕', sans-serif;
}

#css_tabs input:nth-of-type(1), #css_tabs input:nth-of-type(1) ~ div:nth-of-type(1),
	#css_tabs input:nth-of-type(2), #css_tabs input:nth-of-type(2) ~ div:nth-of-type(2)
	{
	display: none
}

#css_tabs input:nth-of-type(1):checked ~ div:nth-of-type(1), #css_tabs input:nth-of-type(2):checked 
	 ~ div:nth-of-type(2) {
	display: block
}

#css_tabs>label {
	display: inline-block;
	font-variant: small-caps;
	font-size: .9em;
	padding: 5px;
	text-align: center;
	width: 20%;
	line-height: 1.8em;
	font-weight: 700;
	border-radius: 3px 3px 0 0;
	background: #eee;
	color: #777;
	border: 1px solid #ccc;
	border-width: 1px 1px 0
}

#css-tabs>label:hover {
	cursor: pointer;
}

#css_tabs label[for=tab1] {
	margin-left: 1.5em
}

#css_tabs input:nth-of-type(1):checked ~ label:nth-of-type(1), #css_tabs>label[for=tab1]:hover
	{
	background: #3b5998;
	color: #fff
}

#css_tabs input:nth-of-type(2):checked ~ label:nth-of-type(2), #css_tabs>label[for=tab2]:hover
	{
	background: #3b5998;
	color: #fff
}

#css_tabs .tab1_content, #css_tabs .tab2_content {
	border: 1px solid #ddd;
	width: 600px;
	height: 270px;
}

<!--
tab 2-->tab_b css -->#css_tabs_b {
	font-family: '나눔고딕', '맑은고딕', sans-serif;
}

#css_tabs_b input:nth-of-type(1), #css_tabs_b input:nth-of-type(1) ~ div:nth-of-type(1),
	#css_tabs_b input:nth-of-type(2), #css_tabs_b input:nth-of-type(2) ~
	div:nth-of-type(2) {
	display: none
}

#css_tabs_b input:nth-of-type(1):checked ~ div:nth-of-type(1),
	#css_tabs_b input:nth-of-type(2):checked 
	 ~ div:nth-of-type(2) {
	display: block
}

#css_tabs_b>label {
	display: inline-block;
	font-variant: small-caps;
	font-size: .9em;
	padding: 5px;
	text-align: center;
	width: 20%;
	line-height: 1.8em;
	font-weight: 700;
	border-radius: 3px 3px 0 0;
	background: #eee;
	color: #777;
	border: 1px solid #ccc;
	border-width: 1px 1px 0
}

#css-tabs_b>label:hover {
	cursor: pointer;
}

#css_tabs_b label[for=tab3] {
	margin-left: 1.5em
}

#css_tabs_b input:nth-of-type(1):checked ~ label:nth-of-type(1),
	#css_tabs_b>label[for=tab3]:hover {
	background: #3b5998;
	color: #fff
}

#css_tabs_b input:nth-of-type(2):checked ~ label:nth-of-type(2),
	#css_tabs_b>label[for=tab4]:hover {
	background: #3b5998;
	color: #fff
}

#css_tabs_b .tab3_content, #css_tabs_b .tab4_content {
	border: 1px solid #ddd;
	width: 600px;
	height: 270px;
	overflow: auto;
}
</style>

<style>
.progress {
	background-color: #D8D8D8;
	border: 0;
	height: 25px;
	border-radius: 9px;
}

.progress-bar {
	/* background-color:#837EFF; */
	background-color: red;
	border: 0;
	height: 25px;
	border-radius: 9px;
}

.progress-striped .progress-bar {
	background-image: -webkit-gradient(linear, 0 100%, 100% 0, color-stop(0.25, rgba(255, 255,
		255, 0.15)), color-stop(0.25, transparent),
		color-stop(0.5, transparent),
		color-stop(0.5, rgba(255, 255, 255, 0.15)),
		color-stop(0.75, rgba(255, 255, 255, 0.15)),
		color-stop(0.75, transparent), to(transparent));
	background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 0.15)
		25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%,
		rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
	background-image: -moz-linear-gradient(45deg, rgba(255, 255, 255, 0.15)
		25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%,
		rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
	background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%,
		transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%,
		rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
	background-size: 40px 40px;
}

#deimg {
	width: 60px;
	height: 70px;
}

#deimg2 {
	width: 85px;
	height: 90px;
}

.table_title {
	background: #3b5998;
	color: white;
	text-align: center;
}
</style>
<style type="text/css">
.btn {
	border: none;
	font-family: inherit;
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	padding: 10px 30px;
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
table {
	padding: 20px;
}

#submenu { /* ★요기★ */
	position: absolute;
	display: none;
	padding: 10px;
	border: 1px solid #b5b2b5;
	background-color: #efefef; /* 백그라운드는 반드시 줘야함 */
	margin-left: -2px; /* 입맛에 맞게 수정 */
	margin-top: -2px; /* 입맛에 맞게 수정 */
	line-height: 1.4;
	white-space: nowrap; /* IE 버그 */
}
</style>
<script>
	function initTmap() {
		var tmp = '${b.b_where}';
		var lonlat = tmp.split(",");
		centerLL = new Tmap.LonLat(lonlat[0],lonlat[1]);
		map = new Tmap.Map({
			div : 'map_div',
			width : '400px',
			height : '400px',
			transitionEffect : "resize",
			animation : true
		});

		var markers = new Tmap.Layer.Markers( "MarkerLayer" );
		map.addLayer(markers);
		 
		var size = new Tmap.Size(44,60);
		var offset = new Tmap.Pixel(-(size.w/2), -size.h);
		var icon = new Tmap.Icon('img/maker_play.png', size, offset);  
		 
		var marker = new Tmap.Marker(new Tmap.LonLat(lonlat[0],lonlat[1]), icon);
		markers.addMarker(marker);
		
	};
	
	var visible = false;
	
	function memberDetail(){
		var sbm = document.getElementById('submenu');
		
		if(visible == false){
			visible= true;
			sbm.style.display='block';
		}else if(visible == true){
			visible = false;
			sbm.style.display='none';
		}
	}
</script>

</head>
<body onload="initTmap()">
	<jsp:include page="navibar_main.jsp"/>
	
	<form id="f" method="post">
		<c:set var="b" value="${requestScope.b}" />
		<c:set var="m_size" value="${requestScope.m_size}" />

		<div class="content">
			<div id="meeting_detail">
				<table id="meeting_details" style="padding: 0px">
					<tr>
						<td>
							<div class="animation_canvas">

								<div class="slider_panel">
									<img class="slider_image" src="files/${b.b_img1 }" /> <img
										class="slider_image" src="files/${b.b_img1 }" /> <img
										class="slider_image" src="files/${b.b_img1 }" />
								</div>
								<div class="control_panel">
									<div class="control_button"></div>
									<div class="control_button"></div>
									<div class="control_button"></div>
								</div>

							</div>
						</td>
					</tr>

				</table>
				<table id="meeting_details2" style="padding: 0px">
					<tr>
						<td colspan="2">
							<%
								int num = (Integer) request.getAttribute("m_size");

													Band b = (Band) request.getAttribute("b");
													int bm = b.getB_people();

													int result = bm - num;

													if (result > 0) {
							%> <strong style="color: black;">예약 가능</strong> <%
 	} else {
 %> <strong style="color: red;">예약 불가</strong> <%
 	}
 %>
						</td>

					</tr>
					<tr>
                  <td colspan="2" class="table_title">
                     <div style="height:50px; width:400px;text-oveflow:clip;overflow:hidden">
                     <nobr><h1>${b.b_title }</h1></nobr>
                     </div>
                  </td>
               </tr>	
					<tr>
						<td colspan="2">
							<h2>${b.b_where }</h2>
						</td>
					</tr>
					<tr>
						<!-- <td align="right" style="color: red;"><br>최대인원:5명 &nbsp;</td> -->
						<td align="left"><br>${b.b_people - m_size}자리 남았어요!</td>
						<td align="right"><br>최대인원: ${b.b_people } 명</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="progress progress-striped">
								<div class="progress-bar" role="progressbar"
									aria-valuenow="${m_size}" aria-valuemin="0"
									aria-valuemax="${b.b_people }"
									style="width: ${(m_size/b.b_people)*100 }%;">
									<span class="sr-only" style="color: #FFFFFF;"><strong>${m_size}명
											참가중</strong></span>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						 <!-- 참여하기 버튼 아이디가 로그인 된 세션 아이이디 여야하지??? -->
							<input type="hidden" id="s_num" name="b_num" value="${b.b_num }">
							<input type="hidden" id="s_id" name="b_m_id" value="${b.b_m_id }">
							<%
								if (result > 0) {
							%>
							<button class="btn btn-1 btn-1a" onclick="goP()">참여하기</button> <%
 	} else {
 %>
							<button class="btn btn-1 btn-1a"
								style="background: #f1f1f1; color: black;" onclick="goP()"
								disabled="disabled">마 감</button> <%
 	}
 %>

						</td>
					</tr>
				</table>

			</div>
		</div>
	</form>
	<div class="content">
		<div id="meeting_menu">
			<table>
			<tr height="50px">
				<td><img src="img/sd_title.png"><br> <br></td>
			</tr>
			<tr height="50px" style="text-align: center">
				<td><br>
					<%-- <h2>${s.b_subtitle }</h2> --%>
					<img src="img/line2.png" width="600px">
				</td>
			</tr>
			<tr>
				<td align="center">
					${b.b_content }
				</td>
			</tr>
			</table>
		</div>


		<c:set var="m" value="${requestScope.m}" />
		
		<table id="meeting_contents">
			<tr height="50px">
				<td colspan="2"><img src="img/sd_host.png"></td>
			</tr>
			<tr>
			
				<td rowspan="3"><img src="files/${m.m_img}" id="deimg2"></td>
				<td height="10px">
				
					<h3><a onclick="memberDetail()"><img src="img/idicon.png"/></a> ${m.m_name }</h3>
					<div id="submenu">
					<div>
						<a href="memberDetail.do?m_id=${b.b_m_id }">회원정보</a>
					</div>
					<div>
						<a href="meet_friend.do?f_id=${b.b_m_id }">친구맺기</a>
					</div>
				</div>
				
			</tr>
			<tr height="30px">
				<td><h4>${m.m_age }</h4></td>
			</tr>
			<tr height="30px">
				<td><h4>${m.m_email }</h4></td>
			</tr>
			<tr height="50px">
				<td colspan="2"><br><br><img src="img/sd_where.png"><br><img src="img/maptext.png" align="right"></td>
			</tr>
			<tr>
				<td colspan="2">
				<script language="javascript"
					src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=06296168-a5d4-3a11-bfe0-d178d3db6ccd"></script>
				<center>
				<div id="map_div"></div>
				</center>
				<!-- <iframe
						src="http://www.mins01.com/web_work/google_apis/maps/maps.php?address=%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD%20%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%20%EA%B0%95%EB%82%A8%20%EA%B5%AC%EC%B2%AD&latLng="
						width="350" height="300" frameborder="0" style="border: 0"></iframe> -->
						
				</td>
			</tr>
			<tr height="50px">
				<td colspan="2"><h4>${b.b_where }</h4></td>
			</tr>
		</table>

	</div>

	<div class="content">
		<table id="meeting_menu" style="top: 0px;">
			<tr>
				<td style="padding-left: 30px;">
					<div id="css_tabs" style="height: 100px;">
						<input id="tab1" type="radio" name="tab" checked="checked" /> <input
							id="tab2" type="radio" name="tab" /> <label for="tab1">댓글
							남기기</label> <label for="tab2">후기 남기기</label>
						<div class="tab1_content" style="height: 150px;">
							<table>
								<tr>
									<form method="post" action="b_r_insert.do">
										<input type="hidden" name="b_r_num" value="${b.b_num}">
										<input type="hidden" name="b_r_m_id" value="${b.b_m_id}">
										<td><textarea rows="3" cols="60"
												placeholder="모임에 대한 댓글을 남겨주세요!" name="inputcom"></textarea></td>
										<td><input style="display: block; visibility: visible;"
											class="btn btn-1 btn-1a" id="reply_add" type="submit"
											value="등록"></td>
									</form>
								</tr>
							</table>
						</div>
						<div class="tab2_content" style="height: 150px;">
							<table>
								<form id="r" name="r" method="post"
									enctype="multipart/form-data" action="b_rv_insert.do">
									<tr>

										<td><input type="file" name="s_rv_img" id="s_rv_img"
											style="display: block; visibility: visible;" /></td>
									</tr>
									<tr>
										<input type="hidden" name="s_rv_num" value="${b.b_num}">
										<input type="hidden" name="b_m_id" value="${b.b_m_id}">
										<td><textarea rows="3" cols="60" name="review"
												placeholder="모임에 대한 후기를 남겨주세요!"></textarea></td>
										<td><input style="display: block; visibility: visible;"
											class="btn btn-1 btn-1a" id="review_add" type="submit"
											value="등록"></td>

									</tr>
								</form>
							</table>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td style="padding-left: 30px; padding-top: 20px;">
					<div id="css_tabs_b" style="height: 300px;">
						<input id="tab3" type="radio" name="tab_b" checked="checked" /> <input
							id="tab4" type="radio" name="tab_b" /> <label for="tab3">댓글
							보기</label> <label for="tab4">후기 보기</label>
						<div class="tab3_content" style="height: 150px;">
							<table>
								<c:forEach items="${br}" var="br">
									<tr>
										<td width="300px" style="color:black; font-size: 12pt; font: bold;">"${br.b_r_content }"</td>
										<td width="80px" align="right">
										<a  href="memberDetail.do?m_id=${br.b_r_m_id }">${br.b_r_m_id }</a>
										</td>
										<td width="200px" align="right">${br.b_r_date }</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="tab4_content" style="height: 300px;">
							<c:forEach items="${brv}" var="brv">
							<table width="580px">
								<tr>
									<td rowspan="2" width="100px"><img src="files/${brv.b_rv_img}" height="100px"
											width="100px" />!@#${brv.b_rv_img}</td>
									<td colspan="2" align="center" style="color:black; font-size: 14pt; font: bold;">"${brv.b_rv_content }"</td>
								</tr>
								<tr>
									<td align="left">　　<a href="memberDetail.do?m_id=${brv.b_rv_m_id }"> ${brv.b_rv_m_id } </a></td>
									<td align="right">${brv.b_rv_date }</td>
								</tr>
							</table>
							</c:forEach>
						</div>
					</div>
				</td>
			</tr>
		</table>

		<table id="meeting_contents" style="height: auto;">
			<tr>
				<td colspan="2"><img src="img/sd_people.png"></td>
			</tr>
			<c:forEach items="${ml}" var="ml">
				<tr>
					<td rowspan="2" style="padding-left: 10px; padding-top: 5px;"><img
						src="files/${ml.m_img}" id="deimg"></td>
					<td width="300px">
					<strong>${ml.m_name}</strong>
					</td>
					<td></td>
				</tr>
				<tr>
					<td><strong>${ml.m_age}</strong></td>
				</tr>
			</c:forEach>
		</table>

	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>