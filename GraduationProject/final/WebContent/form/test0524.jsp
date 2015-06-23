<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="//code.jquery.com/jquery.js"></script>
<style type="text/css">
div.ilsb-child { /* ★요기★ */
	position: absolute;
	display: none;
	padding: 10px;
	border: 1px solid #b5b2b5;
	background-color: #efefef; /* 백그라운드는 반드시 줘야함 */
	margin-left: -2px; /* 입맛에 맞게 수정 */
	margin-top: -2px; /* 입맛에 맞게 수정 */
	line-height: 1.4;
	white-space: nowrap; /* IE 버그 */
}
#submenu { /* ★요기★ */
	position: absolute;
	display: none;
	padding: 10px;
	border: 1px solid #b5b2b5;
	background-color: #efefef; /* 백그라운드는 반드시 줘야함 */
	margin-left: -2px; /* 입맛에 맞게 수정 */
	margin-top: -2px; /* 입맛에 맞게 수정 */
	line-height: 1.4;
	white-space: nowrap; /* IE 버그 */
}

/* 기본 css */
/* body,td,input,textarea,select {font-size:12px; font-family:굴림; color:#404040;}
dl{margin:0;}
a:link    {color:#424542; text-decoration:none;}
a:visited {color:#424542; text-decoration:none;}
a:active  {color:#424542; text-decoration:none;}
a:hover   {color:#295584; text-decoration:underline;} */

/* 추가 css */
.r, a.r:link, a.r:visited, a.r:hover, a.r:active {
	color: #FF3600
} /*red*/
.b, a.b:link, a.b:visited, a.b:hover, a.b:active {
	font-weight: bold
} /*Bold*/
</style>


<script type="text/JavaScript">
<!--
function getElementsByClass(searchClass,tag,node){ // 양키님 협찬
	var classElements = new Array();
	if(!node) node = document;
	if(!tag) tag = '*';
	var els = node.getElementsByTagName(tag);
	var elsLen = els.length;
	var pattern = new RegExp("(^|\\s)"+searchClass+"(\\s|$)");
	for(var i=0; i<elsLen; i++){
		if(pattern.test(els[i].className)) classElements[classElements.length] = els[i];
	}
	return classElements;
}

function set_ilsb(){ // ★요기★
	var d = getElementsByClass("ilsb-parent","div");
	for(var i=0; i<d.length; i++){
		var c = getElementsByClass("ilsb-child","div",d[i]);
		if(c[0]){
			d[i].cMenu = c[0]; // 스코프 관리를 편하게 하기 위해 개체로 삽입
			d[i].onmouseover = new Function("this.cMenu.style.display='block'");
			d[i].onmouseout = new Function("this.cMenu.style.display='none'");
		}
	}
}
</script>
</head>
<body onload="set_ilsb()">
	<h3>
		<span class="r b"><a href='#'><img src="../img/idicon.png" /></a>
			강홍구</span>
	</h3>
	<%-- "memberDetail.do?m_id=${m.m_id }" --%>

	<h3 style="color: blue;">간단한 풀다운 메뉴 만들기</h3>
	<hr>
	<p>
		<!-- <span class="r b">아시아</span>, <span class="r b">유럽</span>, <span
			class="r b">아메리카</span> 마우스를 올려봅니다. -->
	</p>
	<script>
		var visible = false;
		function aaa(){
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


		<!-- ★요기 -->
		<div>
			<a href='#' onclick="aaa()"><img src="../img/idicon.png" /></a> 강홍구
		</div>
		<div id="submenu">
			<div>
				<a href="#">회원정보</a>
			</div>
			<div>
				<a href="#">쪽지보내기</a>
			</div>
			<div>
				<a href="#">팔로우하기</a>
			</div>
			<div>
				<a href="#">1:1채팅</a>
			</div>
		</div>



	<p>Hello,World</p>
	<p>Hello,World</p>
	<p>Hello,World</p>
</body>
</html>