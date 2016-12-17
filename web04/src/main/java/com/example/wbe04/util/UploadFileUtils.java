package com.example.wbe04.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageOutputStream;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	private static final Logger logger =LoggerFactory.getLogger(UploadFileUtils.class);

	private static int thumSize=100;

	public static void setThumSize(int thumSize) {
		UploadFileUtils.thumSize = thumSize;
	}
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		
		logger.info("UploadFileUtils 클래스 시작 uploadPath ="+ uploadPath);
		
		UUID uid =UUID.randomUUID();
		
		String savedName =uid.toString() + "_" +originalName;
		
		String savedPath =calcPath(uploadPath);
		
		File target=new File(uploadPath +savedPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		String formatName =originalName.substring(originalName.lastIndexOf(".")+1);
		
		String uploadedFileName =null;
		
		if(MediaUtils.getMediaType(formatName)!=null){
			uploadedFileName =makeThumbnail(uploadPath, savedPath, savedName);
		}else{
			uploadedFileName =makeIcon(uploadPath, savedPath, savedName);
		}
		
		
		return uploadedFileName;
	}
	
	
	
	private static String makeIcon(String uploadPath, String savedPath, String savedName) {
		// TODO Auto-generated method stub
		
		String iconName =uploadPath +savedPath +savedName;
		
		String result=iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	  logger.info("  makeThumbnail  반환값  :  " + result);
		return result;
	}



	private static String calcPath(String uploadPath){
		
		logger.info("calcePath 시작 :");
		Calendar cal =Calendar.getInstance();
		
		String yearPath=File.separator + cal.get(Calendar.YEAR);
		
		String monthPath=yearPath + File.separator +new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		
		String datePath =monthPath + File.separator +new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath , yearPath, monthPath, datePath);
		logger.info(datePath);
		
		return datePath;
	}
	
	
	private static void makeDir(String uploadPath, String...paths){
		logger.info("makeDir 시작");
		if(new File(paths[paths.length-1]).exists()){
			return;
		}
		
		for(String path : paths){
			File dirPath =new File(uploadPath + path);
			if(! dirPath.exists()){
				dirPath.mkdir();
			}
		}
	}
	
	
	//썸네일
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
		
		BufferedImage sourceImg =ImageIO.read(new File(uploadPath+path, fileName));
		
		BufferedImage destImg =Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, thumSize);
		
		String thumbnailName =uploadPath +path +File.separator+"s_" + fileName;
		
		File newFile =new File(thumbnailName);
		
		String formatName =fileName.substring(fileName.lastIndexOf(".")+1);
		
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		//logger.info("  makeThumbnail  반환값  :  " + thumbnailName.replace(File.separatorChar,'/' ));
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar,'/' );
		
	}
	
	
	
	
	
	
}
