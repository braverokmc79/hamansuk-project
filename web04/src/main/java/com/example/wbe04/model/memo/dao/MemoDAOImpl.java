package com.example.wbe04.model.memo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.wbe04.model.memo.dto.MemoDTO;

@Repository
public class MemoDAOImpl implements MemoDAO {

	private static Logger logger =LoggerFactory.getLogger(MemoDAOImpl.class);
	
	private static String namespace="memo.Mapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<MemoDTO> memoList() {
		List<MemoDTO> list=null;
		try{
			logger.info("DAOImpl - memoList");
			list=sqlSession.selectList(namespace+".memoList");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void memoAdd(MemoDTO dto) {
		try{
			logger.info("DAOImpl - memoAdd");
			sqlSession.insert(namespace+".memoAdd", dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
