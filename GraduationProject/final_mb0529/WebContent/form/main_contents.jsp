<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Travel Mate</title>
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="main.css"/>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimun-scale=1.0, user-scalable=no" />

<!-- �ʱ�ȭ -->
<style>
.picture {
	height: 180px;
	width: 180px;
	margin:1px;
}

* {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Helvetica', sans-serif;
}

li {
	list-style: none;
}

a {
	text-decoration: none;
}
</style>

<!-- ��� -->
<style>
#main_header {
	/* ��� ���� */
	height: 45px;
	/*             background: url('header_background.png'); */
	background: #0D3FA5;
	/* �ڼ� ��ġ ���� */
	position: relative;
	text-align: center;
	line-height: 45px;
}

#main_header>h1 {
	color: white;
}

#main_header>a, #main_header>label {
	display: block;
	height: 32px;
	position: absolute;
}

#main_header>a.left {
	width: 32px;
	left: 5px;
	top: 7px;
}

#main_header>label.right {
	width: 32px;
	right: 5px;
	top: 7px;
}
</style>
<!-- ��������Ʈ �̹��� -->
<style>
#main_header>a.left {
	background: url('img/list_mb.png');
	background-position: 0px 0px;
	text-indent: -99999px;
}

#main_header>label.right {
	background: url('img/profile_mb.png');
	background-position: -62px 0px;
	text-indent: -99999px;
}
</style>
<!-- ��� ��� -->
<style>
/* ��� ���� */
#toggle {
	display: none;
}

#toggle+#wrap>#toggle_gnb_wrap {
	display: none;
}

#toggle:checked+#wrap>#toggle_gnb_wrap {
	display: block;
}

/* ���̾ƿ� ���� */
#toggle_gnb_wrap {
	background: #FFFFFF;
	padding: 15px;
}

#toggle_gnb {
	background: #FFFFFF;
	padding: 5px;
}

/* ��� ��� */
#toggle_gnb>ul {
	overflow: hidden;
}

#toggle_gnb>ul>li {
	width: 80px;
	float: left;
}
</style>
<!-- �׺���̼�(1) -->
<style>
#top_gnb {
	overflow: hidden;
	border-bottom: 1px solid black;
	background: #3163C9;
}

#top_gnb>div>a {
	/* ���� ���� */
	float: left;
	width: 25%;
	/* ũ�� �� ����, ���� */
	height: 35px;
	line-height: 35px;
	text-align: center;
	color: white;
}
</style>
<!-- �׺���̼�(2) -->
<style>
#bottom_gnb {
	display: table;
	width: 100%;
	border-bottom: 1px solid black;
}

#bottom_gnb>div {
	display: table-cell;
	position: relative;
}

#bottom_gnb>div>a {
	display: block;
	height: 35px;
	line-height: 35px;
	text-align: center;
}

#bottom_gnb>div>a::before {
	display: block;
	position: absolute;
	top: 9px;
	left: -1px;
	width: 1px;
	height: 15px;
	border-left: 1px solid black;
	content: '';
}
</style>
<!-- ���� -->
<style>
.section_font {
	font-size: 11px;
	font-weight: bold;
}

#section_header {
	padding: 20px;
}

#section_header2 {
	padding: 20px;
}

#page1 {
	margin: 30px;
	background: #a1cbf2;
}

#page2 {
	margin: 30px;
	background: #a1cbf2;
}

#section_article {
	padding: 10px;
}

#section_article2 {
	padding: 20px;
}

#main_section {
	background: white;
	/* 	        margin: 20px; */
}
#contents_table{
	background: white;
	border: 1px solid #DDDDDD;
}
</style>
<body>
	<c:if test="${param.category =='play'}">
		<table id='contents_table'>
		<c:forEach items="${p_list}" var="p">
			<tr>
				<td width='190'>
				<a href='detailContent.do?p_num=${p.p_num}'>
				<img class="picture" src="files${p.p_img }">
				</a></td>
				<td width='540'>
				<a href='detailContent.do?p_num=${p.p_num}'>
					<p class='section_font'>�ۼ��� : ${p.p_date}</p>
					<p class='section_font'>�ۼ��� : ${p.p_m_id }</p>
					<p class='section_font'>�� �� : ${p.p_content}</p>
					<p class='section_font'>��ġ : ${p.p_location2}</p>
					<p class='section_font'>�������� : ${p.p_price}������</p>
					<p class='section_font'>��õ���� : ${p.p_session}</p>
					<p class='section_font'>�ǳ��ܿ��� : ${p.p_inout}</p>
				</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${param.category =='eat'}">
		<table id='contents_table'>
		<c:forEach items="${e_list}" var="e">
			<tr>
				<td width='190'>
				<a href='detailContent.do?e_num=${e.e_num}'>
				<img class="picture" src="files${e.e_img }">
				</a>
				</td>
				<td width='540'>
				<a href='detailContent.do?e_num=${e.e_num}'>
					<p class='section_font'>�ۼ��� : ${e.e_date}</p>
					<p class='section_font'>�ۼ��� : ${e.e_m_id }</p>
					<p class='section_font'>�� �� : ${e.e_content}</p>
					<p class='section_font'>��ġ : ${e.e_location2}</p>
					<p class='section_font'>�������� : ${e.e_price}������</p>
					<p class='section_font'>��õ���� : ${e.e_session}</p>
					<p class='section_font'>�ǳ��ܿ��� : ${e.e_inout}</p>
				</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<c:if test="${param.category =='sleep'}">
		<table id='contents_table'>
		<c:forEach items="${s_list}" var="s">
			<tr>
				<td width='190'>
				<a href='detailContent.do?s_num=${s.s_num}'>
				<img class="picture" src="files${s.s_img }">
				</a>
				</td>
				<td width='540'>
				<a href='detailContent.do?s_num=${s.s_num}'>
					<p class='section_font'>�ۼ��� : ${s.s_date}</p>
					<p class='section_font'>�ۼ��� : ${s.s_m_id }</p>
					<p class='section_font'>�� �� : ${s.s_content}</p>
					<p class='section_font'>��ġ : ${s.s_location2}</p>
					<p class='section_font'>�������� : ${s.s_price}������</p>
					<p class='section_font'>��õ���� : ${s.s_session}</p>
					<p class='section_font'>�ǳ��ܿ��� : ${s.s_inout}</p>
				</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<c:if test="${param.category =='band'}">
		<table id='contents_table'>
		<c:forEach items="${e_list}" var="e">
			<tr>
			
				<td width='190'>
				<a href='detailContent.do?e_num=${e.e_num}'>
				<img class="picture" src="files${e.e_img }">
				</a>
				</td>
				<td width='540'>
				<a href='detailContent.do?e_num=${e.e_num}'>
					<p class='section_font'>�ۼ��� : ${e.e_date}</p>
					<p class='section_font'>�ۼ��� : ${e.e_m_id }</p>
					<p class='section_font'>�� �� : ${e.e_content}</p>
					<p class='section_font'>��ġ : ${e.e_location2}</p>
					<p class='section_font'>�������� : ${e.e_price}������</p>
					<p class='section_font'>��õ���� : ${e.e_session}</p>
					<p class='section_font'>�ǳ��ܿ��� : ${e.e_inout}</p>
				</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	
	</article>

</body>
</html>