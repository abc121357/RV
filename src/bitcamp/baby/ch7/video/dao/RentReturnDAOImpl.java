package bitcamp.baby.ch7.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitcamp.baby.ch7.video.vo.GogakVO;
import bitcamp.baby.ch7.video.vo.RentReturnVO;
import bitcamp.baby.ch7.video.vo.VideoVO;
import bitcamp.baby.common.ChaeBun;
import bitcamp.baby.common.ConnPropertyOraUser;
import bitcamp.baby.sql.RentReturnSqlMap;

public class RentReturnDAOImpl implements RentReturnDAO {

	
	
	
	
	
    @Override
	public ArrayList selectRentReturn(RentReturnVO vo) {
    	
    	Boolean s = false;
    	Connection c= null;
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	ArrayList aList=null;
    	
    	c=ConnPropertyOraUser.getConnection();
    	try{
    	ps=c.prepareStatement(RentReturnSqlMap.SELECT_QUERY);
    	ps.setString(1, vo.getR_Code());
    	rs=ps.executeQuery();
    	
    	if(rs!=null){
    		aList=new ArrayList();
    		
    		while(rs.next()){
	    		RentReturnVO vvo=null;	
	    		
	    		vvo=new RentReturnVO();
	    		
	    		vvo.setR_Code(rs.getString(1));
	    		vvo.setG_Code(rs.getString(2));
	    		vvo.setV_Code(rs.getString(3));
	    		vvo.setR_RentDate(rs.getString(4));
	    		vvo.setR_PlanDate(rs.getString(5));
	    		vvo.setR_ReturnDate(rs.getString(6));
	    		vvo.setR_TotalPay(rs.getInt(7));
	    		vvo.setR_OverDueDate(rs.getInt(8));
	    		vvo.setDeleteYN(rs.getString(9));
	    		vvo.setCreateDate(rs.getString(10));
	    		vvo.setUpdateDate(rs.getString(11));
	    		
	    		aList.add(vvo);
	    		
    		}
    		
    	}
    	
    	if(c!=null){
    	ConnPropertyOraUser.conClose(c, ps, rs);
    	}
    	}catch(SQLException e){
    		System.out.println("디비연결 또는 쿼리에 문제가 있어요"+e);
    		
    	}finally{
    		try{
    			ConnPropertyOraUser.conClose(c, ps, rs);
    		}catch(Exception e2){
    			e2.printStackTrace();
    		}
    	}
    	
    	return aList;
	}

	@Override
	public boolean insertRentReturn(GogakVO gVo, VideoVO vVo, RentReturnVO rVo) {
		boolean bi=false;
    	
    	Connection c=null;
    	PreparedStatement psI= null;
    	PreparedStatement psU= null;
    	int nCntI=0;
    	int nCntU=0;
    	int nCnt=0;
    	
    	try {
			c=ConnPropertyOraUser.getConnection();
			System.out.println("c >>> : " + c);
			System.out.println("c.getAutoCommit() >>> : " 
			                     + c.getAutoCommit());
			c.setAutoCommit(false);
			
			psI=c.prepareStatement(RentReturnSqlMap.INSERT_QUERY);
			psI.setString(1, ChaeBun.commR());
			psI.setString(2, gVo.getG_Code());
			psI.setString(3, vVo.getV_Code());
			psI.setString(4, vVo.getV_Code());
			System.out.println(gVo.getG_Code());
			System.out.println(vVo.getV_Code());
			nCntI=psI.executeUpdate();
			System.out.println(nCntI);
			
			psU=c.prepareStatement(RentReturnSqlMap.INSERT_UPDATE_QUERY);
			psU.setString(1, vVo.getV_Code());
			nCntU=psU.executeUpdate();
			
			nCnt=nCntI+nCntU;
			System.out.println(nCnt);
			if (nCnt>=2) {
				c.commit();
				ConnPropertyOraUser.conClose(c, psI);
				ConnPropertyOraUser.conClose(c, psU);
				
				bi=true;
			}
			
			
			
		} catch (SQLException s) {
			// TODO: handle exception
			System.out.println("DB 연결 또는 쿼리에 문제가 있습니다 >>> : " + s);
			s.printStackTrace();
		try{
			c.rollback();
		}catch(SQLException e){
			
		}
		
			
		}finally{
			try{
			ConnPropertyOraUser.conClose(c, psI);
			ConnPropertyOraUser.conClose(c, psU);
		}catch(Exception ex){
			
		}
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

}