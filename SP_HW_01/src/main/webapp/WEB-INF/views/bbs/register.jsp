<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style>

    #register {
      margin-top: 5px;
      padding: 20px 0px;
    }

    #register h1 {
      padding: 5px;
      text-align: center;
    }

    #register form{
      display: block;
      width: 80%;
      height: 300px;
      border: 1px solid lightgrey;
      padding: 50px;
    }

    #register .form-item{
      margin-bottom: 10px;
    }

    #register .form-item label{
      display: inline-block;
      width: 150px;
      font-size: 18px;
    }

    #register .form-item input{
      display: inline-block;
      width: 250px;
      font-size: 18px;
    }

    #register button{
      margin-top: 10px;
      padding: 5px;
      float: right;
      width: 100px;
      font-size: 18px;
    }    
 
  </style>
<title>Register</title>
</head>
<body>

  <div id="container">
    <div id="register">
      <h1>Register</h1>
      <form action="">
        <div class="form-item">
          <label for="name">이름</label>
          <input type="text" id="name">
        </div>

        <div class="form-item">
          <label for="email">이메일</label>
          <input type="email" id="email">
        </div>

        <div class="form-item">
          <label for="phone">연락처</label>
          <input type="text" id="phone">
        </div>

        <div class="form-item">
          <label for="password">비밀번호</label>
          <input type="password" id="password">
        </div>

        <div class="form-item">
          <label for="password2">비밀번호 확인</label>
          <input type="password" id="password2">
        </div>
        
        <hr>
        <button>회원가입</button>
		<button>로그인</button>
      </form>
    </div>
  </div>

</body>
</html>