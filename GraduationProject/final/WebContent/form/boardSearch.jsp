<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
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
<!-- ��� -->
<style>
#main_header {
	/*���� ��ǥ*/
	position: relative;
	height: 48px;
	background: #3b5998;
}

#main_header>#main_lnb {
	bottom: 20px;
}
</style>

<!-- ���θ޴� -->
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
	/*�̰� ���� */
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
<!-- ���� �޴� -->
<style>
.sub_menu {
	background: #f1f1f1;
	visibility: hidden;
	font-family: '���� ���', bold;
	font-size: 13px;
	margin: 10px 0 0 0;
	border: 1px solid #dddddd;
}

.sub_menu>li>a {
	color: black;
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
							<th scope="col" width="100px"><label>�۹�ȣ</label></th>
							<th scope="col" width="300px"><label>������</label></th>
							<th scope="col" width="100px"><label>�ۼ���</label></th>
							<th scope="col" width="200px"><label>�ۼ���¥</label></th>
							<th scope="col" width="100px"><label>��ȸ��</label></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${n_search}" var="n" varStatus="status">
							<tr class="table_body" align="center">
								<td>${status.count}</td>
								<td align="left"><a href="n_Detail.do?n_num=${n.n_num}"
									style="text-decoration: none">${n.n_title}&nbsp;&nbsp;[${n.n_r_count}]</a></td>
								<td>������</td>
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
								<option value=n_title name='n_title'>����</option>
								<option value=n_id name='n_id'>�ۼ���</option>
								<option value=n_content name="n_content">����</option>
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
