<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
#content {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	padding-top: 50px;
	padding-bottom: 50px;
}
</style>

<!-- div -->
<style type="text/css">
.login {
	height: 500px;
}

table {
	width: 400px;
	height: 200px;
	cellspacing: 50;
	cellpadding: 50;
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
<script type="text/javascript">
	function setOnImg(i) {

		if (i == 'info') {
			document.getElementById("info").src = "img/make_info_after.png";
			document.getElementById("comment").innerHTML = "정보글을 작성합니다.";
		} else if (i == 'band') {
			document.getElementById("band").src = "img/make_band_after.png";
			document.getElementById("comment").innerHTML = "모임글을 작성합니다.";
		}
	}

	function setOutImg(o) {

		if (o == 'info') {
			document.getElementById("info").src = "img/make_info.png";
			document.getElementById("comment").innerHTML = "작성할 글 항목을 선택하세요.";
		} else if (o == 'band') {
			document.getElementById("band").src = "img/make_band.png";
			document.getElementById("comment").innerHTML = "작성할 글 항목을 선택하세요.";
		}

	}
</script>
</head>
<body>
	<jsp:include page="navibar_main.jsp" />
	<hr>

	<div id="content" class="login">
		<br><br>
		<center>
			<table>
				<tr>
					<td><a href="sns_make.do"><img src="img/make_info.png" id="info"
						onmouseover="setOnImg(this.id)" onmouseout="setOutImg(this.id)"></a></td>
					<td><a href="meeting_make.do"><img src="img/make_band.png" id="band"
						onmouseover="setOnImg(this.id)" onmouseout="setOutImg(this.id)"></a></td>

				</tr>
			</table>
			<br> <br>
			<p id="comment">작성할 글 항목을 선택하세요.</p>

		</center>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>