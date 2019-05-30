	package bitcamp.baby.ch7.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.VideoVO;
import bitcamp.baby.common.ChaeBun;
import bitcamp.baby.common.ConnPropertyOraUser;
import bitcamp.baby.sql.VideoSqlMap;

public class VideoDaoImpl implements VideoDao{

	@Override
	public ArrayList selectVideo(VideoVO vo) {
		ArrayList aList=null;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		c=ConnPropertyOraUser.getConnection();
		try{
		ps=c.prepareStatement(VideoSqlMap.getSelectQuery());
		ps.setString(1, vo.getV_Code());
		
		rs=ps.executeQuery();
		
		if(rs!=null){
			aList=new ArrayList();
			
			while(rs.next()){
			//aList�� vo�� ������ �ֱ� ����..
			vo=new VideoVO();
			vo.setV_Code((rs.getString(1)));
			vo.setV_Title(rs.getString(2));
			vo.setV_Genre(rs.getString(3));
			vo.setV_Pay(rs.getInt(4));
			vo.setV_RentState(rs.getString(5));
			vo.setV_MakeCompany(rs.getString(6));
			vo.setV_MakeDate(rs.getString(7));
			vo.setV_ViewAge(rs.getInt(8));
			vo.setCreateDate(rs.getString(9));
			vo.setUpdateDate(rs.getString(10));
			aList.add(vo);
			
			
			
			}
			
			
			
		}
		
		if(c!=null){
			ConnPropertyOraUser.conClose(c, ps, rs);
		}
		
		
		}catch(SQLException e){
			System.out.println("�˻��ϴµ� ������ �߻��߽��ϴ�. ���� ���� : " + e);
			e.printStackTrace();
		}finally{
			ConnPropertyOraUser.conClose(c, ps, rs);
		}
		
		
		
		
		return aList;
	}

	@Override
	public int insertVideo(VideoVO vo) {
		Connection c=null;
		PreparedStatement ps=null;
		int nCnt=0;
		c=ConnPropertyOraUser.getConnection();
		
		try{
		c.setAutoCommit(false);
		ps=c.prepareStatement(VideoSqlMap.getInsertQuery());
		ps.setString(1, ChaeBun.commV());
		ps.setString(2, vo.getV_Title());
		ps.setString(3, vo.getV_Genre());
		ps.setInt(4, vo.getV_Pay());
		ps.setString(5, vo.getV_MakeCompany());
		ps.setString(6, vo.getV_MakeDate());
		ps.setInt(7, vo.getV_ViewAge());
		nCnt = ps.executeUpdate();
		
		if(nCnt>0){
			c.commit();
			ConnPropertyOraUser.conClose(c, ps);
		}
		
		
		}catch(SQLException e){	
			System.out.println("���� �����ϴµ� ������ �߻��Ͽ����ϴ�. ���� ���� : "+ e);
			e.printStackTrace();
		}finally{
			ConnPropertyOraUser.conClose(c, ps);
		}
		
		return nCnt;
	}

	@Override
	public int updateVideo(VideoVO vo) {
		
		Connection c=null;
		PreparedStatement ps=null;
		int nCnt=0;
		
		c=ConnPropertyOraUser.getConnection();
		
		try{
		c.setAutoCommit(false);
		ps=c.prepareStatement(VideoSqlMap.getUpdateQuery());
		ps.setInt(1, vo.getV_Pay());	
		ps.setString(2, vo.getV_Code());
		nCnt=ps.executeUpdate();
		if(nCnt>0){
			c.commit();
			ConnPropertyOraUser.conClose(c, ps);
		}
		
		
		}catch(SQLException e){
			System.out.println("������ �����ϴµ� ������ �߻��߽��ϴ�. "+e);
			
		}finally{
			ConnPropertyOraUser.conClose(c, ps);
		}
		
		
		
		return nCnt;
	}

	@Override
	public int DeleteVideo(VideoVO vo) {
		
		Connection c=null;
		PreparedStatement ps=null;
		int nCnt=0;
		
		c=ConnPropertyOraUser.getConnection();
		try{
			c.setAutoCommit(false);
			ps=c.prepareStatement(VideoSqlMap.getDeleteQuery());
			ps.setString(1, vo.getV_Code());
			nCnt=ps.executeUpdate();
			
			if(nCnt>0){
				c.commit();
				ConnPropertyOraUser.conClose(c, ps);
				
			}
			
			
		}catch(SQLException e){
			System.out.println("������ �����ϴµ� ������ �߻��޽��ϴ�. ���� ���� : " + e);
		}
		
		
		
		
		return nCnt;
	}


	
	
	
	
	
	
}
