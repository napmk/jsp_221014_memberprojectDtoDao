<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.napmkmk.member.MemberDao" %>
  <%@page import="com.napmkmk.member.MemberDto" %>
 <% request.setCharacterEncoding("utf-8"); %>
 <jsp:useBean id="dto" class="com.napmkmk.member.MemberDto"/>
 <jsp:setProperty property="*" name="dto"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinOk</title>
</head>
<body>
<h3>회원가입 확인</h3>
<hr>
	<%
//	String id = request.getParameter("id");
//	String pw = request.getParameter("pw");
//	String name = request.getParameter("name");
//	String email = request.getParameter("email");
	
	//MemberDto dto = new MemberDto();
//	dto.setId(id);
//	dto.setPw(pw);
//	dto.setUsername(name);
//	dto.setEmail(email);
	
	
	
	MemberDao dao = new MemberDao();
	
	int idResult = dao.idCheck(dto.getId());
	
	
	//int joinCheck = dao.insertMember(id, pw,name, email);
	if(joinCheck == 1){
		out.println("회원가입 성공! 축하합니다.");
	}else {
		int joinCheck = dao.insertMember(dto);
		out.println("회원가입 실패! 다시 확인해주세요");
	}
	%>
</body>
</html>