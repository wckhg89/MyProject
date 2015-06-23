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

<script type="text/javascript">
	function goLogin(){
		var form = document.getElementById("f");
		form.action="loginProcess.do";
		form.submit();
	}
	function goJoin(){
		var form = document.getElementById("f");
		form.action="join.do";
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
</head>
<body>
	<jsp:include page="navibar.jsp"/>
	<hr>

	<div id="content" class="login">
		<center>

			<form role="form" id="f" method="post">
			
			<img src="img/login.png"><br><br>
				<table align="center">
					<tr>
						<div>
						<th class="table_title"><label>User Id</label></th>
						<td class="table_content"><input type="text" class="form-control txt" name="id"
							placeholder="　Enter id"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>Password</label></th>
							<td class="table_content"><input type="password" class="form-control txt" name="pass"
							placeholder="　Password"></td>
						</div>
					</tr>
					<tr>
						<div>
							<td align="left"><input class="btn btn-1 btn-1a" id="join" type="button"
									onclick="goJoin()" value="Join"></td>
							<td align="right"><input class="btn btn-1 btn-1a" id="login" type="button"
									onclick="goLogin()" value="Login"></td>
						</div>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>