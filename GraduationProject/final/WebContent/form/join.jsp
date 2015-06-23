<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>트레블메이트</title>

<script type="text/javascript">
  
   function goReset() {
      var form = document.getElementById("j");
      form.action = "../join.do";
      form.reset();
   }
   function idcheck() {
      var id = document.getElementById("m_id").value;
      if (id.length < 1 || id == null) {
         alert("중복체크할 아이디를 입력하십시오");
         return false;
      }
      var url = "form/idCheck.jsp?m_id=" + id;
      window.open(url, "get", "height = 216, width = 314");
   }

   //Magnific-Popup
   $(document).ready(function() {
      $('.popup-with-form').magnificPopup({
         type : 'inline',
         preloader : false,
         focus : '#name',

         // When elemened is focused, some mobile browsers in some cases zoom in
         // It looks not nice, so we disable it:
         callbacks : {
            beforeOpen : function() {
               if ($(window).width() < 700) {
                  this.st.focus = false;
               } else {
                  this.st.focus = '#name';
               }
            }
         }
      });
   });
</script>
<!-- CSS -->
<!-- 초기화 -->
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: '맑은 고딕', bold;
	font-size: 14px;
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

<!-- 콘텐츠 -->
<style>
#content {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
	background: #f1f1f1;
	padding-top: 50px;
	padding-bottom: 50px;
}
</style>
<!-- div -->
<style type="text/css">
.login {
	height: 800px;
}

table {
	width: 400px;
	height: 400px;
	cellspacing: 50px;
	cellpadding: 50px;
}

.table_content {
	background: white;
	border: 0px;
}

.table_title {
	background: #3b5998;
	color: white;
	text-align: center;
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

</head>
<body>
	<jsp:include page="navibar.jsp" />
	<hr>

	<div id="content" class="login">
		<center>

			<form id="j" name="form" enctype="multipart/form-data" method="post" action="joinProcess.do">

				<img src="img/join.png">
				<table align="center" border='1' bordercolor="#f1f1f1">
					<tr>
						<div>
							<th class="table_title"><label>아&nbsp;이&nbsp;디</label></th>
							<td class="table_content"><input type="text"
								class="form-control txt" id="m_id" name="m_id"
								placeholder=" 아이디를 입력하세요"></td>
							<td align="center" class="table_content"
								style="width: 90px; cellpadding: 0px;"><img
								src="img/idChk.png" onclick="idcheck()"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>비밀번호</label></th>
							<td class="table_content" colspan="2"><input type="password"
								id="m_pass1" name="m_pass1" class="form-control txt"
								placeholder=" 비밀번호를 입력하세요"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>비밀번호확인</label></th>
							<td class="table_content" colspan="2"><input type="password"
								id="m_pass2" name="m_pass2" class="form-control txt"
								placeholder=" 비밀번호를 입력하세요"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</label></th>
							<td class="table_content" colspan="2"><input type="text"
								class="form-control txt" id="m_name" name="m_name"
								placeholder=" ex) 홍길동"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>나&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이</label></th>
							<td class="table_content" colspan="2"><input type="text"
								class="form-control txt" name="m_age" id="m_age"
								placeholder=" ex) 25"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>연&nbsp;락&nbsp;처</label></th>
							<td class="table_content" colspan="2"><input type="text"
								class="form-control txt" name="m_phone" id="m_phone"
								placeholder=" ex) 01012347896  숫자만입력!" size="30"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>E-mail</label></th>
							<td class="table_content" colspan="2"><input type="text"
								class="form-control txt" name="m_email" id="m_email"
								placeholder=" ex) travelmate@domain.com" size="30"></td>
						</div>
					</tr>
					<tr>
						<div>
							<th class="table_title"><label>사&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;진</label></th>
							<td class="table_content" colspan="2"><input type="file"
								class="form-control txt" name="m_img" id="m_img"></td>
						</div>
					</tr>

				</table>

				<table style="height: 100px">
					<tr>
						<div class="form-group">
							<td align="left"><input type="reset"
								class="btn btn-1 btn-1a" id="reset" value="취  소" /></td>
							<td align="right"><input type="submit"
								class="btn btn-1 btn-1a" id="join" value="등  록" /></td>
						</div>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>