<!--
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
-->
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

<script language="javascript">
			 function Category(value, text) {
			  this.value = value;
			  this.text = text;
			  this.length = 0;
			 }
			
			 function addCategory(category, value, text) {
			  category[category.length] = new Category(value, text);
			  category.length++;
			 }
			
			 var category = new Category();
			 
			 addCategory(category,"cat1", "관광지");
			  addCategory(category[0], "1", "1");
			  addCategory(category[0], "2", "2");
			 
			 addCategory(category, "cat2", "맛집");
			  addCategory(category[1], "3", "3");
			  addCategory(category[1], "4", "4");
			 
			 addCategory(category, "cat3", "숙박");
			  addCategory(category[2], "5", "5");
			  addCategory(category[2], "6", "6");
			  addCategory(category[2], "7", "7");
			  addCategory(category[2], "8", "8");
			
			
			 function initForm(form) {
			  form.subject.length = category.length;
			
			  for (i = 0; i < category.length; i++){
			   form.subject[i].value = category[i].value;
			   form.subject[i].text = category[i].text;
			   form.subject.selectedIndex = 0;
			   form.contents.selectedIndex = 0;
			  }
			  
			  change_subject(form);
			 }
			 
			 function change_subject(form) {
			  var i = form.subject.selectedIndex;
			  form.contents.length = category[i].length;
			  
			  for (j = 0; j < form.contents.length; j++){
			   form.contents[j].value = category[i][j].value;
			   form.contents[j].text = category[i][j].text;
			   form.contents.selectedIndex = 0;
			  }
			  change_contents(form);
			 }
			 
			 function change_contents(form) {
			  var i = form.subject.selectedIndex
			  var j = form.contents.selectedIndex;
			  
			  form.components.length = category[i][j].length;
			  
			  for (k = 0; k < form.components.length; k++){
			   form.components[k].value = category[i][j][k].value;
			   form.components[k].text = category[i][j][k].text;
			   form.components.selectedIndex = 0;
			  }
			 }
	</script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimun-scale=1.0, user-scalable=no" />

<!-- 초기화 -->
</style>
<!-- 헤더 -->
<style>
#logo {
	margin-top: 10px;
	margin-bottom: 2px;
}

#main_header {
	/* 배경 지정 */
	height: 45px;
	/*             background: url('header_background.png'); */
	background: #0D3FA5;
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
	background: url('img/map_mb.png');
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
	background: rgba(54, 54, 54, 0.83);
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
	background: #3163C9;
	margin-top: 12px;
}

#top_gnb>div {
	/* 수평 정렬 */
	float: left;
	width: 32%;
	/* 크기 및 색상, 정렬 */
	height: 35px;
	line-height: 35px;
	text-align: center;
	color: white;
}

#top_gnb>#left {
	/* 수평 정렬 */
	float: left;
	width: 32%;
	/* 크기 및 색상, 정렬 */
	height: 35px;
	line-height: 35px;
	margin-left: 2%;
	text-align: left;
	color: white;
}

#top_gnb>#right {
	/* 수평 정렬 */
	float: left;
	width: 32%;
	/* 크기 및 색상, 정렬 */
	height: 35px;
	line-height: 35px;
	text-align: right;
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
	text-align: left;
	background: white;
	font-weight: bold;
	/* 	        margin: 20px; */
}

#main_section>option {
	text-align: center;
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
	position: absolute;
	position: fixed; /* 다른 객체와 충돌이 없어야 합니다. */
	top: 0; /* 메뉴 박스를 상단에 고정합니다. */
	height: 100%; /* 스마트폰에서 세로로 꽉찬 메뉴를 만듭니다. (당연히 PC에서도...) */
	background-color: silver; /* 배경색은 맘에 드시는 걸로...*/
	overflow-x: hidden; /* 메뉴 밖으로 삐져 나오는 애들은 과감하게 잘라냅니다. */
	z-index: 999999; /* 레이어 위치값은 적당히 쎄게(어렵죠 *.*a) */
}

.sidemenu-left {
	left: 0;
} /* 단순 배치용입니다. 상단은 고정 상태이고 왼쪽에 배치할지?*/
.sidemenu-right {
	right: 0;
} /* 오른쪽에 배치할지 */
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
</head>
<body onLoad="initForm(document.form)">
	<input id="toggle" type="checkbox" />
	<div id="wrap">
		<header id="main_header"> <a class="left" href="#"
			data-target="#leftMenu">Main</a>
		<div id="leftMenu" class="sidemenu sidemenu-left"
			style="padding: 10px; width: 200px;">
			<button class="btn btn-primary btn-sidemenu">감추기</button>
			<p></p>
			<div class="list-group">
				<%!String id;%>
				<%
				id = (String) session.getAttribute("login");
			%>
				<%
								if (id == null || id.equals("")) {
			%>
				<a href="join.do" class="list-group-item active">회원가입</a>
				<%}else{ %>
				<a href="memberInfo.do" class="list-group-item active">회원정보</a>
				<%} %>
				<a href="login.do" class="list-group-item">로그인</a> <a
					href="write.do" class="list-group-item">글작성</a> <a
					href="recommend.do" class="list-group-item">추천 </a>

			</div>
		</div>

		<img id='logo' src='img/logo.png' /> <nav id="top_gnb">
		<div id="left"></div>
		<div id="middle" style="font-size: 25px">글쓰기</div>
		<div id="right"></div>
		</nav>
	</div>

	<section id="main_section">

	<div class="container" style="margin: 20px">
		<br>
		<br>

		<form name="writeform" action="write.do">
			1차 카테고리 선택 <select name="subject" class="form-control"
				onchange="change_subject(this.form)">
			</select> <br> 2차 아이템 선택 <select name="contents" class="form-control"
				onchange="change_contents(this.form)">
			</select>
		
		<hr>
		<textarea name="textarea" class="form-control" rows="10%"
			placeholder="글을 작성하세요"></textarea>
		<hr>
		<input type="file">
		<button type="submit" class="btn btn-success" style="float: right">등록</button>
		</form>
	</div>
	</section>

	<footer id="main_footer">
	<h3>졸업작품</h3>
	<address>김진혁, 강홍구, 신유철</address>
	</footer>
</body>
</html>
