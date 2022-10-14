<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<%
	session.invalidate();//모든세션 삭제
%>
	로그아웃 하셨습니다.
	<a href="main.jsp">메인화면으로 가기</a>

</body>
</html>