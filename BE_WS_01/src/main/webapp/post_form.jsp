<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="mydto" class="BE_WS_01.dto.SimpleDto2" scope="request"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {border: 1px solid black; border-collapse: collapse;}
	td {border: 1px solid black;}
</style>
</head>
<body>

	<h1>Post Result</h1>
	<table>
	  <tr>
	    <td>name</td>
	    <td><jsp:getProperty property="name" name="mydto"/></td>
	  </tr>
	  <tr>
	    <td>email</td>
	    <td><jsp:getProperty property="email" name="mydto"/></td>
	  </tr>
	  <tr>
	    <td>gender</td>
	    <td><jsp:getProperty property="gender" name="mydto"/></td>
	  </tr>
	  <tr>
	    <td>hobby</td>
	    <% 
	    	String hobby = Arrays.toString(mydto.getHobby()).replace("[","").replace("]","");
	    %>
	    <td><%= hobby %></td>
	  </tr>
	  <tr>
	    <td>favorite</td>
	    <td><jsp:getProperty property="favorite" name="mydto"/></td>
	  </tr>
	  <tr>
	    <td>desc</td>
	    <td><jsp:getProperty property="desc" name="mydto"/></td>
	  </tr>
	</table>

</body>
</html>