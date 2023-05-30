<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
</head>
<body>
	<h1>회원정보 상세보기</h1>
	<a href = "member_list.do">회원 목록</a> <br>
	<table>
		<tr>
			<th>아이디</th><td>${mem.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th><td>${mem.pwd}</td>
		</tr>
		<tr>
			<th>이름</th><td>${mem.name}</td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td><textarea rows="3" cols="50">${mem.intro}</textarea></td>
		</tr>
	</table>
	<a href=member_update.do?no=${mem.no}">글수정</a>
	
</body>
</html>