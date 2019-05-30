	package bitcamp.baby.ch7.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.baby.ch7.gogak.dao.GogakDAOTemp;
import bitcamp.baby.ch7.gogak.dao.GogakSelectImpl;
import bitcamp.baby.ch7.video.vo.GogakVO;
import bitcamp.baby.common.ChaeBun;
import bitcamp.baby.common.ConnPropertyOraUser;
import bitcamp.baby.sql.GogakSqlMap;

public class GogakDAOImpl implements GogakDAO {

	Scanner sc=null;
	
	@Override
	public ArrayList selectGogak(GogakVO vo) {
		ArrayList aList=null;
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//getConnection함수 호출
		c=ConnPropertyOraUser.getConnection();
	
				try{
			ps=c.prepareStatement(GogakSqlMap.getSelectQuery());
			ps.setString(1, vo.getG_Code());
			rs=ps.executeQuery();
			if(rs!=null){
				aList=new ArrayList();
				while(rs.next()){
					vo.setG_Code(rs.getString(1));
					vo.setG_Name(rs.getString(2));
					vo.setG_Age(rs.getInt(3));
					vo.setG_Addr(rs.getString(4));
					vo.setG_Tel(rs.getString(5));
					vo.setDeleteYN(rs.getString(6));
					vo.setCreateDate(rs.getString(7));
					vo.setUpdateDate(rs.getString(8));
					vo.setVIPYN(rs.getString(9));
					aList.add(vo);
				}
			}
		}catch(SQLException e){
			System.out.println("고객정보를 선택하는데 문제가 발생했습니다. 문제 사유 : " + e);
			e.printStackTrace();
			}finally{
				ConnPropertyOraUser.conClose(c, ps, rs);
			}
		//ArrayList를 만들어서
		//vo의 정보를 집어 넣는다.
		System.out.println("입력됫는지 확인");
		
		
		

		
		return aList;
	}

	@Override
	public int insertGogak(GogakVO vo) {
		Connection c=null;
		PreparedStatement ps=null;
		
		
		int nCnt=0;
		
		c=ConnPropertyOraUser.getConnection();
		try{
			
		
		ps=c.prepareStatement(GogakSqlMap.getInsertQuery());
		
		if(ps!=null){
		ps.setString(1, ChaeBun.commG());
		ps.setString(2,vo.getG_Name());
		ps.setInt(3,vo.getG_Age());
		ps.setString(4,vo.getG_Addr());
		ps.setString(5,vo.getG_Tel());
		nCnt=ps.executeUpdate();
		
		System.out.println(nCnt+"개 삽입 완료 !!");
		}
		
		if(nCnt>0){
			ConnPropertyOraUser.conClose(c, ps);
		}
		}catch(SQLException e){
			System.out.println("고객정보를 입력하는데 문제가 발생하였습니다. 문제 사유 : " + e);
		e.printStackTrace();
		}finally{
		ConnPropertyOraUser.conClose(c, ps);
		}
		return nCnt;
	}

	@Override
	public int updateGogak(GogakVO vo) {
		Connection c=null;
		PreparedStatement ps =null;
		String name=null;
		int age=0;
		int nCnt= 0;
		
		c=ConnPropertyOraUser.getConnection();
		try{
		ps=c.prepareStatement(GogakSqlMap.getUpdateQuery());
		
		//수정할값 입력
		
		
		//쿼리문 수정중
		ps.setString(1, vo.getG_Tel());
		ps.setString(2, vo.getG_Code());
		//쿼리문 수정완료
		nCnt=ps.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("업데이트를 하는데 문제가 발생하였습니다. 문제 사유 : " + e);
		}
		
		return nCnt;
	}

	@Override
	public int deleteGogak(GogakVO vo) {
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement ps=null;
		int nCnt=0;
		int num=0;
		
		c=ConnPropertyOraUser.getConnection();
		try{
		ps=c.prepareStatement(GogakSqlMap.getDeleteQuery());
		sc=new Scanner(System.in);
		
		ps.setString(1, vo.getG_Code());
		nCnt=ps.executeUpdate();
		}catch(SQLException e){
		System.out.println("데이터삭제하는데 문제가 발생했습니다.");
		}
		return nCnt;
	}

}
