package com.example.web02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.web02.dao.Product;

@Controller
public class SampleController {

	
	@RequestMapping(value="/productDetail", method={RequestMethod.POST, RequestMethod.GET})
	public void product(Model model){
			
		Product product =new Product();
		product.setName("홍길동");
		product.setPrice(1000);
		model.addAttribute(product);
		
	}
	
	@RequestMapping(value="/productDetail2", method={RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public  Product product2(Model model){
			
		Product product =new Product();
		product.setName("홍길동");
		product.setPrice(1000);
		model.addAttribute(product);
		return product;
	}
	
	
	@RequestMapping(value="/input")
	public void input(){
		
	}
	
	
	@RequestMapping("/gugu")
	public String gugu(int gugu, Model model){
		
		StringBuilder builder =new StringBuilder();
		
		for(int i=1; i<=9; i++){
			builder.append(gugu + " * " + i +" = " + gugu*i + "<br>");
		}
		model.addAttribute("gugu", builder.toString());
	
		return "/input";
	}
	
	
	
	
	
}
