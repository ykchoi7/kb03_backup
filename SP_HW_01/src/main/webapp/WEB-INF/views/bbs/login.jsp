<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <style>

    #login {
      margin-top: 5px;
      padding: 20px 0px;
    }

    #login h1 {
      padding: 5px;
      text-align: center;
    }

    #login form{
      display: block;
      width: 80%;
      height: 200px;
      border: 1px solid lightgrey;
      padding: 50px;
    }

    #login .form-item{
      margin-bottom: 10px;
    }

    #login .form-item label{
      display: inline-block;
      width: 100px;
      font-size: 18px;
    }

    #login .form-item input{
      display: inline-block;
      width: 200px;
      font-size: 18px;
    }

    #login button{
      margin-top: 10px;
      padding: 5px;
      float: right;
      width: 100px;
      font-size: 18px;
    } 
    
	footer {
	  background-color:LightGray;
	  border-top: 1px solid lightgray;
	  margin-top: 10px;
	  padding: 10px;
	}
	
	footer ul{
	  list-style-type: none;
	}
	footer ul li{
	  padding: 5px;
	  text-align: right;
	}
  </style>
  
<title>Login</title>
</head>
<body>	
	<div id="container">
    <div id="login">
      <h1>Login</h1>
      <form action="">
        <div class="form-item">
          <label for="email">이메일</label>
		      <input type="text" id="email">
        </div>
        <div class="form-item">
          <label for="password">비밀번호</label>
		      <input type="password" id="password">
        </div>
        <hr>
        <button>회원가입</button>
        <button>로그인</button>
      </form>
    </div>

</body>
</html>