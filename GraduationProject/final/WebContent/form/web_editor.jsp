<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- Summer Note -->
<!-- include libries(jQuery, bootstrap, fontawesome) -->
<script src="//code.jquery.com/jquery-1.9.1.min.js"></script>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">

<!-- include summernote css/js-->
<link href="dist/summernote.css" rel="stylesheet">
<script src="dist/summernote.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<script>
		$(document).ready(function() {
			$('#summernote').summernote();
		});

		$('.summernote').summernote({
			height : 100, // set editor height

			minHeight : 300, // set minimum height of editor
			maxHeight : 300, // set maximum height of editor

			focus : true, // set focus to editable area after initializing summernote
		});
	</script>

	<textarea id="summernote" name="maketext" ></textarea>
</body>
</html>