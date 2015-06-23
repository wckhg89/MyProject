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

<script>
	function goModifyProcess() {
		var form = document.getElementById("f");
		form.action = "n_modifyProcess.do";
		form.submit();
	}
	
	function goBack() {
		var form = document.getElementById("f");
		form.action="n_Detail.do"
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
#content {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	padding-top: 50px;
	padding-bottom: 50px;
}
</style>

<!-- 푸터 -->
<style>
#main_footer {
	/* 중앙 정렬 */
	background: #dddddd;
	margin-top: 80px;
	margin-bottom: 10px;
	/* 테두리 */
	box-sizing: border-box;
	padding: 40px;
	/* 글자정렬 */
	text-align: center;
	padding: 40px;
}
</style>

<!-- div -->
<style type="text/css">
table {
	width: 600px;
	cellspacing: 50;
	cellpadding: 50;
}

.table_content {
	background: white;
	border: 0px;
}

.table_body {
	background: white;
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
	padding: 5px 10px;
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
.reply_tl {
	background: #8dc6ff;
	border: 1px solid;
}

.reply_cnt {
	background: #ffffff;
	border: 1px solid;
}
</style>
</head>
<body>
	<jsp:include page="navibar_main.jsp"/>
	<hr>

	<div id="content">
		<center>
			<form id="f" method="post">
				<c:set var="tn" value="${requestScope.tn }" />
				<input type="hidden" name="n_num" value="${tn.n_num }"> <img
					src="img/modify.png"><br> <br>
				<table align="center">
					<tr>
						<div class="form-group">
							<th class="table_title" height="30px" width="150px"><label>Title</label></th>
							<td class="table_content" width="300px"><input type="text"
								class="form-control txt" id="inputTitle" value="${tn.n_title }"
								name="title" size="40"></td>
							<th class="table_title" height="30px" width="75px"><label>Writer</label></th>
							<td class="table_content" width="75px" align="center"><img src="img/micon.png"/> 관리자</td>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th class="table_title" height="300px" width="150px"><label>Content</label></th>
							<td class="table_content" width="450px" colspan="3"><textarea
									name="content" cols="60" rows="20" class="txt">${tn.n_content}</textarea></td>
						</div>
					</tr>
				</table>
				<br>
				<hr>

				<table align="center">
					<tr>
						<td align="right">
							<button class="btn btn-1 btn-1a" id="modify" type="button"
								onclick="goModifyProcess()">완료</button>
							</form>
						</td>
						<td align="right" width="90px">
							<button class="btn btn-1 btn-1a" id="back" type="button"
								onclick="goBack()">상세화면</button>
						</td>
					</tr>
				</table>
		</center>

	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>