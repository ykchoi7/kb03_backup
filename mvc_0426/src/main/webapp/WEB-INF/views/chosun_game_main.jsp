<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chosun_game_main.jsp</title>
</head>
<body>
	<h1>자바 초성 게임</h1>
	<a href="chosun_game">게임 다시 시작</a>
	<br>
	<form action="" method="post">
		<b>힌트초성: ${chosun}</b> 
		<br>
		<input type="text" name="input" size="10">
		<input type="submit" value="정답확인">
	</form>	
	<div>${result}</div>
</body>
</html>