package com.napmkmk.member;

public class MemberDto {
	private String id;
	private String pw;
	private String username;
	private String email;
	private String signuptime;
	// getters setters ..!! 아주 중요.  만들기오른쪽 버튼 -> 소스 - > 게터세터) 
	// DTO 탄생 데이터를 옮겨주는 오브젝트.
	// DTO(Data Transfer Object) 는 계층 간 데이터 교환을 하기 위해 사용하는 객체로, 
	// DTO는 로직을 가지지 않는 순수한 데이터 객체(getter & setter 만 가진 클래스)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSignuptime() {
		return signuptime;
	}
	public void setSignuptime(String signuptime) {
		this.signuptime = signuptime;
	}
	
	
}
