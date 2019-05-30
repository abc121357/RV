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
		//getConnection�Լ� ȣ��
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
			System.out.println("�������� �����ϴµ� ������ �߻��߽��ϴ�. ���� ���� : " + e);
			e.printStackTrace();
			}finally{
				ConnPropertyOraUser.conClose(c, ps, rs);
			}
		//ArrayList�� ����
		//vo�� ������ ���� �ִ´�.
		System.out.println("�Էµ̴��� Ȯ��");
		
		
		

		
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
		
		System.out.println(nCnt+"�� ���� �Ϸ� !!");
		}
		
		if(nCnt>0){
			ConnPropertyOraUser.conClose(c, ps);
		}
		}catch(SQLException e){
			System.out.println("�������� �Է��ϴµ� ������ �߻��Ͽ����ϴ�. ���� ���� : " + e);
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
		
		//�����Ұ� �Է�
		
		
		//������ ������
		ps.setString(1, vo.getG_Tel());
		ps.setString(2, vo.getG_Code());
		//������ �����Ϸ�
		nCnt=ps.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("������Ʈ�� �ϴµ� ������ �߻��Ͽ����ϴ�. ���� ���� : " + e);
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
		System.out.println("�����ͻ����ϴµ� ������ �߻��߽��ϴ�.");
		}
		return nCnt;
	}

}
