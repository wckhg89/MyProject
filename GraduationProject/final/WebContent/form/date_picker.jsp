<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- DatePicker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>

<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					showMonthAfterYear : true,
					minDate : '-0d',
					yearSuffix : '��',
					monthNames : [ '1��', '2��', '3��', '4��', '5��', '6��', '7��',
							'8��', '9��', '10��', '11��', '12��' ],
					dayNamesMin : [ '��', '��', 'ȭ', '��', '��', '��', '��' ],

					onSelect : function(dateText, datePicker) {
						var mm = (datePicker.selectedMonth + 1);
						var dd = datePicker.selectedDay;

						if (mm < 10)
							mm = "0" + mm;
						if (dd < 10)
							dd = "0" + dd;

						$("#currentDate").val(
								datePicker.selectedYear + "/" + mm + "/" + dd);

						$("#currentDate").css({
							"background-color" : "#3b5998",
							"color" : "white"
						});

						$("#date").val(
								datePicker.selectedYear + "�� " + mm + "�� " + dd
										+ "�Ͽ�");
					}
				});
	});

	$('img').bind('mouseenter mouseleave', function() {
		$(this).attr({
			src : $(this).attr('data-other-src'),
			'data-other-src' : $(this).attr('src')
		})
	});
</script>

<table id="meeting_date">
						<tr>
							<td>
								<div id="datepicker"></div> <br> <input type="text"
								id="currentDate" name="currentDate"
								placeholder="�޷¿��� ��¥�� �������ּ���!" size="42px"
								style="text-align: center">
							</td>
						</tr>
					</table>
</body>
</html>