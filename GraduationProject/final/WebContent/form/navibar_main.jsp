<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!-- 슬라이딩 메뉴 스타일 시트 -->
<STYLE type=text/css>
.sidemenu { /* 사이드 메뉴박스를 만들 컨테이너입니다. */
	position:absolute; 
	position:fixed; /* 다른 객체와 충돌이 없어야 합니다. */
	top:0; /* 메뉴 박스를 상단에 고정합니다. */
	height: 100%; /* 스마트폰에서 세로로 꽉찬 메뉴를 만듭니다. (당연히 PC에서도...) */
	background-color: silver; /* 배경색은 맘에 드시는 걸로...*/
	overflow-x:hidden; /* 메뉴 밖으로 삐져 나오는 애들은 과감하게 잘라냅니다. */
	z-index:999999; /* 레이어 위치값은 적당히 쎄게(어렵죠 *.*a) */
}
.sidemenu-left{ 
	left:0;
} /* 단순 배치용입니다. 상단은 고정 상태이고 왼쪽에 배치할지?*/
.sidemenu-right{ 
	right:0;
}/* 오른쪽에 배치할지 */
</STYLE>

<!-- 서브메뉴 스무스 내려오는 script -->
<script type="text/javascript">
	function subOn(n) {

		var notice = document.getElementById("sub_notice");
		$(notice).slideUp('fast');

		var party = document.getElementById("sub_make");
		$(party).slideUp('fast');

		var review = document.getElementById("sub_review");
		$(review).slideUp('fast');

		var community = document.getElementById("sub_community");
		$(community).slideUp('fast');

		var collection = document.getElementById("sub_collection");
		$(collection).slideUp('fast');
		
		var search = document.getElementById("sub_serch");
		$(search).slideUp('fast');
		
		
		switch (n) {
		case 1:
			var sub = document.getElementById("sub_notice");
			$(sub).slideDown('normal').show();
			sub.style.visibility = 'visible';

			break;
		case 2:
			var sub = document.getElementById("sub_make");
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
		case 6:
			var sub = document.getElementById("sub_serch");
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
			<li><a href="mainAll.do" onmouseover="subOn(0)"><img
					src="img/title.png"></a></li>
			<li class="top_menu"><a href="notice.do" onmouseover="subOn(1)">공지사항</a>
				<ul id="sub_notice" class="sub_menu">
					<li><a href="notice.do">알림&사용설명서</a></li>
					<li><a href="question.do">자주묻는질문</a></li>
				</ul></li>
			<li><a href="search_page.do" onmouseover="subOn(6)">상세검색</a>
				<ul id="sub_serch" class="sub_menu">
					<li><a href="notice.do">정보글 검색</a></li>
					<li><a href="question.do">모임글 검색</a></li>
				</ul>
			
			</li>
			<li><a href="make.do" onmouseover="subOn(2)">개시글쓰기</a>
			<ul id="sub_make" class="sub_menu">
					<li><a href="sns_make.do">정보글작성</a></li>
					<li><a href="meeting_make.do">모임글작성</a></li>
				</ul></li>
			<li><a href="socialReply.do" onmouseover="subOn(3)">후기</a>
				<ul id="sub_review" class="sub_menu">
					<li><a href="socialReply.do">후기댓글</a></li>
					<li><a href="socialReview.do">후기사진</a></li>
				</ul></li>
			<li><a href="pride.do" onmouseover="subOn(4)">커뮤니티</a>
				<ul id="sub_community" class="sub_menu">
					<li><a href="pride.do">자랑하기</a></li>
					<li><a href="info.do">정보공유</a></li>
				</ul></li>
			<%
				if (id == null) {
			%>
			<li><a href="login.do" onmouseover="subOn(0)">로그인</a></li>
			<%
				} else {
			%>
			<li><a href="logout.do" onmouseover="subOn(0)">로그아웃</a></li>
			<%
				}
			%>
			<li><a href="#" onmouseover="subOn(5)"><img
					src="img/menu_collection.png"></a>
				<ul id="sub_collection" class="sub_menu">
					<%
						if (id == null) {
					%>
					<li><a href="login.do">로그인</a></li>
					<%
						} else {
					%>
					<li><a href="memberDetail.do?m_id=<%=id%>">회원정보</a></li>
					<%
						}
					%>
					<li><a class="popup-with-form" href="join.do">회원가입</a></li>
				</ul></li>
		</ul>
	</nav>
</header>