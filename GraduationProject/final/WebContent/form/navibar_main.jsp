<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!-- �����̵� �޴� ��Ÿ�� ��Ʈ -->
<STYLE type=text/css>
.sidemenu { /* ���̵� �޴��ڽ��� ���� �����̳��Դϴ�. */
	position:absolute; 
	position:fixed; /* �ٸ� ��ü�� �浹�� ����� �մϴ�. */
	top:0; /* �޴� �ڽ��� ��ܿ� �����մϴ�. */
	height: 100%; /* ����Ʈ������ ���η� ���� �޴��� ����ϴ�. (�翬�� PC������...) */
	background-color: silver; /* ������ ���� ��ô� �ɷ�...*/
	overflow-x:hidden; /* �޴� ������ ���� ������ �ֵ��� �����ϰ� �߶���ϴ�. */
	z-index:999999; /* ���̾� ��ġ���� ������ ���(����� *.*a) */
}
.sidemenu-left{ 
	left:0;
} /* �ܼ� ��ġ���Դϴ�. ����� ���� �����̰� ���ʿ� ��ġ����?*/
.sidemenu-right{ 
	right:0;
}/* �����ʿ� ��ġ���� */
</STYLE>

<!-- ����޴� ������ �������� script -->
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

<!-- ��Ÿ��  �ʱ�ȭ -->
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

<!-- ��� -->
<style>
#main_header {
	/*���� ��ǥ*/
	position: relative;
	height: 48px;
	background: #3b5998;
}

#main_header>#main_lnb {
	bottom: 20px;
}
</style>

<!-- �޴�(2) -->
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
	/*�̰� ���� */
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
<!-- ���� �޴� -->
<style>
.sub_menu {
	background: #f1f1f1;
	visibility: hidden;
	font-family: '���� ���', bold;
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
			<li class="top_menu"><a href="notice.do" onmouseover="subOn(1)">��������</a>
				<ul id="sub_notice" class="sub_menu">
					<li><a href="notice.do">�˸�&��뼳��</a></li>
					<li><a href="question.do">���ֹ�������</a></li>
				</ul></li>
			<li><a href="search_page.do" onmouseover="subOn(6)">�󼼰˻�</a>
				<ul id="sub_serch" class="sub_menu">
					<li><a href="notice.do">������ �˻�</a></li>
					<li><a href="question.do">���ӱ� �˻�</a></li>
				</ul>
			
			</li>
			<li><a href="make.do" onmouseover="subOn(2)">���ñ۾���</a>
			<ul id="sub_make" class="sub_menu">
					<li><a href="sns_make.do">�������ۼ�</a></li>
					<li><a href="meeting_make.do">���ӱ��ۼ�</a></li>
				</ul></li>
			<li><a href="socialReply.do" onmouseover="subOn(3)">�ı�</a>
				<ul id="sub_review" class="sub_menu">
					<li><a href="socialReply.do">�ı���</a></li>
					<li><a href="socialReview.do">�ı����</a></li>
				</ul></li>
			<li><a href="pride.do" onmouseover="subOn(4)">Ŀ�´�Ƽ</a>
				<ul id="sub_community" class="sub_menu">
					<li><a href="pride.do">�ڶ��ϱ�</a></li>
					<li><a href="info.do">��������</a></li>
				</ul></li>
			<%
				if (id == null) {
			%>
			<li><a href="login.do" onmouseover="subOn(0)">�α���</a></li>
			<%
				} else {
			%>
			<li><a href="logout.do" onmouseover="subOn(0)">�α׾ƿ�</a></li>
			<%
				}
			%>
			<li><a href="#" onmouseover="subOn(5)"><img
					src="img/menu_collection.png"></a>
				<ul id="sub_collection" class="sub_menu">
					<%
						if (id == null) {
					%>
					<li><a href="login.do">�α���</a></li>
					<%
						} else {
					%>
					<li><a href="memberDetail.do?m_id=<%=id%>">ȸ������</a></li>
					<%
						}
					%>
					<li><a class="popup-with-form" href="join.do">ȸ������</a></li>
				</ul></li>
		</ul>
	</nav>
</header>