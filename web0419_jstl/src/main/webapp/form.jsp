<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
	
	<form action = "form_jstl.jsp">
		ID : <input type="text" name="id"><br>
		Color : <select name="color">
			<option value="yellow">노랑
			<option value="blue">파랑
			<option value="orange">오렌지
			<option value="pink">분홍
		</select>
		<input type="submit" value="보내기">
	</form>
	
</body>
</html>