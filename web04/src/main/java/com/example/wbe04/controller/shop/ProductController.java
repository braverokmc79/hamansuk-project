package com.example.wbe04.controller.shop;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.wbe04.model.shop.dao.ProductDAO;

@Controller
@RequestMapping(value="/shop")
public class ProductController {

	
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	
	@Inject
	private ProductDAO productDAO ;
	
	
	@RequestMapping(value="/product_list" , method=RequestMethod.GET)
	public void product_list(Model model){
		
		logger.info("product_list 호출....");
		model.addAttribute("list", productDAO.productList());	
	}
	
	
	
	
	
	
	
	
	
	
}





