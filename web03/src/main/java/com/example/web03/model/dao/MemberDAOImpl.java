package com.example.web03.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web03.model.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	
	private static String namespace ="member.Mapper";
	
	
	
	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public int insertMember(MemberVO memberVO) throws Exception{
		// TODO Auto-generated method stub
		int isertnum=0;
		sqlSession.selectOne(namespace+".insertMember",memberVO );
		isertnum =1;
		 return isertnum;
	}

	@Override
	public List<MemberVO> meberList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".meberList");
	}

	@Override
	public MemberVO memeberInfo(String userid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".memeberInfo", userid);
	}

	@Override
	public int memberGetPassword(String  userid, String userpw) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap =new HashMap<>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace+".memberGetPassword", paramMap);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".memberUpdate", memberVO);
	}

	@Override
	public void memberDelete(String userid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".memberDelete", userid);
	}

	
	
	
	
	
}
