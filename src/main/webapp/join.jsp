<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h3>회원가입</h3>
<hr>
	아이디 중복 여부 체크 :<br>
	<form action="idCheck.jsp">
		<input type="text" size="20" name="id">
		<input type="submit" value="중복체크">
	</form><br><br>
	<form action="joinOk.jsp">
		아이디 : <input type="text" name="id" size="20"><br><br> 
		비밀번호 : <input type="password" name="pw" size="20"><br><br>
		이름 : <input type="text" name="username" size="20"><br><br>
		이메일 : <input type="text" name="email" size="20"><br><br> 
		<input type="submit" value="회원가입">
	</form>
</body>
</html>