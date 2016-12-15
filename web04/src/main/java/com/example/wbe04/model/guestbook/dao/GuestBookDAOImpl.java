package com.example.wbe04.model.guestbook.dao;

import java.util.List;

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
				logger.info(str);
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

}
