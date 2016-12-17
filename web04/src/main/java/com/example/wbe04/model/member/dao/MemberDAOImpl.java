package com.example.wbe04.model.member.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.wbe04.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger =LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private static final String namespsce ="member.Mapper";
	
	
	
	
	@Override
	public MemberDTO login(String userid, String userpw) {
	
		MemberDTO dto =null;
		
		try{
			Map<String, String > map =new HashMap<>();
			
			map.put("userid", userid);
			map.put("userpw", userpw);
			
			dto=sqlSession.selectOne(namespsce+".login", map);
			
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		
		
		return dto;
	}

	
	
	
	
	
	
}
