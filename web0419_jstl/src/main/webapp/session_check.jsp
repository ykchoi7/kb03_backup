<%@ page language="java" contentType="text/html; charset=UTF-8"
session="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_check.jsp</title>
</head>
<body>
<%
	//모두 서버에서 실행되는 코드
	Object o = session.getAttribute("mid");
	out.println("mid="+o); //response.getWriter() 라는 것이 out이라는 것에 함축되어있음
%>
<hr>
<!-- <% %> 안에 있는 두 줄은 아래 한 줄로 표현한 것(같은 의미) / 값이 없으면 null 대신 공백을 띄우기-->
mid=${sessionScope.mid}
<br>
pwd=${sessionScope.pwd}
</body>
</html>