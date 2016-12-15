package com.example.wbe04.controller.guestbook;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.wbe04.model.guestbook.dao.GuestBookDAO;
import com.example.wbe04.model.guestbook.dto.GuestBookDTO;

@Controller
public class GuestBookController {

	@Inject
	private GuestBookDAO bookDAO;
	
	
	private static final Logger logger=LoggerFactory.getLogger(GuestBookController.class);


	
	@RequestMapping(value="/guestbook/list")
	public void list(Model model) throws Exception{
		logger.info(" 방명록 리스트");
		
		List<GuestBookDTO> list= bookDAO.gblist();
		model.addAttribute("gblist" ,list);
		model.addAttribute("listCount", list.size());
	}
	
	
	
	@RequestMapping(value="/guestbook/write", method=RequestMethod.GET)
	public void write(){
		
	}
	
	
	@RequestMapping(value="/guestbook/write", method=RequestMethod.POST)
	public String write(@ModelAttribute GuestBookDTO dto, Model model){
		
		if(dto.getName()==null){
			return "/guestbook/write";
		}else{
			bookDAO.gbInsert(dto);
			return "redirect:list";
		}
		
	}
	
	

	

	@RequestMapping(value="/guestbook/{rno}", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> modifyGuestBook( @PathVariable("rno") Integer rno , 
			@RequestBody GuestBookDTO dto){
		
		ResponseEntity<String> entity=null;
			
		try{
			logger.info("패스워드  체크 : " +dto.getPasswdCk() +"  ---- : " + dto.toString() + " rno : " + rno);
			entity =new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
			
		}catch(Exception e){
			e.printStackTrace();
			entity =new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	
	
	
}
