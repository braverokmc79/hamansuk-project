package com.example.wbe04.model.guestbook.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.wbe04.model.guestbook.dto.GuestBookDTO;


public interface GuestBookDAO {

	public List<GuestBookDTO> gblist() throws Exception;

	public int gbInsert(GuestBookDTO dto) ;

	public int passwordCheck(GuestBookDTO dto);

	public void modifyGuestBook(GuestBookDTO dto) throws Exception;
		
	//hamasuk 비번 체크
	public int passwdCk(int idx, String passwd);
	
	public GuestBookDTO gbDetail(int idx) throws Exception;
	
	
	public void gbDelete(int idx) throws Exception;
	
	
	
}
