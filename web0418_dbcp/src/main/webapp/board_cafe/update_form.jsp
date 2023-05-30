<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 게시물 수정</title>
</head>
<body>
	<a href="board_list.do">게시물 목록</a> <br>
	
	<form action="board_update.do" method="post">
		<input type="hidden" name="no" value="${bto.no}">
		게시물 제목: <input type="text" name="title" value="${bto.title}"><br>
		게시물 작성자: <input type="text" name="writer_id" value="${bto.writer_id}"><br>
		게시물 내용: <br>
		<textarea rows="5" cols="65" name="content" value="${bto.content}"></textarea>
		<br>
		<input type="submit" value="수정하기">
	</form>

</body>
</html>