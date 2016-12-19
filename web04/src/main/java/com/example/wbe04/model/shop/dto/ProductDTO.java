package com.example.wbe04.model.shop.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.wbe04.util.FormTagReplace;

import lombok.Data;

@Data
public class ProductDTO {

	 private int product_id;     
	 private String product_name;
	 private Integer price;          
	 private String description;
	 //썸네일 이미지
	 private String picture_url;
	 private Date regdate;
	 
	 //원본 이미지
	 private String original_picture_url;
	 
	 
	 //업로드한 파일 저장
	 private MultipartFile file1;
	 
	 
	
	public String getProduct_name() {
		return FormTagReplace.chagne(product_name);
	}
	
	public String getDescription() {
		return  FormTagReplace.chagne(description);
	}
	
}
