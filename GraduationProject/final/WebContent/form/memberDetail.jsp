<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

#submenu { /* �ڿ��� */
	position: absolute;
	display: none;
	padding: 10px;
	border: 1px solid #b5b2b5;
	background-color: #efefef; /* ��׶���� �ݵ�� ����� */
	margin-left: -2px; /* �Ը��� �°� ���� */
	margin-top: -2px; /* �Ը��� �°� ���� */
	line-height: 1.4;
	white-space: nowrap; /* IE ���� */
}

#likeMember { /* �ڿ��� */
	position: absolute;
	display: none;
	padding: 10px;
	border: 1px solid #b5b2b5;
	background-color: #efefef; /* ��׶���� �ݵ�� ����� */
	margin-left: -2px; /* �Ը��� �°� ���� */
	margin-top: -2px; /* �Ը��� �°� ���� */
	line-height: 1.4;
	white-space: nowrap; /* IE ���� */
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
	font-family: '�������', '�������', sans-serif;
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
	font-family: '�������', '�������', sans-serif;
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
						ȸ�� ����<br> <br> <br> <img src="files/${md.m_img }"
							class="member_pic"> <br>
						<h3>���̵� : ${md.m_id }</h3>

					</div></td>
				<td align="center"><img class="pic" src="img/mem_info.png" />
					<div class="mem_data">
						ȸ�� ���� <br> <br> <br>
						<div align='left'>
							<h4>�� �� : ${md.m_name}</h4>
							<br>
							<h4>�� �� : ${md.m_age}</h4>
							<br>
							<h4>����ó : ${md.m_phone}</h4>
							<br>
							<h4>�̸��� : ${md.m_email}</h4>
							<br>
						</div>

						�߰� ���� <br> <br> <br>
						<div align='left'>
							<h4>��ȣ ���� :</h4>
							<br>
							<h4>��ȣ ���� :</h4>
							<br>
							<h4>��ȣ ���� :</h4>
							<br>
						</div>
					</div></td>
				<td align="center"><img class="pic" src="img/mem_frlist.png" />
					<div class="mem_data">
						ģ�� ��� <br>
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
				id="tab2" type="radio" name="tab" /> <label for="tab1">�ۼ���
				������</label> <label for="tab2">�ۼ��� ���ӱ�</label>
			<div class="tab1_content" style="height: 500px;">
				<table>
					<tr>
						<th>������</th>
					</tr>
					<c:forEach items="${playList}" var="plist">

						<tr>
							<td width="170px" align="center"><img src="img/mband.png">
							</td>
							<td width="735px"><a
								href="play_detail.do?p_num=${plist.p_num }&p_m_id=${plist.p_m_id}">
									�� �� : ${plist.p_title } / �� ġ : ${plist.p_location2} / �� ¥:
									${plist.p_date } </a></td>
						</tr>

					</c:forEach>
					<!-- �԰Ÿ� -->
					<tr>
						<th>�԰Ÿ�</th>
					</tr>
					<c:forEach items="${eatList}" var="elist">

						<tr>
							<td width="170px" align="center"><img src="img/mband.png">
							</td>
							<td width="735px"><a
								href="eat_detail.do?e_num=${elist.e_num }&e_m_id=${elist.e_m_id}">
									�� �� : ${elist.e_title } / �� ġ : ${elist.e_location2} / �� ¥:
									${elist.e_date } </a></td>
						</tr>

					</c:forEach>
					<!-- ���ڸ� -->
					<tr>
						<th>���ڸ�</th>
					</tr>
					<c:forEach items="${sleepList}" var="slist">

						<tr>
							<td width="170px" align="center"><img src="img/mband.png">
							</td>
							<td width="735px"><a
								href="sleep_detail.do?s_num=${slist.s_num }&s_m_id=${slist.s_m_id}">
									�� �� : ${slist.s_title } / �� ġ : ${slist.s_location2} / �� ¥:
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
									�� �� : ${blist.b_title } / ī�װ� : ${blist.b_category} / ���ӳ�¥:
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