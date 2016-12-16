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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	
	@RequestMapping("/guestbook/view")
	public String view (int idx,  String passwd, Model model, RedirectAttributes rttr){
		//비밀 번호가 맞는 지 확인
		System.out.println("view 화면 가기 ");
		int result=bookDAO.passwdCk(idx,  passwd);
		if(result==1){
			//맞으면 view.jsp 로 이동
			System.out.println("비밀번호가 맞습니다.");
			GuestBookDTO list=null;
			try {
				list=bookDAO.gbDetail(idx);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("list", list);
			return "/guestbook/view";
		}else{
			//틀리면 list.jsp 
			System.out.println("비밀번호가 틀립니다.");
			rttr.addFlashAttribute("pwdCkError", "비밀번호가 틀립니다.");
			return "redirect:list";
		}
 
	}
	
	
	@RequestMapping(value="/guestbook/modify" , method=RequestMethod.POST)
	public String modify(@ModelAttribute GuestBookDTO dto) throws Exception{
		//내용 수정하기
		bookDAO.modifyGuestBook(dto);
		logger.info(" 수정 했습니다.  ");
		return "redirect:list";
	}
	

	@RequestMapping(value="/guestbook/delete", method=RequestMethod.POST)
	public String gbDelete(int idx) throws Exception{
		logger.info("삭제 했습니다.");
		bookDAO.gbDelete(idx);
		return "redirect:list";
	}
	
	
	
	
	

	/////REST    //////////////////////////
	
	//Rest 리스트 목록 가져오기
	@ResponseBody
	@RequestMapping(value="/guestbook/rlist")
	public ResponseEntity<List<GuestBookDTO>> list() throws Exception{
		logger.info(" 방명록 리스트");
		ResponseEntity<List<GuestBookDTO>> entity =null;
		
		try{
			entity =new ResponseEntity<List<GuestBookDTO>>(bookDAO.gblist(), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity =new ResponseEntity<List<GuestBookDTO>>( HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	
	
	///Rest 수정 및 패스워드 확인
	@RequestMapping(value="/guestbook/{rno}", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> modifyGuestBook( @PathVariable("rno") Integer rno , 
			@RequestBody GuestBookDTO dto){
		
		ResponseEntity<String> entity=null;
			
		try{
			logger.info("패스워드  체크 : " +dto.getPasswdCk() +"  ---- : " + dto.toString() + " rno : " + rno);
		
			//패스워드 체크
			int result=bookDAO.passwordCheck(dto);
			logger.info("result 값 : " + result);
			if(result !=0){ 
				
				//내용 수정하기
				bookDAO.modifyGuestBook(dto);
				
				entity =new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}else {
				entity =new ResponseEntity<String>("pwError", HttpStatus.OK);
			}
					
		}catch(Exception e){
			e.printStackTrace();
			entity =new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	

	
	///Rest Delete
	
	@RequestMapping(value="/guestbook/rdelete", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> rDelete( @RequestBody GuestBookDTO dto) throws Exception{
		
		ResponseEntity<String> entity =null;
		//패스워드 체크
		int result=bookDAO.passwdCk(dto.getIdx(),  dto.getPasswdCk());
		logger.info("result 값 : " + result);
		
		if(result !=0){ 
			
			logger.info("삭제 했습니다.");
			 bookDAO.gbDelete(dto.getIdx());
			
			 entity =new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}else {
			logger.info("비번인 틀립니다.");
			 entity =new ResponseEntity<String>("pwError", HttpStatus.OK);
		}	
		return entity;
	}

	
	
	
	
}
