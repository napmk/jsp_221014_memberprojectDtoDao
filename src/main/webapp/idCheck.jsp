<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.napmkmk.member.MemberDao" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 여부 체크</title>
</head>
<body>
	<h3>아이디 중복 여부 확인</h3>
	<hr>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id =request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		
		int idResult = dao.idCheck(id);// idFlag 값을 반환(1이면 이미 가입한 아이디 , 0이면 가입가능한 아이디)
		
		if(idResult ==1){
			out.println("이미 존재하는 아이디 입니다. 다른아이디로 입력해주세요");
			
		}else {
			out.println("가입가능한 아이디 입니다. ");
		}
		
	%>
	<a href="join.asp" > 가입화면으로 돌아가기</a>
</body>
</html>