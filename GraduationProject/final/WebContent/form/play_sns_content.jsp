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
#owl-demo .item {
	margin: 4px;
	background: white;
	border: 1px solid #DDDDDD;
}

#owl-demo .item img {
	  display: block;
	  margin: 5px;
	  width: 220px;
	  height: 205px;
}

</style>
<script LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
		$(document).ready(function() {

			$("#owl-demo").owlCarousel({

				autoPlay : 2000, //Set AutoPlay to 3 seconds

				items : 4,
				itemsDesktop : [ 1199, 3 ],
				itemsDesktopSmall : [ 979, 3 ]

			});

		});
	</script>
</head>
<body>
	<div id="owl-demo">
		<c:forEach items="${p_list}" var="p" begin="0" end="7">
			
			<div class="item">
				<h3>${p.p_title }</h3>
				<font>
					장소 : ${p.p_location2 }<br>
					계절 : ${p.p_session }<br>
					작성일 : ${p.p_date }<br>
				</font>
				<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
					<img src="files${p.p_img }" alt="Owl Image">
				</a>
			</div>
		</c:forEach>
	</div>
	
	

</body>
</html>