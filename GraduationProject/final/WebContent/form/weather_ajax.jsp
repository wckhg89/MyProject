<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
		window.onload=function(){
			send();
			
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
			function send() {
				var area_op = document.getElementById("area").value;
				
				httpRequest = getXMLHttpRequest();
				// ������ ���� ��û ����
				if(area_op == 'seoul')
					httpRequest.open("GET", "weather.do?area=seoul", true);
				else if(area_op == 'inchon')
					httpRequest.open("GET","weather.do?area=inchon", true);
				else if(area_op == 'suwon')
					httpRequest.open("GET","weather.do?area=suwon", true);
				else if(area_op == 'paju')
					httpRequest.open("GET","weather.do?area=paju", true);
				else
					httpRequest.open("GET", "weather.do?area=seoul", true);
				
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
	�������� : 
	<select id="area">
		<option value="seoul">����</option>
		<option value="inchon">��õ</option>
		<option value="suwon">����</option>
		<option value="paju">����</option>
	</select>
	<input type="button" value="����" onclick="send()" />
		
	<div id="lodingArea">
	</div>
</body>
</html>