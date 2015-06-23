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

<!-- 초기화 -->
<style>
#content {	
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	padding-top: 50px;
	padding-bottom: 50px;
}
#member_pic {
	height: 90px;
	width: 90px;
	border-radius:80px;
	margin-right:20px;
}
.picture {
	height: 75px;
	width: 75px;
	border-radius:10px;
	
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

<!-- 헤더 -->
<style>
#main_header {
	/* 배경 지정 */
	height: 45px;
	/*             background: url('header_background.png'); */
	background: #395693;
	/* 자손 위치 지정 */
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
<!-- 스프라이트 이미지 -->
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
<!-- 토글 목록 -->
<style>
/* 토글 구현 */
#toggle {
	display: none;
}

#toggle+#wrap>#toggle_gnb_wrap {
	display: none;
}

#toggle:checked+#wrap>#toggle_gnb_wrap {
	display: block;
	
}

/* 레이아웃 색상 */
#toggle_gnb_wrap {
	background: #FFFFFF;
	padding: 15px;
}

#toggle_gnb {
	background: #FFFFFF;
	padding: 5px;
}

/* 토글 목록 */
#toggle_gnb>ul {
	overflow: hidden;
}

#toggle_gnb>ul>li {
	width: 80px;
	float: left;
}
</style>
<!-- 네비게이션(1) -->
<style>
#top_gnb {
	overflow: hidden;
	border-bottom: 1px solid black;
	background: #395693;
}

#top_gnb>div>a {
	/* 수평 정렬 */
	float: left;
	width: 25%;
	/* 크기 및 색상, 정렬 */
	height: 35px;
	line-height: 35px;
	text-align: center;
	color: white;
}
</style>
<!-- 네비게이션(2) -->
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
<!-- 본문 -->
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
#img_box{
	position: relative;
	
}
#data_box{
	position: relative;
	
}

</style>
<!-- 푸터 -->
<style>
#main_footer {
	padding: 10px;
	border-top: 3px solid black;
	text-align: center;
}
</style>

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

<!-- 슬라이딩 메뉴 스크립트 -->
 <script type="text/javascript">
        (function ($) {
            //메뉴바용 플러그인
            $.fn.SideMenu = function () {
                return this.each(function () {
                    
                    var target = $(this);
                    //메뉴바의 위치를 Body테그 직속 자식으로 이동합니다.
                    $('body').append(target);
                    //메뉴바를 숨김니다.
                    target.css("margin-" + func.getmode(target), "-" + target.outerWidth() + "px");
                    //메뉴바 내부에 감춤 버튼 찾기
                    target.find(".btn-sidemenu").each(function () {
                        //메뉴바 감추기 버튼에 이벤트 할당
                        $(this).click(function () { Act.hide(target);});
                    });
                });
            };

            //메뉴바 호출 버튼용...
            $.fn.SideMenuButton = function () {
                return this.each(function () {
                    //타겟이 지정된 경우만 이벤트 할당
                    if ($(this).data("target")) {
                        $(this).click(function () {
                            //메뉴바 호출을 위한 선택자를 불러와 jquery객체로 만듭니다.
                            var target = $($(this).data("target"));

                            //버튼에 설정된 실행함수이름을 가져온다.
                            var acttype = $(this).data("act");

                            if (acttype)//지정된 함수가 있다면
                                Act[acttype](target);//지정된 함수 실행
                            else//없다면
                                Act.show(target);//보여주기 함수 실행
                        });
                    }
                });
            }

            var func = {
                //메뉴바가 좌측 메뉴바인지 우측 메뉴바인지 확인 합니다.
                getmode: function (target) { return target.hasClass("sidemenu-right") ? "right" : "left"; },                
                setmargin: function (target, margin)//마진값 등록기
                {//에니메이션 프로퍼티 값이 상수를 요구하기 때문에 if 로 처리
                    if (this.getmode(target) == "left")
                        target.animate({ "margin-left": margin }, 400);
                    else
                        target.animate({ "margin-right": margin }, 400);
                },
                isClosed: function (target)
                {//현재 메뉴바가 열린건지 닫힌건지 확인
                    return target.css("margin-"+this.getmode(target))
                        == "-" + target.outerWidth() + "px";
                }
            }

            var Act = {
                //보여주기시 마진값 0
                show: function (target) { func.setmargin(target, "0"); },
                //감추기시 역마진값
                hide: function (target) { func.setmargin(target, "-" + target.outerWidth() + "px"); },
                toggle: function (target) {
                    if (func.isClosed(target))
                        this.show(target);
                    else
                        this.hide(target);
                }
            }

            //스크립트 즉시 호출용
            $.SideMenu = function () {
                //가변 매개 변수를 이용해 toggle 실행
                for (var i = 0; i < arguments.length; i++)
                    Act.toggle($(arguments[i]));
            };
            //편의를 위헤 클래스명으로 자동 바인딩
            $(document).ready(function () {
                $(".sidemenu").SideMenu();
                $(".left").SideMenuButton();
            });
        })(jQuery);
    </script>
    <!-- 회원가입 및 로그인  -->
    <script type="text/javascript">
	function goLogin(){
		var form = document.getElementById("f");
		form.action="loginProcess.do";
		form.submit();
	}
	function goJoin(){
		var form = document.getElementById("f");
		form.action="join.do";
		form.submit();
	}
	
