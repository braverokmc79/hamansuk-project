package com.example.wbe04.model.member.dao;

import com.example.wbe04.model.member.dto.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(String userid, String userpw );
	
}
