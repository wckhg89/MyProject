<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		Ajax 에서 넘어온 파라미터는 영문으로 되어있다.
		그치만 기상청 데이터를 파싱할 경우 이는 한글로 지역명이 표시되어있다.
		파라미터 자체를 한글로 넘길 경우 한글이 깨지는 현상이 일어나기 때문에,
		수고 스럽지만 날씨 지역을 비교해서 원하는 지역 날씨를 뽑아오기 위해서
		영문 지역명을 한글 지역명으로 바꾸어 주는 작업을 수행한다.	
	 -->
	<c:if test="${param.area =='seoul'}">
		<c:set var='area' value='서울' />

	</c:if>
	<c:if test="${param.area =='inchon'}">
		<c:set var='area' value='인천' />

	</c:if>
	<c:if test="${param.area =='suwon'}">
		<c:set var='area' value='수원' />

	</c:if>
	<c:if test="${param.area =='paju'}">
		<c:set var='area' value='파주	' />

	</c:if>

	<!-- 
		파싱한 기상청 날씨 데이터는 전국의 날씨 데이터를 파싱해온다.
		따라서, 원하는 지역의 날씨만 보여주기 위해서 조건무을 통해서
		해당 지역의 날씨만 보여준다.
	 -->
	<table bgcolor="white" bordercolor="#DDDDDD">
		<tr>
			<c:forEach items="${w_d_list}" var="wd">
				<c:if test="${area == wd.city }">
					<th><font size='1pt'>${wd.tmEf }</font></th>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${w_d_list}" var="wd">
				<c:if test="${area == wd.city }">
					<td align='center'><c:if test="${'구름많음' == wd.wf }">
							<img align="middle" src='img/w_cloud_mx.jpg'>
						</c:if> <c:if test="${'구름조금' == wd.wf }">
							<img src='img/w_cloud_mn.jpg'>
						</c:if> <br> <font size='2pt'>${wd.wf }</font></td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${w_d_list}" var="wd">
				<c:if test="${area == wd.city }">
					<td align='center'><font size='2pt' color='red'>${wd.tmx }</font>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${w_d_list}" var="wd">
				<c:if test="${area == wd.city }">
					<td align='center'><font size='2pt' color='blue'>${wd.tmn }</font>
					</td>
				</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>