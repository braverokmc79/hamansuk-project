package com.example.wbe04.model.shop.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {

	 private int product_id;     
	 private String product_name;
	 private int price;          
	 private String description;
	 private String picture_url;
	 private Date regdate;
	
}
