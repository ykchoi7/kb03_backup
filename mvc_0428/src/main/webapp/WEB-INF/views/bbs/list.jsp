<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹게시판목록</title>
</head>
<body>

	<h1>웹게시판 목록</h1>
	게시물갯수 = ${bbs_list.size()}

	<table>
	  <tr>
	    <th>번호</th>
	    <th>제목</th>
	    <th>작성자</th>
	    <th>작성일</th>
	  </tr>
	  <c:forEach items="${bbs_list}" var="bbs">
	  <tr>
	  	<td>${bbs.no}</td>
	  	<td>${bbs.title}</td>
	  	<td>${bbs.writer_id}</td>
	  	<td>${bbs.regdate}</td>
	  </tr>
	  </c:forEach>
	</table>

</body>
</html>