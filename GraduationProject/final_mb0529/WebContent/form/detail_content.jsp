<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Travel Mate</title>

<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimun-scale=1.0, user-scalable=no" />

<!-- �ʱ�ȭ -->
<style>
#content {
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	padding-top: 50px;
	padding-bottom: 50px;
}

#content_pic {
	height: 160px;
	width: 160px;
	border-radius: 80px;
	margin-right: 20px;
}

.member_pic {
	height: 55px;
	width: 55px;
	border-radius: 80px;
	margin-right: 20px;
}

#like_pic {
	height: 40px;
	width: 40px;
	margin-left: 5px;
	margin-bottom: 5px;
}

* {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Helvetica', sans-serif;
}

li {
	list-style: none;
}

a {
	text-decoration: none;
}
</style>

<!-- ��� -->
<style>
#main_header {
	/* ��� ���� */
	height: 45px;
	/*             background: url('header_background.png'); */
	background: #395693;
	/* �ڼ� ��ġ ���� */
	position: relative;
	text-align: center;
	line-height: 45px;
}

#main_header>h1 {
	color: white;
}

#main_header>a, #main_header>label {
	display: block;
	height: 32px;
	position: absolute;
}

#main_header>a.left {
	width: 32px;
	left: 5px;
	top: 7px;
}

#main_header>label.right {
	width: 32px;
	right: 5px;
	top: 7px;
}
</style>
<!-- ��������Ʈ �̹��� -->
<style>
#main_header>a.left {
	background: url('img/list_mb.png');
	background-position: 0px 0px;
	text-indent: -99999px;
}

#main_header>label.right {
	background: url('img/profile_mb.png');
	background-position: -62px 0px;
	text-indent: -99999px;
}
</style>
<!-- ��� ��� -->
<style>
/* ��� ���� */
#toggle {
	display: none;
}

#toggle+#wrap>#toggle_gnb_wrap {
	display: none;
}

#toggle:checked+#wrap>#toggle_gnb_wrap {
	display: block;
}

/* ���̾ƿ� ���� */
#toggle_gnb_wrap {
	background: #FFFFFF;
	padding: 15px;
}

#toggle_gnb {
	background: #FFFFFF;
	padding: 5px;
}

/* ��� ��� */
#toggle_gnb>ul {
	overflow: hidden;
}

#toggle_gnb>ul>li {
	width: 80px;
	float: left;
}
</style>
<!-- �׺���̼�(1) -->
<style>
#top_gnb {
	overflow: hidden;
	border-bottom: 1px solid black;
	background: #395693;
}

#top_gnb>div>a {
	/* ���� ���� */
	float: left;
	width: 25%;
	/* ũ�� �� ����, ���� */
	height: 35px;
	line-height: 35px;
	text-align: center;
	color: white;
}
</style>
<!-- �׺���̼�(2) -->
<style>
#bottom_gnb {
	display: table;
	width: 100%;
	border-bottom: 1px solid black;
}

#bottom_gnb>div {
	display: table-cell;
	position: relative;
}

#bottom_gnb>div>a {
	display: block;
	height: 35px;
	line-height: 35px;
	text-align: center;
}

#bottom_gnb>div>a::before {
	display: block;
	position: absolute;
	top: 9px;
	left: -1px;
	width: 1px;
	height: 15px;
	border-left: 1px solid black;
	content: '';
}
</style>
<!-- ���� -->
<style>
.section_font {
	font-size: x-small;
}

#section_header {
	padding: 20px;
}

#section_header2 {
	padding: 20px;
}

#page1 {
	margin: 30px;
	background: #a1cbf2;
}

#page2 {
	margin: 30px;
	background: #a1cbf2;
}

#section_article {
	padding: 10px;
}

#section_article2 {
	padding: 20px;
}

#main_section {
	background: white;
	/* 	        margin: 20px; */
}

#logo {
	margin-top: 12px;
}

#img_box {
	position: relative;
}

#data_box {
	position: relative;
}
</style>
<!-- Ǫ�� -->
<style>
#main_footer {
	padding: 10px;
	border-top: 3px solid black;
	text-align: center;
}
</style>

