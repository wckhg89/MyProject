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
	margin: 3px;
}

#owl-demo .item img {
	display: block;
	width: 100%;
	height: auto;
}
</style>
<script LANGUAGE=JAVASCRIPT TYPE="TEXT/JAVASCRIPT">
		$(document).ready(function() {

			$("#owl-demo").owlCarousel({

				autoPlay : 3000, //Set AutoPlay to 3 seconds

				items : 4,
				itemsDesktop : [ 1199, 3 ],
				itemsDesktopSmall : [ 979, 3 ]

			});

		});
	</script>
</head>
<body>
	
	<div id="owl-demo">

		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>
		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>
		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>
		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>
		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>
		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>
		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>
		<div class="item">
			<img src="../img/play.png" alt="Owl Image">
		</div>

	</div>
	
	

</body>
</html>