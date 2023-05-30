<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자맞추기게임</title>
</head>
<body>
	
	<h1>숫자 맞추기 게임</h1>
	<p>1~100 사이의 숫자를 맞춰보세요</p>
	<form action="">
		<label>숫자: <input type="number" name="n1">
		</label>
		<input type="submit" value="정답확인">
	</form>
	
	<div>메시지: ${msg}</div>
	
</body>
</html>