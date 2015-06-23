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
#owl-demo_e .item {
	margin: 5px;
	background : white;
}

#owl-demo_e .item img {
	display: block;
	width: 230px;
	/* width:225 */
	height: 200px;
}
</style>
<script LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
		$(document).ready(function() {

			$("#owl-demo_e").owlCarousel({

				autoPlay : 3000, //Set AutoPlay to 3 seconds

				items : 4,
				itemsDesktop : [ 1199, 3 ],
				itemsDesktopSmall : [ 979, 3 ]

			});

		});
	</script>
</head>
<body>
	<div id="owl-demo_e">
		<c:forEach items="${e_list}" var="e" begin="0" end="7">
			<div class="item">
				<h3>${e.e_title }</h3>
				<font>
					장소 : ${e.e_location2 }<br>
					계절 : ${e.e_session }<br>
					작성일 : ${e.e_date }<br>
				</font>
				<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
				<img src="files${e.e_img }" alt="Owl Image">
				</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>