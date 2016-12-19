package com.example.wbe04.controller.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.wbe04.model.member.dto.MemberDTO;
import com.example.wbe04.model.shop.dao.CartDAO;
import com.example.wbe04.model.shop.dto.CartDTO;

@Controller
@RequestMapping(value="/cart")
public class CartController {

	
	private static final Logger logger=LoggerFactory.getLogger(CartController.class);
	
	@Inject
	private CartDAO cartDAO;
	
	@RequestMapping(value="/cart_add")
	public String cart_add(HttpSession session, CartDTO cartDTO, Model model){
		logger.info(" cart_add  호출");	

		
		//로그인 한 유저 DB에 바로 넣기
		MemberDTO member=null;
		member=(MemberDTO)session.getAttribute("loginUser");
		CartDTO dto=null;
		logger.info("로그인 한 1유저");
		
		if(member!=null){
			logger.info("로그인 2한 유저");
			
			dto =new CartDTO(cartDTO.getProduct_id(), member.getUserid(), cartDTO.getAmount());
			cartDAO.cartAdd(dto);
			return "redirect:/cart/cart_list";
		}
		
		//cartDAO.cartAdd(dto);	
		//로그인 하지 않는 유저 확인 세션에 담기	
		logger.info("비로그인 한 유저");
		
		
		@SuppressWarnings("unchecked")
		HashMap<String, Object> cart=(HashMap<String, Object>)session.getAttribute("cart_add");
		if(cart!=null){
			//기존에 장바구에 담은 물건이 있을 경우
			logger.info("기존에 장바구에 담은 물건이 있을 경우");
			//기존 세션 삭제
			session.removeAttribute("cart_add");
			
			cartDTO.setMoney(cartDTO.getPrice()*cartDTO.getAmount());
			
			cart.put(String.valueOf(cartDTO.getProduct_id()), cartDTO);
			
			session.setAttribute("cart_add", cart);
			
		}else{
			//처음으로 장바구니에 담은 물건일경우
			logger.info("처음으로 장바구니에 담은 물건일경우");
			Map<String, Object> map =new HashMap<>();
			
			cartDTO.setMoney(cartDTO.getPrice()*cartDTO.getAmount());
			map.put(String.valueOf(cartDTO.getProduct_id()), cartDTO);
			
			session.setAttribute("cart_add", map);			
		}
		
		return "redirect:/cart/cart_list";
	}
	
	
	@RequestMapping(value="/cart_list", method=RequestMethod.GET)
	public String cart_list(HttpSession session, Model model){
		
		logger.info("cart_list  호출");
		
		MemberDTO  member =(MemberDTO)session.getAttribute("loginUser");
		
		//로그인 한 유저가 있으면
		if(member!=null){
			
			//비 로그인 유저를 위한 카트 세션을 지운다.
			session.removeAttribute("cart_add");
	
			List<CartDTO> userCart =cartDAO.getList(member.getUserid());
			model.addAttribute("userCart", userCart);
		}
		
		
		return "/cart/cart_list";
	}
	
	
}



