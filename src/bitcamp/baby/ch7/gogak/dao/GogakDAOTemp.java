package bitcamp.baby.ch7.gogak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.GogakVO;
import bitcamp.baby.common.ConnPropertyOraUser;

public class GogakDAOTemp {

	
	GogakVO vo;
	public ArrayList gogakDAOTemp(GogakSelectImpl gogak){
		
		ArrayList aList=null;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		GogakVO vo=new GogakVO();
		
		c=ConnPropertyOraUser.getConnection();
		try{
			ps=gogak.getQuery(c);
			ps.setInt(1, vo.getG_Code());
			rs=ps.executeQuery();
			if(rs!=null){
				aList=new ArrayList();
				vo=new GogakVO();
				while(rs.next()){
					vo.setG_Code(Integer.parseInt(rs.getString("G_Code")));
					vo.setG_Name(rs.getString(2));
					vo.setG_Age(rs.getInt(3));
					vo.setG_Addr(rs.getString(4));
					vo.setG_Tel(rs.getString(5));
					vo.setG_DeleteYN(rs.getString(6));
					vo.setG_CreateDate(rs.getString(7));
					vo.setG_UpdateDate(rs.getString(8));
					aList.add(vo);
				}
			}
			}catch(SQLException e){
				System.out.println("고객정보를 선택하는데 문제가 발생했습니다. 문제 사유 : " + e);
				e.printStackTrace();
				}finally{
					ConnPropertyOraUser.conClose(c, ps, rs);
				}
		return aList;
	}
	
}
