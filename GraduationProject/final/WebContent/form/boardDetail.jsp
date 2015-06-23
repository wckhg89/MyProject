<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
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
	function goModify() {
		var form = document.getElementById("f");
		form.action = "n_modify.do";
		form.submit();
	}

	function goBack() {
		var form = document.getElementById("f");
		form.action = "notice.do";
		form.submit();
	}

	function goDelete() {
		var form = document.getElementById("f");
		form.action = "n_delete.do";
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

.btn-1a:hover,.btn-1a:active {
	background: #ffffff;
	color: #3b5998;
}
</style>
<style>
.reply_tl {
	background: #3b5998;
	color: white;
	border: 1px solid gray;
	cellspacing: 20px;
}

.reply_cnt {
	background: #ffffff;
	color: black;
	cellspacing: 20px;
	text-align: left;
	padding-left: 5px;
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

				<img src="img/notice.png"><br>
				<br>
				<table align="center">
					<tr>
						<div class="form-group">
							<th class="table_title" height="30px" width="150px"><label>Title</label></th>
							<td class="table_content" width="300px">${tn.n_title }</td>
							<th class="table_title" height="30px" width="75px"><label>Writer</label></th>
							<td class="table_content" width="75px" align="center"><img src="img/micon.png"/> 관리자</td>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th class="table_title" height="450px" width="150px"><label>Content</label></th>
							<td class="table_content" width="450px" colspan="3">${tn.n_content}</td>
						</div>
					</tr>
				</table>
				<br>
				<table align="center">
					<tr>
						<td align="left">
							<button class="btn btn-1 btn-1a" id="back" type="button"
								onclick="goBack()">초기화면</button>
						</td>
						<td align="right" width="70px"><input type="hidden"
							name="n_num" value="${tn.n_num}">
							<button class="btn btn-1 btn-1a" id="modify" type="button"
								onclick="goModify()">수정</button></td>
						<td align="right" width="70px">
							<button class="btn btn-1 btn-1a" id="delete" type="button"
								onclick="goDelete()">삭제</button>
						</td>
					</tr>
				</table>
			</form>
			<hr>
			<table align='center'>
				<c:forEach items="${n_re}" var="n_re">
					<form method="post" action="r_delete.do">
						<input type="hidden" name="r_idx" value="${n_re.tn_index}">
						<input type="hidden" name="r_num" value="${n_re.tn_num}">
						<input type="hidden" name="r_id" value="${n_re.tn_id}">
						<tr align="center">
							<td width="100px" class="reply_tl"><a href="memberDetail.do?m_id=${n_re.tn_id }"><img src="img/idicon2.png"/></a> ${n_re.tn_id}</td>
							<td width="300px" class="reply_cnt">${n_re.tn_content}</td>
							<td width="200px" class="reply_cnt">${n_re.tn_date}</td>
							<td><button class="btn btn-1 btn-1a" id="reply_delete"
									type="submit" style="margin: 0px 0px; width: 55px">삭제</button></td>
						</tr>
					</form>
				</c:forEach>

			</table>
			<br>
			<table align="center" style="height: 30px">
				<tr>
					<form method="post" action="n_r_insert.do">
						<td class="reply_tl" width=100px " style="text-align: center">새
							댓글</td>
						<td><input type="hidden" name="r_num" value="${tn.n_num}"></td>
						<td width="450px" bgcolor="white"><input type="text"
							id="inputcom" name="inputcom" style="border-style: none"
							size="62"></td>
						<td width="50px"><button class="btn btn-1 btn-1a"
								id="reply_submit" type="submit"
								style="margin: 0px 0px; width: 55px;">등록</button></td>
					</form>
				</tr>
			</table>
		</center>
	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>