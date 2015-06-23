<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Travel Mate</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimun-scale=1.0, user-scalable=no" />

<!-- �ʱ�ȭ -->
<style>
.picture {
	height: 140px;
	width: 140px;
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
.section_font{
	font-size: x-small;
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
</style>
<!-- Ajax �񵿱� ��� ��ũ��Ʈ  -->
<script type="text/javascript">
		window.onload=function(){
			send('play');
		}
			//XMLHttpRequest ��ü�� ������ ��������.
			var httpRequest = null;

			//XMLHttpRequest�� �����ϴ� �Լ�.
			function getXMLHttpRequest() {

				//IE7.0, Firefox, safari, opera, chrome...
				if (window.XMLHttpRequest) {

					return new XMLHttpRequest();

				} else {
					// IE6.0 ����
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			// Ŭ���̾�Ʈ�κ��� �̺�Ʈ�� �߻����� ��, ����Ǵ� �Լ�.
			function send(category) {
				
				
				httpRequest = getXMLHttpRequest();
				// ������ ���� ��û ����
				if(category == 'play')
					httpRequest.open("GET", "main_contents.do?category=play", true);
				else if(category == 'eat')
					httpRequest.open("GET","main_contents.do?category=eat", true);
				else if(category == 'sleep')
					httpRequest.open("GET","main_contents.do?category=sleep", true);
				else if(category == 'band')
					httpRequest.open("GET","main_contents.do?category=band", true);
				
				httpRequest.onreadystatechange = callbackFunction;
				httpRequest.send(null);
			}

			function callbackFunction() {
				var log = document.getElementById("log");
				var la = document.getElementById("lodingArea");

				switch (httpRequest.readyState) {
				case 1:
					la.innerHTML = "<img src='img/loading.gif' />";
					//log.value = "initializing...\n";
					break;
				case 2:
					la.innerHTML = "<img src='img/loading.gif' />";
					//log.value += "sending...\n";
					break;
				case 3:
					la.innerHTML = "<img src='img/loading.gif' />";
					//log.value += "interactive...\n";
					break;
				case 4:
					/* log.value += "complete...\n";
					if (httpRequest.status == 200) {
						log.value += "���� ���� �Ϸ�\n";
						log.value += httpRequest.responseText;
					} */
					la.innerHTML = httpRequest.responseText;
					break;
				}
			}
		</script>
</head>
<body>
	<nav id="top_gnb">
		<div>
			<a href="#" onclick="send('play')">������</a>
		</div>
		<div>
			<a href="#" onclick="send('eat')">�԰Ÿ�</a>
		</div>
		<div>
			<a href="#" onclick="send('sleep')">���ڸ�</a>
		</div>
		<div>
			<a href="#" onclick="send('band')">��  ��</a>
		</div>
		</nav>

 		<section id="main_section">
			<!-- <header id="section_header">
			</header>  -->
			<article id="section_article">
				<div id="lodingArea" align="center">
				
				</div>	
			</article> 
		</section>
</body>

</html>