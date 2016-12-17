package com.example.wbe04.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtils {

	
	private static Map<String, MediaType> mediaMap;
	
	static{
		mediaMap=new HashMap<>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("JPEG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
		
	}
	
	
	
	public static MediaType getMediaType(String type){
		return mediaMap.get(type.toUpperCase());
	}
	
	
	//이미지 매치
	public static boolean imageMatch(String image){
		
		boolean result =false;
		
		if(image.equals("JPG")){
			result=true;
		}else if(image.equals("JPEG")){
			result=true;
		}else if(image.equals("GIF")){
			result=true;
		}else if(image.equals("PNG")){
			result=true;
		}
		return result;
	}
	
	
}