<!-- �����̵� �޴� ��Ÿ�� ��Ʈ -->
<STYLE type=text/css>
.sidemenu { /* ���̵� �޴��ڽ��� ���� �����̳��Դϴ�. */
	position: absolute;
	position: fixed; /* �ٸ� ��ü�� �浹�� ����� �մϴ�. */
	top: 0; /* �޴� �ڽ��� ��ܿ� �����մϴ�. */
	height: 100%; /* ����Ʈ������ ���η� ���� �޴��� ����ϴ�. (�翬�� PC������...) */
	background-color: silver; /* ������ ���� ��ô� �ɷ�...*/
	overflow-x: hidden; /* �޴� ������ ���� ������ �ֵ��� �����ϰ� �߶���ϴ�. */
	z-index: 999999; /* ���̾� ��ġ���� ������ ���(����� *.*a) */
}

.sidemenu-left {
	left: 0;
} /* �ܼ� ��ġ���Դϴ�. ����� ���� �����̰� ���ʿ� ��ġ����?*/
.sidemenu-right {
	right: 0;
} /* �����ʿ� ��ġ���� */
</STYLE>

<!-- �����̵� �޴� ��ũ��Ʈ -->
<script type="text/javascript">
	(function($) {
		//�޴��ٿ� �÷�����
		$.fn.SideMenu = function() {
			return this.each(function() {

				var target = $(this);
				//�޴����� ��ġ�� Body�ױ� ���� �ڽ����� �̵��մϴ�.
				$('body').append(target);
				//�޴��ٸ� ����ϴ�.
				target.css("margin-" + func.getmode(target), "-"
						+ target.outerWidth() + "px");
				//�޴��� ���ο� ���� ��ư ã��
				target.find(".btn-sidemenu").each(function() {
					//�޴��� ���߱� ��ư�� �̺�Ʈ �Ҵ�
					$(this).click(function() {
						Act.hide(target);
					});
				});
			});
		};

		//�޴��� ȣ�� ��ư��...
		$.fn.SideMenuButton = function() {
			return this.each(function() {
				//Ÿ���� ������ ��츸 �̺�Ʈ �Ҵ�
				if ($(this).data("target")) {
					$(this).click(function() {
						//�޴��� ȣ���� ���� �����ڸ� �ҷ��� jquery��ü�� ����ϴ�.
						var target = $($(this).data("target"));

						//��ư�� ������ �����Լ��̸��� �����´�.
						var acttype = $(this).data("act");

						if (acttype)//������ �Լ��� �ִٸ�
							Act[acttype](target);//������ �Լ� ����
						else
							//���ٸ�
							Act.show(target);//�����ֱ� �Լ� ����
					});
				}
			});
		}

		var func = {
			//�޴��ٰ� ���� �޴������� ���� �޴������� Ȯ�� �մϴ�.
			getmode : function(target) {
				return target.hasClass("sidemenu-right") ? "right" : "left";
			},
			setmargin : function(target, margin)//������ ��ϱ�
			{//���ϸ��̼� ������Ƽ ���� ����� �䱸�ϱ� ������ if �� ó��
				if (this.getmode(target) == "left")
					target.animate({
						"margin-left" : margin
					}, 400);
				else
					target.animate({
						"margin-right" : margin
					}, 400);
			},
			isClosed : function(target) {//���� �޴��ٰ� �������� �������� Ȯ��
				return target.css("margin-" + this.getmode(target)) == "-"
						+ target.outerWidth() + "px";
			}
		}

		var Act = {
			//�����ֱ�� ������ 0
			show : function(target) {
				func.setmargin(target, "0");
			},
			//���߱�� ��������
			hide : function(target) {
				func.setmargin(target, "-" + target.outerWidth() + "px");
			},
			toggle : function(target) {
				if (func.isClosed(target))
					this.show(target);
				else
					this.hide(target);
			}
		}

		//��ũ��Ʈ ��� ȣ���
		$.SideMenu = function() {
			//���� �Ű� ������ �̿��� toggle ����
			for (var i = 0; i < arguments.length; i++)
				Act.toggle($(arguments[i]));
		};
		//���Ǹ� ���� Ŭ���������� �ڵ� ���ε�
		$(document).ready(function() {
			$(".sidemenu").SideMenu();
			$(".left").SideMenuButton();
		});
	})(jQuery);
