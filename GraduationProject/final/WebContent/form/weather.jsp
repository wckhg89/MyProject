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
		Ajax ���� �Ѿ�� �Ķ���ʹ� �������� �Ǿ��ִ�.
		��ġ�� ���û �����͸� �Ľ��� ��� �̴� �ѱ۷� �������� ǥ�õǾ��ִ�.
		�Ķ���� ��ü�� �ѱ۷� �ѱ� ��� �ѱ��� ������ ������ �Ͼ�� ������,
		���� �������� ���� ������ ���ؼ� ���ϴ� ���� ������ �̾ƿ��� ���ؼ�
		���� �������� �ѱ� ���������� �ٲپ� �ִ� �۾��� �����Ѵ�.	
	 -->
	<c:if test="${param.area =='seoul'}">
		<c:set var='area' value='����' />

	</c:if>
	<c:if test="${param.area =='inchon'}">
		<c:set var='area' value='��õ' />

	</c:if>
	<c:if test="${param.area =='suwon'}">
		<c:set var='area' value='����' />

	</c:if>
	<c:if test="${param.area =='paju'}">
		<c:set var='area' value='����	' />

	</c:if>

	<!-- 
		�Ľ��� ���û ���� �����ʹ� ������ ���� �����͸� �Ľ��ؿ´�.
		����, ���ϴ� ������ ������ �����ֱ� ���ؼ� ���ǹ��� ���ؼ�
		�ش� ������ ������ �����ش�.
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
					<td align='center'><c:if test="${'��������' == wd.wf }">
							<img align="middle" src='img/w_cloud_mx.jpg'>
						</c:if> <c:if test="${'��������' == wd.wf }">
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