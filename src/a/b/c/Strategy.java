package a.b.c;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Strategy {

	public void jdbcContextWithStatementStrategy(StatementTemple stmt)throws SQLException{
		Connection c=null;
		PreparedStatement ps=null;
		
		try{
		stmt.makePreparedStatement(c);
		}catch(Exception e){
			
		}
		
		
	}
	
	
}
