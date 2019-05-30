package bitcamp.baby.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ConnPropertyOraUser {
	
	public static final String DEPT02_URL="jdbc:oracle:thin:@127.0.0.1:1521:orclLHJ00";
	public static final String DEPT02_USER="orauser01";
	public static final String DEPT02_PW="user01";
	public static Connection getConnection(){
		Connection c= null;
		try{
		c=DriverManager.getConnection(DEPT02_URL,DEPT02_USER,DEPT02_PW);
		}catch(SQLException e){
			
		}
		
		return c;
		
		
		
		
	}
	//Ä¿³Ø¼ÇÀ» ´Ý´Â ¸Þ¼Òµå(Connection,PreparedStatement)
	public static void conClose(Connection c,PreparedStatement ps){
		try{
			if(c!=null)
			c.close();
		}catch(SQLException e){
	
		}
		try{
			if(ps!=null)
				ps.close();
		}catch(SQLException e){
			
		}
	}
	//Ä¿³Ø¼ÇÀ» ´Ý´Â ¸Þ¼Òµå(Connection, PreparedStatement, ResultSet)
	public static void conClose(Connection c,PreparedStatement ps,ResultSet rs){
		try{
			if(c!=null)
			c.close();
		}catch(SQLException e){
	
		}
		try{
			if(ps!=null)
				ps.close();
		}catch(SQLException e){
			
		}
		try{
			if(rs!=null)
				rs.close();
		}catch(SQLException e){
			
		}
	}
	
}
