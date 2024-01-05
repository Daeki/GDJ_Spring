package com.winter.app.regions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;

public class RegionDAOTest extends MyTest {

	@Autowired
	private RegionDAO regionDAO;
	
	@Test
	public void addTest()throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		
		regionDTO.setRegion_name("Test");
		int result = regionDAO.add(regionDTO);
		
		assertEquals(1, result);
		
		
	}
	
	@Test
	public void getListTest()throws Exception{
		List<RegionDTO> ar = regionDAO.getList();
		assertEquals(0, ar.size());
	}
	
	@Test
	public void getDetailTest()throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(1);
		regionDTO = regionDAO.getDetail(regionDTO);
		
		assertNotNull(regionDTO);
		
	}

	
	

}
