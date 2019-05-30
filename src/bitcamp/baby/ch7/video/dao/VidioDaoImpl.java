package bitcamp.baby.ch7.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.VidioVO;
import bitcamp.baby.common.Chaebun;
import bitcamp.baby.common.ConnProperty;

public class VidioDaoImpl implements VidioDao{

	@Override
	public ArrayList selectVidio(VidioVO vo) {
		ArrayList aList=null;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		c=ConnProperty.getConnection();
		try{
		ps=c.prepareStatement(VidioSqlMap.getSelectQuery());
		ps.setString(1, vo.getV_Code());
		
		rs=ps.executeQuery();
		
		if(rs!=null){
			aList=new ArrayList();
			
			while(rs.next()){
			//aList에 vo의 내용을 넣기 위해..
			vo=new VidioVO();
			vo.setV_Code((rs.getString(1)));
			vo.setV_Title(rs.getString(2));
			vo.setV_Genre(rs.getString(3));
			vo.setV_Pay(rs.getInt(4));
			vo.setV_RentState(rs.getInt(5));
			vo.setV_MakeCompany(rs.getString(6));
			vo.setV_MakeDate(rs.getString(7));
			vo.setV_ViewAge(rs.getInt(8));
			vo.setCreateDate(rs.getString(9));
			vo.setUpdateDate(rs.getString(10));
			aList.add(vo);
			
			
			
			}
			
			
			
		}
		
		if(c!=null){
			ConnProperty.conClose(c, ps, rs);
		}
		
		
		}catch(SQLException e){
			System.out.println("검색하는데 문제가 발생했습니다. 문제 이유 : " + e);
			e.printStackTrace();
		}finally{
			ConnProperty.conClose(c, ps, rs);
		}
		
		
		
		
		return aList;
	}

	@Override
	public int insertVidio(VidioVO vo) {
		Connection c=null;
		PreparedStatement ps=null;
		int nCnt=0;
		c=ConnProperty.getConnection();
		
		try{
		c.setAutoCommit(false);
		ps=c.prepareStatement(VidioSqlMap.getInsertQuery());
		ps.setString(1, Chaebun.commonNo());
		ps.setString(2, vo.getV_Title());
		ps.setString(3, vo.getV_Genre());
		ps.setInt(4, vo.getV_Pay());
		ps.setInt(5, vo.getV_RentState());
		ps.setString(6, vo.getV_MakeCompany());
		ps.setString(7, vo.getV_MakeDate());
		ps.setInt(8, vo.getV_ViewAge());
		nCnt = ps.executeUpdate();
		
		if(nCnt>0){
			c.commit();
			ConnProperty.conClose(c, ps);
		}
		
		
		}catch(SQLException e){	
			System.out.println("값을 삽입하는데 문제가 발생하였습니다. 문제 이유 : "+ e);
			e.printStackTrace();
		}finally{
			ConnProperty.conClose(c, ps);
		}
		
		return nCnt;
	}

	@Override
	public int updateVidio(VidioVO vo) {
		
		Connection c=null;
		PreparedStatement ps=null;
		int nCnt=0;
		
		c=ConnProperty.getConnection();
		
		try{
		c.setAutoCommit(false);
		ps=c.prepareStatement(VidioSqlMap.getUpdateQuery());
		ps.setInt(1, vo.getV_RentState());	
		ps.setString(2, vo.getV_Code());
		nCnt=ps.executeUpdate();
		if(nCnt>0){
			c.commit();
			ConnProperty.conClose(c, ps);
		}
		
		
		}catch(SQLException e){
			System.out.println("내용을 수정하는데 문제가 발생했습니다. "+e);
		}finally{
			ConnProperty.conClose(c, ps);
		}
		
		
		
		return nCnt;
	}

	@Override
	public int DeleteVidio(VidioVO vo) {
		
		Connection c=null;
		PreparedStatement ps=null;
		int nCnt=0;
		
		c=ConnProperty.getConnection();
		try{
			c.setAutoCommit(false);
			ps=c.prepareStatement(VidioSqlMap.getDeleteQuery());
			ps.setString(1, vo.getV_Code());
			nCnt=ps.executeUpdate();
			
			if(nCnt>0){
				c.commit();
				ConnProperty.conClose(c, ps);
				
			}
			
			
		}catch(SQLException e){
			System.out.println("내용을 삭제하는데 문제가 발생햇습니다. 문제 사유 : " + e);
		}
		
		
		
		
		return nCnt;
	}


	
	
	
	
	
	
}
