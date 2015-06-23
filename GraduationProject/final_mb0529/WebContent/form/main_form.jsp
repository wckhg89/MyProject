<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Travel Mate</title>

<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimun-scale=1.0, user-scalable=no" />

<!-- �ʱ�ȭ -->
<style>
.picture {
	height: 140px;
	width: 140px;
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
	background: url('img/map_mb.png');
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
.section_font{
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
#logo{
	margin-top:12px;
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
<!-- �����̵� �޴� ��ũ��Ʈ -->
 <script type="text/javascript">
        (function ($) {
            //�޴��ٿ� �÷�����
            $.fn.SideMenu = function () {
                return this.each(function () {
                    
                    var target = $(this);
                    //�޴����� ��ġ�� Body�ױ� ���� �ڽ����� �̵��մϴ�.
                    $('body').append(target);
                    //�޴��ٸ� ����ϴ�.
                    target.css("margin-" + func.getmode(target), "-" + target.outerWidth() + "px");
                    //�޴��� ���ο� ���� ��ư ã��
                    target.find(".btn-sidemenu").each(function () {
                        //�޴��� ���߱� ��ư�� �̺�Ʈ �Ҵ�
                        $(this).click(function () { Act.hide(target);});
                    });
                });
            };

            //�޴��� ȣ�� ��ư��...
            $.fn.SideMenuButton = function () {
                return this.each(function () {
                    //Ÿ���� ������ ��츸 �̺�Ʈ �Ҵ�
                    if ($(this).data("target")) {
                        $(this).click(function () {
                            //�޴��� ȣ���� ���� �����ڸ� �ҷ��� jquery��ü�� ����ϴ�.
                            var target = $($(this).data("target"));

                            //��ư�� ������ �����Լ��̸��� �����´�.
                            var acttype = $(this).data("act");

                            if (acttype)//������ �Լ��� �ִٸ�
                                Act[acttype](target);//������ �Լ� ����
                            else//���ٸ�
                                Act.show(target);//�����ֱ� �Լ� ����
                        });
                    }
                });
            }

            var func = {
                //�޴��ٰ� ���� �޴������� ���� �޴������� Ȯ�� �մϴ�.
                getmode: function (target) { return target.hasClass("sidemenu-right") ? "right" : "left"; },                
                setmargin: function (target, margin)//������ ��ϱ�
                {//���ϸ��̼� ������Ƽ ���� ����� �䱸�ϱ� ������ if �� ó��
                    if (this.getmode(target) == "left")
                        target.animate({ "margin-left": margin }, 400);
                    else
                        target.animate({ "margin-right": margin }, 400);
                },
                isClosed: function (target)
                {//���� �޴��ٰ� �������� �������� Ȯ��
                    return target.css("margin-"+this.getmode(target))
                        == "-" + target.outerWidth() + "px";
                }
            }

            var Act = {
                //�����ֱ�� ������ 0
                show: function (target) { func.setmargin(target, "0"); },
                //���߱�� ��������
                hide: function (target) { func.setmargin(target, "-" + target.outerWidth() + "px"); },
                toggle: function (target) {
                    if (func.isClosed(target))
                        this.show(target);
                    else
                        this.hide(target);
                }
            }

            //��ũ��Ʈ ��� ȣ���
            $.SideMenu = function () {
                //���� �Ű� ������ �̿��� toggle ����
                for (var i = 0; i < arguments.length; i++)
                    Act.toggle($(arguments[i]));
            };
            //���Ǹ� ���� Ŭ���������� �ڵ� ���ε�
            $(document).ready(function () {
                $(".sidemenu").SideMenu();
                $(".left").SideMenuButton();
            });
        })(jQuery);
    </script>
</head>
<body>
	<input id="toggle" type="checkbox" />
	<div id="wrap">
		<header id="main_header"> 
		<a class="left" href="#" data-target="#leftMenu">Main</a>
		<div id="leftMenu" class="sidemenu sidemenu-left" style="padding:10px; width:200px;">
            <button class="btn btn-primary btn-sidemenu">���߱�</button><p></p>
            <div class="list-group">
            <%!String id;%>
			<%
				id = (String) session.getAttribute("login");
			%>
			<%
								if (id == null || id.equals("")) {
			%>
                <a href="join.do" class="list-group-item active">ȸ������</a>
            <%}else{ %>
                <a href="memberInfo.do" class="list-group-item active">ȸ������</a>	
            <%} %>    
                <a href="login.do" class="list-group-item">�α���</a>
                <a href="write.do" class="list-group-item">���ۼ�</a>
                <a href="recommend.do" class="list-group-item">��õ</a>
                
            </div>
        </div>
		<img id='logo' src='img/logo.png'/>
		<label class="right" for="toggle" onclick="">Toggle</label> </header>
		<!-- <div id="toggle_gnb_wrap">
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
		</div> -->
		<jsp:include page="main_contents_ajax.jsp" />
		<footer id="main_footer">
		<h3>������ǰ</h3>
		<address>������, ��ȫ��, ����ö</address>
		</footer>
</body>
</html>
