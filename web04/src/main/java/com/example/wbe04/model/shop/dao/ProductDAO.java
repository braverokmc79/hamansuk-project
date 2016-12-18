package com.example.wbe04.model.shop.dao;

import java.util.List;

import com.example.wbe04.model.shop.dto.ProductDTO;

public interface ProductDAO {

	public List<ProductDTO> productList();

	public ProductDTO productDetail(int product_id);

	public int product_write(ProductDTO dto);

	public int product_edit(ProductDTO dto);

	public void productDelete(int product_id);
	
}
