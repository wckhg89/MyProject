<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<SCRIPT LANGUAGE="JavaScript">

//이미지 순서대로

var rollCnt=0;
function rollImage()
{
  var roll= document.all("rolID");

  if(roll==undefined || roll==null){
   return;
  }
  if(roll.length==undefined)
  {
   roll.style.display = "block";  
   return;
  }
  
  for(var i = 0 ; i < roll.length ; i++)
  {   
   if(i == rollCnt) {
    roll[i].style.display = "block";  
    continue ;
   }  
   roll[i].style.display = "none"; 
 
  }

  rollCnt++;
  
  if(rollCnt==roll.length){
   rollCnt=0;
  }
   // 시간 간격 주기 (1초)
  setTimeout('rollImage()','1000');
}



</SCRIPT>
</head>
<body>
<img id="rolID" src="../img/play_sns.png"/>

<img id="rolID" src="../img/eat_sns.png"/>

<img id="rolID" src="../img/sleep_sns.png"/>

<img id="rolID" src="../img/play.png"/>

 
</body>
</html>

