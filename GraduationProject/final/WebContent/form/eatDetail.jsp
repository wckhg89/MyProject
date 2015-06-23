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
<script>
function initTmap() {
	var tmp = '${eatList.e_location}';
	
	var lonlat = tmp.split(",");
	
	centerLL = new Tmap.LonLat(lonlat[0],lonlat[1]);
	map = new Tmap.Map({
		div : 'map_div',
		width : '400px',
		height : '400px',
		transitionEffect : "resize",
		animation : true
	});

	var markers = new Tmap.Layer.Markers( "MarkerLayer" );
	map.addLayer(markers);
	 
	var size = new Tmap.Size(44,60);
	var offset = new Tmap.Pixel(-(size.w/2), -size.h);
	var icon = new Tmap.Icon('img/maker_play.png', size, offset);  
	 
	var marker = new Tmap.Marker(new Tmap.LonLat(lonlat[0],lonlat[1]), icon);
	markers.addMarker(marker);
   
};
</script>
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

.section_font {
	font-size: medium;
}
.like_font {
	font-size: x-small;
}
.like_pic {
	height: 55px;
	width: 55px;
	border-radius: 80px;
	
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
</style>
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=581b52bf427addc822b75318dd52cec8effd3375"></script>
<!-- 9c13582401dfcd9731d9a58747b5e6f8de2a6e50 -->
<!-- 	38a075511104ca3ed2b86b293d3c1cf0d7335dc5
 -->
</head>
<body onload="initTmap()">
	<jsp:include page="navibar_main.jsp" />
	<hr>

	<div id="content">
		<c:set var="e_d" value="${requestScope.eatList }" />
		<c:set var="e_r_d" value="${requestScope.eatRList }" />
		<c:set var="e_l_d" value="${requestScope.eatLList }" />
		<script>
								var visible2 = false;
								
								function likeMemberList(){
									var lml = document.getElementById('likeMember');
									
									if(visible2 == false){
										visible2= true;
										lml.style.display='block';
									}else if(visible2 == true){
										visible2 = false;
										lml.style.display='none';
									}
								}
								
		</script>
		<table>
			<tr>
				<td align="center"><img class="pic" src="img/picture.png" />
					<div>
						<img src="files/${e_d.e_img }"
							style="width: 400px; height: 400px;" />
					</div></td>
				<td style="width: 100px;"></td>
				<td align="center"><img class="pic" src="img/location.png" />
					<script language="javascript"
						src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=06296168-a5d4-3a11-bfe0-d178d3db6ccd"></script>
					<div id="map_div"></div></td>
			</tr>
			<tr>
				<td align="center">
					<table>
						<tr>
							<td>
								<p class='section_font'>
									<a onclick="likeMemberList()"><img src="img/idicon.png" /></a>
									��õ �� : ${e_d.e_l_count }
								</p>
								<div id="likeMember">
									<table>
										<tr>
											<th>��õ ���</th>
										</tr>
										<tr>
											<c:forEach items="${e_l_d}" var="eld">
												<td align='center'><img src="files/${eld.m_img }"
													class="like_pic"> <br>
													<p class='like_font'>${eld.e_l_m_id }</p></td>
											</c:forEach>
										</tr>
									</table>
								</div>
							</td>
							<td style="width: 100px;"></td>
							<td><p class='section_font'>��� �� : ${e_d.e_r_count }</p></td>
						</tr>
					</table>
				</td>
				<td style="width: 100px;"></td>
				<td align="center"><img class="pic3" src="img/infomation.png" />
				</td>
			</tr>
			
			<tr>
				<td>
					<div class="info_div">
						<table>
						<c:forEach items="${e_r_d}" var="erd">
							<tr>
							<td>						
							<img src="files/${erd.m_img}" class="member_pic">
							</td>
							<td>
							${erd.e_r_m_id }
							${erd.e_r_content }
							${erd.e_r_date }
							</td>
							</tr>
							
						</c:forEach>
						</table>
					</div>
				</td>
				<td style="width: 100px;"></td>
				<td align="center">
					<div class="info_div">
						<br>
						<table>
							<tr>
								<td>�� �� : </td>
								<td>${e_d.e_title}</td>
							</tr>
							<tr>
								<td>�� ġ : </td>
								<td>${e_d.e_location2}</td>
							</tr>
							<tr>
								<td>�ۼ��� : </td>
								
								<td>
								<script>
								var visible = false;
								
								function memberDetail(){
									var sbm = document.getElementById('submenu');
									
									if(visible == false){
										visible= true;
										sbm.style.display='block';
									}else if(visible == true){
										visible = false;
										sbm.style.display='none';
									}
								}
								
								</script>
								<a onclick="memberDetail()"><img src="img/idicon3.png"/></a>&nbsp;${e_d.e_m_id }
								<div id="submenu">
									<div>
										<a href="memberDetail.do?m_id=${e_d.e_m_id }">ȸ������</a>
									</div>
									<div>
										<a href="meet_friend.do?f_id=${e_d.e_m_id }">ģ���α�</a>
									</div>
								</div>
								
								</td>
								
							</tr>
							<tr>
								<td>�ۼ��� : </td>
								<td>${e_d.e_date}</td>
							</tr>

						</table>
						
						<br>
						<table align="center">
							<tr>
								<td align="center">
									<img src="img/info_price.png">
								</td>
								<td align="center">
									<img src="img/info_season.png">
								</td>
								<td align="center">
									<img src="img/info_inout.png">
								</td>
								
							</tr>
							<tr>
								<td align="center">${e_d.e_price}������</td>
								<td align="center">${e_d.e_session}</td>
								<td align="center">${e_d.e_inout}</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center">
				<form id='like_btn' method='post' action='enterEatReply.do'>
					<input type="hidden" name="id" value="${e_d.e_m_id}">
						<img src='img/like_mb.png' id='like_pic' onclick="checkLike()">
						<script>
							function checkLike() {
								var isOk = confirm("�� ���� ��õ�Ͻðڽ��ϱ�?");
								var like_Btn = document
										.getElementById("like_btn");

								if (isOk == true) {
									like_Btn.action = "enterEatLike.do"
									like_Btn.submit();
								} else {
									//Nothing
								}
							}
						</script>
						<input type="hidden" name='e_num' value='${param.e_num }'>
						<input type="textarea" name='e_content_Rply' style="width: 330px; text-align: center"><input
							type='submit'>
					</form>
				</td>
				<td style="width: 100px;"></td>
				<td style="width: 400px;"></td>
			</tr>

		</table>

		<div class="content_div" align="center">${e_d.e_content}</div>
		<jsp:include page="footer.jsp" />
</body>
</html>