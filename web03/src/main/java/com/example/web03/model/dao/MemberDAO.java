package com.example.web03.model.dao;

import java.util.List;

import com.example.web03.model.dto.MemberVO;

public interface MemberDAO {
	
	public String getTime();
	
	public int insertMember(MemberVO memberVO) throws Exception;
	
	public List<MemberVO> meberList() throws Exception;
	
	public MemberVO memeberInfo(String userid) throws Exception;

	public int memberGetPassword(String userid, String userpw) throws Exception;

	public void memberUpdate(MemberVO memberVO) throws Exception;

	public void memberDelete(String userid) throws Exception;
	
}
