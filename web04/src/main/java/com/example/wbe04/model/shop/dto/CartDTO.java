package com.example.wbe04.model.shop.dto;

import lombok.Data;

@Data
public class CartDTO {

	   private Integer idx;
	   private String userid;
	   private Integer product_id;
	   private Integer amount;
	   private String name;
	   private String product_name;
	   private int price;
	   private int money;
	   
	   private String picture_url;
	   
	   
	   //기본 생성자
	   public CartDTO(){
		   
	   }
	   
	   //입력 생성자
	   public CartDTO(int product_id, String userid, int amount){
		   this.product_id =product_id;
		   this.userid=userid;
		   this.amount=amount;
	   }
	   
}
