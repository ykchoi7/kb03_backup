<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>

	r = <%= request.getAttribute("r") %>
	<!-- hello서블릿 실행하지 않고 jsp 실행하면 r=null 출력됨 
		 hello.do 로 실행이 되어야 정상 출력됨 -->
		 
</body>
</html>