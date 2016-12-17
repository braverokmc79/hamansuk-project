package com.example.wbe04.model.member.dto;

import java.sql.Date;

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
	
	
}

