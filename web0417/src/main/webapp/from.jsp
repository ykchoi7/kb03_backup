<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>From</h1>
	
	<jsp:forward page="hello.jsp"></jsp:forward>
	<!-- hello.jsp의 페이지가 출력되지만 링크는 여전히 from.jsp url을 사용 
		 from.jsp의 코드는 아예 날라감 -->
</body>
</html>