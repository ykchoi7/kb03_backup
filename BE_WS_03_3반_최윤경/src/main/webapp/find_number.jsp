<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자맞추기</title>
</head>
<body>
	
	<h1>숫자맞추기</h1>
	<p>1~100 사이 숫자를 맞춰 보세요</p>
	<form action="find_number.do" method="post">
	
		<input type="number" name="user_num" value="${param.user_num}" placeholder="1~100사이 숫자를 입력하세요">
		<input type="submit" value="정답확인">
	
	</form>
	<div id="result"> ${param.user_num} ${ requestScope.result } </div>
		
</body>
</html>