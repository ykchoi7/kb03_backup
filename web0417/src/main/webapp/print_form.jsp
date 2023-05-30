<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="mydto" class="web0417.dto.SimpleDto" scope="request"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	mid : <jsp:getProperty property="mid" name="mydto"/>
	<br>
	singer: <jsp:getProperty property="singer" name="mydto"/>

</body>
</html>