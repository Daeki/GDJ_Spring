package com.winter.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnector;

@Repository
public class RegionDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.winter.app.regions.RegionDAO.";
	
	
	//update
	public int update(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql="UPDATE REGIONS SET REGION_NAME=? WHERE REGION_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, regionDTO.getRegion_name());
		st.setInt(2, regionDTO.getRegion_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	//Insert
	public int add(RegionDTO regionDTO)throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "INSERT INTO REGIONS VALUES(?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception{
		return sqlSession.selectOne(namespace+"getDetail", regionDTO);
	}
	
	public List<RegionDTO> getList() throws Exception {
		return sqlSession.selectList(namespace+"getList");
	}

}
