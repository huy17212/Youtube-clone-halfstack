<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/user/taglibJSTL.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Google Form</title>
    <%@ include file="/common/user/linkLogin.jsp"%>
</head>
<body>
 
    <div class="box">
        <div class="logo">
            <img src="<c:url value='templates/user/images/google-logo-9834.png'/>" width="30%" alt="" srcset="">
        </div>
    <h2>Sign In</h2>
    <p style="">Use your Google Account</p>
    <form action="login" method="post">
        <div class="inputBox">
          <input  type="text" name="username" required onkeyup="this.setAttribute('value', this.value);"  value="">
          <label>Username</label>
        </div>
        <div class="inputBox" >
              <input  type="password" name="password" required onkeyup="this.setAttribute('value', this.value);" value="">
              <label>Password</label>
        </div>
        <div>
            <input type="checkbox">
            <label for="">Remember me</label>
            <label style="margin: 0px 0px 0px 110px; color: #0984e3;" for="">Create account</label>
        </div>
        <input style="margin-top: 10px;" type="submit">
      </form>
    </div>
     
</body>
</html>