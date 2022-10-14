<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.napmkmk.member.*" %>
  <% request.setCharacterEncoding("utf-8"); %>  
   <jsp:useBean id="dto" class="com.napmkmk.member.MemberDto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	MemberDao dao= new MemberDao();
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