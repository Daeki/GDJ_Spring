package com.winter.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

//DAO 보내기전 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	//delete
	public int delete(RegionDTO regionDTO)throws Exception{
		return regionDAO.delete(regionDTO);
	} 
	
	
	//update
	public int update(RegionDTO regionDTO)throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	//insert
	public int add(RegionDTO regionDTO)throws Exception{
		return regionDAO.add(regionDTO);
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
