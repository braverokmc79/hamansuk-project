package com.example.wbe04.model.guestbook.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.wbe04.model.guestbook.dto.GuestBookDTO;


public interface GuestBookDAO {

	public List<GuestBookDTO> gblist() throws Exception;

	public int gbInsert(GuestBookDTO dto) ;
		
		

}