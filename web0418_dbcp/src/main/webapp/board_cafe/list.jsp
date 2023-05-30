<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
	
	<a href="board_insert.cafe">게시물 등록</a>
	<br>
	<h3>갯수: ${board_list.size()}</h3>
	<table>
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
		</tr>
		
		<c:forEach items="${board_list}" var="brd">
		<tr>
			<td>${brd.no}</td>
			<td><a href="board_detail.cafe?no=${brd.no}">${brd.title}</a></td>
			<td>${brd.writer_id}</td>
			<td>${brd.date}</td>		
		</tr>
		</c:forEach>
	</table>
	
	<br>
	<a href="logout.cafe">로그아웃</a>
	
</body>
</html>