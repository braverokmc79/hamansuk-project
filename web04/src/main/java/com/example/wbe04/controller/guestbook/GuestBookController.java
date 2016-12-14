package com.example.wbe04.controller.guestbook;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.wbe04.model.guestbook.dao.GuestBookDAO;
import com.example.wbe04.model.guestbook.dto.GuestBookDTO;

@Controller
@RequestMapping(value="/guestbook")
public class GuestBookController {

	@Inject
	private GuestBookDAO bookDAO;
	
	
	private static final Logger logger=LoggerFactory.getLogger(GuestBookController.class);
	
	
	@RequestMapping(value="/list")
	public void list(Model model) throws Exception{
		logger.info(" 방명록 리스트");
		
		model.addAttribute("gblist" , bookDAO.gblist());
	}
	
	
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void write(){
		
	}
	
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute GuestBookDTO dto, Model model){
		
		if(dto.getName()==null){
			return "/guestbook/write";
		}else{
			bookDAO.gbInsert(dto);
			return "redirect:list";
		}
		
	}
	
	
	
	
	
}
