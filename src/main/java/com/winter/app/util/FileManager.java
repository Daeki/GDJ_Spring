package com.winter.app.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileManager {
	
	
	
	public void fileSave(String path, MultipartFile file)throws Exception{
		File f = new File("/resources/upload");		
		
		f= new File(f, path);
		
		if(f.isFile()) {
			throw new Exception();
			//return;
		}
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		//2. 어떤 파일명으로 저장할 것인가??
		//a. 시간 사용
		Calendar ca = Calendar.getInstance();
		String fileName=ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		System.out.println(fileName);
		//b. UUID
		fileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println(fileName);
		
		//3. 파일을 저장
		//a. FileCopyUtils 클래스 사용
		f= new File(f, fileName);
		FileCopyUtils.copy(file.getBytes(), f);
		
	}

}
