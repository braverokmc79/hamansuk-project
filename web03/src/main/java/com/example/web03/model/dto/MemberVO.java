package com.example.web03.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	   private String userid ;
	   private String userpw  ;
	   private String username ;
	   private String email   ;
	   private Date regdate   ; 
	   private Date  timestamp ;
	   
}