</script>
<!-- ȸ������ �� �α���  -->
<script type="text/javascript">
	function goLogin() {
		var form = document.getElementById("f");
		form.action = "loginProcess.do";
		form.submit();
	}
	function goJoin() {
		var form = document.getElementById("f");
		form.action = "join.do";
		form.submit();
	}
</script>
</head>
<body>
	<input id="toggle" type="checkbox" />
	<div id="wrap">
		<header id="main_header"> <a class="left" href="#"
			data-target="#leftMenu">Main</a>
		<div id="leftMenu" class="sidemenu sidemenu-left"
			style="padding: 10px; width: 200px;">
			<button class="btn btn-primary btn-sidemenu">���߱�</button>
			<p></p>
			<div class="list-group">
				<a href="#" class="list-group-item active">ȸ������</a> <a href="#"
					class="list-group-item">�α���</a> <a href="#" class="list-group-item">���ۼ�</a>

			</div>
		</div>
		<img id='logo' src='img/logo.png' /> <label class="right" for="toggle"
			onclick="">Toggle</label> </header>
		<div id="toggle_gnb_wrap">
			<div id="toggle_gnb">
				<ul>
					<li><a href="#">��ư</a></li>
					<li><a href="#">��ư</a></li>
					<li><a href="#">��ư</a></li>
					<li><a href="#">��ư</a></li>
					<li><a href="#">��ư</a></li>
					<li><a href="#">��ư</a></li>
					<li><a href="#">��ư</a></li>
					<li><a href="#">��ư</a></li>
				</ul>
			</div>
		</div>

		<section id="content"> 
		<c:if test="${param.category =='p'}">
			<!-- �� ���� �� -->
			<center>
				<div id='section_article'>
					<table>
						<tr>
							<td><img src='files/${play_Bean.p_img }' id='content_pic' />
							</td>

							<td>
								<p class='section_font'>�ۼ��� : ${play_Bean.p_date }</p>
								<p class='section_font'>�ۼ��� : ${play_Bean.p_m_id }</p>
								<p class='section_font'>�� �� : ${play_Bean.p_content }</p>
								<p class='section_font'>�� ġ : ${play_Bean.p_location2 }</p>
								<p class='section_font'>�������� : ${play_Bean.p_price }</p>
								<p class='section_font'>��õ���� : ${play_Bean.p_session }</p>
								<p class='section_font'>�ǳ��ܿ��� : ${play_Bean.p_inout }</p>
							</td>
						</tr>
					</table>
				</div>
				<div id='section_article2'>
					<!-- ���⼭���� ��õ�� ��� -->
					<table background="white">
						<tr>
							<td><p class='section_font'>��õ �� : ${play_Bean.p_l_count }</p></td>
							<td><p class='section_font'>��� �� : ${play_Bean.p_r_count }</p></td>
						</tr>
						<c:forEach items="${play_R_List}" var='pr'>
							<tr>
								<td colspan='2'>
									<p class='section_font'>
										<img src='files/${play_Bean.p_img }' class='member_pic' />
										${pr.p_r_m_id } ${pr.p_r_content } ${pr.p_r_date }
									</p>
								</td>
							</tr>
						</c:forEach>								
						<tr>
							<form id='like_btn' method='get' action='enterReply.do'>
							<td colspan=2><img src='img/like_mb.png' id='like_pic' onclick="checkLike()">
							<script>
								function checkLike(){
									var isOk = confirm("�� ���� ��õ�Ͻðڽ��ϱ�?");
									var like_Btn = document.getElementById("like_btn");
									
									if(isOk == true){
										like_Btn.action = "enterLike.do"
										like_Btn.submit();
									}else{
										//Nothing
									}
								}
							</script>
								<input type="hidden" name='p_num' value='${param.p_num }'>
								<input type="textarea" name='content_Rply'><input type='submit'></td>
							</form>								
						</tr>
					</table>

					</span>
				</div>
			</center>
		</c:if> </section>

		<footer id="main_footer">
		<h3>������ǰ</h3>
		<address>������, ��ȫ��, ����ö</address>
		</footer>
</body>
</html>
