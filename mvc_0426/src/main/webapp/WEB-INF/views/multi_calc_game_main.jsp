<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>multi_calc_game_main.jsp</title>
</head>
<body>
	<h1>곱셈 게임 시작</h1>
	<a href="multi_calc_game">게임 다시 시작</a>
	<br>
	<h3>${game_seq}번 문제</h3>
	<form action="" method="post">
		<input type="number" name = "n1" value="${n1}" readonly="readonly" size="3"> 
		* 
		<input type="number" name = "n2" value="${n2}" readonly="readonly" size="3"> 
		= 
		<input type="number" name="answer" size="5"> 
		<br>
		<input type="submit" value="정답확인">
	</form>	
	<div>${result}</div>
	<div>${MultiCalcDto.answer}</div>
</body>
</html>