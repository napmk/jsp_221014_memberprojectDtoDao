<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원로그인</title>
</head>
<body>
	<form action="loginOk.jsp" method="post">
		아이디 : <input type="text" size="20" name="id">
		비밀번호 : <input type="password" size="20" name="pw">
		 <input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
		  <input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'">
	</form>
</body>
</html>