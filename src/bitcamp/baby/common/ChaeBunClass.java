package bitcamp.baby.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/*
  CREATE TABLE CHAEBUNTEST(
    MNUM VARCHAR2(20) PRIMARY KEY
);

SELECT * FROM CHAEBUNTEST;
DESC CHAEBUNTEST;
DELETE FROM CHAEBUNTEST;
COMMIT;

SELECT /*+ INDEX_DESC(A SYS_C0011067) */ /*	
NVL(MAX(SUBSTR(A.MNUM, 12)), 0) + 1 commNO FROM CHAEBUNTEST A;

SELECT A.MNUM + 1 FROM CHAEBUNTEST A;
SELECT NULL + 1 FROM DUAL;
SELECT MAX(A.MNUM) FROM CHAEBUNTEST A;
SELECT NVL(MAX(A.MNUM), 0) + 1 FROM CHAEBUNTEST A;
INSERT INTO CHAEBUNTEST VALUES('M201905270001');
COMMIT;
SELECT MNUM FROM CHAEBUNTEST;
*/

public class ChaeBunClass {

	public static final String QUERY_CHABUN = 
	            " SELECT /*+ INDEX_DESC(A SYS_C0011067) */ "	
			  + " NVL(MAX(SUBSTR(A.MNUM, 12)), 0) + 1 commNO FROM CHAEBUNTEST A";
	
	public static String commonNo()
	{	
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet  rsRs         = null;	
		
		String commNO    = "";		 
					
		try
		{
			conn = ConnPropertyOraUser.getConnection();
			System.out.println("Connection이 성공되었습니다.");
			
			pstmt = conn.prepareStatement(ChaeBunClass.QUERY_CHABUN);
				    		
			rsRs = pstmt.executeQuery();	
			System.out.println("CAHBUN ===> : \n" + ChaeBunClass.QUERY_CHABUN);	
			
			if ( rsRs != null){
			  while (rsRs.next()){
				commNO = String.valueOf(rsRs.getInt("commNO"));					
			  }
			}
			System.out.println("commNO >>>> : " + commNO);
			
			ConnPropertyOraUser.conClose(conn, pstmt);
		}
		catch (SQLException e){
			System.out.println("DB 에러 " + e.getMessage());
		}
		finally {
			try{
				ConnPropertyOraUser.conClose(conn, pstmt);
			}catch (Exception e2){
				e2.printStackTrace();
			}		
		} 
	
		return commNO;
	}
	
	public static String commYearNo()
	{	
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet  rsRs         = null;	
		
		String commNO    = "";		 
		int commYEAR_  = 0;
		int commMONTH_ = 0;
		int commDAY_   = 0;
		String commYEAR  = "";
		String commMONTH = "";
		String commDAY   = "";
		
		try
		{
			conn = ConnPropertyOraUser.getConnection();
			System.out.println("Connection이 성공되었습니다.");
			
			pstmt = conn.prepareStatement(ChaeBunClass.QUERY_CHABUN);				     		
			rsRs = pstmt.executeQuery();	
			System.out.println("CAHBUN ===> : \n" + ChaeBunClass.QUERY_CHABUN);					
			
			if ( rsRs != null){
				while (rsRs.next()){
					 commNO = String.valueOf(rsRs.getInt("commNO"));					
				}
			}
			System.out.println(" commNO >>>> : " + commNO);
			
			Calendar cl = Calendar.getInstance( );  // 현재 날짜 정보 얻기	
			commYEAR_ = cl.get(Calendar.YEAR);
			commMONTH_ = cl.get(Calendar.MONTH) + 1;
			commDAY_ = cl.get(Calendar.DAY_OF_MONTH);
			
			commYEAR = String.valueOf(commYEAR_);
			commMONTH = String.valueOf(commMONTH_);
			commDAY = String.valueOf(commDAY_);
			
			//commYEAR = commYEAR.substring(2, 4); //2015 -> 15
			if ( commMONTH_ < 10 ) //1, 2 ~ 9 : 01
			{
				commMONTH = "0" + String.valueOf(commMONTH_);
			}
			
		    System.out.println("현재 년: " +  commYEAR);
		    System.out.println("현재 월: " +  commMONTH);
		    System.out.println("현재 일: " +  commDAY);
			
			if (1 == commNO.length())
			{
				commNO = "000" + commNO;
			}
			if (2 == commNO.length())
			{
				commNO = "00" + commNO;
			}
			if (3 == commNO.length())
			{
				commNO = "0" + commNO;
			}
	
			// M201509040001			
			System.out.println("commNO >>>> : " + commNO);
			
			commNO = "M" + commYEAR + commMONTH + commDAY + commNO;
			System.out.println("commNO >>>> : " + commNO);
			
			ConnPropertyOraUser.conClose(conn, pstmt);
		}
		catch (SQLException e){
			System.out.println("DB 에러 " + e.getMessage());
		}
		finally {
			try{
				ConnPropertyOraUser.conClose(conn, pstmt);
			}catch (Exception e2){
				e2.printStackTrace();
			}				
		} 
	
		return commNO;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String commNumber = ChaeBunClass.commonNo();
//		System.out.println(" commNumber >>> : " + commNumber);
		String commYearNumber = ChaeBunClass.commYearNo();
		System.out.println(" commYearNumber >>>> : "+ commYearNumber);
	}
}
