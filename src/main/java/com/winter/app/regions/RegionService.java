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

import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;

//DAO 보내기전 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	//내장 객체 중 application
	private ServletContext servletContext;
	
	//delete
	public int delete(RegionDTO regionDTO)throws Exception{
		//파일명 조회
		List<RegionFileDTO> ar = regionDAO.getListFiles(regionDTO);

		//DB에서 삭제
		int result =regionDAO.delete(regionDTO);
		
		//경로 생성
		String path=servletContext.getRealPath("/resources/upload/regions/");
		
		for(RegionFileDTO f:ar) {
			path=path+f.getFileName();
			//HDD에서 삭제
			fileManager.fileDelete(path);
		}
		
		return result;
	} 
	
	
	//update
	public int update(RegionDTO regionDTO)throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	//insert
	public int add(RegionDTO regionDTO, MultipartFile [] file)throws Exception{
		
		int result =regionDAO.add(regionDTO);
		//1. 어디에 저장할 것인가??
		String path = servletContext.getRealPath("/resources/upload/regions");
		
		for(MultipartFile f : file) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
		

		
		//4. DB에 정보 저장
			RegionFileDTO dto = new RegionFileDTO();
			dto.setFileName(fileName);
			dto.setOriName(f.getOriginalFilename());
			dto.setRegion_id(regionDTO.getRegion_id());
			result = regionDAO.addFile(dto);
		}
		return result;//;
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
