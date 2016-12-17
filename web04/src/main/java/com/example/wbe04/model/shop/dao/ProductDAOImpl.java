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

	@Override
	public ProductDTO productDetail(int product_id) {
		// TODO Auto-generated method stub
		
		ProductDTO dto =null;
		try {
			
			dto=sqlSession.selectOne(namespace+".productDetail", product_id);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return dto;
	}

	@Override
	public int  product_write(ProductDTO dto) {
		int result=0;
		try {
			sqlSession.insert(namespace+".product_write", dto);
			result=1;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	
	
	
}



