package com.example.wbe04.model.memo.dto;

import java.sql.Date;

import com.example.wbe04.model.member.dto.MemberDTO;
import com.example.wbe04.util.FormTagReplace;

import lombok.Data;

@Data
public class MemoDTO {

	private Integer idx;
	private String writer;
	private String memo;
	private Date write_date;
	
	
	public MemoDTO(){
		
	}
	
	public MemoDTO(String writer, String memo){
		super();
		this.writer=writer;
		this.memo=memo;
	}
	
	
/*	public void setWriter(String writer) {
		this.writer = FormTagReplace.chagne(writer);
	}
	
	
	public void setMemo(String memo) {
		this.memo = FormTagReplace.chagne(memo );
	}*/
	
}
