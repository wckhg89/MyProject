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
							placeholder="��Enter id"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>Password</label></th>
							<td class="table_content"><input type="password" class="form-control txt" name="pass"
							placeholder="��Password"></td>
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