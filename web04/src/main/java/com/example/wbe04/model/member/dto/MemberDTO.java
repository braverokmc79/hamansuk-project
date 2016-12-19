package com.example.wbe04.model.member.dto;

import java.sql.Date;

import com.example.wbe04.util.FormTagReplace;

import lombok.Data;

@Data
public class MemberDTO {

	private String userid;
	private String userpw;
	private String username;
	private String email;
	private String address;
	private String tel;

	private Date regdate;
	private Date updatedate;
	
	
	public void setUserid(String userid) {
		this.userid = FormTagReplace.chagne(userid);
	}
	
	
	public void setUsername(String username) {
		this.username = FormTagReplace.chagne(username);
	}
	
	public void setEmail(String email) {
		this.email = FormTagReplace.chagne(email);
	}
	
	public void setAddress(String address) {
		this.address = FormTagReplace.chagne(address);
	}
	
	public void setTel(String tel) {
		this.tel = FormTagReplace.chagne(tel);
	}
	
}


