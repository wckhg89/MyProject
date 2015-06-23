<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
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
	width: 800px;
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
<script>
	function goSearch() {
		var form = document.getElementById("p_form");
		form.action = "prideSearch.do";
		form.submit();
	}
	function goWrite() {
		var form = document.getElementById("p_form");
		form.action = "prideNew.do";
		form.submit();
	}
</script>
</head>
<body>
	<jsp:include page="navibar_main.jsp"/>
	<hr>

	<div id="content">
		<c:set var="n_search" value="${requestScope.n_search }" />
		<center>
			<img src="img/play.png"> <br>
			<table summary="list" align="center" class="table table-hover"
				style="width: 800px">
				<div class="form-group">
					<thead align="center">
						<tr class="table_title">
							<th scope="col" width="100px"><label>글번호</label></th>
							<th scope="col" width="300px"><label>글제목</label></th>
							<th scope="col" width="100px"><label>작성자</label></th>
							<th scope="col" width="200px"><label>작성날짜</label></th>
							<th scope="col" width="100px"><label>조회수</label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${n_search}" var="n" varStatus="status">
							<tr class="table_body" align="center">
								<td>${status.count}</td>
								<td align="left"><a href="n_Detail.do?n_num=${n.n_num}"
									style="text-decoration: none">${n.n_title}&nbsp;&nbsp;[${n.n_r_count}]</a></td>
								<td>관리자</td>
								<td>${n.n_date}</td>
								<td>${n.n_count}</td>
							</tr>
						</c:forEach>
					</tbody>
				</div>
			</table>

			<table align="center" style="width: 400px">
				<tr>
					<form id='n_form' method="post">
						<td><select name="n_condition1">
								<option value=n_title name='n_title'>제목</option>
								<option value=n_id name='n_id'>작성자</option>
								<option value=n_content name="n_content">내용</option>
						</select></td>
						<td><input type="text" name="n_condition2"></td>
						<td><button class="btn btn-1 btn-1a" id="search"
								onclick="goSearch()">Search</button></td>

						<td><button class="btn btn-1 btn-1a" id="write" onclick="goWrite()">Write</button>
					</form>
					</td>
				</tr>
			</table>
		</center>
	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>
