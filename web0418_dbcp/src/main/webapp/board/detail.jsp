<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
</head>
<body>
	<h1>게시물 상세보기</h1>
	<a href = "board_list.do">게시물 목록</a> <br>
	<table>
		<tr>
			<th>번호</th><td>${bto.no}</td>
		</tr>
		<tr>
			<th>제목</th><td>${bto.title}</td>
		</tr>
		<tr>
			<th>작성자</th><td>${bto.writer_id}</td>
		</tr>
		<tr>
			<th>내용</th><td>${bto.content}</td>
		</tr>
		<tr>
			<th>날짜</th><td>${bto.date}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre>${bto.content}</pre></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="50">${bto.content}</textarea></td>
		</tr>
	</table>
	<a href="board_update.do?no=${bto.no}">글수정</a>
	<!-- 수정을 하려면 board_detail과 board_update를 합쳐야한다 -->
	<a href="board_delete.do?no=${bto.no}">글삭제</a>
	
</body>
</html>