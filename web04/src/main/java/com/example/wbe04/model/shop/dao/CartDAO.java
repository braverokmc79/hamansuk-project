package com.example.wbe04.model.shop.dao;

import java.util.List;

import com.example.wbe04.model.shop.dto.CartDTO;

public interface CartDAO {

	public void cartAdd(CartDTO dto);

	public List<CartDTO> getList(String userid);
	
	
}
