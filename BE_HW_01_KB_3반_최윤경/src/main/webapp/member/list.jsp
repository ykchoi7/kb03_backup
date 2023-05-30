<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	
	<a href="member_insert.do">회원 등록</a>
	<br>
	<h3>갯수: ${member_list.size()}</h3>
	<table>
		<tr>
			<th>회원아이디</th><th>이름</th>
		</tr>
		
		<c:forEach items="${member_list}" var="mem">
		<tr>
			<td>${mem.no}</td>
			<td><a href="member_detail.do?no=${mem.no}">${mem.name}</a></td>	
		</tr>
		</c:forEach>
	</table>
		
</body>
</html>