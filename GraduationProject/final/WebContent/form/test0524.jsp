<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="//code.jquery.com/jquery.js"></script>
<style type="text/css">
div.ilsb-child { /* �ڿ��� */
	position: absolute;
	display: none;
	padding: 10px;
	border: 1px solid #b5b2b5;
	background-color: #efefef; /* ��׶���� �ݵ�� ����� */
	margin-left: -2px; /* �Ը��� �°� ���� */
	margin-top: -2px; /* �Ը��� �°� ���� */
	line-height: 1.4;
	white-space: nowrap; /* IE ���� */
}
#submenu { /* �ڿ��� */
	position: absolute;
	display: none;
	padding: 10px;
	border: 1px solid #b5b2b5;
	background-color: #efefef; /* ��׶���� �ݵ�� ����� */
	margin-left: -2px; /* �Ը��� �°� ���� */
	margin-top: -2px; /* �Ը��� �°� ���� */
	line-height: 1.4;
	white-space: nowrap; /* IE ���� */
}

/* �⺻ css */
/* body,td,input,textarea,select {font-size:12px; font-family:����; color:#404040;}
dl{margin:0;}
a:link    {color:#424542; text-decoration:none;}
a:visited {color:#424542; text-decoration:none;}
a:active  {color:#424542; text-decoration:none;}
a:hover   {color:#295584; text-decoration:underline;} */

/* �߰� css */
.r, a.r:link, a.r:visited, a.r:hover, a.r:active {
	color: #FF3600
} /*red*/
.b, a.b:link, a.b:visited, a.b:hover, a.b:active {
	font-weight: bold
} /*Bold*/
</style>


<script type="text/JavaScript">
<!--
function getElementsByClass(searchClass,tag,node){ // ��Ű�� ����
	var classElements = new Array();
	if(!node) node = document;
	if(!tag) tag = '*';
	var els = node.getElementsByTagName(tag);
	var elsLen = els.length;
	var pattern = new RegExp("(^|\\s)"+searchClass+"(\\s|$)");
	for(var i=0; i<elsLen; i++){
		if(pattern.test(els[i].className)) classElements[classElements.length] = els[i];
	}
	return classElements;
}

function set_ilsb(){ // �ڿ���
	var d = getElementsByClass("ilsb-parent","div");
	for(var i=0; i<d.length; i++){
		var c = getElementsByClass("ilsb-child","div",d[i]);
		if(c[0]){
			d[i].cMenu = c[0]; // ������ ������ ���ϰ� �ϱ� ���� ��ü�� ����
			d[i].onmouseover = new Function("this.cMenu.style.display='block'");
			d[i].onmouseout = new Function("this.cMenu.style.display='none'");
		}
	}
}
</script>
</head>
<body onload="set_ilsb()">
	<h3>
		<span class="r b"><a href='#'><img src="../img/idicon.png" /></a>
			��ȫ��</span>
	</h3>
	<%-- "memberDetail.do?m_id=${m.m_id }" --%>

	<h3 style="color: blue;">������ Ǯ�ٿ� �޴� �����</h3>
	<hr>
	<p>
		<!-- <span class="r b">�ƽþ�</span>, <span class="r b">����</span>, <span
			class="r b">�Ƹ޸�ī</span> ���콺�� �÷����ϴ�. -->
	</p>
	<script>
		var visible = false;
		function aaa(){
			var sbm = document.getElementById('submenu');
			
			if(visible == false){
				visible= true;
				sbm.style.display='block';
			}else if(visible == true){
				visible = false;
				sbm.style.display='none';
			}
			
			
		}
	</script>


		<!-- �ڿ�� -->
		<div>
			<a href='#' onclick="aaa()"><img src="../img/idicon.png" /></a> ��ȫ��
		</div>
		<div id="submenu">
			<div>
				<a href="#">ȸ������</a>
			</div>
			<div>
				<a href="#">����������</a>
			</div>
			<div>
				<a href="#">�ȷο��ϱ�</a>
			</div>
			<div>
				<a href="#">1:1ä��</a>
			</div>
		</div>



	<p>Hello,World</p>
	<p>Hello,World</p>
	<p>Hello,World</p>
</body>
</html>