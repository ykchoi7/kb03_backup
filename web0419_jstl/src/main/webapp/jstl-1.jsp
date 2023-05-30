<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl-1</title>
</head>
<body>
<c:set var="str3" value="aaa" scope="request" />

	<c:if test="${requestScope.msg != null}"> <!-- 값이 존재하는지 여부 확인 -->
	Message : ${msg}
	</c:if>
	<c:if test="${msg2 == null}"> <!-- 등록되어있는지 비교 -->
	Message : 없음
	</c:if>
	<hr>
	<c:forEach items="${sa}" var="s">
	[${s}] <br>
	</c:forEach>
	
	<!-- items가 없으면 숫자로만 표현해도 되고, items가 있으면 사용 -->
	<%-- 일반 html주석을 달면 페이지 소스에는 모두 노출되고, jsp주석을 달아야 페이지 소스에서 안 보임
	<h3>구구단 3단</h3>
	<c:set var="dan" value="3"></c:set>
	<c:forEach begin="1" end="9" var="i">
	${dan} * ${i} = ${dan * i} <br>
	</c:forEach>
	--%>
	
	<hr>
	<c:forEach items="${dtos}" var="dto">
	<!-- 하나씩 뽑아서 var에 저장 -->
	MID: ${dto.mid} <br>
	</c:forEach>

<%
	//pageContext, requestContext, sessionContext, applicationContext에 값 저장
	//위에 <c:set> 사용했으면 아래 코드는 안 써도 된다 같은 의미, 다른 표현 방식일 뿐 
	//request.setAttribute("str3", "aaa");
%>

</body>
</html>