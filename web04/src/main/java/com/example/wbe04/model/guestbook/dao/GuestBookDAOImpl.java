package com.example.wbe04.model.guestbook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.wbe04.model.guestbook.dto.GuestBookDTO;


@Repository
public class GuestBookDAOImpl implements GuestBookDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	
	private static final String namespace="GuestBook.Mapper";
	
	private static Logger logger	=LoggerFactory.getLogger(GuestBookDAOImpl.class);
	
	
	
	@Override
	public List<GuestBookDTO> gblist() throws Exception {
		// TODO Auto-generated method stub
		
		List<GuestBookDTO> list =null;
		try{
			list =sqlSession.selectList(namespace+".gblist");
			
			
			for(GuestBookDTO dto : list){
				
				String content =dto.getContent();
				//줄바꿈 
				//칸띄우기
				//<  태그 xmp
				//스크립트 처리
				String str=content.replace("\n", "<br>")
						.replace("  ", "&nbsp;&nbsp;")
						.replace("<", "&lt")
						.replace(">", "&gt");
			
				dto.setContent(str);
				//logger.info(str);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return list;
	}



	@Override
	public int gbInsert(GuestBookDTO dto) {
		int result =0;
		try {
			result=sqlSession.insert(namespace+".gbInsert" ,dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	@Override
	public int passwordCheck(GuestBookDTO dto) {	
		int result=0;
		/*Map<String, Object> paraMap =new HashMap<>();
		paraMap.put("idx", dto.getIdx());
		paraMap.put("passwdCk", dto.getPasswdCk());*/
		try{
			//글번호와 패스워드가 맞으면 1을 반환 
			result=sqlSession.selectOne(namespace+".passwordCheck", dto);	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}



	@Override
	public void modifyGuestBook(GuestBookDTO dto) throws Exception {
		
		
		sqlSession.update(namespace+".modifyGuestBook", dto);
	}



	@Override
	public int passwdCk(int idx, String passwd) {
		int result =0;
		
		try{
			Map<String , Object>  map =new HashMap<>();
			map.put("idx", idx);
			map.put("passwd", passwd);
			
			result=sqlSession.selectOne(namespace+".passwdCk", map);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public GuestBookDTO gbDetail(int idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".gbDetail", idx);
	}



	@Override
	public void gbDelete(int idx) throws Exception {
		
		sqlSession.delete(namespace +".gbDelete" , idx);
		
	}
	

	
	
	
	

}


