<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<meta charset="EUC-KR">

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

<!-- 콘텐츠 -->
<style>
.member_pic {
	height: 55px;
	width: 55px;
	border-radius: 80px;
	margin-right: 15px;
	margin-left: 25px;
	margin-top: 15px;
	margin-bottom: 0px;
}

.like_pic {
	height: 55px;
	width: 55px;
	border-radius: 80px;
}

.section_font {
	font-size: medium;
}

.like_font {
	font-size: x-small;
}

#content {
	width: 960px;
	margin: 0 auto;
	background: #f1f1f1;
	padding-top: 50px;
	padding-left: 50px;
	padding-bottom: 50px;
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

#likeMember { /* ★요기★ */
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

#like_pic {
	height: 40px;
	width: 40px;
	margin-left: -10px;
	margin-bottom: -13px;
}
</style>

<!-- div -->
<style type="text/css">
.login {
	height: 500px;
}

table {
	margin-left: 27px;
	cellspacing: 50;
	cellpadding: 50;
	cellspacing: 50;
}

.table_content {
	background: white;
	border: 0px;
}

.table_title {
	background: #3b5998;
	color: white;
}

.txt {
	border: 0px;
}

.frd_list {
	width: 287px;
	height: 400px;
	overflow: scroll;
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

.pic {
	margin-top: -30px;
	width: 110px;
	margin-bottom: 25px;
}

.pic2 {
	width: 170px;
	margin-top: 10px;
	padding: 10px;
}

.pic3 {
	width: 110px;
	margin-top: 15px;
}

.info_div {
	width: 390px;
	overflow: scroll;
	height: 315px;
	background: white;
	border: 5px solid #DDDDDD;
	margin-top: 25px;
	margin-bottom: 5px;
}

.content_div {
	width: 895px;
	overflow: scroll;
	height: 500px;
	background: white;
	border: 5px solid #DDDDDD;
	margin-top: 50px;
	margin-bottom: 5px;
}

.member_pic {
	height: 120px;
	width: 120px;
	border-radius: 80px;
}
</style>
<style>
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
	font-size: 1.0em;
	padding: 20px;
	text-align: center;
	width: 20%;
	line-height: 1.8em;
	font-weight: 700;
	border-radius: 3px 3px 0 0;
	background: #eee;
	color: #777;
	border: 1px solid #ccc;
	border-width: 1px 1px 0;
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
	border: 5px solid #DDDDDD;
	background-color: white;
	width: 895px;
	height: 500px;
}

.mem_data {
	width: 287px;
	height: 400px;
	background-color: white;
	border: 5px solid #DDDDDD;
	margin-right: 6px;
	margin-bottom: 30px;
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

</head>
<body onload="initTmap()">
	<jsp:include page="navibar_main.jsp" />
	<hr>

	<div id="content">
		<c:set var="md" value="${requestScope.memberData }" />
		<c:set var="fl" value="${requestScope.friendList }" />
		<c:set var="bl" value="${requestScope.bandList }" />

		<table>
			<tr>
				<td align="center"><img class="pic" src="img/mem_img.png" />
					<div class="mem_data">
						회원 사진<br> <br> <br> <img src="files/${md.m_img }"
							class="member_pic"> <br>
						<h3>아이디 : ${md.m_id }</h3>

					</div></td>
				<td align="center"><img class="pic" src="img/mem_info.png" />
					<div class="mem_data">
						회원 정보 <br> <br> <br>
						<div align='left'>
							<h4>이 름 : ${md.m_name}</h4>
							<br>
							<h4>나 이 : ${md.m_age}</h4>
							<br>
							<h4>연락처 : ${md.m_phone}</h4>
							<br>
							<h4>이메일 : ${md.m_email}</h4>
							<br>
						</div>

						추가 정보 <br> <br> <br>
						<div align='left'>
							<h4>선호 음식 :</h4>
							<br>
							<h4>선호 숙소 :</h4>
							<br>
							<h4>선호 지역 :</h4>
							<br>
						</div>
					</div></td>
				<td align="center"><img class="pic" src="img/mem_frlist.png" />
					<div class="mem_data">
						친구 목록 <br>
						<br>
						<br>
						<c:forEach items="${fl}" var="frdl">
							<div align="left">
								<img src="files/${frdl.m_img }" class="friend_pic">
								${frdl.f_id } / ${frdl.m_name } / ${frdl.m_age } <br>
							</div>
						</c:forEach>

					</div></td>
			</tr>
		</table>
		<div id="css_tabs" align='center'>
			<input id="tab1" type="radio" name="tab" checked="checked" /> <input
				id="tab2" type="radio" name="tab" /> <label for="tab1">작성한
				정보글</label> <label for="tab2">작성한 모임글</label>
			<div class="tab1_content" style="height: 500px;">
				<table>
					<tr>
						<th>관광지</th>
					</tr>
					<c:forEach items="${playList}" var="plist">

						<tr>
							<td width="170px" align="center"><img src="img/mband.png">
							</td>
							<td width="735px"><a
								href="play_detail.do?p_num=${plist.p_num }&p_m_id=${plist.p_m_id}">
									제 목 : ${plist.p_title } / 위 치 : ${plist.p_location2} / 날 짜:
									${plist.p_date } </a></td>
						</tr>

					</c:forEach>
					<!-- 먹거리 -->
					<tr>
						<th>먹거리</th>
					</tr>
					<c:forEach items="${eatList}" var="elist">

						<tr>
							<td width="170px" align="center"><img src="img/mband.png">
							</td>
							<td width="735px"><a
								href="eat_detail.do?e_num=${elist.e_num }&e_m_id=${elist.e_m_id}">
									제 목 : ${elist.e_title } / 위 치 : ${elist.e_location2} / 날 짜:
									${elist.e_date } </a></td>
						</tr>

					</c:forEach>
					<!-- 잠자리 -->
					<tr>
						<th>잠자리</th>
					</tr>
					<c:forEach items="${sleepList}" var="slist">

						<tr>
							<td width="170px" align="center"><img src="img/mband.png">
							</td>
							<td width="735px"><a
								href="sleep_detail.do?s_num=${slist.s_num }&s_m_id=${slist.s_m_id}">
									제 목 : ${slist.s_title } / 위 치 : ${slist.s_location2} / 날 짜:
									${slist.s_date } </a></td>
						</tr>

					</c:forEach>
				</table>
			</div>
			<div class="tab2_content" style="height: 500px;">
				<table>
					<c:forEach items="${bl}" var="blist">
						<tr>
							<td width="170px" align="center"><img src="img/mband.png">
							</td>
							<td width="735px"><a
								href="socialDetail.do?b_num=${blist.b_num }&b_m_id=${blist.b_m_id}">
									제 목 : ${blist.b_title } / 카테고리 : ${blist.b_category} / 모임날짜:
									${blist.b_when } </a></td>
						</tr>
					</c:forEach>
				</table>
			</div>


		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>