<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#mm {
	padding-top: 50px;
	padding-bottom: 100px;
}
</style>
<script type="text/javascript">
	//XMLHttpRequest ��ü�� ������ ��������.
	var httpRequest_category = null;

	//XMLHttpRequest�� �����ϴ� �Լ�.
	function getXMLHttpRequest_category() {

		//IE7.0, Firefox, safari, opera, chrome...
		if (window.XMLHttpRequest) {

			return new XMLHttpRequest();

		} else {
			// IE6.0 ����
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}

	// Ŭ���̾�Ʈ�κ��� �̺�Ʈ�� �߻����� ��, ����Ǵ� �Լ�.
	function send_category() {
		
		httpRequest_category = getXMLHttpRequest();
		// ������ ���� ��û ����
		if (true)
			httpRequest_category.open("GET", "mainAll.do?category='1'", true);
		

		httpRequest_category.onreadystatechange = callbackFunction_category;
		httpRequest_category.send(null);
	}

	function callbackFunction_category() {
		
		var la2 = document.getElementById("lodingArea2");

		switch (httpRequest_category.readyState) {
		case 1:
			la.innerHTML = "<img src='img/loading.gif' />";
			//log.value = "initializing...\n";
			break;
		case 2:
			//log.value += "sending...\n";
			break;
		case 3:
			//log.value += "interactive...\n";
			break;
		case 4:
			/* log.value += "complete...\n";
			if (httpRequest.status == 200) {
				log.value += "���� ���� �Ϸ�\n";
				log.value += httpRequest.responseText;
			} */
			la2.innerHTML = httpRequest_category.responseText;
			break;
		}
	}

	/*
		ī�װ� �̹��� Ŭ���� �̹��� ȿ�� �� Ajax ó��
	*/
	
	var clkImg = "";
	
	function clickImgAjax(c) {
		document.getElementById("eat").src = "img/eat-2.png";
		document.getElementById("play").src = "img/play-2.png";
		document.getElementById("ride").src = "img/ride-2.png";

		var act = document.getElementById("act");

		if (c == "eat") {
			send_category();
			document.getElementById("eat").src = "img/eat-3.png"
			clkImg = c;
		} else if (c == 'play') {
			send_category();
			document.getElementById("play").src = "img/play-3.png"
			clkImg = c;
		} else if (c == 'ride') {
			send_category();
			document.getElementById("ride").src = "img/ride-3.png"
			clkImg = c;
		}
		
		
	}
	
	/* ī�װ� �̹��� �� �ƿ� �̹��� ȿ�� ��ũ��Ʈ ��� */

	function setOnImg(i) {
		if (i == 'eat') {
			document.getElementById("eat").src = "img/eat-3.png"
		} else if (i == 'play') {
			document.getElementById("play").src = "img/play-3.png"
		} else if (i == 'ride') {
			document.getElementById("ride").src = "img/ride-3.png"
		}
	}

	function setOutImg(o) {
		if (o == clkImg)
			return false;
		else {
			if (o == 'eat') {
				document.getElementById("eat").src = "img/eat-2.png"
			} else if (o == 'play') {
				document.getElementById("play").src = "img/play-2.png"
			} else if (o == 'ride') {
				document.getElementById("ride").src = "img/ride-2.png"
			}
		}
	}
</script>
</head>
<body>
	<!-- ī�װ� �̹��� -->
	<div id="mm">
		<table>
			<tr>
				<td><img src="img/eat-2.png" id="eat"
					onclick="clickImgAjax(this.id)" onmouseover="setOnImg(this.id)"
					onmouseout="setOutImg(this.id)"></td>
				<td><img src="img/play-2.png" id="play"
					onclick="clickImgAjax(this.id)" onmouseover="setOnImg(this.id)"
					onmouseout="setOutImg(this.id)"></td>
				<td><img src="img/ride-2.png" id="ride"
					onclick="clickImgAjax(this.id)" onmouseover="setOnImg(this.id)"
					onmouseout="setOutImg(this.id)"></td>
			</tr>

		</table>
	</div>
	<div id="lodingArea2"></div>
</body>
</html>