package com.example.wbe04.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.wbe04.model.shop.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Inject
	SqlSession sqlSession;
	
	private static final String namespace="cart.Mapper";

	private static Logger logger=LoggerFactory.getLogger(CartDAOImpl.class);
	
	
	@Override
	public void cartAdd(CartDTO dto) {
		try {
			sqlSession.insert("cartAdd", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<CartDTO> getList(String userid) {
		// TODO Auto-generated method stub
		List<CartDTO> list=null;
		
		try{
			//유저 아이디의 장바구니 목록을 다 가져온다
			list=sqlSession.selectList(namespace+".getList", userid);
			
		}catch(Exception e){
			logger.info("getList 에러  ");
			e.printStackTrace();	
		}	
		return list;
	}


	@Override
	public void delete(Integer idx) {
		// TODO Auto-generated method stub
		logger.info("CartDAOImpl -> delete ");
		try{
			sqlSession.delete(namespace+".delete" , idx);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	@Override
	public void cartDelAll(String userid) {
		
		logger.info("CartDAOImp -> cartDelAll ") ;
		try{
			 sqlSession.delete(namespace+".cartDelAll" , userid);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}


