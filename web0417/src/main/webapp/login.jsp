<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = request.getParameter("mid");
	String pwd = request.getParameter("pwd");
%>
<% //java 파트
	//mid가 xyz면 로그인 성공 -> hello.jsp 출력 / xyz 아니면 로그인 실패 -> form.jsp 출력
	if (mid.equals("xyz")) {
%>
<!-- html 파트 -->
<jsp:forward page="hello.jsp"></jsp:forward>
<%
	} else {
//		response.sendRedirect("form.jsp");
//	}   //-> form.jsp로 url이 변경됨
%>
<jsp:forward page="form.jsp"></jsp:forward>
<%
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>