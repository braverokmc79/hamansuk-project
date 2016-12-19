package com.example.wbe04.model.guestbook.dto;

import java.util.Date;

import com.example.wbe04.util.FormTagReplace;

import lombok.Data;


@Data
public class GuestBookDTO {
	
	
	 private int idx ;
	 private String name;
	 private String email;
	 private String passwd;
	 private String content;
	 private Date post_date;
	 private String passwdCk;
	 
	 
	public void setName(String name) {  
		 this.name = FormTagReplace.chagne(name);
	}
	 
	public void setEmail(String email) {
		this.email = FormTagReplace.chagne(email);
	}
	
	public void setContent(String content) {
		this.content = FormTagReplace.chagne(content);
	}
	
	
	
}



