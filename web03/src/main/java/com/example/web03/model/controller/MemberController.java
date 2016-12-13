package com.example.web03.model.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.web03.model.dao.MemberDAO;
import com.example.web03.model.dto.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Inject
	private MemberDAO memberDAO;
	
	
	private static Logger logger =LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/getTime")
	public void getTime(Model model){
		
		logger.info("현재 시간 DB 가져오기  :  ");
		
		model.addAttribute("msg", memberDAO.getTime());
		
	}
	
	
	@RequestMapping(value="/memberForm", method=RequestMethod.GET)
	public void memberForm (){
		
	}
	
	
	@RequestMapping(value="/memebrInsert", method=RequestMethod.POST)
	public String memberForm (@ModelAttribute MemberVO memberVo, Model model, HttpSession session,RedirectAttributes rttr) throws Exception{
		
		
		 try{
			 
			 int num=memberDAO.insertMember(memberVo);
			 System.out.println("insert  삽입  : " + num);
			// rttr.addFlashAttribute("insertMsg", "SUCCESS");
			model.addAttribute("message", "회원 가입에 성공 했습니다.");
			 session.setAttribute("userid", memberVo.getUserid());
			return "redirect:/member/main";
			
		 }catch(Exception e){
				 logger.info(e.getMessage());
				 rttr.addFlashAttribute("insertMsg", "FAIL");
				 return "redirect:/member/memberForm"; 
		 }	 
	}
	
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void main(){
		
	}
	
	@RequestMapping(value="/meberList")
	public void meberList(Model model) throws Exception{
		model.addAttribute("list",  memberDAO.meberList() );
	}
	
	@RequestMapping(value="/memeberInfo")
	public void memeberInfo(@ModelAttribute("userid") String userid, Model model) throws Exception{
		
		model.addAttribute("dto", memberDAO.memeberInfo(userid));
	}
	
	
	
	
	@RequestMapping(value="/memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute MemberVO vo, String updatepw,  RedirectAttributes rttr ) throws Exception{
		
		//
		//비밀 번호가 맞는지 확인
		
		int pwConfirm =memberDAO.memberGetPassword(vo.getUserid(), vo.getUserpw());
		
		
		//비밀 번호가 맞으면 update => 리스트로 이동
		if(pwConfirm==1){
					vo.setUserpw(updatepw);
					memberDAO.memberUpdate(vo);
					return "redirect:/member/meberList";
		}else{
			//비밀 번호가 틀리면  memebrInfo 로 돌아가
			logger.info(" //비밀 번호가 틀리면  memebrInfo 로 돌아가");
			//model.addAttribute("dto",  memberDAO.memeberInfo(vo.getUserid()));
			//rttr.addFlashAttribute("dto", vo);
			rttr.addFlashAttribute("pwError", "아이디 또는 패스워드가 틀립니다.");
			return "redirect:/member/memeberInfo?userid="+vo.getUserid();
		}
		
	}
	
	
	@RequestMapping(value="/memberDelete", method=RequestMethod.POST)
	public String memberDelete(@ModelAttribute MemberVO vo) throws Exception{
		
		memberDAO.memberDelete(vo.getUserid());
		
		return "redirect:meberList";
		
	}
	
	
	
}
