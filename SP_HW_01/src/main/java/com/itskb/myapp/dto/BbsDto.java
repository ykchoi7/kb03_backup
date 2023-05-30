package com.itskb.myapp.dto;

import java.util.Date;

public class BbsDto {
	private String name, email, contact, pwd, pwd_re;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd_re() {
		return pwd_re;
	}

	public void setPwd_re(String pwd_re) {
		this.pwd_re = pwd_re;
	}

	@Override
	public String toString() {
		return "BbsDto [name=" + name + ", email=" + email + ", contact=" + contact + ", pwd=" + pwd + ", pwd_re="
				+ pwd_re + "]";
	}	
	
	
}
