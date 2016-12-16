package com.example.wbe04.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.wbe04.model.shop.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="product.Mapper";
	
	private static Logger logger =LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Override
	public List<ProductDTO> productList() {
		
		List<ProductDTO> list =null;
		try {
			list =sqlSession.selectList(namespace+".productList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}



