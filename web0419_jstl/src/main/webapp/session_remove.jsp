<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_remove.jsp</title>
</head>
<body>
	<%
		//mid 속성만 삭제. 나머지 속성은 유지중
		session.removeAttribute("mid");
	%>
</body>
</html>