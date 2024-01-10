package com.winter.app.regions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

//DAO 보내기전 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	//내장 객체 중 application
	private ServletContext servletContext;
	
	//delete
	public int delete(RegionDTO regionDTO)throws Exception{
		return regionDAO.delete(regionDTO);
	} 
	
	
	//update
	public int update(RegionDTO regionDTO)throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	//insert
	public int add(RegionDTO regionDTO, MultipartFile file)throws Exception{
		
		//1. 어디에 저장할 것인가??
		String path = servletContext.getRealPath("/resources/upload");
		
		System.out.println(path);
		File f = new File(path, "regions");
		
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
		
		//4. DB에 정보 저장
		
		return 0;//regionDAO.add(regionDTO);
	}
	
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception{
		return regionDAO.getDetail(regionDTO);
	}
	
	//list
	public List<RegionDTO> getList(Pager pager)throws Exception{
		pager.makeRow();
		Long totalCount=regionDAO.getTotal(pager);
		System.out.println(totalCount);

		pager.makeNum(totalCount);
		
		List<RegionDTO> ar = this.regionDAO.getList(pager);
		
		return ar;
	}
	
	
	

}
