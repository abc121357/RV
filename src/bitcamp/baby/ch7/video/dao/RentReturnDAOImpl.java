package bitcamp.baby.ch7.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.RentReturnVO;
import bitcamp.baby.common.ConnPropertyOraUser;

public class RentReturnDAOImpl implements RentReturnDAO{

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
			ps = c.prepareStatement(sql)
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public int insertRentReturn(RentReturnVO vo) {
		// TODO Auto-generated method stub
		return 0;
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

	
	
	
}// end of RentReturnDAOImpl class
