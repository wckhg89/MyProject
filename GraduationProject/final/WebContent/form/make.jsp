<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Ʈ�������Ʈ</title>

<!-- ��Ʈ��Ʈ�� -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- jQuery (��Ʈ��Ʈ���� �ڹٽ�ũ��Ʈ �÷������� ���� �ʿ���) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- ��� ������ �÷������� �����ϰų� (�Ʒ�) �ʿ��� ������ ���ϵ��� �����ϼ��� -->
<script src="js/bootstrap.min.js"></script>

<!-- Respond.js ���� IE8 ���� ������ ����� Ȱ��ȭ�ϼ��� (https://github.com/scottjehl/Respond) -->
<script src="js/respond.js"></script>

<meta charset="EUC-KR">

<!-- CSS -->
<!-- �ʱ�ȭ -->
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: '���� ���', bold;
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

<!-- ������ -->
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
			document.getElementById("comment").innerHTML = "�������� �ۼ��մϴ�.";
		} else if (i == 'band') {
			document.getElementById("band").src = "img/make_band_after.png";
			document.getElementById("comment").innerHTML = "���ӱ��� �ۼ��մϴ�.";
		}
	}

	function setOutImg(o) {

		if (o == 'info') {
			document.getElementById("info").src = "img/make_info.png";
			document.getElementById("comment").innerHTML = "�ۼ��� �� �׸��� �����ϼ���.";
		} else if (o == 'band') {
			document.getElementById("band").src = "img/make_band.png";
			document.getElementById("comment").innerHTML = "�ۼ��� �� �׸��� �����ϼ���.";
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
			<p id="comment">�ۼ��� �� �׸��� �����ϼ���.</p>

		</center>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>