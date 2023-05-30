<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<h1>로 그 인</h1>
	<form action="login.do" method="post">
	
		<label>아이디 : <input type="text" name="mid"><br></label>
		<label>비밀번호 : <input type="password" name = "pwd"><br></label>
		<input type="submit" value="로그인">
		
	</form>
	
	<div id="msg">${msg}</div>
</body>
</html>