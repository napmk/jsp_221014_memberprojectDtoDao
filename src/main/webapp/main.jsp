<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<%
		if(session.getAttribute("vaildMember") == null){ //로그인상태
	%>
	<a href="login.jsp">로그인으로 가기</a>
	<%
		}else{	
			String id = (String)session.getAttribute("memberId");
			out.println(id + "님 로그인 중");
	%>
	<br><br>
	<a href="logout.jsp">로그아웃</a>
	<br><br>
	<a href="modify.jsp">회원정보수정</a>
	<% 
		}
	%>
	
</body>
</html>