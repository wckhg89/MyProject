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
			send_loc();
			
		}
			//XMLHttpRequest ��ü�� ������ ��������.
			var httpRequest_loc = null;

			//XMLHttpRequest�� �����ϴ� �Լ�.
			function getXMLHttpRequest_loc() {

				//IE7.0, Firefox, safari, opera, chrome...
				if (window.XMLHttpRequest) {

					return new XMLHttpRequest();

				} else {
					// IE6.0 ����
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			// Ŭ���̾�Ʈ�κ��� �̺�Ʈ�� �߻����� ��, ����Ǵ� �Լ�.
			function send_loc(category_op) {
				
				
				httpRequest_loc = getXMLHttpRequest();
				// ������ ���� ��û ����
				if(category_op == 'play')
					httpRequest_loc.open("GET", "recommand_loc.do?category=play", true);
				else if(category_op == 'eat')
					httpRequest_loc.open("GET","recommand_loc.do?category=eat", true);
				else if(category_op == 'sleep')
					httpRequest_loc.open("GET","recommand_loc.do?category=sleep", true);
				else if(category_op == 'band')
					httpRequest_loc.open("GET","recommand_loc.do?category=band", true);
				else
					httpRequest_loc.open("GET", "recommand_loc.do?category=play", true);
				
				httpRequest_loc.onreadystatechange = callbackFunction_loc;
				httpRequest_loc.send(null);
			}

			function callbackFunction_loc() {
				var la_loc = document.getElementById("lodingArea_loc");

				switch (httpRequest_loc.readyState) {
				case 1:
					la_loc.innerHTML = "<img src='img/loading.gif' />";
					//log.value = "initializing...\n";
					break;
				case 2:
					la_loc.innerHTML = "<img src='img/loading.gif' />";
					//log.value += "sending...\n";
					break;
				case 3:
					la_loc.innerHTML = "<img src='img/loading.gif' />";
					//log.value += "interactive...\n";
					break;
				case 4:
					/* log.value += "complete...\n";
					if (httpRequest.status == 200) {
						log.value += "���� ���� �Ϸ�\n";
						log.value += httpRequest.responseText;
					} */
			
					la_loc.innerHTML = httpRequest_loc.responseText;
					
					break;
				}
			}
		</script>
</head>
<body>
	ī�װ� ���� :
	<select id="category_loc">
		<option value="play">������</option>
		<option value="eat">�԰Ÿ�</option>
		<option value="sleep">���ڸ�</option>
		<option value="band">���Ƹ�</option>
	</select>
	<input type="button" value="����" onclick="send_loc()" />
	<div id="lodingArea_loc">
		<script language="javascript"
						src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=06296168-a5d4-3a11-bfe0-d178d3db6ccd"></script>
			<script type="text/javascript">
			
			function initialize(aa) {
				
				var map = new Tmap.Map({
					div : "map_div",
					width : '480px',
					height : '370px'
				});

				var markerLayer = new Tmap.Layer.Markers();
				map.addLayer(markerLayer);
				var lonlat = new Tmap.LonLat(14135893.887852, 4518348.1852606);
				var size = new Tmap.Size(44, 60);
				var offset = new Tmap.Pixel(-(size.w / 2), -(size.h));
				var icon = new Tmap.Icon('img/maker_eat.png', size, offset);

				var marker = new Tmap.Marker(lonlat, icon);
				markerLayer.addMarker(marker);

				map.setCenter(
						new Tmap.LonLat(14135893.887852, 4518348.1852606), 14);

			}
			/* window.onload = function() {
				initialize();
			} */
		</script>

	</div>
</body>
</html>