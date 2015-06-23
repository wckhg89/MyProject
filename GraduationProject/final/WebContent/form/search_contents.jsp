<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
.font_size{
	font-size: small;
}

</style>
</head>
<body>


<c:if test="${param.category =='play'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${p_list}" var="p">
		<tr>
			<td width='220'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
			<img class="picture" src="files${p.p_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
				<p>작성일 : ${p.p_date}</p>
				<p>작성자 : ${p.p_m_id }</p> <br>
				<p>제  목 : ${p.p_title}</p> <br>
				<p>위  치 : ${p.p_location2}</p>
				<p>가격정보 : ${p.p_price}만원대</p>
				<p>추천계절 : ${p.p_session}</p>
				<p>실내외여부 : ${p.p_inout}</p><br>
				<p>추천수 : ${p.p_l_count}  /  댓글수 : ${p.p_r_count}</p>
			</a>
			</td>
			
		</tr>
	</c:forEach>
		</table>
</c:if>
<c:if test="${param.category =='eat'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${e_list}" var="e">
		<tr>
			<td width='220'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
			<img class="picture" src="files${e.e_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
				<p>작성일 : ${e.e_date}</p>
				<p>작성자 : ${e.e_m_id }</p> <br>
				<p>제  목 : ${e.e_title}</p> <br>
				<p>위  치 : ${e.e_location2}</p>
				<p>가격정보 : ${e.e_price}만원대</p>
				<p>추천계절 : ${e.e_session}</p>
				<p>실내외여부 : ${e.e_inout}</p>
				<br><p>추천수 : ${e.e_l_count}  /  댓글수 : ${e.e_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${param.category =='sleep'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${s_list}" var="s">
		<tr>
			<td width='220'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
			<img class="picture" src="files${s.s_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
				<p>작성일 : ${s.s_date}</p>
				<p>작성자 : ${s.s_m_id }</p> <br>
				<p>제  목 : ${s.s_title}</p> <br>
				<p>위  치 : ${s.s_location2}</p>
				<p>가격정보 : ${s.s_price}만원대</p>
				<p>추천계절 : ${s.s_session}</p>
				<p>실내외여부 : ${s.s_inout}</p>
				<br><p>추천수 : ${s.s_l_count}  /  댓글수 : ${s.s_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${param.category =='new_play'}">
	<c:forEach items="${p_list}" var="p">
	<table border='1' bordercolor="#b5b2b5">
		<tr>
			<td width='220'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
			<img class="picture" src="files${p.p_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
				<p>작성일 : ${p.p_date}</p>
				<p>작성자 : ${p.p_m_id }</p> <br>
				<p>제  목 : ${p.p_title}</p> <br>
				<p>위  치 : ${p.p_location2}</p>
				<p>가격정보 : ${p.p_price}만원대</p>
				<p>추천계절 : ${p.p_session}</p>
				<p>실내외여부 : ${p.p_inout}</p><br>
				<p>추천수 : ${p.p_l_count}  /  댓글수 : ${p.p_r_count}</p>
			</a>
			</td>
			
		</tr>
	</table>
	</c:forEach>
</c:if>
<c:if test="${param.category =='new_eat'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${e_list}" var="e">
		<tr>
			<td width='220'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
			<img class="picture" src="files${e.e_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
				<p>작성일 : ${e.e_date}</p>
				<p>작성자 : ${e.e_m_id }</p> <br>
				<p>제  목 : ${e.e_title}</p> <br>
				<p>위  치 : ${e.e_location2}</p>
				<p>가격정보 : ${e.e_price}만원대</p>
				<p>추천계절 : ${e.e_session}</p>
				<p>실내외여부 : ${e.e_inout}</p>
				<br><p>추천수 : ${e.e_l_count}  /  댓글수 : ${e.e_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${param.category =='new_sleep'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${s_list}" var="s">
		<tr>
			<td width='220'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
			<img class="picture" src="files${s.s_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
				<p>작성일 : ${s.s_date}</p>
				<p>작성자 : ${s.s_m_id }</p> <br>
				<p>제  목 : ${s.s_title}</p> <br>
				<p>위  치 : ${s.s_location2}</p>
				<p>가격정보 : ${s.s_price}만원대</p>
				<p>추천계절 : ${s.s_session}</p>
				<p>실내외여부 : ${s.s_inout}</p>
				<br><p>추천수 : ${s.s_l_count}  /  댓글수 : ${s.s_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${param.category =='like_play'}">
	<c:forEach items="${p_list}" var="p">
	<table border='1' bordercolor="#b5b2b5">
		<tr>
			<td width='220'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
			<img class="picture" src="files${p.p_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
				<p>작성일 : ${p.p_date}</p>
				<p>작성자 : ${p.p_m_id }</p> <br>
				<p>제  목 : ${p.p_title}</p> <br>
				<p>위  치 : ${p.p_location2}</p>
				<p>가격정보 : ${p.p_price}만원대</p>
				<p>추천계절 : ${p.p_session}</p>
				<p>실내외여부 : ${p.p_inout}</p><br>
				<p>추천수 : ${p.p_l_count}  /  댓글수 : ${p.p_r_count}</p>
			</a>
			</td>
			
		</tr>
		</tr>
	</table>
	</c:forEach>
</c:if>
<c:if test="${param.category =='like_eat'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${e_list}" var="e">
		<tr>
			<td width='220'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
			<img class="picture" src="files${e.e_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
				<p>작성일 : ${e.e_date}</p>
				<p>작성자 : ${e.e_m_id }</p> <br>
				<p>제  목 : ${e.e_title}</p> <br>
				<p>위  치 : ${e.e_location2}</p>
				<p>가격정보 : ${e.e_price}만원대</p>
				<p>추천계절 : ${e.e_session}</p>
				<p>실내외여부 : ${e.e_inout}</p>
				<br><p>추천수 : ${e.e_l_count}  /  댓글수 : ${e.e_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${param.category =='like_sleep'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${s_list}" var="s">
		<tr>
			<td width='220'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
			<img class="picture" src="files${s.s_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
				<p>작성일 : ${s.s_date}</p>
				<p>작성자 : ${s.s_m_id }</p> <br>
				<p>제  목 : ${s.s_title}</p> <br>
				<p>위  치 : ${s.s_location2}</p>
				<p>가격정보 : ${s.s_price}만원대</p>
				<p>추천계절 : ${s.s_session}</p>
				<p>실내외여부 : ${s.s_inout}</p>
				<br><p>추천수 : ${s.s_l_count}  /  댓글수 : ${s.s_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${param.ctg =='date_play'}">
	<c:forEach items="${p_list}" var="p">
	<table border='1' bordercolor="#b5b2b5">
		<tr>
			<td width='220'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
			<img class="picture" src="files${p.p_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="play_detail.do?p_num=${p.p_num}&p_m_id=${p.p_m_id}">
				<p>작성일 : ${p.p_date}</p>
				<p>작성자 : ${p.p_m_id }</p> <br>
				<p>제  목 : ${p.p_title}</p> <br>
				<p>위  치 : ${p.p_location2}</p>
				<p>가격정보 : ${p.p_price}만원대</p>
				<p>추천계절 : ${p.p_session}</p>
				<p>실내외여부 : ${p.p_inout}</p><br>
				<p>추천수 : ${p.p_l_count}  /  댓글수 : ${p.p_r_count}</p>
			</a>
			</td>
			
		</tr>
	</table>
	</c:forEach>
</c:if>
<c:if test="${param.ctg =='date_eat'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${e_list}" var="e">
		<tr>
			<td width='220'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
			<img class="picture" src="files${e.e_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="eat_detail.do?e_num=${e.e_num}&e_m_id=${e.e_m_id}">
				<p>작성일 : ${e.e_date}</p>
				<p>작성자 : ${e.e_m_id }</p> <br>
				<p>제  목 : ${e.e_title}</p> <br>
				<p>위  치 : ${e.e_location2}</p>
				<p>가격정보 : ${e.e_price}만원대</p>
				<p>추천계절 : ${e.e_session}</p>
				<p>실내외여부 : ${e.e_inout}</p>
				<br><p>추천수 : ${e.e_l_count}  /  댓글수 : ${e.e_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${param.ctg =='date_sleep'}">
	<table border='1' bordercolor="#b5b2b5">
	<c:forEach items="${s_list}" var="s">
		<tr>
			<td width='220'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
			<img class="picture" src="files${s.s_img }">
			</a>
			</td>
			<td width='440' class='font_size'>
			<a href="sleep_detail.do?s_num=${s.s_num}&s_m_id=${s.s_m_id}">
				<p>작성일 : ${s.s_date}</p>
				<p>작성자 : ${s.s_m_id }</p> <br>
				<p>제  목 : ${s.s_title}</p> <br>
				<p>위  치 : ${s.s_location2}</p>
				<p>가격정보 : ${s.s_price}만원대</p>
				<p>추천계절 : ${s.s_session}</p>
				<p>실내외여부 : ${s.s_inout}</p>
				<br><p>추천수 : ${s.s_l_count}  /  댓글수 : ${s.s_r_count}</p>
			</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>