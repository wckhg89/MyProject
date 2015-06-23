<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!-- 서브메뉴 스무스 내려오는 script -->
<script type="text/javascript">
	function subOn(n) {

		var notice = document.getElementById("sub_notice");
		//notice.style.visibility = 'hidden';
		$(notice).slideUp('fast');

		var party = document.getElementById("sub_party");
		$(party).slideUp('fast');
		//party.style.visibility = 'hidden';

		var review = document.getElementById("sub_review");
		$(review).slideUp('fast');
		//review.style.visibility = 'hidden';

		var community = document.getElementById("sub_community");
		$(community).slideUp('fast');
		/* community.style.visibility = 'hidden'; */

		var collection = document.getElementById("sub_collection");
		$(collection).slideUp('fast');

		switch (n) {
		case 1:
			var sub = document.getElementById("sub_notice");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';

			break;
		case 2:
			var sub = document.getElementById("sub_party");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		case 3:
			var sub = document.getElementById("sub_review");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		case 4:
			var sub = document.getElementById("sub_community");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		case 5:
			var sub = document.getElementById("sub_collection");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		}

	}

	function subOn(n) {

		var notice = document.getElementById("sub_notice");
		//notice.style.visibility = 'hidden';
		$(notice).slideUp('fast');

		var party = document.getElementById("sub_party");
		$(party).slideUp('fast');
		//party.style.visibility = 'hidden';

		var review = document.getElementById("sub_review");
		$(review).slideUp('fast');
		//review.style.visibility = 'hidden';

		var community = document.getElementById("sub_community");
		$(community).slideUp('fast');
		/* community.style.visibility = 'hidden'; */

		var collection = document.getElementById("sub_collection");
		$(collection).slideUp('fast');

		switch (n) {
		case 1:
			var sub = document.getElementById("sub_notice");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';

			break;
		case 2:
			var sub = document.getElementById("sub_party");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		case 3:
			var sub = document.getElementById("sub_review");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		case 4:
			var sub = document.getElementById("sub_community");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		case 5:
			var sub = document.getElementById("sub_collection");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';
			break;
		}

	}
</script>

<!-- 스타일  초기화 -->
<!-- CSS -->
<!-- 초기화 -->
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: '맑은 고딕', bold;
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

<!-- 헤더 -->
<style>
#main_header {
	/*절대 좌표*/
	position: relative;
	height: 48px;
	background: #3b5998;
}

#main_header>#main_lnb {
	bottom: 20px;
}
</style>

<!-- 메뉴(2) -->
<style>
#main_lnb>ul {
	position: relative;
	overflow: hidden;
	width: 960px;
	margin: 0 auto;
}

#main_lnb>ul>li {
	float: left;
	text-align: center;
	/*이게 문제 */
}

#main_lnb>ul>li>a {
	background: white;
	color: white;
	display: block;
	background: #3b5998;
}

#main_lnb>ul>li>a:hover {
	background: #384F80;
	color: white;
	display: block;
	transition-duration: 2s;
}

#main_lnb>ul>li>a {
	background: #3b5998;
	color: white;
	display: block;
	padding: 13px 27px;
	transition-duration: 2s;
}
</style>
<!-- 서브 메뉴 -->
<style>
.sub_menu {
	background: #f1f1f1;
	visibility: hidden;
	font-family: '맑은 고딕', bold;
	font-size: 13px;
	margin: 10px 0 0 0;
	border: 1px solid #dddddd;
}

.sub_menu>li>a {
	color: black;
}
</style>
<%
	String id = (String) session.getAttribute("login");
%>
<header id="main_header">
	<nav id="main_lnb">
		<ul>
			<li><a href="login.do" onmouseover="subOn(0)"><img
					src="img/title.png"></a></li>
		</ul>
	</nav>
</header>