</script>
</head>
<body>
	<input id="toggle" type="checkbox" />
	<div id="wrap">
		<header id="main_header"> 
		<a class="left" href="#" data-target="#leftMenu">Main</a>
		<div id="leftMenu" class="sidemenu sidemenu-left" style="padding:10px; width:200px;">
            <button class="btn btn-primary btn-sidemenu">감추기</button><p></p>
            <div class="list-group">
                <a href="#" class="list-group-item active">회원가입</a>
                <a href="#" class="list-group-item">로그인</a>
                <a href="#" class="list-group-item">글작성</a>
                <a href="#" class="list-group-item">추천</a>
                
            </div>
        </div>
		<img id='logo' src='img/logo.png'/>
		<label class="right" for="toggle" onclick="">Toggle</label> </header>
		<div id="toggle_gnb_wrap">
			<div id="toggle_gnb">
				<ul>
					<li><a href="#">버튼</a></li>
					<li><a href="#">버튼</a></li>
					<li><a href="#">버튼</a></li>
					<li><a href="#">버튼</a></li>
					<li><a href="#">버튼</a></li>
					<li><a href="#">버튼</a></li>
					<li><a href="#">버튼</a></li>
					<li><a href="#">버튼</a></li>
				</ul>
			</div>
		</div>
		
		<section id="content">
		<center>
		<div id='section_article'>
			<table>
				<tr>
					<td>
						<img src='files/${mem_Data.m_img }' id='member_pic'/>
					</td>
					
					<td>
						<p class='section_font'>아이디 : ${mem_Data.m_id }</p>
						<p class='section_font'>이   름 : ${mem_Data.m_name }</p>
						<p class='section_font'>나   이 : ${mem_Data.m_age }</p>
						<p class='section_font'>연락처 : 0${mem_Data.m_phone }</p>
						<p class='section_font'>이메일 : ${mem_Data.m_email }</p>
					</td>
				</tr>
			</table>
		</div>
		<div id='section_article2'>
		<!-- 여기서부터 데이터 -->
			<table>
				<tr>
					<c:forEach items='${mem_Play }' var='p' begin="0" end="3">
						<td><img src='files${p.p_img }' class='picture'></td>
					</c:forEach>
				</tr>
				<tr>
					<c:forEach items='${mem_Eat }' var='e' begin="0" end="3">
						<td><img src='files${e.e_img }' class='picture'></td>
					</c:forEach>
				</tr>
				<tr>
					<c:forEach items='${mem_Sleep }' var='s' begin="0" end="3">
						<td><img src='files${s.s_img }' class='picture'></td>
					</c:forEach>
				</tr>
				<tr>
					<c:forEach items='${mem_Band }' var='b' begin="0" end="3">
						<td><img src='files${b.s_img }' class='picture'></td>
					</c:forEach>
				</tr>
			</table>
		</div>
		</center>
		</section>
		
		<footer id="main_footer">
		<h3>졸업작품</h3>
		<address>김진혁, 강홍구, 신유철</address>
		</footer>
</body>
</html>
