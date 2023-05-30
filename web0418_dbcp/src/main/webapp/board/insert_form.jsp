<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 게시물 등록</title>
</head>
<body>

	<form action="board_insert.do" method="post">
		게시물 제목: <input type="text" name="title"><br>
		게시물 작성자: <input type="text" name="writer_id"><br>
		게시물 내용: <br>
		<textarea rows="5" cols="65" name="content"></textarea>
		<br>
		<input type="submit" value="등록하기">
	</form>

</body>
</html>