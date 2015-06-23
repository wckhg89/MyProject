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
	height: 120px;
	width: 120px;
	border-radius: 80px;
}

/* .picture:hover {
	width: 105px;
	hegiht: 105px;
	transition-duration: 1s;
	
} */
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

.mem_data {
	width: 240px;
	height: 365px;
	background-color: white;
	border: 1px solid #DDDDDD;
	overflow: scroll;
}
.friend_pic {
	height: 55px;
	width: 55px;
	border-radius: 80px;
	margin-right: 15px;
	margin-left: 25px;
	margin-top: 15px;
	margin-bottom: 0px;
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
<!-- 이미지슬라이더 -->
<style>
* {
	margin: 0px;
	padding: 0px;
}

/*Animation Canvas*/
.animation_canvas {
	width: 370px;
	height: 240px;
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
	width: 370px;
	height: 240px;
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
	top: 227px;
	left: 165px;
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
}

.control_button:hover {
	top: -16px;
}

.control_button:active {
	top: -31px;
}
</style>

<script src="//code.jquery.com/jquery.js"></script>
<!-- 컨텐츠 이미지 슬라이딩 -->
<script LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
	$(document).ready(function() {

		$("#owl-demo").owlCarousel({

			autoPlay : 3000, //Set AutoPlay to 3 seconds

			items : 4,
			itemsDesktop : [ 1199, 3 ],
			itemsDesktopSmall : [ 979, 3 ]

		});
	});
</script>
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
</style>

</script>
</head>
<body>
	<%!String id;%>
	<%
		id = (String) session.getAttribute("login");
	%>
	<jsp:include page="navibar_main.jsp" />
	<hr>

	<div id="content">
		<div align="left">
			<div>
				<img src="img/weather_main.png" class="category_image">
			</div>
		</div>
		<div>
			<jsp:include page="weather_ajax.jsp" />
		</div>
		<div>
			<table>
				<tr>
					<td width=480><img src="img/recommand_main.png"
						class="category_image"></td>
					<td width=480><img src="img/m_info_main.png"
						class="category_image"></td>
				</tr>
				<tr height=400>
					<td bgcolor="white" bordercolor="#DDDDDD">
						<div>
							<jsp:include page="recommand_loc_ajax.jsp" />
						</div>

					</td>
					<td bgcolor="white" bordercolor="#DDDDDD">
						<div class='member'>
							<%
								if (id == null || id.equals("")) {
							%>
							Login 해주세요.
							<%
								} else {
							%>
							<c:set var="member" value="${requestScope.member }" />
							<h2>기본 정보</h2>
							&nbsp;&nbsp;&nbsp;&nbsp;<img src="files/${member.m_img }"
								class="picture"><br> &nbsp;&nbsp;&nbsp;&nbsp;아이디 :
							${member.m_id } <br>
							&nbsp;&nbsp;&nbsp;&nbsp;이&nbsp;&nbsp;&nbsp;름 : ${member.m_name }
							<br> &nbsp;&nbsp;&nbsp;&nbsp;나&nbsp;&nbsp;&nbsp;이 :
							${member.m_age } <br> &nbsp;&nbsp;&nbsp;&nbsp;연락처 :
							${member.m_phone } <br> &nbsp;&nbsp;&nbsp;&nbsp;이메일 :
							${member.m_email } <br> <br>
							<h2>추가 정보</h2>
							&nbsp;&nbsp;&nbsp;&nbsp;선호 계절 : ${member.m_session } <br>
							&nbsp;&nbsp;&nbsp;&nbsp;선호 음식 : ${member.m_food } <br>
							&nbsp;&nbsp;&nbsp;&nbsp;선호 숙소 : ${member.m_sleep } <br>
							&nbsp;&nbsp;&nbsp;&nbsp;선호 지역 : ${member.m_area } <br> <br>

						</div>
						<div class='member'>
							<h2>친구 목록</h2>
							<div class='mem_data'>
								<c:forEach items="${f_list}" var="frdl">
									<div align="left">
										<img src="files/${frdl.m_img }" class="friend_pic">
										<font style="font-size: x-small;">${frdl.f_id } / ${frdl.m_name } / ${frdl.m_age } <br>
										</font>
									</div>
								</c:forEach>

							</div>
						</div> <%
						}
						%>
					</td>

				</tr>
			</table>

		</div>
		<div id="write_table">
			<div align="left">
				<div>
					<img src="img/play_sns.png" class="category_image">
				</div>
			</div>
			<div>
				<div>
					<c:import url="play_sns_content.jsp" />
				</div>
			</div>
			<div align="left">
				<div>
					<img src="img/eat_sns.png" class="category_image">
				</div>
			</div>
			<div>
				<div>
					<c:import url="eat_sns_content.jsp" />
				</div>
			</div>
			<div align="left">
				<div>
					<img src="img/sleep_sns.png" class="category_image">
				</div>
			</div>
			<div>
				<div>
					<c:import url="sleep_sns_content.jsp" />
				</div>
			</div>
		</div>
		<c:set var="play" value="${requestScope.play }" />
		<c:set var="ride" value="${requestScope.ride }" />
		<c:set var="sleep" value="${requestScope.sleep }" />
		<c:set var="eat" value="${requestScope.eat }" />
		<div id="write_table">
			<div align="left">
				<div>
					<img src="img/band_sns.png" class="category_image">
				</div>
			</div>
		</div>
		<table id="content_table">
			<tr>
				<td align="center"><img src="img/play.png" class="band_image"></td>
				<td align="center"><img src="img/ride.png" class="band_image"></td>
				<td align="center"><img src="img/sleep.png" class="band_image"></td>
				<td align="center"><img src="img/eat.png" class="band_image"></td>
			</tr>
			<tr>
				<td align="center">
					<div class='category_div'>
						<table>
							<tr>
								<td>
									<div
										style="height: 120px; width: 200px; text-oveflow: clip; overflow: hidden">
										<h3 align="center" style="padding-top: 40px;">${play.b_title }</h3>
									</div>
								</td>
							</tr>
							<tr>
								<td style="height: 165px; width: 200px;"><a
									href="socialDetail.do?b_num=${play.b_num }&b_m_id=${play.b_m_id}"><img
										class="image_category" src="files/${play.b_img1 }"></a></td>
							</tr>
						</table>
					</div>
				</td>
				<td align="center">
					<div class='category_div'>
						<table>
							<tr>
								<td>
									<div
										style="height: 120px; width: 200px; text-oveflow: clip; overflow: hidden">
										<h3 align="center" style="padding-top: 40px;">${ride.b_title }</h3>
									</div>
								</td>
							</tr>
							<tr>
								<td style="height: 165px; width: 200px;"><a
									href="socialDetail.do?b_num=${ride.b_num }&b_m_id=${ride.b_m_id}"><img
										class="image_category" src="files/${ride.b_img1 }"></a></td>
							</tr>
						</table>
					</div>
				</td>
				<td align="center">
					<div class='category_div'>
						<table>
							<tr>
								<td>
									<div
										style="height: 120px; width: 200px; text-oveflow: clip; overflow: hidden">
										<h3 align="center" style="padding-top: 40px;">${sleep.b_title }</h3>
									</div>
								</td>
							</tr>
							<tr>
								<td style="height: 165px; width: 200px;"><a
									href="socialDetail.do?b_num=${sleep.b_num }&b_m_id=${sleep.b_m_id}"><img
										class="image_category" src="files/${sleep.b_img1 }"></a></td>
							</tr>
						</table>
					</div>
				</td>
				<td align="center">
					<div class='category_div'>
						<table>
							<tr>
								<td>
									<div
										style="height: 120px; width: 200px; text-oveflow: clip; overflow: hidden">
										<h3 align="center" style="padding-top: 40px;">${eat.b_title }</h3>
									</div>
								</td>
							</tr>
							<tr>
								<td style="height: 165px; width: 200px;"><a
									href="socialDetail.do?b_num=${eat.b_num }&b_m_id=${eat.b_m_id}"><img
										class="image_category" src="files/${eat.b_img1 }"></a></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>