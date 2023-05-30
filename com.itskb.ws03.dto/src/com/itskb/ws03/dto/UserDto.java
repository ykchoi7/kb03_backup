package com.itskb.ws03.dto;

public class UserDto {  //고객클래스
	private int userSeq;
	private String name;  //타입이 같으면 private String name, email, phone; 으로 써도 됨
	private String email;
	private String phone;
	private boolean isSleep; //is는 메서드이기 때문에 보통 변수명에 is를 넣지 않음 
							 //boolean은 get 대신 is라는 메서드를 사용
	
	
	public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
		this.userSeq = userSeq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isSleep = isSleep;
	}
	
	
	//빈공간에 source > generate constructor using fields 를 클릭하면 아래 코드가 자동으로 생성됨
//	public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
//		super(); //super는 자동으로 
//		this.userSeq = userSeq;
//		this.name = name;
//		this.email = email;
//		this.phone = phone;
//		this.isSleep = isSleep;
//	}

	
	// getter/setter 메서드
	//한 방에 만들어주는 것이 있음 > 빈공간에 source > generate getters and setters > select all > generate
	
	public int getUserSeq() {
		return userSeq;
	}


	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isSleep() {
		return isSleep;
	}


	public void setSleep(boolean isSleep) {
		this.isSleep = isSleep;
	}


	@Override
	public String toString() {
		return "UserDto [userSeq=" + userSeq + ", name=" + name + ", email=" + email + ", phone=" + phone + ", isSleep="
				+ isSleep + "]";
	}
	
	
//	public boolean isSleep() {
//		return isSleep;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public String getName() {
//		return name;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public int getUserSeq() {
//		return userSeq;
//	}
//	
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public void setSleep(boolean isSleep) {
//		this.isSleep = isSleep;
//	}
//	public void setUserSeq(int userSeq) {
//		this.userSeq = userSeq;
//	}
	
	
	// 이것도 자동으로 만들어주는 기능이 있음 > Source > generate toString()
//	public String toString() {
//		return "name = " +name + ", email = "+email + ", phone = "+phone + ", userSeq = " +userSeq + ", isSleep = " + isSleep;
//	}
}
 
