package com.example.wbe04.controller.memo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbe04.model.memo.dao.MemoDAO;
import com.example.wbe04.model.memo.dto.MemoDTO;

@Controller
@RequestMapping(value="/memo")
public class MemoController {

	private static final Logger logger=LoggerFactory.getLogger(MemoController.class);
	
	@Inject
	private MemoDAO memoDao;
	
	
	
	@RequestMapping("/list")
	public String list(){
		logger.info(" memo list 호출");
		
		return "memo/memo";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/memo_list", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> memo_list(){
		//dao 호출
		ResponseEntity<Map<String, Object>> entity =null;
		try{	
			
			List<MemoDTO>  list=memoDao.memoList();
			Map<String, Object> map=new HashMap<>();
			map.put("list", list);
		
			entity =new ResponseEntity<Map<String, Object>>(map , HttpStatus.OK);
			//모델 자료 저장
		}catch(Exception e){
			e.getStackTrace();
			entity =new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}	
		return entity;
	}

	
	
	@ResponseBody
	@RequestMapping(value="/memo_add", method=RequestMethod.POST)
	public ResponseEntity<String> memo_add(@RequestBody MemoDTO dto){
		ResponseEntity<String> entity=null;
		
		try {
			memoDao.memoAdd(dto);
			 entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	
}




