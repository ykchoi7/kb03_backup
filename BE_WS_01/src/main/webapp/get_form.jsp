<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="mydto" class="BE_WS_01.dto.SimpleDto" scope="request"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	job : <jsp:getProperty property="job" name="mydto"/>
	<br>
	pageNo: <jsp:getProperty property="pageNo" name="mydto"/>
	<br>
	searchWord: <jsp:getProperty property="searchWord" name="mydto"/>

</body>
</html>