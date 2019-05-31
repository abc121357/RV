package bitcamp.baby.ch7.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.GogakVO;
import bitcamp.baby.ch7.video.vo.RentReturnVO;
import bitcamp.baby.ch7.video.vo.VideoVO;
import bitcamp.baby.common.ConnPropertyOraUser;

public class RentReturnDAOImpl3 {
	
/*
	@Override
	public ArrayList selectRentReturn(RentReturnVO vo) {
		// TODO Auto-generated method stub
		// 지역변수 초기화
		ArrayList aList=null;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		c = ConnPropertyOraUser.getConnection();
		try {
			ps = c.prepareStatement(RentReturnDAOImpl.SELECT_QUERY);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public boolean insertRentReturn(GogakVO gVo, VideoVO vVo, RentReturnVO rVo) {
		// TODO Auto-generated method stub
		boolean bi=false;
		try{
		bi=RentReturnDAOImpl.insertRentReturn(gVo, vVo, rVo);
		}catch(SQLException e){
			
		}
		
		return bi;
	}

	@Override
	public int updateRentReturn(RentReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRentReturn(RentReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	*/
}// end of RentReturnDAOImpl class
