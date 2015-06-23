<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Ʈ�������Ʈ</title>

<script src="//code.jquery.com/jquery-1.9.1.min.js"></script>

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

.note {
	width: 100px;
	height: 50px;
}
</style>

<!-- ������ -->
<style>
#content {
	width: 960px;
	margin: 0 auto;
	background: #f1f1f1;
	padding-top: 50px;
	padding-bottom: 50px;
	overflow: auto;
}
</style>

<!-- div -->
<style type="text/css">
.login {
	/* height: 500px; */
	
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
	var clkImg = "";
	var clkImg_2 = "";
	var clkImg_3 = "";
	var clkImg_4 = "";

	function clickImg(v, c) {
		if (v == 1) {
			document.getElementById("play").src = "img/play_make.png";
			document.getElementById("eat").src = "img/eat_make.png";
			document.getElementById("sleep").src = "img/sleep_make.png";

			var act = document.getElementById("act");

			if (c == "play") {
				document.getElementById("play").src = "img/play_make_after.png"
				clkImg = c;
				act.value = "play";
			} else if (c == "eat") {
				document.getElementById("eat").src = "img/eat_make_after.png"
				clkImg = c;
				act.value = "eat";
			} else if (c == "sleep") {
				document.getElementById("sleep").src = "img/sleep_make_after.png"
				clkImg = c;
				act.value = "sleep";
			}
		}
		if (v == 2) {
			document.getElementById("won1").src = "img/1won.png";
			document.getElementById("won2").src = "img/2won.png";
			document.getElementById("won5").src = "img/5won.png";

			var price = document.getElementById("price");
			
			if (c == "won1") {
				document.getElementById("won1").src = "img/1won_after.png"
				clkImg_2 = c;
				price.value = "won1";
			} else if (c == "won2") {
				document.getElementById("won2").src = "img/2won_after.png"
				clkImg_2 = c;
				price.value = "won2";
			} else if (c == "won5") {
				document.getElementById("won5").src = "img/5won_after.png"
				clkImg_2 = c;
				price.value = "won5";
			}
		}
		if (v == 3) {
			document.getElementById("in").src = "img/in.png";
			document.getElementById("out").src = "img/out.png";

			var inout = document.getElementById("inout");
			
			if (c == "in") {
				document.getElementById("in").src = "img/in_after.png"
				clkImg_3 = c;
				inout.value="in";
			} else if (c == "out") {
				document.getElementById("out").src = "img/out_after.png"
				clkImg_3 = c;
				inout.value="out";
			}
		}
		if (v == 4) {
			document.getElementById("spring").src = "img/spring.png";
			document.getElementById("summer").src = "img/summer.png";
			document.getElementById("fall").src = "img/fall.png";
			document.getElementById("winter").src = "img/winter.png";

			var session = document.getElementById("session");
			
			if (c == "spring") {
				document.getElementById("spring").src = "img/spring_after.png"
				clkImg_4 = c;
				session.value="spring";
			} else if (c == "summer") {
				document.getElementById("summer").src = "img/summer_after.png"
				clkImg_4 = c;
				session.value="summer";
			} else if (c == "fall") {
				document.getElementById("fall").src = "img/fall_after.png"
				clkImg_4 = c;
				session.value="fall";
			} else if (c == "winter") {
				document.getElementById("winter").src = "img/winter_after.png"
				clkImg_4 = c;
				session.value="winter";
			}
		}
	}

	function setOnImg(v, i) {
		if (v == 1) {
			if (i == 'play') {
				document.getElementById("play").src = "img/play_make_after.png";
				document.getElementById("comment").innerHTML = "'������'���� �������� �ۼ��մϴ�.";
			} else if (i == 'eat') {
				document.getElementById("eat").src = "img/eat_make_after.png";
				document.getElementById("comment").innerHTML = "'����'���� �������� �ۼ��մϴ�.";
			} else if (i == 'sleep') {
				document.getElementById("sleep").src = "img/sleep_make_after.png";
				document.getElementById("comment").innerHTML = "'����'���� �������� �ۼ��մϴ�.";
			}
		}
		if (v == 2) {
			if (i == 'won1') {
				document.getElementById("won1").src = "img/1won_after.png";
				document.getElementById("comment_2").innerHTML = "'1������'�������Դϴ�.";
			} else if (i == 'won2') {
				document.getElementById("won2").src = "img/2won_after.png";
				document.getElementById("comment_2").innerHTML = "'2������'�������Դϴ�.";
			} else if (i == 'won5') {
				document.getElementById("won5").src = "img/5won_after.png";
				document.getElementById("comment_2").innerHTML = "'5�����̻�'�������Դϴ�.";
			}
		}
		if (v == 3) {
			if (i == 'in') {
				document.getElementById("in").src = "img/in_after.png";
				document.getElementById("comment_3").innerHTML = "'�ǳ�'�������� �����մϴ�.";
			} else if (i == 'out') {
				document.getElementById("out").src = "img/out_after.png";
				document.getElementById("comment_3").innerHTML = "'�ǿ�'�������� �����մϴ�.";
			}
		}
		if (v == 4) {
			if (i == 'spring') {
				document.getElementById("spring").src = "img/spring_after.png";
				document.getElementById("comment_4").innerHTML = "'��'�� �����ϱ� ������ �������� �ۼ��մϴ�.";
			} else if (i == 'summer') {
				document.getElementById("summer").src = "img/summer_after.png";
				document.getElementById("comment_4").innerHTML = "'����'�� �����ϱ� ������ �������� �ۼ��մϴ�.";
			} else if (i == 'fall') {
				document.getElementById("fall").src = "img/fall_after.png";
				document.getElementById("comment_4").innerHTML = "'����'�� �����ϱ� ������ �������� �ۼ��մϴ�.";
			} else if (i == 'winter') {
				document.getElementById("winter").src = "img/winter_after.png";
				document.getElementById("comment_4").innerHTML = "'�ܿ�'�� �����ϱ� ������ �������� �ۼ��մϴ�.";
			}
		}

	}

	function setOutImg(v, o) {
		if (v == 1) {
			if (o == clkImg)
				return false;
			else {

				if (o == 'play') {
					document.getElementById("play").src = "img/play_make.png";
					document.getElementById("comment").innerHTML = "�ۼ��� �� �׸��� �����ϼ���.";
				} else if (o == 'eat') {
					document.getElementById("eat").src = "img/eat_make.png";
					document.getElementById("comment").innerHTML = "�ۼ��� �� �׸��� �����ϼ���.";
				} else if (o == 'sleep') {
					document.getElementById("sleep").src = "img/sleep_make.png";
					document.getElementById("comment").innerHTML = "�ۼ��� �� �׸��� �����ϼ���.";
				}
			}
		}
		if (v == 2) {
			if (o == clkImg_2)
				return false;
			else {

				if (o == 'won1') {
					document.getElementById("won1").src = "img/1won.png";
					document.getElementById("comment_2").innerHTML = "���ݴ븦 �����ϼ���.";
				} else if (o == 'won2') {
					document.getElementById("won2").src = "img/2won.png";
					document.getElementById("comment_2").innerHTML = "���ݴ븦 �����ϼ���.";
				} else if (o == 'won5') {
					document.getElementById("won5").src = "img/5won.png";
					document.getElementById("comment_2").innerHTML = "���ݴ븦 �����ϼ���.";
				}
			}
		}
		if (v == 3) {
			if (o == clkImg_3)
				return false;
			else {

				if (o == 'in') {
					document.getElementById("in").src = "img/in.png";
					document.getElementById("comment_3").innerHTML = "�ǳ�/�ǿ� ���౸���� �������ּ���.";
				} else if (o == 'out') {
					document.getElementById("out").src = "img/out.png";
					document.getElementById("comment_3").innerHTML = "�ǳ�/�ǿ� ���౸���� �������ּ���.";
				}
			}
		}
		if (v == 4) {
			if (o == clkImg_4)
				return false;
			else {

				if (o == 'spring') {
					document.getElementById("spring").src = "img/spring.png";
					document.getElementById("comment_4").innerHTML = "���࿡ ������ ������ �����ϼ���.";
				} else if (o == 'summer') {
					document.getElementById("summer").src = "img/summer.png";
					document.getElementById("comment_4").innerHTML = "���࿡ ������ ������ �����ϼ���.";
				} else if (o == 'fall') {
					document.getElementById("fall").src = "img/fall.png";
					document.getElementById("comment_4").innerHTML = "���࿡ ������ ������ �����ϼ���.";
				} else if (o == 'winter') {
					document.getElementById("winter").src = "img/winter.png";
					document.getElementById("comment_4").innerHTML = "���࿡ ������ ������ �����ϼ���.";
				}
			}
		}
	}
	
</script>

<script>
<!-- T�� -->
	//�ʱ�ȭ �Լ�
	var markers;
	function initTmap() {
		centerLL = new Tmap.LonLat(14145677.4, 4511257.6);
		map = new Tmap.Map({
			div : 'map_div',
			width : '100%',
			height : '400px',
			transitionEffect : "resize",
			animation : true
		});
		markers = new Tmap.Layer.Markers("MarkerLayer");
		map.addLayer(markers);
		map.events.register("click", map, onClickMap)
	};

	function onClickMap(evt) {
		LonLatFromPixel(evt.clientX, evt.clientY)			
	}

	function LonLatFromPixel(x, y) {
		var lonlat = map.getLonLatFromPixel(new Tmap.Pixel(
				x, y));
		AddMarker(lonlat);
	}
	function AddMarker(lonlat) {
		
		markers.clearMarkers(); 
		
		
		var tmp = lonlat.toString();
		var arr = tmp.split(",");
		
		var lon = arr[0].substr(4);
		var lat = arr[1].substr(4);
	
		var placetxt = document.getElementById("placetxt");
		
		
		placetxt.value = lon +","+ lat;
		
		var size = new Tmap.Size(44,60);
		var offset = new Tmap.Pixel(-335,-285);
		var icon = new Tmap.Icon('img/maker_play.png',
				size, offset);
		var marker = new Tmap.Marker(lonlat, icon);
		
		markers.addMarker(marker);
		

       // loadGetAddressFromLonLat(lonlat);
	}
	
	function loadGetAddressFromLonLat(ll) {
		var tdata = new Tmap.TData();
		tdata.events.register("onComplete", tdata,
				onCompleteLoadGetAddressFromLonLat);
		tdata.getAddressFromLonLat("06296168-a5d4-3a11-bfe0-d178d3db6ccd", "xml", 1, ll);
	}
	
	function onCompleteLoadGetAddressFromLonLat() {
		alert(this.responseXML);
		 alert(jQuery(this.responseXML).find("fullAddress").text());
	}

</script>
</head>

<body onload="initTmap()">
	<jsp:include page="navibar_main.jsp" />
	<hr>

	<form name="f" enctype="multipart/form-data"
		action="sns_make_process.do" method="post">
		<div id="content">
			<center>
				<div>
					<table>
						<tr>
							<td><img src="img/play_make.png" id="play"
								onclick="clickImg(1,this.id)" onmouseover="setOnImg(1,this.id)"
								onmouseout="setOutImg(1,this.id)"></td>
							<td><img src="img/eat_make.png" id="eat"
								onclick="clickImg(1,this.id)" onmouseover="setOnImg(1,this.id)"
								onmouseout="setOutImg(1,this.id)"></td>
							<td><img src="img/sleep_make.png" id="sleep"
								onclick="clickImg(1,this.id)" onmouseover="setOnImg(1,this.id)"
								onmouseout="setOutImg(1,this.id)"></td>
						</tr>
					</table>
					<p id="comment">�ۼ��� �� �׸��� �����ϼ���.</p>
				</div>
				<div>
					<table>
						<tr>
							<td><img src="img/1won.png" id="won1"
								onclick="clickImg(2,this.id)" onmouseover="setOnImg(2,this.id)"
								onmouseout="setOutImg(2,this.id)"></td>
							<td><img src="img/2won.png" id="won2"
								onclick="clickImg(2,this.id)" onmouseover="setOnImg(2,this.id)"
								onmouseout="setOutImg(2,this.id)"></td>
							<td><img src="img/5won.png" id="won5"
								onclick="clickImg(2,this.id)" onmouseover="setOnImg(2,this.id)"
								onmouseout="setOutImg(2,this.id)"></td>
						</tr>
					</table>
					<p id="comment_2">���ݴ븦 �����ϼ���.</p>
				</div>
				<div>
					<table>
						<tr>
							<td align="center"><img src="img/in.png" id="in"
								onclick="clickImg(3,this.id)" onmouseover="setOnImg(3,this.id)"
								onmouseout="setOutImg(3,this.id)"></td>
							<td align="center"><img src="img/out.png" id="out"
								onclick="clickImg(3,this.id)" onmouseover="setOnImg(3,this.id)"
								onmouseout="setOutImg(3,this.id)"></td>
						</tr>
					</table>
					<p id="comment_3">�ǳ�/�ǿ� ���౸���� �������ּ���.</p>
				</div>
				<div>
					<table>
						<tr>
							<td><img src="img/spring.png" id="spring"
								onclick="clickImg(4,this.id)" onmouseover="setOnImg(4,this.id)"
								onmouseout="setOutImg(4,this.id)"></td>
							<td><img src="img/summer.png" id="summer"
								onclick="clickImg(4,this.id)" onmouseover="setOnImg(4,this.id)"
								onmouseout="setOutImg(4,this.id)"></td>
							<td><img src="img/fall.png" id="fall"
								onclick="clickImg(4,this.id)" onmouseover="setOnImg(4,this.id)"
								onmouseout="setOutImg(4,this.id)"></td>
							<td><img src="img/winter.png" id="winter"
								onclick="clickImg(4,this.id)" onmouseover="setOnImg(4,this.id)"
								onmouseout="setOutImg(4,this.id)"></td>
						</tr>
					</table>
					<p id="comment_4">���࿡ ������ ������ �����ϼ���.</p>
				</div>
				<br> <br> <br> <br> <input type="hidden"
					id="act" name="act"> <input type="hidden" id="price"
					name="price"> <input type="hidden" id="session"
					name="session"> <input type="hidden" id="inout"
					name="inout">

				<script language="javascript"
					src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=06296168-a5d4-3a11-bfe0-d178d3db6ccd"></script>

				<div id="map_div"></div>
				<br> <input type="text" id="placetxt" name="placetxt"
					style="width: 400px; text-align: center;"
					placeholder="���ñۿ� �ش��ϴ� ��Ҹ� ������ �ּ���." readonly> <br>
				<br>
				<br>
				<br>
				<br> <br> <input type="file" name="fileName1" placeholder="��ǥ ������ ����� �ּ���."/> <br>
				<br> <input type="text" name="title" maxlength="26"
					placeholder="���ù��� ��ǥ ������ �����ּ���."
					style="width: 400px; text-align: center;" /> <br>
				<br>
				<c:import url="web_editor.jsp" />

				<br> <input type="submit" class="btn btn-1 btn-1a"
					value="������ ����ϱ�">

			</center>
		</div>

		</div>
	</form>

	<jsp:include page="footer.jsp" />
</body>
</html>