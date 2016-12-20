package com.example.wbe04.controller.shop;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		MemberDTO member=(MemberDTO)session.getAttribute("loginUser");
	
		
			try {
				  logger.info("로그인 한 1유저");
					if(member!=null ){
						logger.info("로그인 2한 유저" + cartDTO.getIdx() + " amount :" +cartDTO.getAmount());
						
						CartDTO dto =new CartDTO(cartDTO.getProduct_id(), member.getUserid(), cartDTO.getAmount());
						logger.info("로그인 3한 유저");
						cartDAO.cartAdd(dto);
						return "redirect:/cart/cart_list";
					}			
				
					//cartDAO.cartAdd(dto);	
					//로그인 하지 않는 유저 확인 세션에 담기	
					logger.info("비로그인 한 유저");
					
					
				
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
						//  처음으로 장바구니에 담은 물건일경우 DB에 담는 것이 아니라 idx 값이 없다. key 값으로 getProduct_id 사용  
						logger.info("처음으로 장바구니에 담은 물건일경우");
						Map<String, Object> map =new HashMap<>();
						
						cartDTO.setMoney(cartDTO.getPrice()*cartDTO.getAmount());
						map.put(String.valueOf(cartDTO.getProduct_id()), cartDTO);
						
						session.setAttribute("cart_add", map);			
					}
					
					return "redirect:/cart/cart_list";
					
					
			} catch (Exception e) {
				// TODO: handle exception	
				logger.info(e.getMessage());
				logger.info(member.toString());
				return "redirect:/cart/cart_list";
			}
			

	}
	
	
	@RequestMapping(value="/cart_list", method=RequestMethod.GET)
	public String cart_list(HttpSession session, Model model){
		
		logger.info("cart_list  호출");
		
		MemberDTO  member =(MemberDTO)session.getAttribute("loginUser");
		
		//로그인 한 유저가 있으면
		if(member!=null){
			logger.info("cart_list  호출 member null 이 아니다");
			//비 로그인 유저를 위한 카트 세션을 지운다.
			session.removeAttribute("cart_add");
	
			List<CartDTO> userCart =cartDAO.getList(member.getUserid());
			model.addAttribute("userCart", userCart);
		}
		return "/cart/cart_list";
	}
	
	
	//로그인 한 유저 카드 삭제
	@RequestMapping(value="/delete1/{idx}/{str}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idx") Integer idx, @PathVariable("str") String str){
		logger.info(" delete 호출" + idx + " : " +str);
		
		ResponseEntity<String> entity =null;
		try {
			
			
			cartDAO.delete(idx);
			
			entity=new ResponseEntity<>( "SUCCESS" ,HttpStatus.OK);
			
		} catch (Exception e) {
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity; 
	}
	
	
	//비 로그인 한 유저 카트 삭제
	@RequestMapping(value="/delete2/{idx}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idx") Integer idx, HttpSession session){
		logger.info(" delete 호출" + idx + " : " );
		
		ResponseEntity<String> entity =null;
		try {
			
			HashMap<String, CartDTO> cartMap=(HashMap<String, CartDTO>)session.getAttribute("cart_add");
			
			if(cartMap!=null){
			   
			    
				Iterator iterator =cartMap.keySet().iterator();
				while(iterator.hasNext()){
				
					String key = (String)iterator.next();
					
					CartDTO dto =(CartDTO)cartMap.get(key);
					logger.info( "선택 한 키값 idx :" +idx +" 현재 key 아이템 : " +key );
					
					if(key.equals(String.valueOf(idx))){
						logger.info(" idx 삭제");
						iterator.remove();
					}

				}					
			}
		
			entity=new ResponseEntity<>( "SUCCESS" ,HttpStatus.OK);
			
		} catch (Exception e) {
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity; 
	}
	
	//로그인 한 유저 카트 전부 삭제
	@RequestMapping(value="/cartdelAll2/{userid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> cartDelAll( @PathVariable("userid") String userid){
		logger.info(" cartDelAll 호출" + userid );
		
		ResponseEntity<String> entity =null;
		try {
			
			cartDAO.cartDelAll(userid);
			
			entity=new ResponseEntity<>( "SUCCESS" ,HttpStatus.OK);
			
		} catch (Exception e) {
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity; 
	}
	
	
	
	//비 로그인 한 유저 카트 전부 삭제
	@RequestMapping("/cartdelAll")
	public String cartDelAll(HttpSession session){
		
		session.removeAttribute("cart_add");
		return "redirect:/cart/cart_list";
	}
	
	
	
	
}



