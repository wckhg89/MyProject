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
			//XMLHttpRequest 객체를 저장할 전역변수.
			var httpRequest = null;

			//XMLHttpRequest를 생성하는 함수.
			function getXMLHttpRequest() {

				//IE7.0, Firefox, safari, opera, chrome...
				if (window.XMLHttpRequest) {

					return new XMLHttpRequest();

				} else {
					// IE6.0 이하
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			// 클라이언트로부터 이벤트가 발생했을 때, 실행되는 함수.
			function send() {
				var area_op = document.getElementById("area").value;
				
				httpRequest = getXMLHttpRequest();
				// 서버에 보낼 요청 설정
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
						log.value += "정상 응답 완료\n";
						log.value += httpRequest.responseText;
					} */
					la.innerHTML = httpRequest.responseText;
					break;
				}
			}
		</script>
</head>
<body>
	지역선택 : 
	<select id="area">
		<option value="seoul">서울</option>
		<option value="inchon">인천</option>
		<option value="suwon">수원</option>
		<option value="paju">파주</option>
	</select>
	<input type="button" value="선택" onclick="send()" />
		
	<div id="lodingArea">
	</div>
</body>
</html>