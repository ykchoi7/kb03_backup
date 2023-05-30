<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form_jstl.jsp</title>
</head>
<body>
	
	<c:if test="${param.id != null}"> <!-- 어떤 값이 저장되어 있는데, null인지 아닌지 확인 -->
		<b> ${param.id} </b>
	</c:if>
	<c:if test="${param.id == ''}"> <!-- id에 입력 자체가 안된 경우 공백 -->
		<b> Guest </b>
	</c:if>
	<hr>
	<c:choose> <!-- choose -> when/otherwise 두 개가 있음 -->
		<c:when test="${param.color == 'blue'}"> <!-- 이게 참이면 중간에 나오는 코드가 실행되어 출력 -->
			Color: 파랑
		</c:when>
		<c:when test="${param.color == 'yellow'}"> 
			Color: 노랑
		</c:when>
		<c:when test="${param.color == 'orange'}">
			Color: 오렌지
		</c:when>
		<c:when test="${param.color == 'pink'}">
			Color: 분홍
		</c:when>
		<c:otherwise>
			Color: 알수없음
		</c:otherwise>
	</c:choose>

</body>
</html>