package com.example.wbe04.model.guestbook.dto;

import java.util.Date;

import lombok.Data;

@Data
public class GuestBookDTO {
	
	
	 private int idx ;
	 private String name;
	 private String email;
	 private String passwd;
	 private String content;
	 private Date post_date;
	 
	 
	
}
