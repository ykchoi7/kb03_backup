<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>간단 계산기</h1>
	<form action="mini_calc.do" method="post">
	
		<input type="number" name="n1" value="${param.n1}">
		<br>
		<input type="radio" name = "opr" value="+" ${param.opr=="+"?"checked":""}> + <!--checked 속성-->
		<input type="radio" name = "opr" value="-" ${param.opr=="-"?"checked":""}> -
		<input type="radio" name = "opr" value="*" ${param.opr=="*"?"checked":""}> *
		<input type="radio" name = "opr" value="/" ${param.opr=="/"?"checked":""}> /
		<input type="radio" name = "opr" value="%" ${param.opr=="%"?"checked":""}> %
		<br>
		<input type="number" name="n2" value="${param.n2}">
		<br>
		<input type="submit" value="계 산 하 기">
	
	</form>
	<!-- 기본형식 / 값이 없으면 null로 출력 -->
	<div id="result"> <%= request.getAttribute("result") %> </div>
	<!-- 짧게 줄인 형식 (EL) -> 자바로 해석 실행 / 값이 없으면 null대신 공백으로 출력 -->
	<div id="result"> ${param.n1} ${param["opr"]} ${param.n2} ${ result } </div>
	
	<!-- 서블릿의 "result" 속성을 가져오기 -->
	
</body>
</html>