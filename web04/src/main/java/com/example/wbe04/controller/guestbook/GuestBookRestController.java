package com.example.wbe04.controller.guestbook;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbe04.model.guestbook.dao.GuestBookDAO;
import com.example.wbe04.model.guestbook.dto.GuestBookDTO;


public class GuestBookRestController {

	@Inject
	private GuestBookDAO bookDAO;
	
	
	private static final Logger logger=LoggerFactory.getLogger(GuestBookRestController.class);
	
	
	
	
	
	
	
}
