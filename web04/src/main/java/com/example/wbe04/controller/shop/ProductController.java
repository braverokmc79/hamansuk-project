package com.example.wbe04.controller.shop;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		String url=formData(dto, request, 1);
		return  url;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/product_write_save", method=RequestMethod.POST)
	public ResponseEntity<String> product_write_save( ProductDTO dto, HttpServletRequest request){
		
		logger.info("ajax 전송");
		
		ResponseEntity<String> entity=null;
		
		String url ="/";
		try {	 
			url=formData(dto, request, 1);
			
			if(url.equals("error")){
				entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}else{
				entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			}
				
		} catch (Exception e) {
			logger.info(e.getMessage());
			entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	
	
	public String formData( ProductDTO dto, HttpServletRequest request, int W) throws Exception{
		
		String url ="/";		
		
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

		//1이면 업로드 2이면 업데이트
		int result=0;
		if(W==1){
		  
		  result=productDAO.product_write(dto);
		  logger.info("업데이트 완료");
		}else{
			result=productDAO.product_edit(dto);
			logger.info("수정 완료");
		}
		
		if(result==1){
			//업로드가 되었다.
			logger.info("업로드 성공");
			url = "redirect:product_list";
		}else{
			logger.info("업로드 실패");
			url ="error";
			
		}
	
		return url;
	}
	
	
	
	@RequestMapping(value="/product_edit/{id}",  method=RequestMethod.GET)
	public String  productEdit(@ModelAttribute("id") Integer id, Model model){
		
		logger.info("상품 수정");
		
		ProductDTO dto =productDAO.productDetail(id);
		model.addAttribute("dto", dto);
		logger.info("상품 이미지 주소 : " + dto.getPicture_url());
		return "/shop/product_edit";
		
	}
	
	
	
	@RequestMapping(value="/product_update",  method=RequestMethod.POST)
	public String  productEdit(@ModelAttribute("dto") ProductDTO dto,  HttpServletRequest request, Model model, RedirectAttributes rttr) {
		
		logger.info("상품 수정 POST");
		
		try{
			logger.info(dto.getFile1().getOriginalFilename() +" : 이미지 이름 길이" + dto.getFile1().getOriginalFilename().length());
			
			if(dto.getFile1().getOriginalFilename().length() > 3){
				//파일을 다시 업로드 한 경우
				
				// 1.기존 이미지   삭제
				imageDelete(dto, request );
				 
				 
				 //2. 다시 업로드
				formData(dto, request, 2);
				
				return "redirect:product_list";
			}else{
			
				//파일을 업로드 하지 않고 기존의 이미지 사용할 경우	
				logger.info("기존 이미지 사용 ");
				int result=productDAO.product_edit(dto);
				if(result==1){
					//업로드가 되었다.
					logger.info("업로드 성공");
					return "redirect:product_list";
				}else{
					logger.info("업로드 실패");
					return "redirect:/shop/product_edit/"+dto.getProduct_id();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.info("업로드 실패");
			
			return "redirect:/shop/product_edit/"+dto.getProduct_id();
		}
		
	}
	
	
	@RequestMapping(value="/product_delete", method=RequestMethod.POST)
	public String productDelete(@RequestParam("proudctId") int proudctId,  HttpServletRequest request) throws Exception{
		logger.info(" productDelete ()");
		//상품 정보 불러오기
		ProductDTO dto =productDAO.productDetail(proudctId);
	
		logger.info("이미지 삭제");
		// 이미지  삭제
		imageDelete(dto, request );
		
		logger.info("DB삭제");
		//DB삭제
		productDAO.productDelete(proudctId);
		
		return "redirect:product_list";
	}
	
	
	
	
	//이미지 삭제 메소드
	public void imageDelete(ProductDTO dto, HttpServletRequest request) {
		
		try {
			//1.기존의 파일 삭제 
	        //원본 이미지 삭제
			logger.info("기존 이미지 삭제");
			 String original=dto.getOriginal_picture_url(); //18번째 시작 위치
			 // DB 중복 된 resources/upload/ 삭제 하기
			 
			 String path =UploadPath.path(request);
			 logger.info("original = " +original);
			 if(original!=null){
				 logger.info("원본 파일 삭제" + original.substring(18));
				 logger.info("원본 파일 삭제 주소 : "+ path +original.substring(18).replace('/', File.separatorChar));
				 new File(path +original.substring(18).replace('/', File.separatorChar)).delete();
				 
			 }
			   		 
			 
			 //썸네일 이미지 삭제
	        String thumnail=dto.getPicture_url();
			 if(thumnail!=null){
				 logger.info("썸네일 파일 삭제");
				 new File(path +thumnail.substring(18).replace('/', File.separatorChar)).delete();
				 logger.info("썸네일 파일 삭제 주소 : "+ path +thumnail.substring(18).replace('/', File.separatorChar));
			 }   
		}catch(Exception e){
			e.printStackTrace();
			logger.info("이미지 디렉토리 삭제 실패");
		}
		
	}
	
	
	
	
	
}





