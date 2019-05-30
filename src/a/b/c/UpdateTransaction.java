package a.b.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTransaction {

	public static final String DEPT02_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orclYJH00";
	public static final String DEPT02_USER = "scott";
	public static final String DEPT02_PASS = "tiger";
	
	public UpdateTransaction(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		}catch (ClassNotFoundException e)
		{
			System.out.println("드라이버를 못찾아서요 >>> : " + e);
		}//end of try~catch block		
	}//end of UpdateTransaction() constructor block		
	
	// insert SQL
	public static String getInsertQuery(){
		System.out.println("getInsertQuery() 함수 진입");
		StringBuffer sb = new StringBuffer();		
        sb.append("UPDATE			        \n");
        sb.append("DEPT02    			    \n");
        sb.append("SET DNAME = 'MARKETING'	\n");
        sb.append("WHERE                	\n");
        sb.append("DEPTNO = 50              \n");
        return sb.toString();
	}
	
	public int updateDEPT02(){
		System.out.println("updateDEPT02() 함수 진입");
		
		Connection con = null;
		Statement  stmt = null;
		int nCnt = 0;
		
		try {
			con = DriverManager.getConnection(DEPT02_URL
					                         ,DEPT02_USER
					                         ,DEPT02_PASS);
			System.out.println("con >>> : " + con);
			System.out.println("con.getAutoCommit() >>> : "  + con.getAutoCommit());
			con.setAutoCommit(false);
			stmt = con.createStatement();
			nCnt = stmt.executeUpdate(UpdateTransaction.getInsertQuery());
			System.out.println("nCnt : "+nCnt);
			if(nCnt > 0)
				con.commit();			
			    stmt.close(); stmt=null;
				con.close(); con=null;
		}catch(SQLException s){
			System.out.println("DB 연결 또는 쿼리에 문제가 있습니다 >>> : " + s);
		}finally{
			try {
				if (stmt !=null){ try{stmt.close(); stmt=null;} catch(Exception e){}}
				if (con !=null){ try{con.close(); con=null;} catch(Exception e){}}	
			}catch(Exception ex){			
			}					
		}
		
		return nCnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nCnt = new UpdateTransaction().updateDEPT02();
		System.out.println("DEPT02 테이블에 " + nCnt + "건 입력 되었습니다.");
	}

}
