<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_invalidate.jsp</title>
</head>
<body>
<%
	//세션을 새로 생성, 할당
	session.invalidate();
%>
session.invalidate();
</body>
</html>