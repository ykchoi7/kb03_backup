<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<a href="member_list.do">회원 목록</a> <br>
	
	<form action="member_update.do" method="post">
		아이디 : <input type="text" name=id"><br>
		비밀번호 : <input type="text" name="pwd"><br>
		이름 : <input type="text" name="name"><br>
		자기소개 : <br>
		<textarea rows="5" cols="65" name="intro"></textarea>
		<br>
		<input type="submit" value="저장하기">
	</form>
	
	<a href="member_delete.do?id=${mem.id}" onclick="return confirm('정말 삭제하시겠습니까?');}">삭제하기</a>
	

</body>
</html>