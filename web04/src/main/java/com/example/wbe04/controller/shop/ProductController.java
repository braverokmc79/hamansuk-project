package com.example.wbe04.controller.shop;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.wbe04.model.shop.dao.ProductDAO;
import com.example.wbe04.model.shop.dto.ProductDTO;
import com.example.wbe04.util.MediaUtils;
import com.example.wbe04.util.UploadFileUtils;
import com.example.wbe04.util.UploadPath;

@Controller
@RequestMapping(value="/shop")
public class ProductController {

	
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	
	@Inject
	private ProductDAO productDAO ;
	
	
	@RequestMapping(value="/product_list" , method=RequestMethod.GET)
	public void product_list(Model model){
		
		logger.info("product_list 호출....");
		model.addAttribute("list", productDAO.productList());	
	}
	
	
	
	@RequestMapping(value="/product_detail", method=RequestMethod.GET)
	public void product_detail(int product_id, Model model){
		//@RequestParam 변수 =>request.getParameter("변수");  @RequestParam 도 생략 가능
		logger.info("product_detail 호출...");
		
		model.addAttribute("dto", productDAO.productDetail(product_id));
	}
	
	
	//Post 방식으로 호출시에만 등록 페이지 이동
	@RequestMapping(value="/product_write", method=RequestMethod.POST)
	public void product_wirte(){
		
	}
	//GET 방식으로 호출 되면 메인 이동
	@RequestMapping(value="/product_write", method=RequestMethod.GET)
	public void product_wirte2(){
		product_wirte();
	}
	
	
	
	//파일 업로드 처리
	@RequestMapping(value="/product_write_w", method=RequestMethod.POST , produces="text/plain;charset=UTF-8")
	public String product_writeW(@ModelAttribute("dto") ProductDTO dto, HttpServletRequest request, Model model, RedirectAttributes rttr) throws Exception{
		logger.info("파일 업로드");
		logger.info(dto.toString());
		
		
		if(dto.getDescription().trim().length()==0 || dto.getDescription()==null){
			rttr.addFlashAttribute("uploadError", "상품 내용을  작성해 주세요");
			return "redirect:/shop/product_write";
		}else if(dto.getProduct_name().trim().length()==0 || dto.getProduct_name()==null){
			rttr.addFlashAttribute("uploadError", "상품 이름을 작성해 주세요");
			return "redirect:/shop/product_write";
		}else if(dto.getPrice()==null){
			rttr.addFlashAttribute("uploadError", "상품 가격을 작성해 주세요");
			return "redirect:/shop/product_write";
		}else if(dto.getFile1()==null){
			rttr.addFlashAttribute("uploadError", "상품 파일 이미지를 올려 주세요");
			return "redirect:/shop/product_write";
		}
		
		MultipartFile file =dto.getFile1();	
		//썸네일 크기 셋팅
		UploadFileUtils.setThumSize(180);
		String   uploadedFileName=UploadFileUtils.uploadFile(UploadPath.path(request), file.getOriginalFilename() , file.getBytes());
		
		//썸네일 크기 셋팅
		
		//업로드 된 파일 이름
		// uploadPath + uploadedFileName
		
		logger.info("업로드 된 파일 이름 : " +uploadedFileName);
		
		//썸네일 이미지 셋팅
		dto.setPicture_url("/resources/upload"  +uploadedFileName);
	
		//EX)  resources/upload +/2016/12/17/s_99ef854e-d99d-41f7-acf2-e3bf13895d45_page1-img7.jpg
		
		//이미지 인지 확인 이미지 이면 원본 이미지 저장
		int imageIdx =uploadedFileName.lastIndexOf('.');
		logger.info("imageIdx : " + imageIdx + " uploadedFileName.toUpperCase()) :" + uploadedFileName.substring(imageIdx+1).toUpperCase());
		if(MediaUtils.imageMatch(uploadedFileName.substring(imageIdx+1).toUpperCase())){
			String front =uploadedFileName.substring(0, 12);
			String end=uploadedFileName.substring(14);
			dto.setOriginal_picture_url("/resources/upload" +front+end);
		}
	
		
		int result=productDAO.product_write(dto);
		
		if(result==1){
			//업로드가 되었다.
			logger.info("업로드 성공");
			return "redirect:product_list";
		}else{
			logger.info("업로드 실패");
			rttr.addFlashAttribute("uploadError", "업로드에 실패 했습니다.");
			return "/shop/product_write";
		}
		
	}
	
	
	
	
}





