<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>

	<form action="member_insert.do" method="post">
		아이디 : <input type="text" name=id"><br>
		비밀번호 : <input type="text" name="pwd"><br>
		이름 : <input type="text" name="name"><br>
		자기소개 : <br>
		<textarea rows="5" cols="65" name="intro"></textarea>
		<br>
		<input type="submit" value="등록하기">
	</form>

</body>
</html>