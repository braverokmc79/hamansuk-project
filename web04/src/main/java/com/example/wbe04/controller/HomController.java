package com.example.wbe04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomController {

	@RequestMapping("/")
	public String main(Model model){
		model.addAttribute("message", "홈페이지에 온신것을 환영합니다.");
		
		return "main";
	}
	
}
