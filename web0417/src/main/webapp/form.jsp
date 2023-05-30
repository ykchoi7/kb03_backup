<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mydto" class="web0417.dto.SimpleDto" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="mydto" />

<jsp:forward page = "print_form.jsp"></jsp:forward>
<!-- 실제 작업은 print_form.jsp에서 하겠다는 의미 -->

<!-- 위에 두줄을 설명하는게 아래줄 -->
<%
	SimpleDto s1 = new SimpleDto();
	s1.setMid(request.getParameter("mid")); //위에 property의 이름이 setMid와 "mid" 안에 있는 것과 동일해야한다
%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	mid : <jsp:getProperty property="mid" name="mydto"/>
	<br>
	singer: <jsp:getProperty property="singer" name="mydto"/>

<% //!로 멤버변수로 지정해줌
	String a = "KIM";
	int r = new java.util.Random().nextInt(100)+1;
	//요청할 때마다 난수가 새로 생성되기 때문에 맞출 수가 없어짐
	//이런 난수의 경우 멤버변수로 설정하여 초기화될 때 한번만 생성되어야 한다
	String mid = request.getParameter("mid");
%>

	r = <%= r %>
	<br>
	mid = <%= mid %> <br>
	mid = <%= request.getParameter("mid") %> <br>

<!-- 불러오기 -->
<jsp:include page = "footer.jsp"></jsp:include>


</body>
</html>
