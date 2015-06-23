<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="ko-KR">
<head>
<title>UI Laboratory</title>
<meta charset="utf-8" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- Important Owl stylesheet -->
<link rel="stylesheet" href="owl-carousel/owl.carousel.css">
 
<!-- Default Theme -->
<link rel="stylesheet" href="owl-carousel/owl.theme.css">
 
<!--  jQuery 1.7+  -->
<script src="jquery-1.9.1.min.js"></script>
 
<!-- Include js plugin -->
<script src="assets/owl-carousel/owl.carousel.js"></script>
<style type="text/css">
#owl-demo_s .item {
	margin: 5px;
	background : white;
}

#owl-demo_s .item img {
	display: block;
	width: 230px;
	/* width:225 */
	height: 200px;
}
</style>
<script LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
		$(document).ready(function() {

			$("#owl-demo_s").owlCarousel({

				autoPlay : 3500, //Set AutoPlay to 3 seconds

				items : 4,
				itemsDesktop : [ 1199, 3 ],
				itemsDesktopSmall : [ 979, 3 ]

			});

		});
	</script>
</head>
<body>
	<div id="owl-demo_s">
		<c:forEach items="${s_list}" var="s" begin="0" end="7">			
			<div class="item">
			<h3>${s.s_title }</h3>
				<font>
					장소 : ${s.s_location2 }<br>
					계절 : ${s.s_session }<br>
					작성일 : ${s.s_date }<br>
				</font>
				<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
				<img src="files${s.s_img }" alt="Owl Image">
				</a>
			</div>
		</c:forEach>
		

	</div>
	
	

</body>
</html>